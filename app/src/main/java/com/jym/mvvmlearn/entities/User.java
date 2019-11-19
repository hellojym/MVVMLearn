package com.jym.mvvmlearn.entities;

import androidx.databinding.ObservableField;

/**
 * 类描述：
 *
 * @author: jiayuanmin
 * @time: 2019-10-28
 */
public class User {
    private String name;

    public ObservableField<String> age = new ObservableField<>();

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
