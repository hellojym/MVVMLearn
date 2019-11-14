package com.jym.mvvmlearn.viewmodel;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.jym.mvvmlearn.R;

/**
 * 类描述：
 *
 * @author: jiayuanmin
 * @time: 2019-11-14
 */
public class ViewModelActivity extends AppCompatActivity {

    UserViewModel viewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);
        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);

    }
}
