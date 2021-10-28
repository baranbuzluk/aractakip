package com.ldselektronik.application.enums;

public enum WindowType {
	MAIN(Constant.MAIN),
	NORMAL(Constant.NORMAL);

	private final String strType;

	private WindowType(String strType) {
		this.strType = strType;
	}
	
	public String getType()
	{
		return strType;
	}
	
	public static class Constant
	{
		public static final String MAIN = "window.main";
		public static final String NORMAL = "window.normal";
	}

	
}

