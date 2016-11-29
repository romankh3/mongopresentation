package org.mongo.dao.impl;

import com.mongodb.MongoClient;
import org.mongo.dao.IMongoDBDAO;
import org.mongo.domain.User;
import org.mongo.settings.MongoDBSettings;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import java.util.List;
import java.util.Map;

/**
 * @author rbeskrovnyi
 */
public class MongoMorphiaDAO implements IMongoDBDAO{

    final Datastore dataStore;

    public MongoMorphiaDAO(MongoDBSettings settings){
        final Morphia morphia = new Morphia();
        morphia.mapPackage("org.mongo.domain");
        dataStore = morphia.createDatastore(new MongoClient(settings.getHost(),settings.getPort()), settings.getDatabase());
    }

    @Override
    public void insert(User user) {
        dataStore.save(user);
    }

    @Override
    public List<User> find(User user) {
        Query<User> query = dataStore.createQuery(User.class);
        for(Map.Entry<String,String> entry: user.getSkills().entrySet()){
            query.criteria("skills."+entry.getKey()).contains(entry.getValue());
        }
        return query
                .field("name").equal(user.getName())
                .field("age").equal(user.getAge())
                .asList();
    }

    @Override
    public void remove(User user) {
        Query<User> query = dataStore.createQuery(User.class);
        for(Map.Entry<String,String> entry: user.getSkills().entrySet()){
            query.criteria("skills."+entry.getKey()).contains(entry.getValue());
        }
        query = query
                .field("name").equal(user.getName())
                .field("age").equal(user.getAge());
        dataStore.delete(query);
    }

    @Override
    public void dropCollection(String collection) {
        dataStore.getDB().getCollection(collection).drop();
    }
}
