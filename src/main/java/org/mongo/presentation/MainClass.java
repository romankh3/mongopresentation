package org.mongo.presentation;

import org.mongo.dao.MongoDocumentDAO;
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
        MongoDocumentDAO documentDAO = new MongoDocumentDAO(new MongoDBSettings());
        documentDAO.insert(john);
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
