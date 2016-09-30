package com.wisn.test;

import java.util.HashSet;

public class TestCheckID {
		public static void main(String[] args) {
			HashSet<Integer>  test=new  HashSet<Integer>();
			test.add(333);
			test.add(333);
			test.add(333);
			test.add(333);
			test.add(333);
			System.out.println(test.size());
			
		}
}
