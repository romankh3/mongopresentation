package org.mongo.domain;

import java.util.Map;

/**
 * @author rbeskrovnyi
 */
public class User {
    private String name;
    private int age;
    private Map<String,String> skills;

    public User addSkill(String skill, String description){
        getSkills().put(skill,description);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSkills(Map<String, String> skills) {
        this.skills = skills;
    }

    public String getName() {

        return name;
    }

    public int getAge() {
        return age;
    }

    public Map<String, String> getSkills() {
        return skills;
    }
}
