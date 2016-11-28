package org.mongo.settings;

/**
 * @author rbeskrovnyi
 */
public class MongoDBSettings {

    private String host = "localhost";
    private int port = 27017;
    private String database = "presentation";
    private String collections = "users";

    public void setCollections(String collections) {
        this.collections = collections;
    }

    public String getCollections() {

        return collections;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }
}
