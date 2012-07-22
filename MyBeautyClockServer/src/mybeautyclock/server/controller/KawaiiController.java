package mybeautyclock.server.controller;

import java.util.HashMap;
import java.util.Map;

import mybeautyclock.server.model.Danshi;
import mybeautyclock.server.model.Joshi;
import mybeautyclock.server.service.KawaiiService;
import mybeautyclock.server.util.Utils;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.datastore.Key;


public class KawaiiController extends JsonController {
    private KawaiiService service = new KawaiiService();

    @Override
    protected Map<String, Object> handle() throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String id = request.getParameter("id");
        String lid = request.getParameter("lid");
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        
        if(!Utils.isNull(id) && !Utils.isNull(lid)){
            
            boolean incKawaii = false;
            
            Danshi danshi = service.findDanshi(lid);
            if(danshi==null){
                Transaction tx = Datastore.beginTransaction();
                danshi = new Danshi();
                Key key = Datastore.createKey(Danshi.class, lid);
                danshi.setKey(key);
                Datastore.put(danshi);
                tx.commit();
                incKawaii = true;
            }
            
            Joshi joshi = service.findJoshi(id); 
            if(joshi!=null){
                if(!incKawaii){
                    incKawaii = !service.hasLink(joshi, danshi);
                }
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
                incKawaii = true;
            }
            
            if(incKawaii){
                service.incKawaii(joshi, danshi);
                
                result.put("result","true");
                return result;
            }
        }
        
        result.put("result","false");
       
        return result;
    }
}
