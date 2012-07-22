package mybeautyclock.server.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mybeautyclock.server.model.Joshi;
import mybeautyclock.server.service.KawaiiService;
import mybeautyclock.server.util.Utils;

import org.json.JSONObject;

public class RankController extends JsonController {
    private KawaiiService service = new KawaiiService();

    @Override
    protected Map<String, Object> handle() throws Exception {
        int offset = Utils.valueInteger(request.getParameter("offset"), 0);
        int limit = Utils.valueInteger(request.getParameter("limit"), 0);
        
        //safty
        if(offset<0){
            offset = 0;
        }

        List<Joshi> list = service.ranking();
        List<JSONObject> jsonlist = new ArrayList<JSONObject>();
        int ranking = 0;
        int beforValue = -1;
        for(int i=offset; i<list.size(); i++){
            if(limit>0 && jsonlist.size()>limit){
                break;
            }
            Joshi joshi = list.get(i);
            
            if(joshi.getKawaii()!=beforValue){
                ranking++;
            }
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("url", joshi.getKey().getName());
            map.put("ranking", ranking);
            map.put("name", joshi.getName());
            map.put("category", joshi.getCategory());
            map.put("kawaii", joshi.getKawaii());
            JSONObject jsonobj = new JSONObject(map);
            jsonlist.add(jsonobj);
            
            beforValue = joshi.getKawaii();
        }
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(TYPE_ARRAY, jsonlist);
        return result;
    }
}
