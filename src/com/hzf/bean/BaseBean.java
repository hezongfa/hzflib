package com.hzf.bean;

import java.io.Serializable;

public class BaseBean implements Serializable {

	public BaseBean() {
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BaseBean [id=" + id + "]";
	}

}
