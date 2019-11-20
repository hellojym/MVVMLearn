package com.jym.mvvmlearn.completedemo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jym.mvvmlearn.entities.Product;

/**
 * 类描述：
 *
 * @author: jiayuanmin
 * @time: 2019-11-19
 */
public class Repo {

    private MutableLiveData<Product> mProductDetail = new MutableLiveData<>();

    public LiveData<Product> getProductDetail() {

        //模拟网络传输
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Product product = new Product();
            product.setDiscount("0.6");
            product.setFrom("山东");
            product.setId("2");
            product.setName("大枣");
            product.setPrice(20);
            mProductDetail.postValue(product);
        }).start();
        return mProductDetail;
    }

    public void commit() {

    }
}
