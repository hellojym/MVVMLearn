package com.jym.mvvmlearn.databinding;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.jym.mvvmlearn.R;
import com.jym.mvvmlearn.entities.User;
import com.jym.mvvmlearn.viewmodel.UserViewModel;

import java.util.Random;

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

        //如果跟ViewModel结合，请使用下面这行代码
        UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.setUser("通过VM设置的");
        activityDatabindBinding.setUserVM(userViewModel);

        //如果不跟ViewModel结合，使用这里
        User user = new User();
        user.age.set("50");
        user.setName("马云");
        activityDatabindBinding.setUserInfo(user);
        findViewById(R.id.change).setOnClickListener(v -> {
            String random = new Random().nextInt(50) + "";
            user.age.set(random);
        });

    }

    /**
     * 给TextView添加后缀
     *
     * @param textView
     * @param append
     */
    @SuppressLint("SetTextI18n")
    @BindingAdapter("textAppend")
    public static void append(TextView textView, String append) {
        textView.setText(textView.getText() + append);
    }
}
