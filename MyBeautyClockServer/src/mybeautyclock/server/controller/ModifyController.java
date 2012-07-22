package mybeautyclock.server.controller;

import java.util.HashMap;
import java.util.Map;

import mybeautyclock.server.model.Joshi;
import mybeautyclock.server.service.KawaiiService;
import mybeautyclock.server.util.Utils;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

public class ModifyController extends JsonController {
    private KawaiiService service = new KawaiiService();

    @Override
    protected Map<String, Object> handle() throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        
        Joshi joshi = service.findJoshi(id); 
        if(joshi!=null){
            Transaction tx = Datastore.beginTransaction();
            if(!Utils.isNull(name)){
                joshi.setName(name);
            }
            if(!Utils.isNull(category)){
                joshi.setCategory(category);
            }
            Datastore.put(joshi);
            tx.commit();
        }
        else{
            Transaction tx = Datastore.beginTransaction();
            joshi = new Joshi();
            Key key = Datastore.createKey(Joshi.class, id);
            joshi.setKey(key);
            joshi.setKawaii(0);
            if(!Utils.isNull(name)){
                joshi.setName(name);
            }
            if(!Utils.isNull(category)){
                joshi.setCategory(category);
            }
            Datastore.put(joshi);
            tx.commit();
        }
        
        result.put("result","true");
        return result;
    }
}
