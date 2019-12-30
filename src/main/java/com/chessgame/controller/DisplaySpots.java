package com.chessgame.controller;

public class DisplaySpots {
int hor;
int vart;
String name;

public DisplaySpots(int hor, int vart) {
	super();
	this.hor = hor;
	this.vart = vart;
}

public DisplaySpots(String name) {
	super();
	this.name = name;
}

public int getHor() {
	return hor;
}
public void setHor(int hor) {
	this.hor = hor;
}
public int getVart() {
	return vart;
}
public void setVart(int vart) {
	this.vart = vart;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String toString() {
	if(this.name==null) {
		return hor+"---"+vart;
	}else {
		return name;
	}
}
}
