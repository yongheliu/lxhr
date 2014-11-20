package com.lxhr.dao;

import java.util.List;
import java.util.Map;

import com.lxhr.ds.BaseConnection;

public class ResourceDao extends BaseConnection {
	
	public List<Map<String,Object>> getResources(){
		String sql="select rid,text,parentrid,isnull(url,'0')as url from resource";
		List<Map<String,Object>> list=this.query(sql);
		System.out.println("list="+list);
		return list;
	}
	
}
