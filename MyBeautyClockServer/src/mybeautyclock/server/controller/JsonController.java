package mybeautyclock.server.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.DatastoreFailureException;
import com.google.appengine.api.datastore.DatastoreTimeoutException;
import com.google.apphosting.api.DeadlineExceededException;
import com.google.apphosting.api.ApiProxy.CapabilityDisabledException;

public abstract class JsonController extends Controller {
    protected static final Logger logger =
        Logger.getLogger(JsonController.class.getName());
    protected static final String STATUS = "status";
    protected static final String ERRCODE = "errorCode";
    protected static final String ERRMESSAGE = "errorMessage";
    protected static final String CANRETRY = "canRetry";
    protected static final String STATUS_OK = "OK";
    protected static final String STATUS_NG = "NG";
    protected static final String TYPE_ARRAY = "array";
    
    abstract protected Map<String, Object> handle() throws Exception;
    
    @Override
    protected Navigation run() throws Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        Map<String, Object> map = handle();
        if (map == null) {
            throw new AssertionError("handle() must not be null.");
        }
        PrintWriter pw = response.getWriter();
    
        if(map.containsKey(TYPE_ARRAY)){
            new JSONArray((List)map.get(TYPE_ARRAY)).write(pw);
        }
        else{
            new JSONObject(map).write(pw);
        }
        
        response.flushBuffer();
        return null;
    }

    @Override
    protected Navigation handleError(Throwable error) throws Throwable {
        Map<String, Object> map = new HashMap<String, Object>();
        String errorCode;
        String errorMessage;
        boolean canRetry = false;
        if (error instanceof CapabilityDisabledException) {
            errorCode = "READONLY";
            errorMessage = "AppEngineのサービスが読み取り専用です";
        } else if (error instanceof DatastoreTimeoutException) {
            errorCode = "DSTIMEOUT";
            errorMessage = "データストアがタイムアウトしました。";
            canRetry = true;
        } else if (error instanceof DatastoreFailureException) {
            errorCode = "DSFAILURE";
            errorMessage = "データストアのアクセスに失敗しました。";
        } else if (error instanceof DeadlineExceededException) {
            errorCode = "DEE";
            errorMessage = "30秒を超えても処理が終了しませんでした。";
            canRetry = true;
        } else {
            errorCode = "UNKNOWN";
            errorMessage = "予期せぬエラーが発生しました。" + error.toString();
        }
        map.put(STATUS, STATUS_NG);
        map.put(ERRCODE, errorCode);
        map.put(ERRMESSAGE, errorMessage);
        map.put(CANRETRY, canRetry);
        
        //PrintWriter pw = response.getWriter();
        new JSONObject(map).write(response.getWriter());
        response.flushBuffer();
        return null;
    }
}
