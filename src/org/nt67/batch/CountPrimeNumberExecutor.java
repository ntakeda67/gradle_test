package org.nt67.batch;

import java.util.List;
import java.util.SortedSet;

import org.nt67.BatchException;
import org.nt67.NumberFileReader;
import org.nt67.ListElementConverter;
import org.nt67.PrimeNumberCounter;
import org.nt67.context.CountPrimeNumberContext;

/**
 * <p>
 * 入力ファイルに記入された数値以下の素数の数を出力します。
 * <p>
 * 入力ファイルの仕様は下記の物を想定しています。
 * <ul>
 * <li>一行ごとに半角アラビア数字で計算対象の値が記されている</li>
 * <li>値は{@code java.lang.Long.MAX_VALUE}(2^63-1)より小さい</li>
 * </ul>
 * @author ntakeda
 *
 */
public class CountPrimeNumberExecutor {

	public static void main(String[] args) {
		CountPrimeNumberContext context = new CountPrimeNumberContext();
		
		NumberFileReader reader = new NumberFileReader(context.getNumbersFileName());
		
		List<String> numberStringList = null;
		try {
			numberStringList = reader.getNumberList();
		} catch (BatchException e) {
			System.err.println("バッチ実行に失敗しました。");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		
		
		SortedSet<Long> numberSet = ListElementConverter.convertStringToLong(numberStringList);
		
		for(Long number : numberSet){
			PrimeNumberCounter counter = new PrimeNumberCounter();
			System.out.println(counter.countPrimeNumber(number));
		}
	}

}