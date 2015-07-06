package com.interview.collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class RemoveDupInArrayList {
	public static void main(String[] args) {
		RemoveDupInArrayList.withoutUsingSet();
	}
	
	private static void usingSet() {

		List<String> list = new ArrayList<String>();
		
		list.add("IOS");
		list.add("Android");
		list.add("Android");
		list.add("Symbian");
		list.add("Windows");
		
		System.out.println(list);
		
		HashSet<String> set = new HashSet<String>();
		
		for(String listElem : list) {
			set.add(listElem);
		}
		
		List<String> list1 = new ArrayList<String>(set);
		
		System.out.println(list1);
	
	}
	
	private static void withoutUsingSet() {
		List<String> list = new ArrayList<String>();
		
		list.add("IOS");
		list.add("Android");
		list.add("Android");
		list.add("Symbian");
		list.add("Windows");
		list.add("Windows");
		
		int curr = 0;
		while(curr != list.size()) {
			int runner = 0;
			
			while(runner != curr) {
				if(list.get(runner) == list.get(curr)) {
					list.remove(curr);
					curr++;
				}
				runner++;
			}
			
			if(runner == curr) {
				curr++;
			}
		}
		
		System.out.println(list);
		
		
	}
}
