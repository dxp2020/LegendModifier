package com.baolv.bean;

public class GoodsInfo {
	String gailv;//����
	String name;//��Ʒ����
	String monster;//��������
	String mapName;//��ͼ����
	
	public String getGailv() {
		return gailv;
	}
	public void setGailv(String gailv) {
		this.gailv = gailv;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMonster() {
		return monster;
	}
	public void setMonster(String monster) {
		this.monster = monster;
	}
	public String getMapName() {
		return mapName;
	}
	public void setMapName(String mapName) {
		this.mapName = mapName;
	}
	@Override
	public String toString() {
		return "GoodsInfo [gailv=" + gailv + ", name=" + name + ", monster=" + monster + ", mapName=" + mapName + "]";
	}
	
	
	
}
