package com.jym.mvvmlearn.livedata;

/**
 * 类描述：
 *
 * @author: jiayuanmin
 * @time: 2019-11-14
 */
public class LiveDataHolder {

    private static UserLiveData userLiveData = new UserLiveData();

    public static UserLiveData getUserLiveData() {
        return userLiveData;
    }
}
