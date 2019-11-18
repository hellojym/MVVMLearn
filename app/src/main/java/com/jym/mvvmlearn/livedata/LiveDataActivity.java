package com.jym.mvvmlearn.livedata;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jym.mvvmlearn.R;
import com.jym.mvvmlearn.model.User;

import java.util.Objects;


/**
 * 类描述：LiveData演示
 *
 * @author: jiayuanmin
 * @time: 2019-11-14
 */
public class LiveDataActivity extends AppCompatActivity {

    private static final String TAG = "MVVM";

    UserLiveData user = LiveDataHolder.getUserLiveData();
    TextView nameTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        nameTv = findViewById(R.id.tv_name);
        findViewById(R.id.btn_to_change).setOnClickListener(v -> startActivity(new Intent(this, ChangeDataActivity.class)));

        user.observe(this, o -> {
                    nameTv.setText(Objects.requireNonNull(user.getValue()).getName());
                    Log.d(TAG, "observe changed: value = " + user.getValue().getName());
                }
        );

        requestData();
    }

    /**
     * 模拟获取数据
     */
    private void requestData() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        user.setValue(new User("一号"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        user.setValue(new User("二号"));
    }

    /**
     * 如果这里setValue，那么外部改变的数据就不会生效了，会被覆盖
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
        user.setValue(new User("三号"));
    }

}
