package com.lxhr.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lxhr.dao.ResourceDao;

public class ResourceService {

	private ResourceDao resourceDao;

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}
	
	public JSONObject getResources(){
		JSONObject rs=new JSONObject();
		rs.put("data", JSONArray.fromObject(JSONArray.fromObject(resourceDao.getResources())));
		return rs;
	}
	
	public List<Map<String,Object>> getJsonResource(){
		return resourceDao.getResources();
	}
	
}
