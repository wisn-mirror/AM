package com.wisn.test;

import java.util.HashSet;

public class TestCheckID {
		public static void main(String[] args) {
			HashSet<Integer>  test=new  HashSet<Integer>();
			System.out.println(System.nanoTime());
			for(int i=0;i<1000;i++){
				test.add(333);
				test.add(333);
				test.add(333);
				test.add(333);
				test.add(333);
			}
			System.out.println(test.size());
			System.out.println(System.nanoTime());
			
		}
}
