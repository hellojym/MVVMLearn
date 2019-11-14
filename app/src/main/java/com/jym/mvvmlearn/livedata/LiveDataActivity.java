package com.jym.mvvmlearn.livedata;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jym.mvvmlearn.R;
import com.jym.mvvmlearn.model.User;

/**
 * 类描述：
 *
 * @author: jiayuanmin
 * @time: 2019-11-14
 */
public class LiveDataActivity extends AppCompatActivity {

    UserLiveData user = new UserLiveData();
    TextView nameTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        nameTv = findViewById(R.id.tv_name);
        user.setValue(new User("小强", "11"));
        user.observe(this, o -> {
            nameTv.setText(user.getValue().getName());
        });
        user.setValue(new User("小飞","17"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        user.setValue(new User("小红", "14"));

        Log.d("MVVM", nameTv.getText().toString());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        user.setValue(new User("小蓝", "12"));

    }
}
