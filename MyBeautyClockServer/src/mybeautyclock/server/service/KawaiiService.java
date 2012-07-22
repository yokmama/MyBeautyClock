package mybeautyclock.server.service;

import java.util.List;

import javax.activation.DataSource;

import mybeautyclock.server.meta.DanshiMeta;
import mybeautyclock.server.meta.JoshiMeta;
import mybeautyclock.server.model.Danshi;
import mybeautyclock.server.model.Joshi;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.ModelQuery;
import org.slim3.datastore.ModelRef;
import org.slim3.datastore.ModelRefAttributeMeta;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.datastore.Key;


public class KawaiiService {

    public Joshi findJoshi(String id) {
        JoshiMeta mt = JoshiMeta.get();
        Key key = Datastore.createKey(mt.getKind(), id);
        Joshi obj = null;
        try {
            obj = Datastore.get(Joshi.class, key);
        } catch (Exception e) {
            System.out.println("ERROR e:" + e.toString());
        }
        return obj;
    }

    public Danshi findDanshi(String id) {
        DanshiMeta mt = DanshiMeta.get();
        Key key = Datastore.createKey(mt.getKind(), id);
        Danshi obj = null;
        try {
            obj = Datastore.get(Danshi.class, key);
        } catch (Exception e) {
            System.out.println("ERROR e:" + e.toString());
        }
        return obj;

    }

    public boolean hasLink(Joshi joshi, Danshi danshi) {
        DanshiMeta danshiMeta = DanshiMeta.get();
        ModelRefAttributeMeta<Danshi, ModelRef<Joshi>, Joshi> refMeta = danshiMeta.joshiRef;
        ModelQuery<Danshi> list = Datastore.query(Danshi.class).filter(refMeta.equal(joshi.getKey()));
        for(Danshi obj : list.asList()){
            if(obj.getKey().equals(danshi.getKey())){
                return true;
            }
        }
        
        return false;
    }

    public void incKawaii(Joshi joshi, Danshi danshi) {
        Transaction tx = Datastore.beginTransaction();
        joshi.setKawaii(joshi.getKawaii()+1);
        Datastore.put(joshi);
        tx.commit();
        link(joshi, danshi);
    }
    
    private void link(Joshi joshi, Danshi danshi){
        Transaction tx = Datastore.beginTransaction();
        danshi.getJoshiRef().setModel(joshi);
        Datastore.put(danshi);
        tx.commit();
    }

    public List<Joshi> ranking(
            int offset, int limit) {
        JoshiMeta mt = JoshiMeta.get();
        if(offset>0){
            if(limit>0){
                return Datastore.query(mt).sort(mt.kawaii.desc).offset(offset).limit(limit).asList();
            }
            else{
                return Datastore.query(mt).sort(mt.kawaii.desc).offset(offset).asList();
            }
        }
        else{
            if(limit>0){
                return Datastore.query(mt).sort(mt.kawaii.desc).limit(limit).asList();
            }
            else{
                return Datastore.query(mt).sort(mt.kawaii.desc).asList();
            }
        }
    }
    
    public List<Joshi> ranking() {
        JoshiMeta mt = JoshiMeta.get();
        return Datastore.query(mt).sort(mt.kawaii.desc).asList();
    }

}
