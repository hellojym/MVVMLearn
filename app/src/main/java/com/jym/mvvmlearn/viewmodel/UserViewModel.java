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

    User user;

    public void setUser(String name) {
        user = new User(name);
        Log.d("MVVM","user Changed to: " + name);
    }

}
