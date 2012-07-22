package mybeautyclock.server.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-07-22 19:09:17")
/** */
public final class JoshiMeta extends org.slim3.datastore.ModelMeta<mybeautyclock.server.model.Joshi> {

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<mybeautyclock.server.model.Joshi> category = new org.slim3.datastore.StringUnindexedAttributeMeta<mybeautyclock.server.model.Joshi>(this, "category", "category");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<mybeautyclock.server.model.Joshi, java.lang.Integer> kawaii = new org.slim3.datastore.CoreAttributeMeta<mybeautyclock.server.model.Joshi, java.lang.Integer>(this, "kawaii", "kawaii", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<mybeautyclock.server.model.Joshi, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<mybeautyclock.server.model.Joshi, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<mybeautyclock.server.model.Joshi> name = new org.slim3.datastore.StringUnindexedAttributeMeta<mybeautyclock.server.model.Joshi>(this, "name", "name");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<mybeautyclock.server.model.Joshi, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<mybeautyclock.server.model.Joshi, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final JoshiMeta slim3_singleton = new JoshiMeta();

    /**
     * @return the singleton
     */
    public static JoshiMeta get() {
       return slim3_singleton;
    }

    /** */
    public JoshiMeta() {
        super("Joshi", mybeautyclock.server.model.Joshi.class);
    }

    @Override
    public mybeautyclock.server.model.Joshi entityToModel(com.google.appengine.api.datastore.Entity entity) {
        mybeautyclock.server.model.Joshi model = new mybeautyclock.server.model.Joshi();
        model.setCategory((java.lang.String) entity.getProperty("category"));
        model.setKawaii(longToPrimitiveInt((java.lang.Long) entity.getProperty("kawaii")));
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        mybeautyclock.server.model.Joshi m = (mybeautyclock.server.model.Joshi) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setUnindexedProperty("category", m.getCategory());
        entity.setProperty("kawaii", m.getKawaii());
        entity.setUnindexedProperty("name", m.getName());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        mybeautyclock.server.model.Joshi m = (mybeautyclock.server.model.Joshi) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        mybeautyclock.server.model.Joshi m = (mybeautyclock.server.model.Joshi) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        mybeautyclock.server.model.Joshi m = (mybeautyclock.server.model.Joshi) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        mybeautyclock.server.model.Joshi m = (mybeautyclock.server.model.Joshi) model;
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
        mybeautyclock.server.model.Joshi m = (mybeautyclock.server.model.Joshi) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCategory() != null){
            writer.setNextPropertyName("category");
            encoder0.encode(writer, m.getCategory());
        }
        writer.setNextPropertyName("kawaii");
        encoder0.encode(writer, m.getKawaii());
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder0.encode(writer, m.getName());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected mybeautyclock.server.model.Joshi jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        mybeautyclock.server.model.Joshi m = new mybeautyclock.server.model.Joshi();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("category");
        m.setCategory(decoder0.decode(reader, m.getCategory()));
        reader = rootReader.newObjectReader("kawaii");
        m.setKawaii(decoder0.decode(reader, m.getKawaii()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}