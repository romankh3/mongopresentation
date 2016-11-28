package org.mongo.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.mongo.domain.User;
import org.mongo.settings.MongoDBSettings;
import org.mongo.settings.MongoDatabaseConnector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author rbeskrovnyi
 */
public class MongoDocumentDAO {

    private MongoCollection<Document> collection;
    private MongoDatabase database;


    public MongoDocumentDAO(MongoDBSettings settings){
        MongoDatabaseConnector connector = new MongoDatabaseConnector(settings);
        database = connector.get();
        collection = database.getCollection(settings.getCollections());
    }

    public void insert(User user){
        Document userDocument = convertUserToDocument(user);
        collection.insertOne(userDocument);
    }

    public List<User> find(User user){
        List<User> users =  new ArrayList<>();
        MongoCursor cursor = collection.find(convertUserToDocument(user)).iterator();
        while(cursor.hasNext()){
            users.add(convertDocumentToUser((Document) cursor.next()));
        }
        return users;
    }

    public void remove(User user){
        collection.deleteMany(convertUserToDocument(user));
    }

    public void dropCollection(String collection){
        database.getCollection(collection).drop();
    }

    private static Document convertUserToDocument(User user){
        Document document = new Document();
        document.append("name",user.getName())
                .append("age",user.getName())
                .append("skills",user.getSkills());
        return document;
    }

    private static User convertDocumentToUser(Document document){
        User user = new User();
        user.setName((String) document.get("name"));
        user.setAge((Integer) document.get("age"));
        user.setSkills((Map<String, String>) document.get("skills"));
        return user;
    }
}
