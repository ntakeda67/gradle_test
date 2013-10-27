package org.nt67.context;

/**
 * 実施する処理に必要な、バッチ外部から入力される条件を保持します。
 * @author ntakeda
 *
 */
public class CountPrimeNumberContext {
	// ファイル名が指定されなかった際に読み込まれるファイル名
	private static final String DEFAULT_NUMBERS_FILE_NAME = "primenumber.txt";

	// 計算対象の値一覧を読み込むファイル名
	private String numbersFileName = DEFAULT_NUMBERS_FILE_NAME;
	
	public String getNumbersFileName() {
		return numbersFileName;
	}
	public void setNumbersFileName(String numbersFileName) {
		this.numbersFileName = numbersFileName;
	}
}
