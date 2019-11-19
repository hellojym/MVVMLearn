package com.jym.mvvmlearn.completedemo;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.jym.mvvmlearn.entities.Product;

/**
 * 类描述：一般来说，请求完数据以后，拿数据展示。不用考虑把对象数据修改后动态修改UI数值
 *
 * @author: jiayuanmin
 * @time: 2019-11-19
 */
public class ProductViewModel extends ViewModel {

    public ObservableField<Product> productDetail = new ObservableField<>();
    private Repo mRepo = new Repo();

    /**
     * 模拟网络传输获取数据
     */
    public void fetchData() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //mock product
        Product p = mRepo.getProductDetail();
        productDetail.set(p);
    }

    /**
     * 模拟网络传提交数据
     */
    public void commitData() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mRepo.commit();
    }
}
