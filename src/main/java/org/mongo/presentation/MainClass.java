package org.mongo.presentation;

import org.mongo.dao.IMongoDBDAO;
import org.mongo.dao.impl.MongoDocumentDAO;
import org.mongo.dao.impl.MongoMorphiaDAO;
import org.mongo.domain.User;
import org.mongo.settings.MongoDBSettings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rbeskrovnyi
 */
public class MainClass {

    public static void main(String[] args) {
        User john = getUser();
        MongoDBSettings settings = new MongoDBSettings();
        IMongoDBDAO documentDAO = new MongoDocumentDAO(settings);
        IMongoDBDAO morphiaDAO = new MongoMorphiaDAO(settings);

        documentDAO.insert(john);
        morphiaDAO.insert(john);
    }

    public static User getUser(){
        User user = new User();
        user.setName("John");
        user.setAge(21);
        Map<String,String> johnSkills = new HashMap<>();
        johnSkills.put("java","Java SE, Java EE");
        johnSkills.put("MongoDB","Has Certificate from MongoDB University.");
        user.setSkills(johnSkills);
        return user;
    }
}
