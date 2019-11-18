package com.jym.mvvmlearn.viewmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.jym.mvvmlearn.R;

/**
 * 类描述：
 *
 * @author: jiayuanmin
 * @time: 2019-11-18
 */
public class ViewModelFragment extends Fragment {

    private TextView title;
    private View rootView;
    private Button changeModel;

    public static ViewModelFragment newInstance(String content) {
        ViewModelFragment fragment = new ViewModelFragment();
        Bundle b = new Bundle();
        b.putString("title", content);
        fragment.setArguments(b);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_view_model, container, false);
        title = rootView.findViewById(R.id.title);
        changeModel = rootView.findViewById(R.id.change_model);

        String contentStr = getArguments().getString("title");
        changeModel.setOnClickListener(v -> ViewModelProviders.of(getActivity()).get(UserViewModel.class).setUser(contentStr + " change_model"));
        title.setText(contentStr);
        return rootView;
    }

}
