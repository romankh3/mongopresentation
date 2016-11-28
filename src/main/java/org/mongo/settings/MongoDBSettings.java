package org.mongo.settings;

/**
 * @author rbeskrovnyi
 */
public class MongoDBSettings {

    private String host = "localhost";
    private String port = "27017";
    private String database = "presentation";

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getHost() {

        return host;
    }

    public String getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }
}
