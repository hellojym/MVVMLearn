package com.jym.mvvmlearn.completedemo;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jym.mvvmlearn.entities.Product;

/**
 * 类描述：
 *
 * @author: jiayuanmin
 * @time: 2019-11-19
 */
public class ProductViewModel extends ViewModel {

    public ObservableField<Product> productDetail = new ObservableField<>();
    private Product mProduct = new Product();
    /**
     * 由于price需要动态修改，需要跟UI绑定,拿出来单独观察
     */
    public ObservableField<Integer> price = new ObservableField<>();
    /**
     * liveData用于观察数据变化时设置折扣值
     */
    public MutableLiveData<Integer> priceLiveData = new MutableLiveData<>();

    /**
     * dataBinding需要注意一点(有点坑),在set的时候，如果set的值是一个引用，这时，如果引用的对象内容改了，它是不会通知ui更新的，
     * 因为引用地址没有发生变化。
     */
    public void increasePrice() {
        mProduct.setPrice(mProduct.getPrice() + 10);
        price.set(mProduct.getPrice());
        priceLiveData.setValue(mProduct.getPrice());
    }


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
        mProduct = new Product();
        mProduct.setDiscount("0.6");
        mProduct.setFrom("山东");
        mProduct.setId("2");
        mProduct.setName("大枣");
        mProduct.setPrice(20);
        productDetail.set(mProduct);
        price.set(mProduct.getPrice());
        priceLiveData.setValue(mProduct.getPrice());
    }
}
