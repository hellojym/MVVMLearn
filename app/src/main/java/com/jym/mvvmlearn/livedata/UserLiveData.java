package com.jym.mvvmlearn.livedata;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.jym.mvvmlearn.entities.User;


/**
 * 类描述：
 *
 * @author: jiayuanmin
 * @time: 2019-11-14
 */
public class UserLiveData extends MutableLiveData<User> {

    @Override
    protected void onActive() {
        super.onActive();
        Log.d("MVVM", "onActive");
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        Log.d("MVVM", "onInActive");
    }
}
