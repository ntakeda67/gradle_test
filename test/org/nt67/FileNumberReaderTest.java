package org.nt67;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileNumberReaderTest {

	
	@Test(expected=BatchException.class)
	public void 存在しないファイルを指定するとエラーとなる() throws BatchException {
		NumberFileReader reader = new NumberFileReader("UNKNOWN_FILE");
		reader.getNumberList();
	}
}
