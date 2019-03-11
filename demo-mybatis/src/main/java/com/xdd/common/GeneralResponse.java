package com.xdd.common;

import com.github.pagehelper.Page;

/**
 * @author
 * @date
 */
public class GeneralResponse<T> {
	/**
	 * 0表示正常，1表示异常
	 */
	private String code;
	/**
	 * 面向用户的消息
	 */
	private String message;
	/**
	 * 面向开发者的详细信息
	 */
	private String detail;
	/**
	 * 返回给前端的数据
	 */
	private T datas;

	private Long total;
	
	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public GeneralResponse(String code, String message, String detail, T datas) {
		this.code = code;
		this.message = message;
		this.detail = detail;
		this.datas = datas;
		if(datas instanceof Page<?>) {
			this.total =  ((Page<?>) datas).getTotal();
		}
	}

	public static GeneralResponse<?> success(String message, String detail) {
		return new GeneralResponse<Object>("0", message, detail, null);
	}

	public static GeneralResponse<?> fail(String message, String detail) {
		return new GeneralResponse<Object>("1", message, detail, null);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public T getDatas() {
		return datas;
	}

	public void setDatas(T datas) {
		this.datas = datas;
	}
}
