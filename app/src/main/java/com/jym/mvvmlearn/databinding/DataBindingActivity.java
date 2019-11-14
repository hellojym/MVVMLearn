package com.jym.mvvmlearn.databinding;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.jym.mvvmlearn.R;
import com.jym.mvvmlearn.model.User;

/**
 * 类描述：
 *
 * @author: jiayuanmin
 * @time: 2019-11-14
 */
public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDatabindBinding activityDatabindBinding = DataBindingUtil.setContentView(this, R.layout.activity_databind);
        User user = new User();
        user.setName("马云");
        user.setAge("123456");
        activityDatabindBinding.setUserInfo(user);



    }
}
