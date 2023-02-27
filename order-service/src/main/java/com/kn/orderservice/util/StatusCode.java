package com.kn.orderservice.util;

public enum StatusCode {

    SUCCESS(0),
    ORDERS_NOT_FOUND(-95),
    UNKNOWN_ERROR(-99),
    CUSTOMER_EXIST(-98),
    PRODUCT_EXIST(-97);

    private int errorCode;

    StatusCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
