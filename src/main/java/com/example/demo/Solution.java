package com.example.demo;

public class Solution {
    public static int reverse(int x) {
        String m,nstr="";
        if(x>(Math.pow(2,31)-1)&&x>Math.pow(-2,31)){
            x= 0;
        }else{
            if(x>0){
                m=String.valueOf(x);
                char ch;
                for (int i=0; i<m.length(); i++)
                {
                    ch= m.charAt(i);
                    nstr= ch+nstr;
                }
                x=Integer.parseInt(nstr);
            }else{ m=String.valueOf(x);
                char ch;
                for (int i=1; i<m.length(); i++)
                {
                    ch= m.charAt(i);
                    nstr= ch+nstr;
                }
                x=Integer.parseInt(nstr)*(-1);
            }
        }
        return x;
    }
    public static void main(String[] args) {
        System.out.println(reverse(-321));
    }
    }
