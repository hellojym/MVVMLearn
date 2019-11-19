package com.jym.mvvmlearn.completedemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.jym.mvvmlearn.R;
import com.jym.mvvmlearn.databinding.ActivityLayoutCompleteBinding;

/**
 * 类描述：结合ViewModel，dataBinding，liveData的例子
 * 最常见的一个例子，从服务端获取商品详情数据，然后展示出来
 *
 * @author: jiayuanmin
 * @time: 2019-11-19
 */
public class CompleteDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProductViewModel vm = ViewModelProviders.of(this).get(ProductViewModel.class);
        ActivityLayoutCompleteBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_layout_complete);
        dataBinding.setProductVM(vm);
        //取数据
        vm.fetchData();


        TextView discountTv = findViewById(R.id.discount);
        vm.priceLiveData.observe(this, s -> {
            float discount = Float.parseFloat(vm.productDetail.get().getDiscount());
            String discountPrice = discount * s + "";
            discountTv.setText(discountPrice);
        });
    }
}
