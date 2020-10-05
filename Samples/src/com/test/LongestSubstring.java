package com.test;

import java.util.ArrayList;

public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Output: "+lengthOfLongestSubstring("pwwkew"));
	}
    public static int lengthOfLongestSubstring(String s) {
        if(s.equals("")){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        if(s.length()==2 && s.charAt(0)==s.charAt(1)){
            return 1;
        }
        if(s.length()==2 && s.charAt(0)!=s.charAt(1)){
            return 2;
        }
        ArrayList arr = new ArrayList<String>();
        for(int i=0;i<s.length()-1;i++){
            for(int k=i+1;k<s.length();k++){
                if(s.charAt(i)==s.charAt(k)){
                    arr.add(s.substring(i,k));
                    if((k-i)==1) {
                    	arr.add(s.substring(i,k+1));
                    	continue;
                    }
                    else if(k==s.length()-1 && s.charAt(0)==s.charAt(k)){
                        arr.add(s.substring(0,k+1));
                    	continue;
                    }
                    else {
                    break;
                    }
                }
            }
        }
        String maxStr = "";
        if(arr.size()==1) {
        	maxStr = arr.get(0).toString();
        }
        else {
        for(int j=0;j<arr.size()-1;j++){
            if(arr.get(j).toString().length()>arr.get(j+1).toString().length()){
                if(arr.get(j).toString().length()>maxStr.length()){
            	maxStr = arr.get(j).toString();
                }
            }
            else{
            	if(arr.get(j+1).toString().length()>maxStr.length()){
                maxStr = arr.get(j+1).toString();
            	}
            }
        }
        }
        if(maxStr.length()==s.length()) {
        	return 1;
        }
        return maxStr.length();
    }
	
}
