package bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataProvider {
	
	public static Map<String,List<String>> getBaoLvForBoss() {
		List<String> lowBoss = DataProvider.getLowBoss();
		List<String> boss = DataProvider.getBoss();
		List<String> highBoss = DataProvider.getHighBoss();
		
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		map.put("20",lowBoss);
		map.put("30",boss);
		map.put("35",highBoss);
		return map;
	}
	
	public static Map<String,Integer> getBaolvRemindDataForLowZhuangBei(){
		Map<String,Integer> map = new HashMap<String, Integer>();
		
		map.put("圣战头盔", 15);
		map.put("圣战项链", 15);
		map.put("圣战手镯", 15);
		map.put("圣战戒指", 15);
		map.put("命运之刃", 15);
		map.put("法神头盔", 15);
		map.put("法神项链", 15);
		map.put("法神手镯", 15);
		map.put("法神戒指", 15);
		map.put("天尊头盔", 15);
		map.put("天尊项链", 15);
		map.put("天尊手镯", 15);
		map.put("天尊戒指", 15);
		
		map.put("天魔神甲", 20);
		map.put("圣战宝甲", 20);
		map.put("法神披风", 20);
		map.put("霓裳羽衣", 20);
		map.put("天尊道袍", 20);
		map.put("天师长袍", 20);
		
		map.put("雷霆项链", 25);
		map.put("雷霆护腕", 25);
		map.put("雷霆战戒", 25);
		map.put("雷霆战靴", 25);
		map.put("雷霆腰带", 25);
		map.put("烈焰项链", 25);
		map.put("烈焰护腕", 25);
		map.put("烈焰魔戒", 25);
		map.put("烈焰魔靴", 25);
		map.put("烈焰腰带", 25);
		map.put("光芒项链", 25);
		map.put("光芒护腕", 25);
		map.put("光芒道戒", 25);
		map.put("光芒道靴", 25);
		map.put("光芒腰带", 25);
		
		map.put("强化雷霆护腕", 35);
		map.put("强化雷霆战戒", 35);
		map.put("强化雷霆战靴", 35);
		map.put("强化雷霆腰带", 35);
		map.put("强化烈焰护腕", 35);
		map.put("强化烈焰魔戒", 35);
		map.put("强化烈焰魔靴", 35);
		map.put("强化烈焰腰带", 35);
		map.put("强化光芒护腕", 35);
		map.put("强化光芒道戒", 35);
		map.put("强化光芒道靴", 35);
		map.put("强化光芒腰带", 35);
		
		map.put("雷霆战甲(男)", 40);
		map.put("雷霆战甲(女)", 40);
		map.put("烈焰魔衣(男)", 40);
		map.put("烈焰魔衣(女)", 40);
		map.put("光芒道袍(男)", 40);
		map.put("光芒道袍(女)", 40);
		
		map.put("战神项链", 50);
		map.put("战神手镯", 50);
		map.put("战神戒指", 50);
		map.put("圣魔项链", 50);
		map.put("圣魔手镯", 50);
		map.put("圣魔戒指", 50);
		map.put("真魂项链", 50);
		map.put("真魂手镯", 50);
		map.put("真魂戒指", 50);
		map.put("战神头盔", 50);
		map.put("圣魔头盔", 50);
		map.put("真魂头盔", 50);
		map.put("战神圣靴", 50);
		map.put("战神腰带", 50);
		map.put("圣魔法靴", 50);
		map.put("圣魔腰带", 50);
		map.put("真魂道靴", 50);
		map.put("真魂腰带", 50);
		
		map.put("屠龙", 50);
		map.put("噬魂法杖", 50);
		map.put("霸者之刃", 50);
		
		map.put("怒斩", 25);
		map.put("龙牙", 25);
		map.put("逍遥扇", 25);
		
		map.put("裁决之杖", 20);
		map.put("骨玉权杖", 20);
		map.put("龙纹剑", 20);
		
		return map;
	}
	
	public static Map<String,Integer> getBaolvRemindData(){
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("星王神甲", 2000);
		map.put("星王神衣", 2000);
		map.put("星王战刃", 2000);
		map.put("星王道刃", 1600);
		map.put("星王法刃", 1200);
		
		map.put("开天", 800);
		map.put("玄天", 600);
		map.put("镇天", 400);
		
		map.put("凤天魔甲", 600);
		map.put("凰天魔衣", 600);
		
		map.put("黄金勋章", 250);
		map.put("黄金斗笠", 250);
		map.put("白银勋章", 100);
		map.put("白银斗笠", 100);
		
		map.put("星王战镯", 100);
		map.put("星王战戒", 100);
		
		map.put("星王道镯", 75);
		map.put("星王道戒", 75);
		
		map.put("星王法镯", 50);
		map.put("星王法戒", 50);
		
		map.put("星王战盔", 50);
		map.put("星王战带", 50);
		map.put("星王战靴", 50);
		
		map.put("星王道盔", 40);
		map.put("星王道带", 40);
		map.put("星王道靴", 40);
		
		map.put("星王法盔", 35);
		map.put("星王法带", 35);
		map.put("星王法靴", 35);
		
		return map;
	}
	
	public static List<String> getBoss(){
		List<String> list = new ArrayList<String>();
		list.add("双头血魔.txt");
		list.add("双头金刚.txt");
		list.add("沃玛教主.txt");
		list.add("牛魔王.txt");
		list.add("虹魔教主.txt");
		list.add("触龙神.txt");
		list.add("赤月恶魔.txt");
		list.add("魔龙教主.txt");
		list.add("黄泉教主.txt");
		list.add("祭灵教主.txt");
		list.add("地藏王.txt");
		list.add("龙之教主.txt");
		list.add("千年树妖.txt");
		list.add("千年尸王.txt");
		list.add("重装使者.txt");
		return list;
	}
	
	public static List<String> getHighBoss(){
		List<String> list = new ArrayList<String>();
		list.add("暗之双头血魔.txt");
		list.add("暗之双头金刚.txt");
		list.add("暗之沃玛教主.txt");
		list.add("暗之牛魔王.txt");
		list.add("暗之虹魔教主.txt");
		list.add("暗之触龙神.txt");
		list.add("暗之赤月恶魔.txt");
		list.add("暗之魔龙教主.txt");
		list.add("暗之黄泉教主.txt");
		list.add("打我爆终极.txt");
		list.add("超级魔龙教主.txt");
		list.add("斗勋教主.txt");
		list.add("绝岭道圣.txt");
		list.add("绝岭魔尊.txt");
		list.add("绝岭战神.txt");
		list.add("绝命恶魔.txt");
		list.add("龍之金龙.txt");
		list.add("龍之天珠.txt");
		list.add("神之赤月恶魔.txt");
		list.add("嗜血爆龙.txt");
		list.add("嗜血教主.txt");
		return list;
	}
	
	public static List<String> getLowBoss(){
		List<String> list = new ArrayList<String>();
		list.add("暗之骷髅精灵.txt");
		list.add("暗之魔龙力士.txt" );
		list.add("暗之魔龙力士1.txt" );
		list.add("暗之魔龙力士2.txt");
		list.add("暗之魔龙力士3.txt" );
		list.add("暗之魔龙巨蛾.txt" );
		list.add("暗之魔龙巨蛾1.txt" );
		list.add("暗之魔龙巨蛾2.txt");
		list.add("暗之魔龙巨蛾3.txt" );
		list.add("暗之魔龙战将.txt" );
		list.add("暗之魔龙战将1.txt" );
		list.add("暗之魔龙战将2.txt"); 
		list.add("暗之魔龙战将3.txt" );
		return list;
	} 
	
	public static Integer isExsitBoss(String monster,Map<String,List<String>> map) {
		Iterator iterator = map.entrySet().iterator();
		for (String key : map.keySet()) {
			Integer baolv = Integer.parseInt(key);
			List<String> list = map.get(key);
			if(list.contains(monster)) {
				return baolv;
			}
		}
		return 0;
	}
	
	public static boolean isNotExsit(String goods) {
		List<String> list = new ArrayList<String>();
		list.add("强效太阳水");
		list.add("强效太阳水");
		list.add("强效太阳水");
		list.add("强效太阳水");
		list.add("强效太阳水");
		list.add("强效太阳水");
		list.add("强效太阳水");
		list.add("强效太阳水");
		list.add("强效太阳水");
		
		return false;
	}
}
