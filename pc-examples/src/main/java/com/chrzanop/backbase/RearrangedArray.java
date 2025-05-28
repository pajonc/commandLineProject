package com.chrzanop.backbase;

import java.util.Arrays;

public class RearrangedArray {


    public static void main(String []args)
    {
        int a[] = {2,5,6,7,0,1,9};
        int j=-1,temp;
        for (int i=0; i<a.length; i++)
        {
            if (a[i]%2==0)
            {
                j++;
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }

        System.out.println(Arrays.toString(a));
    }


}
