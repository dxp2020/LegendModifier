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
		list.add("ڤ������");//��ͼ�в����ڵ�
		list.add("ڤ������1");
		list.add("ڤ������2");
		list.add("ڤ������3");
		list.add("ڤ�����");
		list.add("ڤ�����1");
		list.add("ڤ�����2");
		list.add("ڤ�����3");
		list.add("ڤ��ħ��");
		list.add("ڤ��ħ��1");
		list.add("ڤ��ħ��2");
		list.add("ڤ��ħ��3");
		list.add("���ʥ��");
		list.add("���ʥ��1");
		list.add("���ʥ��2");
		list.add("���ʥ��3");
		list.add("����ħ");
		list.add("��������");
		list.add("��������ħ");
		list.add("������ħ");
		list.add("����ս��");
		list.add("����ս��");
		list.add("���硤��ħ��");
		list.add("���硤�ո���");
		list.add("���硤ͳ����");
		list.add("���硤������");
		list.add("�������");
		list.add("������ȸ");
		list.add("�����ռ�����");
		list.add("��������");
		list.add("����ƽ���");
		list.add("������ʿ");
		list.add("������ʿ1");
		list.add("�Ǵ���ս1");
		list.add("�Ǵ���ս2");
		list.add("�Ǵ���ս3");
		list.add("����ħ��");
		list.add("����ħ��");
		list.add("�����ħ");
		list.add("�Ƹ�ħ��");
		list.add("Զ��ħţ");
		list.add("ѩ�����11");
		list.add("ѩ�����22");
		list.add("ѩ�����33");
		list.add("ѩ�����44");
		
		list.add("ѩ����׳�11");
		list.add("ѩ����׳�12");
		list.add("ѩ����׳�13");
		list.add("ѩ����׳�14");
		list.add("ѩ����ʿ11");
		list.add("ѩ����ʿ22");
		list.add("ѩ����ʿ33");
		list.add("ѩ����ʿ44");
		list.add("ѩ����ʿ11");
		list.add("ѩ����ʿ22");
		list.add("ѩ����ʿ33");
		list.add("ѩ����ʿ44");
		list.add("ѩ���콫11");
		list.add("ѩ���콫22");
		list.add("ѩ���콫33");
		list.add("ѩ���콫44");
		list.add("ѩ�򺮱�ħ11");
		list.add("ѩ�򺮱�ħ22");
		list.add("ѩ�򺮱�ħ33");
		list.add("ѩ�򺮱�ħ44");
		list.add("ѩ��ս��11");
		list.add("ѩ��ս��22");
		list.add("ѩ��ս��33");
		list.add("ѩ��ս��44");
		list.add("ѩ��ë��11");
		list.add("ѩ��ë��22");
		list.add("ѩ��ë��33");
		list.add("ѩ��ë��44");
		list.add("ѩ��Ұ��11");
		list.add("ѩ��Ұ��22");
		list.add("ѩ��Ұ��33");
		list.add("ѩ��Ұ��44");
		list.add("�嶾ħ");//��ͼ�д��ڵ�
		list.add("����֩��");
		list.add("��ħ֩��");
		list.add("��֮ħ����ʿ");
		list.add("��֮ħ����ʿ1");
		list.add("��֮ħ����ʿ2");
		list.add("��֮ħ����ʿ3");
		list.add("��֮ħ���޶�");
		list.add("��֮ħ���޶�1");
		list.add("��֮ħ���޶�2");
		list.add("��֮ħ���޶�3");
		list.add("��֮ħ��ս��");
		list.add("��֮ħ��ս��1");
		list.add("��֮ħ��ս��2");
		list.add("��֮ħ��ս��3");
		list.add("���Ȼ�����");
		list.add("ʥ����ʿ");
		list.add("��ħ֩��");
		list.add("��ջ���");
		list.add("����֩��");
		list.add("˫ͷѪħ");
		list.add("˫ͷ���");
		list.add("�������");
		list.add("ţħ��");
		list.add("��ħ����");
		list.add("������");
		list.add("���¶�ħ");
		list.add("ħ������");
		list.add("��Ȫ����");
		list.add("�������");
		list.add("�ز���");
		list.add("��֮����");
		list.add("ǧ������");
		list.add("ǧ��ʬ��");
		list.add("��װʹ��");
		list.add("��֮˫ͷѪħ");
		list.add("��֮˫ͷ���");
		list.add("��֮�������");
		list.add("��֮ţħ��");
		list.add("��֮��ħ����");
		list.add("��֮������");
		list.add("��֮���¶�ħ");
		list.add("��֮ħ������");
		list.add("��֮��Ȫ����");
		list.add("���ұ��ռ�");
		list.add("����ħ������");
		list.add("��ѫ����");
		list.add("�����ʥ");
		list.add("����ħ��");
		list.add("����ս��");
		list.add("������ħ");
		list.add("��֮����");
		list.add("��֮����");
		list.add("��֮���¶�ħ");
		list.add("��Ѫ����");
		list.add("��Ѫ����");
		return list;
	}
	
	public static List<String> getNoContainerZhanShenXingWangMonster(){
		List<String> list = new ArrayList<>();
		list.add("ڤ������");//��ͼ�в����ڵ�
		list.add("ڤ������1");
		list.add("ڤ������2");
		list.add("ڤ������3");
		list.add("ڤ�����");
		list.add("ڤ�����1");
		list.add("ڤ�����2");
		list.add("ڤ�����3");
		list.add("ڤ��ħ��");
		list.add("ڤ��ħ��1");
		list.add("ڤ��ħ��2");
		list.add("ڤ��ħ��3");
		list.add("���ʥ��");
		list.add("���ʥ��1");
		list.add("���ʥ��2");
		list.add("���ʥ��3");
		list.add("����ħ");
		list.add("��������");
		list.add("��������ħ");
		list.add("������ħ");
		list.add("����ս��");
		list.add("����ս��");
		list.add("���硤��ħ��");
		list.add("���硤�ո���");
		list.add("���硤ͳ����");
		list.add("���硤������");
		list.add("�������");
		list.add("������ȸ");
		list.add("�����ռ�����");
		list.add("��������");
		list.add("����ƽ���");
		list.add("������ʿ");
		list.add("������ʿ1");
		list.add("�Ǵ���ս1");
		list.add("�Ǵ���ս2");
		list.add("�Ǵ���ս3");
		list.add("����ħ��");
		list.add("����ħ��");
		list.add("�����ħ");
		list.add("�Ƹ�ħ��");
		list.add("Զ��ħţ");
		list.add("ѩ�����11");
		list.add("ѩ�����22");
		list.add("ѩ�����33");
		list.add("ѩ�����44");
		
		list.add("ѩ����׳�11");
		list.add("ѩ����׳�12");
		list.add("ѩ����׳�13");
		list.add("ѩ����׳�14");
		list.add("ѩ����ʿ11");
		list.add("ѩ����ʿ22");
		list.add("ѩ����ʿ33");
		list.add("ѩ����ʿ44");
		list.add("ѩ����ʿ11");
		list.add("ѩ����ʿ22");
		list.add("ѩ����ʿ33");
		list.add("ѩ����ʿ44");
		list.add("ѩ���콫11");
		list.add("ѩ���콫22");
		list.add("ѩ���콫33");
		list.add("ѩ���콫44");
		list.add("ѩ�򺮱�ħ11");
		list.add("ѩ�򺮱�ħ22");
		list.add("ѩ�򺮱�ħ33");
		list.add("ѩ�򺮱�ħ44");
		list.add("ѩ��ս��11");
		list.add("ѩ��ս��22");
		list.add("ѩ��ս��33");
		list.add("ѩ��ս��44");
		list.add("ѩ��ë��11");
		list.add("ѩ��ë��22");
		list.add("ѩ��ë��33");
		list.add("ѩ��ë��44");
		list.add("ѩ��Ұ��11");
		list.add("ѩ��Ұ��22");
		list.add("ѩ��Ұ��33");
		list.add("ѩ��Ұ��44");
		list.add("�嶾ħ");//��ͼ�д��ڵ�
		list.add("����֩��");
		list.add("��ħ֩��");
		list.add("��֮ħ����ʿ");
		list.add("��֮ħ����ʿ1");
		list.add("��֮ħ����ʿ2");
		list.add("��֮ħ����ʿ3");
		list.add("��֮ħ���޶�");
		list.add("��֮ħ���޶�1");
		list.add("��֮ħ���޶�2");
		list.add("��֮ħ���޶�3");
		list.add("��֮ħ��ս��");
		list.add("��֮ħ��ս��1");
		list.add("��֮ħ��ս��2");
		list.add("��֮ħ��ս��3");
		list.add("���Ȼ�����");
		list.add("ʥ����ʿ");
		list.add("��ħ֩��");
		list.add("��ջ���");
		list.add("����֩��");
		list.add("ħ����ʿ");
		list.add("ħ���޶�");
		return list;
	}
	
	public static Map<String,List<String>> getMiddleGradeMapMonsterInfo() {
		List<String> containerGoods = new ArrayList<>();
		containerGoods.add("ǿ����������");
		containerGoods.add("ǿ������ս��");
		containerGoods.add("ǿ������սѥ");
		containerGoods.add("ǿ����������");
		containerGoods.add("ǿ�����滤��");
		containerGoods.add("ǿ������ħ��");
		containerGoods.add("ǿ������ħѥ");
		containerGoods.add("ǿ����������");
		containerGoods.add("ǿ����â����");
		containerGoods.add("ǿ����â����");
		containerGoods.add("ǿ����â��ѥ");
		containerGoods.add("ǿ����â����");
		containerGoods.add("����ս��(��)");
		containerGoods.add("����ս��(Ů)");
		containerGoods.add("����ħ��(��)");
		containerGoods.add("����ħ��(Ů)");
		containerGoods.add("��â����(��)");
		containerGoods.add("��â����(Ů)");
		
		List<String> noContainerGoods = new ArrayList<>();
		noContainerGoods.add("ս������");
		noContainerGoods.add("ս������");
		noContainerGoods.add("ս���ָ");
		noContainerGoods.add("ʥħ����");
		noContainerGoods.add("ʥħ����");
		noContainerGoods.add("ʥħ��ָ");
		noContainerGoods.add("�������");
		noContainerGoods.add("�������");
		noContainerGoods.add("����ָ");
		noContainerGoods.add("ս��ͷ��");
		noContainerGoods.add("ʥħͷ��");
		noContainerGoods.add("���ͷ��");
		noContainerGoods.add("ս��ʥѥ");
		noContainerGoods.add("ս������");
		noContainerGoods.add("ʥħ��ѥ");
		noContainerGoods.add("ʥħ����");
		noContainerGoods.add("����ѥ");
		noContainerGoods.add("�������");
		noContainerGoods.add("����֮��");
		noContainerGoods.add("����");
		noContainerGoods.add("�Ȼ귨��");
		
		noContainerGoods.add("�������");
		noContainerGoods.add("��������");
		noContainerGoods.add("����ս��");
		noContainerGoods.add("����ս��");
		noContainerGoods.add("����ս��");
		noContainerGoods.add("����ս��");
		noContainerGoods.add("����սѥ");
		noContainerGoods.add("��������");
		noContainerGoods.add("��������");
		noContainerGoods.add("��������");
		noContainerGoods.add("��������");
		noContainerGoods.add("������ѥ");
		noContainerGoods.add("��������");
		noContainerGoods.add("��������");
		noContainerGoods.add("��������");
		noContainerGoods.add("��������");
		noContainerGoods.add("������ѥ");
		noContainerGoods.add("��������");
		noContainerGoods.add("��������");
		noContainerGoods.add("����ս��");
		noContainerGoods.add("����ս��");
		noContainerGoods.add("��������");
		noContainerGoods.add("��������");
		
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		map.put("container", containerGoods);
		map.put("noContainer", noContainerGoods);
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
