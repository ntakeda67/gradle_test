package org.nt67;

import org.apache.commons.lang.exception.NestableException;

/**
 * バッチ実行中に発生した例外を表すクラスです。
 * @author ntakeda
 *
 */
public class BatchException extends NestableException {

	private static final long serialVersionUID = 6626675080338746227L;


	public BatchException(String message) {
		super(message);
	}
	public BatchException(String message, Throwable t){
		super(message, t);
	}
	

	@Override
	public String toString(){
		return super.toString();
	}
}
