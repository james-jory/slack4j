package com.vintank.slack4j.webhook.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Field {
	private String title;
	private String value;
	@JsonProperty("short")
	private boolean isShort;
	
	Field() {
	}
	
	public Field(String title) {
		this(title, null, false);
	}
	
	public Field(String title, String value) {
		this(title, value, false);
	}
	
	public Field(String title, String value, boolean isShort) {
		this.title = title;
		this.value = value;
		this.isShort = isShort;
	}
	
	public static Field instance(String title) {
		return new Field(title);
	}
	
	public static Field instance(String title, String value) {
		return new Field(title, value);
	}
	
	public Field title(String title) {
		setTitle(title);
		return this;
	}
	
	public Field value(String value) {
		setValue(value);
		return this;
	}
	
	public Field isShort(boolean isShort) {
		setShort(isShort);
		return this;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isShort() {
		return isShort;
	}

	public void setShort(boolean isShort) {
		this.isShort = isShort;
	}
}
