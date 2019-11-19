package com.jym.mvvmlearn.livedata;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jym.mvvmlearn.R;
import com.jym.mvvmlearn.entities.User;

/**
 * 类描述：
 *
 * @author: jiayuanmin
 * @time: 2019-11-18
 */
public class ChangeDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_value);

        findViewById(R.id.changeData).setOnClickListener(v -> {
            LiveDataHolder.getUserLiveData().setValue(new User("外部"));
            Log.d("MVVM","change data");
        });
    }
}
