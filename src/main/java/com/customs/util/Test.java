package com.customs.util;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
	BigDecimal bigDecimal = new BigDecimal(200);
	BigDecimal remainder = bigDecimal.remainder(new BigDecimal(15));
	System.out.println(remainder);
	System.out.println(bigDecimal.multiply(new BigDecimal(5)));
	System.out.println(bigDecimal.divide(new BigDecimal(5)));
    }
}
