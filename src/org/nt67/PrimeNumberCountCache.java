package org.nt67;

/**
 * <p>
 * ある値と、その値より小さい素数の数のセットを保持します。
 * <p>
 * このクラスに値をセットする際には、値と素数の数の組の妥当性はチェックされません。
 * @author ntakeda
 *
 */
public class PrimeNumberCountCache implements Comparable<PrimeNumberCountCache>{

	public PrimeNumberCountCache(Long upperThreshold, Long numberOfPrimes) {
		this.upperThreshold = upperThreshold;
		this.numberOfPrimes = numberOfPrimes;
	}

	// この値よりも小さい素数の数を{@code numberOfPrimes}が持つ
	private Long upperThreshold;

	// {@code upperThreshold}よりも小さい素数の数
	private Long numberOfPrimes;

	public Long getUpperThreshold() {
		return upperThreshold;
	}
	public void setUpperThreshold(Long upperThreshold) {
		this.upperThreshold = upperThreshold;
	}
	public Long getNumberOfPrimes() {
		return numberOfPrimes;
	}
	public void setNumberOfPrimes(Long numberOfPrimes) {
		this.numberOfPrimes = numberOfPrimes;
	}
	@Override
	public int compareTo(PrimeNumberCountCache o) {
		return this.getUpperThreshold().compareTo(o.getUpperThreshold());
	}
}
