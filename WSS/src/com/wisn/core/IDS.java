package com.wisn.core;

import com.wisn.utils.LogUtils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 
 * @author Wisn
 * 2016年9月30日   上午9:23:39
 *
 */
public class IDS {
	private  static  HashSet<Long >  idSet=new LinkedHashSet<>();
	public static  boolean  getId( long  ids){
		if(idSet!=null){
			Iterator<Long> iterator = idSet.iterator();
			while (iterator.hasNext()){
				Long next = iterator.next();
				LogUtils.d("id:"+next);
			}
			return idSet.contains(ids);
		}else{
			return false;
		}

	}
	public  static boolean  addId(long  ids){
		return idSet.add(ids);
	}
	public static  boolean  addAll(HashSet<Long>  ids){
		return idSet.addAll(ids);
	}
}
