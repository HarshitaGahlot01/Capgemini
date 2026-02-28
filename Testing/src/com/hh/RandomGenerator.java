package com.hh;

public class RandomGenerator {
	public int[] getTenRandoms() {
		int arr[]=new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*10)+1;
		}
		return arr;
	}
	
public class Random{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      RandomGenerator r=new RandomGenerator();
      int result[]=r.getTenRandoms();
      for(int n:result) {
    	  System.out.println(n+" ");
      }
	}}}


