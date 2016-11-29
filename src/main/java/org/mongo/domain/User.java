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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (!name.equals(user.name)) return false;
        return skills != null ? skills.equals(user.skills) : user.skills == null;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        return result;
    }
}
