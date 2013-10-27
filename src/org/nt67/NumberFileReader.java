package org.nt67;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;

/**
 * 素数の数を数えるべき値が記載されたファイルをを読み込むクラスです。
 * @author ntakeda
 *
 */
public class NumberFileReader {
	private String filename;
	
	public NumberFileReader(String filename) {
		this.filename = filename;
	}

	public List<String> getNumberList() throws BatchException{
		try {
			return IOUtils.readLines(this.getClass().getResourceAsStream("/" + filename));
		} catch (IOException | NullPointerException e) {
			throw new BatchException("指定したファイル " + filename + " の読み込みに失敗しました", e);
		}
	}
}
