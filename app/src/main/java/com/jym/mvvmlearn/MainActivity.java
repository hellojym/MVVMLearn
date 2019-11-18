package com.jym.mvvmlearn;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jym.mvvmlearn.databinding.DataBindingActivity;
import com.jym.mvvmlearn.livedata.LiveDataActivity;
import com.jym.mvvmlearn.viewmodel.ViewModelActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.livedata).setOnClickListener(v -> {
            to(LiveDataActivity.class);
        });

        findViewById(R.id.viewmodel).setOnClickListener(v -> {
            to(ViewModelActivity.class);
        });

        findViewById(R.id.databinding).setOnClickListener(v -> {
            to(DataBindingActivity.class);
        });
    }


    private void to(Class a) {
        startActivity(new Intent(this, a));
    }
}
