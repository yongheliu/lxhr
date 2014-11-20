package com.lxhr.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONObject;

import com.lxhr.service.ResourceService;
import com.lxhr.util.Node;

@Controller
@RequestMapping("/resource.do")
public class ResourceController {
	
	private ResourceService resourceService;

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	
	@RequestMapping(params = "method=getResource")
	public void getResource(HttpServletRequest request, HttpServletResponse response){
		
		JSONObject rs=null;
		PrintWriter pw=null;
		response.setCharacterEncoding("UTF-8");
		try {
			pw=response.getWriter();
			rs=resourceService.getResources();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(rs.toString());
		
	}
	
	@RequestMapping(params = "method=getJsonResource")
	public void getJsonResource(HttpServletRequest request, HttpServletResponse response){
		List dataList=resourceService.getJsonResource();
		PrintWriter pw=null;
		response.setCharacterEncoding("UTF-8");
		try {
			pw=response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap nodeList = new HashMap();
		// 根节点
		Node root = null;
		// 根据结果集构造节点列表（存入散列表）
		for (Iterator it = dataList.iterator(); it.hasNext();) {
			Map dataRecord = (Map) it.next();
			Node node = new Node();
			node.rid = String.valueOf(dataRecord.get("rid"));System.out.println("rid="+node.rid);
			node.text =dataRecord.get("text").toString(); System.out.println("text="+node.text);
			node.parentrid =String.valueOf(dataRecord.get("parentrid")); System.out.println("parentrid="+node.parentrid);
			node.url=dataRecord.get("url").toString();
			nodeList.put(node.rid, node);
		}
		// 构造无序的多叉树
		Set entrySet = nodeList.entrySet();
		for (Iterator it = entrySet.iterator(); it.hasNext();) {
			Node node = (Node) ((Map.Entry) it.next()).getValue();
			if (node.parentrid.equals("0")) {//node.parentrid == null ||
				root = node;
			} else {
				((Node) nodeList.get(node.parentrid)).children.addChild(node);
			}
		}
		// 输出无序的树形菜单的JSON字符串
		System.out.println(root.toString());			
		// 对多叉树进行横向排序
		root.sortChildren();
		// 输出有序的树形菜单的JSON字符串
		System.out.println(root.toString());	
		pw.print(root.toString());
	}
	
}
