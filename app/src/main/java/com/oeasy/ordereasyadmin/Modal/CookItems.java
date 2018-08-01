package com.oeasy.ordereasyadmin.Modal;
public class CookItems {
    private String mname;
    private int mquantity;
    private String waitername;
    private int tablenum;

    public CookItems(String name, int quantity,int tablenum,String waitername) {
        mname = name;
        mquantity=quantity;
        this.waitername=waitername;
        this.tablenum=tablenum;
    }

    public String getFoodname() {
        return mname;
    }



    public int getFoodquantity() {
        return mquantity;
    }

    public String getWaiterName() {
        return waitername;
    }

    public int getTablenum() {
        return tablenum;
    }
}

