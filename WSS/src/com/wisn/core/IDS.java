package com.wisn.core;

import java.util.HashSet;
/**
 * 
 * @author Wisn
 * 2016年9月30日   上午9:23:39
 *
 */
public class IDS {
	private  static  HashSet<Long >  idSet=new  HashSet<Long>();
	public static  boolean  getId( long  ids){
		return idSet.contains(ids);
	}
	public  static boolean  addId(long  ids){
	
		return idSet.add(ids);
	}
	public static  boolean  addAll(HashSet<Long>  ids){
		return idSet.addAll(ids);
	}
}
