package com.oeasy.ordereasyadmin;
public class WaiterFoodItems {
    private String mname;
    private int mquantity;

    public WaiterFoodItems(String name, int quantity) {
        mname = name;
        mquantity=quantity;
    }

    public String getMname() {
        return mname;
    }



    public int getMquantity() {
        return mquantity;
    }
}
