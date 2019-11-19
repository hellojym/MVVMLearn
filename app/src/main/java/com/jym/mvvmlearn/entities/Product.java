package com.jym.mvvmlearn.entities;

/**
 * 类描述：
 *
 * @author: jiayuanmin
 * @time: 2019-11-19
 */
public class Product {

    private String id;
    private String name;
    private int price;
    private String from;
    private String discount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
