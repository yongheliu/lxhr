package com.lxhr.util;

public class Node {
	
	/**
	 * 节点编号
	 */
	
	/**
	 * 节点内容
	 */
	public String text;
	/**
	 * 父节点编号
	 */
	
	/**
	 * 孩子节点列表
	 */
	public Children children = new Children();
	public String rid;
	public String parentrid;
	public String url;
	
	// 先序遍历，拼接JSON字符串
	public String toString() {		
		String result = "{"
			+ "rid : '" + rid + "'"
			+ ", text : '" + text + "'"+",url:'"+url+"'";
		
		if (children != null && children.getSize() != 0) {
			result += ", children : " + children.toString();
		} else {
			result += ", leaf : true";
		}
				
		return result + "}";
	}
	
	// 兄弟节点横向排序
	public void sortChildren() {
		if (children != null && children.getSize() != 0) {
			children.sortChildren();
		}
	}
	
}
