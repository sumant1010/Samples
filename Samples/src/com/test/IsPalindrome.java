package com.test;

public class IsPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(isPalindrome(2222222));

	}
	public static boolean isPalindrome(int x) {
        if(x<=0){
            return false;
        }
        if(x>=0 && x<10){
            return true;
        }
        if(x/10 == x%10 && x<100 && x>0){
            return true;
        }
        if(x>99 && x<1000 && x/100 == x%10){
            return true;
        }
        if(x>1000 && x<10000 && x/1000 == x%100 && x/100 == x%100 && x%10 == x/1000){
            return true;
        }
        if(x>1000 && x<10000 && x/100 == x%100 && x%10 == x/1000){
            return true;
        }
        if(x>10000 && x<100000 && x/1000 == x%100) {
        	return true;
        }
        if(x>100000 && x<10000000 && x/10000 == x%1000 && x/100000 == x%100) {
        	return true;
        }
        else
            return false;
    }

}
