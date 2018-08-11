package com.sunbeaminfo.spring;

public class Box {
	private int length;
	private int width;
	private int heitht;
	
	public Box() {
	}
	
	public Box(int l, int w, int h) {
		this.length = l;
		this.width = w;
		this.heitht = h;
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeitht() {
		return heitht;
	}
	public void setHeitht(int breadth) {
		this.heitht = breadth;
	}

	@Override
	public String toString() {
		return "Box [length=" + length + ", width=" + width + ", heitht=" + heitht + "]";
	}
	
	public int calcVolumn() {
		return this.length * this.width * this.heitht;
	}
}
