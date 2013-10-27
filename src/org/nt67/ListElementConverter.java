package org.nt67;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 
 * {@code java.util.List}の要素を別のクラスにソート済み集合に置き換えるクラスです。
 * @author ntakeda
 *
 */
public class ListElementConverter {

	/**
	 * Stringを要素に持つ{@code java.util.List}を Long要素の{@code java.util.SortedSet}に置き換えます。
	 * @param inputList
	 * @return
	 */
	public static SortedSet<Long> convertStringToLong(List<String> inputList){
		SortedSet<Long> sortedSet = new TreeSet<Long>();
		
		for(String element : inputList){
			Long longElement = Long.valueOf(element, 10);
			
			if(isNotNaturalNumber(longElement)){
				throw new IllegalArgumentException("自然数ではない値 " + element + "が入力されました");
			}
			sortedSet.add(longElement);
		}
		
		return sortedSet;
	}

	private static boolean isNotNaturalNumber(Long value){
		if(value < 0){
			return true;
		}
		return false;
	}
}
