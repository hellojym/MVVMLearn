package com.jym.mvvmlearn.model;

/**
 * 类描述：
 *
 * @author: jiayuanmin
 * @time: 2019-10-28
 */
public class User {
    private String name;
    private String age;


    public User() {

    }

    public User(String name,String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
