package com.jym.mvvmlearn.completedemo;

import com.jym.mvvmlearn.entities.Product;

/**
 * 类描述：
 *
 * @author: jiayuanmin
 * @time: 2019-11-19
 */
public class Repo {

    public Product getProductDetail() {
        Product product = new Product();
        product.setDiscount("0.6");
        product.setFrom("山东");
        product.setId("2");
        product.setName("大枣");
        product.setPrice(20);
        return product;
    }

    public void commit() {

    }
}
