package com.jym.mvvmlearn.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.jym.mvvmlearn.model.User;

/**
 * 类描述：
 *
 * @author: jiayuanmin
 * @time: 2019-11-14
 */
public class UserViewModel extends ViewModel {

    private User user;

    public void setUser(String name) {
        user = new User(name);
        Log.d("MVVM","user Changed to: " + name);
    }

    public User getUser() {
        if (user == null) {
            fetchUserData();
        }
        return user;
    }

    private void fetchUserData() {
        //网络操作获取response后
        user = new User("ok");
    }

}
