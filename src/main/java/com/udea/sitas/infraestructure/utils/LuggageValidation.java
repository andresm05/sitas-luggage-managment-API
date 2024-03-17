package com.udea.sitas.infraestructure.utils;

public class LuggageValidation {

    public static boolean validatePositiveDecimals(double[] values) {
        for (double value : values) {
            if (value < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateExtraCharge(Double extraCharge) {
        if(extraCharge == null) {
            return true;
        }
        return extraCharge >= 0;
    }

    public static boolean validateQuantity(Integer quantity) {
        if(quantity == null) {
            return true;
        }
        return quantity > 0;
    }
}
