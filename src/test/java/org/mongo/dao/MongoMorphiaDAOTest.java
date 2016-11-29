package org.mongo.dao;

import org.junit.Test;
import org.mongo.dao.impl.MongoMorphiaDAO;
import org.mongo.domain.User;
import org.mongo.presentation.MainClass;
import org.mongo.settings.MongoDBSettings;
import org.mongodb.morphia.Datastore;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author rbeskrovnyi
 */
public class MongoMorphiaDAOTest {

    private MongoMorphiaDAO morphiaDAO;
    private MongoDBSettings settings;

    public MongoMorphiaDAOTest(){
        settings = new MongoDBSettings();
        morphiaDAO = new MongoMorphiaDAO(settings);
    }

    @Test
    public void dbOperations(){
        User user = MainClass.getUser();

        morphiaDAO.insert(user);

        List<User> users =  morphiaDAO.find(user);

        assertEquals(user,users.get(0));

        morphiaDAO.remove(user);

        users = morphiaDAO.find(user);

        assertTrue("users is not empty!",users.isEmpty());

        morphiaDAO.dropCollection(settings.getCollections());
    }
}