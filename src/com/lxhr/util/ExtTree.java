package com.lxhr.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExtTree {
	
	public static void main(String[] args) {
		// 读取层次数据结果集列表 
				List dataList =null;// VirtualDataGenerator.getVirtualResult();		
				
				// 节点列表（散列表，用于临时存储节点对象）
				HashMap nodeList = new HashMap();
				// 根节点
				Node root = null;
				// 根据结果集构造节点列表（存入散列表）
				for (Iterator it = dataList.iterator(); it.hasNext();) {
					Map dataRecord = (Map) it.next();
					Node node = new Node();
					node.rid = (String) dataRecord.get("rid");
					node.text = (String) dataRecord.get("text");
					node.parentrid = (String) dataRecord.get("parentrid");
					nodeList.put(node.rid, node);
				}
				// 构造无序的多叉树
				Set entrySet = nodeList.entrySet();
				for (Iterator it = entrySet.iterator(); it.hasNext();) {
					Node node = (Node) ((Map.Entry) it.next()).getValue();
					if (node.parentrid == null || node.parentrid.equals("")) {
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
	}
	
}
/**
 * 10000廊坊银行总 行
     110000 廊坊 分 行
	    111000 廊坊银行金光道 
	    112000 廊坊银行解 放 道 支 行
      		112200 廊坊银行 大 街 支 行 
      		112100 廊坊银行 广 阳 道 支 行
    	113000 廊坊银行 开 发 区 支 行 
 * **/
