package com.jym.mvvmlearn.completedemo;

import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.jym.mvvmlearn.entities.Product;

/**
 * 类描述：一般来说，请求完数据以后，拿数据展示。不用考虑把对象数据修改后动态修改UI数值
 *
 * @author: jiayuanmin
 * @time: 2019-11-19
 */
public class ProductViewModel extends ViewModel {

    private ObservableField<Product> productDetail = new ObservableField<>();
    private LiveData<Product> productLiveData = null;
    private Repo mRepo = new Repo();

    /**
     * 模拟网络传输获取数据
     */
    public LiveData<Product> getProductData() {
        if (productLiveData == null) {
            productLiveData = mRepo.getProductDetail();
        }
        return productLiveData;
    }

    /**
     * 模拟网络传提交数据
     */
    public void commitData() {
        Log.d("MVVM", "提交数据");
        mRepo.commit();
    }

    public ObservableField<Product> getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(Product product) {
        this.productDetail.set(product);
    }
}
