package com.xhx.webapi;

import java.util.List;

public class JsonData {

	private String id;
	
	private String text;
	
	private String icon;
	
	private String data;
	
	private String type;
	
	private List<JsonData> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<JsonData> getChildren() {
		return children;
	}

	public void setChildren(List<JsonData> children) {
		this.children = children;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "JsonData [id=" + id + ", text=" + text + ", icon=" + icon
				+ ", data=" + data + ", type=" + type + ", children="
				+ children + "]";
	}
	
	
}
