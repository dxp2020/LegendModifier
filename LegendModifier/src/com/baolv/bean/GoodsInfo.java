package com.baolv.bean;

public class GoodsInfo {
	String gailv;//概率
	String name;//物品名称
	String monster;//怪物名称
	String mapName;//地图名称
	
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
