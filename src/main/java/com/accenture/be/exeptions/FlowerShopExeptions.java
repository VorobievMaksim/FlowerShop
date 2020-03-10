package com.accenture.be.exeptions;

public class FlowerShopExeptions extends Exception {
    public FlowerShopExeptions(FlowerShopErrors error){
        super(error.getValue());
    }
}
