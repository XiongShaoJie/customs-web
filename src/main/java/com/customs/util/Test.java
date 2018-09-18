package com.customs.util;

public class Test {
    public static void main(String[] args) {
	String name = "admin123";
	System.out.println(MD5Util.toMD5(name).toUpperCase());
    }

}
