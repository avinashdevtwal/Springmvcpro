package com.learn.helper;

public class Message {
private String containt; 
private String type;
public String getContaint() {
	return containt;
}
public void setContaint(String containt) {
	this.containt = containt;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Message(String containt, String type) {
	super();
	this.containt = containt;
	this.type = type;
}


}
