package com.beardfish.educativeio;

import java.util.Comparator;
class IntegerComparator implements Comparator<Integer> {
	public int compare(Integer x, Integer y) {
		return x - y;
	}
}
