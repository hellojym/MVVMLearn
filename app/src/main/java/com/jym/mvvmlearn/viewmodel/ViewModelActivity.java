package com.jym.mvvmlearn.viewmodel;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.jym.mvvmlearn.R;

/**
 * 类描述：ViewModel演示，其实viewModel最好配合livedata，但是为了单独说明其应用场景，为采用livedata
 *
 * @author: jiayuanmin
 * @time: 2019-11-14
 */
public class ViewModelActivity extends AppCompatActivity {

    UserViewModel viewModel;
    TextView name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);
        name = findViewById(R.id.name);
        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        ViewPager vp = findViewById(R.id.vp);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return ViewModelFragment.newInstance("fragment_" + position);
            }

            @Override
            public int getCount() {
                return 3;
            }
        });

        findViewById(R.id.refresh).setOnClickListener(v -> {
            name.setText(viewModel.user.getName());
        });

    }

}
