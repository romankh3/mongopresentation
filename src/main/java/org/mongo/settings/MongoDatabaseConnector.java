package org.mongo.settings;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * @author rbeskrovnyi
 */
public class MongoDatabaseConnector {
    private MongoDatabase db;
    private MongoDBSettings settings;

    public MongoDatabaseConnector(MongoDBSettings settings){
        this.settings = settings;
        db = createDatabase();
    }

    public synchronized MongoDatabase get() {
        if(db == null){
            db = createDatabase();
        }
        return db;
    }

    private MongoDatabase createDatabase(){
        MongoDatabase database;
        MongoClient client = new MongoClient(settings.getHost(),settings.getPort());
        database = client.getDatabase(settings.getDatabase());
        return database;
    }
}
