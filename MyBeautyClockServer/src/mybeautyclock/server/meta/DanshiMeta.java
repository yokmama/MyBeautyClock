package mybeautyclock.server.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-07-22 19:09:17")
/** */
public final class DanshiMeta extends org.slim3.datastore.ModelMeta<mybeautyclock.server.model.Danshi> {

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<mybeautyclock.server.model.Danshi, org.slim3.datastore.ModelRef<mybeautyclock.server.model.Joshi>, mybeautyclock.server.model.Joshi> joshiRef = new org.slim3.datastore.ModelRefAttributeMeta<mybeautyclock.server.model.Danshi, org.slim3.datastore.ModelRef<mybeautyclock.server.model.Joshi>, mybeautyclock.server.model.Joshi>(this, "joshiRef", "joshiRef", org.slim3.datastore.ModelRef.class, mybeautyclock.server.model.Joshi.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<mybeautyclock.server.model.Danshi, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<mybeautyclock.server.model.Danshi, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<mybeautyclock.server.model.Danshi, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<mybeautyclock.server.model.Danshi, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final DanshiMeta slim3_singleton = new DanshiMeta();

    /**
     * @return the singleton
     */
    public static DanshiMeta get() {
       return slim3_singleton;
    }

    /** */
    public DanshiMeta() {
        super("Danshi", mybeautyclock.server.model.Danshi.class);
    }

    @Override
    public mybeautyclock.server.model.Danshi entityToModel(com.google.appengine.api.datastore.Entity entity) {
        mybeautyclock.server.model.Danshi model = new mybeautyclock.server.model.Danshi();
        if (model.getJoshiRef() == null) {
            throw new NullPointerException("The property(joshiRef) is null.");
        }
        model.getJoshiRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("joshiRef"));
        model.setKey(entity.getKey());
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        mybeautyclock.server.model.Danshi m = (mybeautyclock.server.model.Danshi) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getJoshiRef() == null) {
            throw new NullPointerException("The property(joshiRef) must not be null.");
        }
        entity.setProperty("joshiRef", m.getJoshiRef().getKey());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        mybeautyclock.server.model.Danshi m = (mybeautyclock.server.model.Danshi) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        mybeautyclock.server.model.Danshi m = (mybeautyclock.server.model.Danshi) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        mybeautyclock.server.model.Danshi m = (mybeautyclock.server.model.Danshi) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        mybeautyclock.server.model.Danshi m = (mybeautyclock.server.model.Danshi) model;
        if (m.getJoshiRef() == null) {
            throw new NullPointerException("The property(joshiRef) must not be null.");
        }
        m.getJoshiRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        mybeautyclock.server.model.Danshi m = (mybeautyclock.server.model.Danshi) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        mybeautyclock.server.model.Danshi m = (mybeautyclock.server.model.Danshi) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getJoshiRef() != null && m.getJoshiRef().getKey() != null){
            writer.setNextPropertyName("joshiRef");
            encoder0.encode(writer, m.getJoshiRef(), maxDepth, currentDepth);
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected mybeautyclock.server.model.Danshi jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        mybeautyclock.server.model.Danshi m = new mybeautyclock.server.model.Danshi();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("joshiRef");
        decoder0.decode(reader, m.getJoshiRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}