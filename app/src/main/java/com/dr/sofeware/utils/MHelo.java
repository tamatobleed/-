package com.dr.sofeware.utils;

import java.util.ArrayList;

/**
 * @auther DR_bluelake
 * @create 2022/11/12-5:33
 */
public class MHelo {
    public static void main(String[] args){
        MathMethod s=new MathMethod();
        Integer i,j,k;
        i=Integer.parseInt("5");
        j=Integer.parseInt("5");
        k=Integer.parseInt("1");
        ArrayList<String> arr=s.createFormuls(i,j,k);
        for(String str:arr){
            System.out.println(str);
        }

    }
}
