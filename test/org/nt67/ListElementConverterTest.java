package org.nt67;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListElementConverterTest {

	@Test(expected=IllegalArgumentException.class)
	public void 自然数ではない値が入力されるとエラーとなる() {
		List<String> inputList = new ArrayList<>();
		inputList.add("1");
		inputList.add("-1");
		ListElementConverter.convertStringToLong(inputList);
	}

	@Test(expected=IllegalArgumentException.class)
	public void 数ではない値が入力されるとエラーとなる() {
		List<String> inputList = new ArrayList<>();
		inputList.add("4");
		inputList.add("A");
		ListElementConverter.convertStringToLong(inputList);
	}

}
