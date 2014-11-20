package com.lxhr.util;

import java.util.Comparator;


public class NodeIDComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		int j1 = Integer.parseInt(((Node)o1).rid);
	    int j2 = Integer.parseInt(((Node)o2).rid);
	    return (j1 < j2 ? -1 : (j1 == j2 ? 0 : 1));
	}	
}
