package mybeautyclock.server.controller;

import java.util.HashMap;
import java.util.Map;

import mybeautyclock.server.model.Joshi;
import mybeautyclock.server.service.KawaiiService;
import mybeautyclock.server.util.Utils;

public class DodeskaController extends JsonController {
    private KawaiiService service = new KawaiiService();

    @Override
    protected Map<String, Object> handle() throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String id = request.getParameter("id");
        
        if(!Utils.isNull(id)){
            Joshi joshi = service.findJoshi(id); 
            
            if(joshi!=null){
                result.put("result","true");
                result.put("url", joshi.getKey().getName());
                result.put("kawaii", joshi.getKawaii());
                result.put("name", Utils.valueString(joshi.getName()));
                result.put("category", Utils.valueString(joshi.getCategory()));
                return result;
            }
        }
        
        result.put("result","false");

        return result;
    }
}
