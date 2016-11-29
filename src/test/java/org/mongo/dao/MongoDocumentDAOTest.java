package org.mongo.dao;

import org.junit.Test;
import org.mongo.dao.impl.MongoDocumentDAO;
import org.mongo.domain.User;
import org.mongo.settings.MongoDBSettings;

import static org.junit.Assert.*;
import org.mongo.presentation.MainClass;

import java.util.List;

/**
 * @author rbeskrovnyi
 */
public class MongoDocumentDAOTest {

    private IMongoDBDAO documentDAO;
    private MongoDBSettings settings;

    public MongoDocumentDAOTest(){
        settings = new MongoDBSettings();
        settings.setCollections("testCollection");
        documentDAO = new MongoDocumentDAO(settings);
    }

    @Test
    public void dbOperations(){
        User user = MainClass.getUser();

        documentDAO.insert(user);

        List<User> users =  documentDAO.find(user);

        assertEquals(user,users.get(0));

        documentDAO.remove(user);

        users = documentDAO.find(user);

        assertTrue("users is not empty!",users.isEmpty());

        documentDAO.dropCollection(settings.getCollections());
    }

}