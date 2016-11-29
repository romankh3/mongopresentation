package org.mongo.dao;

import org.mongo.domain.User;

import java.util.List;

/**
 * @author rbeskrovnyi
 */
public interface IMongoDBDAO {

    public void insert(User user);
    public List<User> find(User user);
    public void remove(User user);
    public void dropCollection(String collection);
}
