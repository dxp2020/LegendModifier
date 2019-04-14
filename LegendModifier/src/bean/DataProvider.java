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
		
		map.put("ʥսͷ��", 15);
		map.put("ʥս����", 15);
		map.put("ʥս����", 15);
		map.put("ʥս��ָ", 15);
		map.put("����֮��", 15);
		map.put("����ͷ��", 15);
		map.put("��������", 15);
		map.put("��������", 15);
		map.put("�����ָ", 15);
		map.put("����ͷ��", 15);
		map.put("��������", 15);
		map.put("��������", 15);
		map.put("�����ָ", 15);
		
		map.put("��ħ���", 20);
		map.put("ʥս����", 20);
		map.put("��������", 20);
		map.put("��������", 20);
		map.put("�������", 20);
		map.put("��ʦ����", 20);
		
		map.put("��������", 25);
		map.put("��������", 25);
		map.put("����ս��", 25);
		map.put("����սѥ", 25);
		map.put("��������", 25);
		map.put("��������", 25);
		map.put("���滤��", 25);
		map.put("����ħ��", 25);
		map.put("����ħѥ", 25);
		map.put("��������", 25);
		map.put("��â����", 25);
		map.put("��â����", 25);
		map.put("��â����", 25);
		map.put("��â��ѥ", 25);
		map.put("��â����", 25);
		
		map.put("ǿ����������", 35);
		map.put("ǿ������ս��", 35);
		map.put("ǿ������սѥ", 35);
		map.put("ǿ����������", 35);
		map.put("ǿ�����滤��", 35);
		map.put("ǿ������ħ��", 35);
		map.put("ǿ������ħѥ", 35);
		map.put("ǿ����������", 35);
		map.put("ǿ����â����", 35);
		map.put("ǿ����â����", 35);
		map.put("ǿ����â��ѥ", 35);
		map.put("ǿ����â����", 35);
		
		map.put("����ս��(��)", 40);
		map.put("����ս��(Ů)", 40);
		map.put("����ħ��(��)", 40);
		map.put("����ħ��(Ů)", 40);
		map.put("��â����(��)", 40);
		map.put("��â����(Ů)", 40);
		
		map.put("ս������", 50);
		map.put("ս������", 50);
		map.put("ս���ָ", 50);
		map.put("ʥħ����", 50);
		map.put("ʥħ����", 50);
		map.put("ʥħ��ָ", 50);
		map.put("�������", 50);
		map.put("�������", 50);
		map.put("����ָ", 50);
		map.put("ս��ͷ��", 50);
		map.put("ʥħͷ��", 50);
		map.put("���ͷ��", 50);
		map.put("ս��ʥѥ", 50);
		map.put("ս������", 50);
		map.put("ʥħ��ѥ", 50);
		map.put("ʥħ����", 50);
		map.put("����ѥ", 50);
		map.put("�������", 50);
		
		map.put("����", 50);
		map.put("�ɻ귨��", 50);
		map.put("����֮��", 50);
		
		map.put("ŭն", 25);
		map.put("����", 25);
		map.put("��ң��", 25);
		
		map.put("�þ�֮��", 20);
		map.put("����Ȩ��", 20);
		map.put("���ƽ�", 20);
		
		return map;
	}
	
	public static Map<String,Integer> getBaolvRemindData(){
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("�������", 2000);
		map.put("��������", 2000);
		map.put("����ս��", 2000);
		map.put("��������", 1600);
		map.put("��������", 1200);
		
		map.put("����", 800);
		map.put("����", 600);
		map.put("����", 400);
		
		map.put("����ħ��", 600);
		map.put("����ħ��", 600);
		
		map.put("�ƽ�ѫ��", 250);
		map.put("�ƽ���", 250);
		map.put("����ѫ��", 100);
		map.put("��������", 100);
		
		map.put("����ս��", 100);
		map.put("����ս��", 100);
		
		map.put("��������", 75);
		map.put("��������", 75);
		
		map.put("��������", 50);
		map.put("��������", 50);
		
		map.put("����ս��", 50);
		map.put("����ս��", 50);
		map.put("����սѥ", 50);
		
		map.put("��������", 40);
		map.put("��������", 40);
		map.put("������ѥ", 40);
		
		map.put("��������", 35);
		map.put("��������", 35);
		map.put("������ѥ", 35);
		
		return map;
	}
	
	public static List<String> getBoss(){
		List<String> list = new ArrayList<String>();
		list.add("˫ͷѪħ.txt");
		list.add("˫ͷ���.txt");
		list.add("�������.txt");
		list.add("ţħ��.txt");
		list.add("��ħ����.txt");
		list.add("������.txt");
		list.add("���¶�ħ.txt");
		list.add("ħ������.txt");
		list.add("��Ȫ����.txt");
		list.add("�������.txt");
		list.add("�ز���.txt");
		list.add("��֮����.txt");
		list.add("ǧ������.txt");
		list.add("ǧ��ʬ��.txt");
		list.add("��װʹ��.txt");
		return list;
	}
	
	public static List<String> getHighBoss(){
		List<String> list = new ArrayList<String>();
		list.add("��֮˫ͷѪħ.txt");
		list.add("��֮˫ͷ���.txt");
		list.add("��֮�������.txt");
		list.add("��֮ţħ��.txt");
		list.add("��֮��ħ����.txt");
		list.add("��֮������.txt");
		list.add("��֮���¶�ħ.txt");
		list.add("��֮ħ������.txt");
		list.add("��֮��Ȫ����.txt");
		list.add("���ұ��ռ�.txt");
		list.add("����ħ������.txt");
		list.add("��ѫ����.txt");
		list.add("�����ʥ.txt");
		list.add("����ħ��.txt");
		list.add("����ս��.txt");
		list.add("������ħ.txt");
		list.add("��֮����.txt");
		list.add("��֮����.txt");
		list.add("��֮���¶�ħ.txt");
		list.add("��Ѫ����.txt");
		list.add("��Ѫ����.txt");
		return list;
	}
	
	public static List<String> getLowBoss(){
		List<String> list = new ArrayList<String>();
		list.add("��֮���þ���.txt");
		list.add("��֮ħ����ʿ.txt" );
		list.add("��֮ħ����ʿ1.txt" );
		list.add("��֮ħ����ʿ2.txt");
		list.add("��֮ħ����ʿ3.txt" );
		list.add("��֮ħ���޶�.txt" );
		list.add("��֮ħ���޶�1.txt" );
		list.add("��֮ħ���޶�2.txt");
		list.add("��֮ħ���޶�3.txt" );
		list.add("��֮ħ��ս��.txt" );
		list.add("��֮ħ��ս��1.txt" );
		list.add("��֮ħ��ս��2.txt"); 
		list.add("��֮ħ��ս��3.txt" );
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
		list.add("ǿЧ̫��ˮ");
		list.add("ǿЧ̫��ˮ");
		list.add("ǿЧ̫��ˮ");
		list.add("ǿЧ̫��ˮ");
		list.add("ǿЧ̫��ˮ");
		list.add("ǿЧ̫��ˮ");
		list.add("ǿЧ̫��ˮ");
		list.add("ǿЧ̫��ˮ");
		list.add("ǿЧ̫��ˮ");
		
		return false;
	}
}
