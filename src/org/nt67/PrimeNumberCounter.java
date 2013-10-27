package org.nt67;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 素数の数を数える機能を提供します。
 * <p>
 * 一度計算した結果はフィールド中にキャッシュし、以降の計算ではそのキャッシュの結果を利用します。
 * 素数の判定は試し割り法で実施します。
 * @author ntakeda
 *
 */
public class PrimeNumberCounter {

	/**
	 * <p>
	 * ある値未満の素数の数を計算した結果を記憶します。
	 * <ul>
	 * <li>key: 値</li>
	 * <li>value: keyの値以下の素数の数</li>
	 * </ul>
	 */
	private static SortedSet<PrimeNumberCountCache> primeNumberCountCacheList;

	// 計算の過程で素数であると判定された値をキャッシュします
	private static SortedSet<Long> cachedPrimeNumberSet;

	static {
		cachedPrimeNumberSet = new TreeSet<Long>();
		cachedPrimeNumberSet.add(2L);
		cachedPrimeNumberSet.add(3L);

		primeNumberCountCacheList = new TreeSet<PrimeNumberCountCache>();
		primeNumberCountCacheList.add(new PrimeNumberCountCache(0L, 0L));
		primeNumberCountCacheList.add(new PrimeNumberCountCache(1L, 0L));
		primeNumberCountCacheList.add(new PrimeNumberCountCache(2L, 0L));
		primeNumberCountCacheList.add(new PrimeNumberCountCache(3L, 1L));
	}

	/**
	 * 指定した値より小さい素数の数を返します。
	 * @param upperThreshold
	 * @return
	 */
	public Long countPrimeNumber(Long upperThreshold){
		// 指定した値より小さく、
		// かつキャッシュされた計算結果の中で最大の入力値
	    PrimeNumberCountCache cachedUpperThreshold = primeNumberCountCacheList.first();
		for(PrimeNumberCountCache cache : primeNumberCountCacheList){
			Long cacheThreshold = cache.getUpperThreshold();

			if(cacheThreshold.equals(upperThreshold)){
				return cache.getNumberOfPrimes();
			}

			if(upperThreshold.compareTo(cacheThreshold) > 0){
				cachedUpperThreshold = cache;
				continue;
			}
			return cachedUpperThreshold.getNumberOfPrimes() + countPrimeNumber(cachedUpperThreshold.getUpperThreshold(), upperThreshold);
		}
		return primeNumberCountCacheList.last().getNumberOfPrimes() + countPrimeNumber(cachedUpperThreshold.getUpperThreshold(), upperThreshold);
	}

	/**
	 * 指定した値の間の素数の数を返します。
	 * 計算範囲の上限値自身が素数であっても
	 * 返す値には含みません。
	 *
	 * @param from 計算範囲の下限（結果に自身を含まむ）
	 * @param to   計算範囲の上限（結果に自身を含まない）
	 * @return
	 */
	public Long countPrimeNumber(Long from, Long to){
		if(from > to){
			throw new IllegalArgumentException("指定された下限値が上限値よりも大きい");
		}
		Long number = 0L;
		for(Long index = from; index < to; index++){
			if(isPrime(index)){
				number++;
			}
		}
		return number;
	}

	/**
	 * 与えられた値が素数であるか判定します。
	 * @param value
	 * @return
	 */
	public boolean isPrime(Long value){
		if(value.equals(1L) || value.equals(0L)){
			return false;
		}

		for(Long prime : cachedPrimeNumberSet){
			if(prime.equals(value)){
				return true;
			}
			if(value % prime == 0){
				return false;
			}
		}


		for(Long candidate = cachedPrimeNumberSet.last() + 1; candidate < value; candidate++){
			if(value % candidate == 0){
				return false;
			}
		}

		cachedPrimeNumberSet.add(value);
		return true;
	}
}
