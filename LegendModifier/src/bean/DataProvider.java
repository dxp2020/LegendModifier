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
	
	public static List<String> getContainerQiangHuaMonster(){
		List<String> list = new ArrayList<>();
		list.add("冥界王子");//地图中不存在的
		list.add("冥界王子1");
		list.add("冥界王子2");
		list.add("冥界王子3");
		list.add("冥界鬼王");
		list.add("冥界鬼王1");
		list.add("冥界鬼王2");
		list.add("冥界鬼王3");
		list.add("冥界魔尊");
		list.add("冥界魔尊1");
		list.add("冥界魔尊2");
		list.add("冥界魔尊3");
		list.add("天罡圣兽");
		list.add("天罡圣兽1");
		list.add("天罡圣兽2");
		list.add("天罡圣兽3");
		list.add("寒冰魔");
		list.add("寒冰侍卫");
		list.add("寒冰灭天魔");
		list.add("寒冰巨魔");
		list.add("寒冰战将");
		list.add("寒冰战将");
		list.add("暴风·巨魔兽");
		list.add("暴风·收割者");
		list.add("暴风·统治者");
		list.add("暴风·赤炎龙");
		list.add("暴风巨兽");
		list.add("暴风朱雀");
		list.add("暴风终级神龙");
		list.add("暴风蓝龙");
		list.add("暴风黄金龙");
		list.add("炼狱妖士");
		list.add("炼狱妖士1");
		list.add("狼锤铁战1");
		list.add("狼锤铁战2");
		list.add("狼锤铁战3");
		list.add("神器魔王");
		list.add("经验魔王");
		list.add("西域恶魔");
		list.add("财富魔王");
		list.add("远古魔牛");
		list.add("雪域冰狼11");
		list.add("雪域冰狼22");
		list.add("雪域冰狼33");
		list.add("雪域冰狼44");
		
		list.add("雪域冰甲虫11");
		list.add("雪域冰甲虫12");
		list.add("雪域冰甲虫13");
		list.add("雪域冰甲虫14");
		list.add("雪域力士11");
		list.add("雪域力士22");
		list.add("雪域力士33");
		list.add("雪域力士44");
		list.add("雪域卫士11");
		list.add("雪域卫士22");
		list.add("雪域卫士33");
		list.add("雪域卫士44");
		list.add("雪域天将11");
		list.add("雪域天将22");
		list.add("雪域天将33");
		list.add("雪域天将44");
		list.add("雪域寒冰魔11");
		list.add("雪域寒冰魔22");
		list.add("雪域寒冰魔33");
		list.add("雪域寒冰魔44");
		list.add("雪域战将11");
		list.add("雪域战将22");
		list.add("雪域战将33");
		list.add("雪域战将44");
		list.add("雪域毛人11");
		list.add("雪域毛人22");
		list.add("雪域毛人33");
		list.add("雪域毛人44");
		list.add("雪域野人11");
		list.add("雪域野人22");
		list.add("雪域野人33");
		list.add("雪域野人44");
		list.add("五毒魔");//地图中存在的
		list.add("巨镰蜘蛛");
		list.add("恶魔蜘蛛");
		list.add("暗之魔龙力士");
		list.add("暗之魔龙力士1");
		list.add("暗之魔龙力士2");
		list.add("暗之魔龙力士3");
		list.add("暗之魔龙巨蛾");
		list.add("暗之魔龙巨蛾1");
		list.add("暗之魔龙巨蛾2");
		list.add("暗之魔龙巨蛾3");
		list.add("暗之魔龙战将");
		list.add("暗之魔龙战将1");
		list.add("暗之魔龙战将2");
		list.add("暗之魔龙战将3");
		list.add("狂热火蜥蜴");
		list.add("圣殿卫士");
		list.add("绿魔蜘蛛");
		list.add("金刚护卫");
		list.add("金杖蜘蛛");
		list.add("双头血魔");
		list.add("双头金刚");
		list.add("沃玛教主");
		list.add("牛魔王");
		list.add("虹魔教主");
		list.add("触龙神");
		list.add("赤月恶魔");
		list.add("魔龙教主");
		list.add("黄泉教主");
		list.add("祭灵教主");
		list.add("地藏王");
		list.add("龙之教主");
		list.add("千年树妖");
		list.add("千年尸王");
		list.add("重装使者");
		list.add("暗之双头血魔");
		list.add("暗之双头金刚");
		list.add("暗之沃玛教主");
		list.add("暗之牛魔王");
		list.add("暗之虹魔教主");
		list.add("暗之触龙神");
		list.add("暗之赤月恶魔");
		list.add("暗之魔龙教主");
		list.add("暗之黄泉教主");
		list.add("打我爆终极");
		list.add("超级魔龙教主");
		list.add("斗勋教主");
		list.add("绝岭道圣");
		list.add("绝岭魔尊");
		list.add("绝岭战神");
		list.add("绝命恶魔");
		list.add("龍之金龙");
		list.add("龍之天珠");
		list.add("神之赤月恶魔");
		list.add("嗜血爆龙");
		list.add("嗜血教主");
		return list;
	}
	
	public static List<String> getNoContainerZhanShenXingWangMonster(){
		List<String> list = new ArrayList<>();
		list.add("冥界王子");//地图中不存在的
		list.add("冥界王子1");
		list.add("冥界王子2");
		list.add("冥界王子3");
		list.add("冥界鬼王");
		list.add("冥界鬼王1");
		list.add("冥界鬼王2");
		list.add("冥界鬼王3");
		list.add("冥界魔尊");
		list.add("冥界魔尊1");
		list.add("冥界魔尊2");
		list.add("冥界魔尊3");
		list.add("天罡圣兽");
		list.add("天罡圣兽1");
		list.add("天罡圣兽2");
		list.add("天罡圣兽3");
		list.add("寒冰魔");
		list.add("寒冰侍卫");
		list.add("寒冰灭天魔");
		list.add("寒冰巨魔");
		list.add("寒冰战将");
		list.add("寒冰战将");
		list.add("暴风·巨魔兽");
		list.add("暴风·收割者");
		list.add("暴风·统治者");
		list.add("暴风·赤炎龙");
		list.add("暴风巨兽");
		list.add("暴风朱雀");
		list.add("暴风终级神龙");
		list.add("暴风蓝龙");
		list.add("暴风黄金龙");
		list.add("炼狱妖士");
		list.add("炼狱妖士1");
		list.add("狼锤铁战1");
		list.add("狼锤铁战2");
		list.add("狼锤铁战3");
		list.add("神器魔王");
		list.add("经验魔王");
		list.add("西域恶魔");
		list.add("财富魔王");
		list.add("远古魔牛");
		list.add("雪域冰狼11");
		list.add("雪域冰狼22");
		list.add("雪域冰狼33");
		list.add("雪域冰狼44");
		
		list.add("雪域冰甲虫11");
		list.add("雪域冰甲虫12");
		list.add("雪域冰甲虫13");
		list.add("雪域冰甲虫14");
		list.add("雪域力士11");
		list.add("雪域力士22");
		list.add("雪域力士33");
		list.add("雪域力士44");
		list.add("雪域卫士11");
		list.add("雪域卫士22");
		list.add("雪域卫士33");
		list.add("雪域卫士44");
		list.add("雪域天将11");
		list.add("雪域天将22");
		list.add("雪域天将33");
		list.add("雪域天将44");
		list.add("雪域寒冰魔11");
		list.add("雪域寒冰魔22");
		list.add("雪域寒冰魔33");
		list.add("雪域寒冰魔44");
		list.add("雪域战将11");
		list.add("雪域战将22");
		list.add("雪域战将33");
		list.add("雪域战将44");
		list.add("雪域毛人11");
		list.add("雪域毛人22");
		list.add("雪域毛人33");
		list.add("雪域毛人44");
		list.add("雪域野人11");
		list.add("雪域野人22");
		list.add("雪域野人33");
		list.add("雪域野人44");
		list.add("五毒魔");//地图中存在的
		list.add("巨镰蜘蛛");
		list.add("恶魔蜘蛛");
		list.add("暗之魔龙力士");
		list.add("暗之魔龙力士1");
		list.add("暗之魔龙力士2");
		list.add("暗之魔龙力士3");
		list.add("暗之魔龙巨蛾");
		list.add("暗之魔龙巨蛾1");
		list.add("暗之魔龙巨蛾2");
		list.add("暗之魔龙巨蛾3");
		list.add("暗之魔龙战将");
		list.add("暗之魔龙战将1");
		list.add("暗之魔龙战将2");
		list.add("暗之魔龙战将3");
		list.add("狂热火蜥蜴");
		list.add("圣殿卫士");
		list.add("绿魔蜘蛛");
		list.add("金刚护卫");
		list.add("金杖蜘蛛");
		list.add("魔龙力士");
		list.add("魔龙巨蛾");
		return list;
	}
	
	public static Map<String,List<String>> getMiddleGradeMapMonsterInfo() {
		List<String> containerGoods = new ArrayList<>();
		containerGoods.add("强化雷霆护腕");
		containerGoods.add("强化雷霆战戒");
		containerGoods.add("强化雷霆战靴");
		containerGoods.add("强化雷霆腰带");
		containerGoods.add("强化烈焰护腕");
		containerGoods.add("强化烈焰魔戒");
		containerGoods.add("强化烈焰魔靴");
		containerGoods.add("强化烈焰腰带");
		containerGoods.add("强化光芒护腕");
		containerGoods.add("强化光芒道戒");
		containerGoods.add("强化光芒道靴");
		containerGoods.add("强化光芒腰带");
		containerGoods.add("雷霆战甲(男)");
		containerGoods.add("雷霆战甲(女)");
		containerGoods.add("烈焰魔衣(男)");
		containerGoods.add("烈焰魔衣(女)");
		containerGoods.add("光芒道袍(男)");
		containerGoods.add("光芒道袍(女)");
		
		List<String> noContainerGoods = new ArrayList<>();
		noContainerGoods.add("战神项链");
		noContainerGoods.add("战神手镯");
		noContainerGoods.add("战神戒指");
		noContainerGoods.add("圣魔项链");
		noContainerGoods.add("圣魔手镯");
		noContainerGoods.add("圣魔戒指");
		noContainerGoods.add("真魂项链");
		noContainerGoods.add("真魂手镯");
		noContainerGoods.add("真魂戒指");
		noContainerGoods.add("战神头盔");
		noContainerGoods.add("圣魔头盔");
		noContainerGoods.add("真魂头盔");
		noContainerGoods.add("战神圣靴");
		noContainerGoods.add("战神腰带");
		noContainerGoods.add("圣魔法靴");
		noContainerGoods.add("圣魔腰带");
		noContainerGoods.add("真魂道靴");
		noContainerGoods.add("真魂腰带");
		noContainerGoods.add("霸者之刃");
		noContainerGoods.add("屠龙");
		noContainerGoods.add("嗜魂法杖");
		
		noContainerGoods.add("星王神甲");
		noContainerGoods.add("星王神衣");
		noContainerGoods.add("星王战链");
		noContainerGoods.add("星王战镯");
		noContainerGoods.add("星王战戒");
		noContainerGoods.add("星王战带");
		noContainerGoods.add("星王战靴");
		noContainerGoods.add("星王法链");
		noContainerGoods.add("星王法镯");
		noContainerGoods.add("星王法戒");
		noContainerGoods.add("星王法带");
		noContainerGoods.add("星王法靴");
		noContainerGoods.add("星王道链");
		noContainerGoods.add("星王道镯");
		noContainerGoods.add("星王道戒");
		noContainerGoods.add("星王道带");
		noContainerGoods.add("星王道靴");
		noContainerGoods.add("星王法盔");
		noContainerGoods.add("星王道盔");
		noContainerGoods.add("星王战盔");
		noContainerGoods.add("星王战刃");
		noContainerGoods.add("星王道刃");
		noContainerGoods.add("星王法刃");
		
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		map.put("container", containerGoods);
		map.put("noContainer", noContainerGoods);
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
