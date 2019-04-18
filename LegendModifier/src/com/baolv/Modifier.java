package com.baolv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.baolv.bean.DataProvider;
import com.baolv.util.FileUtil;


public class Modifier {
	private static String root = "F:/github/LegendModifier/LegendModifier/XingWangLegend/MonItems/MonItems/";
	private static String goodsFile = "F:/github/LegendModifier/LegendModifier/XingWangLegend/��Ʒ����.txt";
	private static String noRepeatgoodsFile = "F:/github/LegendModifier/LegendModifier/XingWangLegend/��Ʒ����-�����ظ�.txt";
	private static String mapDataFile = "F:/github/LegendModifier/LegendModifier/XingWangLegend/��ͼ����.txt";
	
	public static void main(String[] args){
//		FileUtil.errorRecovery(goodsFile,root);//��鱬���ļ����ڵĸ�ʽ����
//		FileUtil.checkRepeatGoods(goodsFile,noRepeatgoodsFile,root);//��鱬���ļ����Ƿ�����ظ�����Ʒ
//		FileUtil.showGoodsIsBAOCHU(true, goodsFile, root);//��ʾ�ɱ������ɱ�����Ʒ
//		FileUtil.checkGoodsWhereBao("ʥս����", root);//�����Ʒ���ı�	
//		FileUtil.showMonster(false,root,mapDataFile);//��ʾ��ͼ�� ���ڡ������ڵĹ���
//		FileUtil.replaceChatT(root);//�滻��'\t'Ϊ' '
//		FileUtil.rejectMonsterNoBaoGoods(goodsFile,root);//�޳������ļ��в����ڵ���Ʒ
//		FileUtil.showMonsterGoodsNum(root);//��ʾ����ɱ���Ʒ����
//		fixNoAutoNew();//�����û���Զ����е�����
//		remindBaoLv(DataProvider.getBaoLvForBoss(),root);//���ݹ���ȼ��趨����
		
//		genarateMonsterNameSQL();//���ɹ�������sql
//		deleteMonster(root,"��ɷ");
//		checkGoods("����",goodsFile);
//		checkGoodsWhereBao("====",root);//�����Ʒ���ı�	
//		remindBaoLv(DataProvider.getBaoLvForBoss(),root);//�趨��֮С�֡�boos����boos����
//		addGoods("����ս��","����ѫ��",200);//�����Ʒ
//		checkMonster("��֮",root);//������
//		deleteContainerZuMaMonter();//ɾ����������װ���Ĺ���
//		deleteContainer40LevelClothesMonster();//ɾ��������40���·�
//		deleteContainer42LevelClothesMonster();//ɾ��������42���·�
//		deleteNoContainerChiYueGoodsInfo();//ɾ�����ð�������װ���Ĺ���
//		deleteNoContainerLeiTingGoodsInfo();//ɾ�����ð�������װ���Ĺ���
//		deleteNoContainerZhanShenXingWangGoodsInfo();//ɾ�����ð���ս��װ���Ĺ���
//		deleteContainerQiangHuaGoodsToMonster();//ɾ�����ð���ǿ��װ���Ĺ���
//		addZumaToMonster();//�������װ����������
//		add40LevelClothesToMonster();//���40���·��������У�����֮��40���·�
//		add42LevelClothesToMonster();//���42���·���������
//		addContainerQiangHuaGoodsToMonster();//���ǿ��װ����������
//		addContainerZhanShenGoodsToMonster();//���ս��װ����������
//		addContainerXingWangGoodsToMonster();//�������װ����������
//		remindAllBaolv(DataProvider.getBaolvRemindDataForLowZhuangBei(), root);//�趨���б���(�Ƕ���װ��)
//		remindAllBaolv(DataProvider.getBaolvRemindData(), root);//�趨���б���
    }
	
	private static void addZumaToMonster() {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		List<String> mContainerZuMa= DataProvider.getZuMaGuauWu();
		Map<String,Integer> zuMaMap = DataProvider.getBaolvRemindDataForZuMa();
		for(String monster:monsters){
			String simpleMonster = monster.replace(".txt", "");
			if(mContainerZuMa.contains(simpleMonster)){
				boolean isChanged = false;
				String pathname= root+monster;
				String content = FileUtil.getTxtFileContenet(pathname);
				StringBuffer sb = new StringBuffer(content);
				for(String key:zuMaMap.keySet()){
					if(!content.contains(key)){
						isChanged = true;
						Integer baolv = zuMaMap.get(key);
						sb.append("1/"+baolv+" "+key+"\n");
						
						System.out.println(monster+" "+ "1/"+baolv+" "+key);
					}
				}
		        if (isChanged) {
					FileUtil.writeContent(root, monster, sb.toString());
					System.out.println("д��ɹ���" + monster);
				}
			}
		}
	}

	private static void deleteContainerZuMaMonter() {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		Map<String,List<String>> map = DataProvider.getGoodsGrade();
		for(String monster:monsters){
			if (monster.contains(".txt")) {
				boolean isChanged = false;
				String pathname= root+monster;
				FileReader reader = null;
		        BufferedReader br = null;
		        StringBuffer sb = new StringBuffer();       
		        try{
		        	reader = new FileReader(pathname);
		    		br = new BufferedReader(reader);
		            String line;
		            while ((line = br.readLine()) != null) {
		            	if(!"".equals(line)&&isExsitZumaGoods(line, map)){
		            		isChanged = true;
		            		System.out.println(monster+"  "+line + "���滻");
		            		sb.append("");
		            	}else{
		            		sb.append(line + "\r\n");
		            	}
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }finally{
		        	try {
		        		if (br!=null) {
							br.close();
						}
						if(reader!=null){
							reader.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
		        	if (isChanged) {
						FileUtil.writeContent(root, monster, sb.toString());
						System.out.println("д��ɹ���" + monster);
					}
		        }
			}
		}
	}

	private static void add40LevelClothesToMonster() {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		List<String> monster42 = DataProvider.getMonster40();
		List<String> monster42ClothesList = DataProvider.getGoodsGrade().get("40clothes");
		Map<String,Integer> baolvMap = DataProvider.getBaolvRemindDataForLowZhuangBei();
		for(String monster:monsters){
			if (isExsitIn4042Monster(monster,monster42)) {
				String pathname= root+monster;
				String content = FileUtil.getTxtFileContenet(pathname);
				StringBuffer sb = new StringBuffer(content); 
				for(String clothes:monster42ClothesList) {
					String contents = "1/"+baolvMap.get(clothes)+" "+clothes+"\r\n";
					sb.append(contents);
					System.out.println(contents);
				}
				FileUtil.writeContent(root, monster, sb.toString());
				System.out.println("д��ɹ���" + monster);
			}
		}
	}

	private static void add42LevelClothesToMonster() {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		List<String> monster42 = DataProvider.getMonster42();
		List<String> monster42ClothesList = DataProvider.getGoodsGrade().get("42clothes");
		Map<String,Integer> baolvMap = DataProvider.getBaolvRemindDataForLowZhuangBei();
		for(String monster:monsters){
			if (isExsitIn4042Monster(monster,monster42)) {
				String pathname= root+monster;
				String content = FileUtil.getTxtFileContenet(pathname);
				StringBuffer sb = new StringBuffer(content); 
				for(String clothes:monster42ClothesList) {
					String contents = "1/"+baolvMap.get(clothes)+" "+clothes+"\r\n";
					sb.append(contents);
					System.out.println(contents);
				}
				FileUtil.writeContent(root, monster, sb.toString());
				System.out.println("д��ɹ���" + monster);
			}
		}
	}

	private static boolean isExsitIn4042Monster(String monster, List<String> list) {
		for(String name:list) {
			if(monster.contains(name)) {
				return true;
			}
		}
		return false;
	}

	private static void deleteContainer40LevelClothesMonster() {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		Map<String,List<String>> map = DataProvider.getGoodsGrade();
		for(String monster:monsters){
			if (monster.contains(".txt")) {
				boolean isChanged = false;
				String pathname= root+monster;
				FileReader reader = null;
		        BufferedReader br = null;
		        StringBuffer sb = new StringBuffer();       
		        try{
		        	reader = new FileReader(pathname);
		    		br = new BufferedReader(reader);
		            String line;
		            while ((line = br.readLine()) != null) {
		            	if(!"".equals(line)&&isExsit40clothes(line, map)){
		            		isChanged = true;
		            		System.out.println(monster+"  "+line + "���滻");
		            		sb.append("");
		            	}else{
		            		sb.append(line + "\r\n");
		            	}
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }finally{
		        	try {
		        		if (br!=null) {
							br.close();
						}
						if(reader!=null){
							reader.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
		        	if (isChanged) {
						FileUtil.writeContent(root, monster, sb.toString());
						System.out.println("д��ɹ���" + monster);
					}
		        }
			}
		}
	}
	
	private static void deleteContainer42LevelClothesMonster() {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		Map<String,List<String>> map = DataProvider.getGoodsGrade();
		for(String monster:monsters){
			if (monster.contains(".txt")) {
				boolean isChanged = false;
				String pathname= root+monster;
				FileReader reader = null;
		        BufferedReader br = null;
		        StringBuffer sb = new StringBuffer();       
		        try{
		        	reader = new FileReader(pathname);
		    		br = new BufferedReader(reader);
		            String line;
		            while ((line = br.readLine()) != null) {
		            	if(!"".equals(line)&&isExsit42clothes(line, map)){
		            		isChanged = true;
		            		System.out.println(monster+"  "+line + "���滻");
		            		sb.append("");
		            	}else{
		            		sb.append(line + "\r\n");
		            	}
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }finally{
		        	try {
		        		if (br!=null) {
							br.close();
						}
						if(reader!=null){
							reader.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
		        	if (isChanged) {
						FileUtil.writeContent(root, monster, sb.toString());
						System.out.println("д��ɹ���" + monster);
					}
		        }
			}
		}
	}

	private static void fixNoAutoNew() {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		for(String monster:monsters){
			if (monster.contains(".txt")) {
				update(root,monster);
			}
		}
	}

	private static void update(String root,String pathName) {
		FileReader reader = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();       
        try{
        	reader = new FileReader(root+pathName);
    		br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
            	if(!"".equals(line)&&!"\n".equals(line)) {
            		sb.append(line+"\r\n");
            	}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
        	try {
        		if (br!=null) {
					br.close();
				}
				if(reader!=null){
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				FileUtil.writeContent(root, pathName, sb.toString());
			}
        }
	}
	
	private static void deleteNoContainerLeiTingGoodsInfo(){
		String[] monsters = FileUtil.getDirectoryFileList(root);
		List<String> mContainerZhanShen= DataProvider.getNoContainerLeiTingMonster();
		Map<String,List<String>> map = DataProvider.getGoodsGrade();
		for(String monster:monsters){
			String simpleMonster = monster.replace(".txt", "");
			if(mContainerZhanShen.contains(simpleMonster)){
				boolean isChanged = false;
				String pathname= root+monster;
				FileReader reader = null;
		        BufferedReader br = null;
		        StringBuffer sb = new StringBuffer();       
		        try{
		        	reader = new FileReader(pathname);
		    		br = new BufferedReader(reader);
		            String line;
		            while ((line = br.readLine()) != null) {
		            	if(!"".equals(line)&&isExsitLeiting(line, map)){
		            		isChanged = true;
		            		System.out.println(monster+"  "+line + "���滻");
		            		sb.append("");
		            	}else{
		            		sb.append(line + "\n");
		            	}
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }finally{
		        	try {
		        		if (br!=null) {
							br.close();
						}
						if(reader!=null){
							reader.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
		        	if (isChanged) {
						FileUtil.writeContent(root, monster, sb.toString());
						System.out.println("д��ɹ���" + monster);
					}
		        }
			}
		}
	}
	
	private static void deleteNoContainerChiYueGoodsInfo() {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		List<String> mContainerZhanShen= DataProvider.getNoContainerChiYueMonster();
		Map<String,List<String>> map = DataProvider.getGoodsGrade();
		for(String monster:monsters){
			String simpleMonster = monster.replace(".txt", "");
			if(mContainerZhanShen.contains(simpleMonster)){
				boolean isChanged = false;
				String pathname= root+monster;
				FileReader reader = null;
		        BufferedReader br = null;
		        StringBuffer sb = new StringBuffer();       
		        try{
		        	reader = new FileReader(pathname);
		    		br = new BufferedReader(reader);
		            String line;
		            while ((line = br.readLine()) != null) {
		            	if(!"".equals(line)&&isExsitChiYue(line, map)){
		            		isChanged = true;
		            		System.out.println(monster+"  "+line + "���滻");
		            		sb.append("");
		            	}else{
		            		sb.append(line + "\n");
		            	}
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }finally{
		        	try {
		        		if (br!=null) {
							br.close();
						}
						if(reader!=null){
							reader.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
		        	if (isChanged) {
						FileUtil.writeContent(root, monster, sb.toString());
						System.out.println("д��ɹ���" + monster);
					}
		        }
			}
		}
	}

	private static void deleteContainerQiangHuaGoodsToMonster() {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		List<String> mContainerQiangHua= DataProvider.getContainerQiangHuaMonster();
		Map<String,List<String>> map = DataProvider.getGoodsGrade();
		for(String monster:monsters){
			String simpleMonster = monster.replace(".txt", "");
			if(!mContainerQiangHua.contains(simpleMonster)){
				boolean isChanged = false;
				String pathname= root+monster;
				FileReader reader = null;
		        BufferedReader br = null;
		        StringBuffer sb = new StringBuffer();       
		        try{
		        	reader = new FileReader(pathname);
		    		br = new BufferedReader(reader);
		            String line;
		            while ((line = br.readLine()) != null) {
		            	if(!"".equals(line)&&isExsitQianghua(line, map)) {
		            		isChanged = true;
		            		System.out.println(monster+"  "+line + "���滻");
		            		sb.append("");
		            	}else{
		            		sb.append(line + "\n");
		            	}
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }finally{
		        	try {
		        		if (br!=null) {
							br.close();
						}
						if(reader!=null){
							reader.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
		        	if (isChanged) {
						FileUtil.writeContent(root, monster, sb.toString());
						System.out.println("д��ɹ���" + monster);
					}
		        }
			}
		}
	}
	
	private static void addContainerXingWangGoodsToMonster() {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		List<String> mContainerXingWang= DataProvider.getContainerXingWangMonster();
		Map<String,Integer> xingWangMap = DataProvider.getBaolvRemindData();
		for(String monster:monsters){
			String simpleMonster = monster.replace(".txt", "");
			if(mContainerXingWang.contains(simpleMonster)){
				boolean isChanged = false;
				String pathname= root+monster;
				String content = FileUtil.getTxtFileContenet(pathname);
				StringBuffer sb = new StringBuffer(content);
				for(String key:xingWangMap.keySet()){
					if(!content.contains(key)){
						isChanged = true;
						Integer baolv = xingWangMap.get(key);
						sb.append("1/"+baolv+" "+key+"\n");
						
						System.out.println(monster+" "+ "1/"+baolv+" "+key);
					}
				}
		        if (isChanged) {
					FileUtil.writeContent(root, monster, sb.toString());
					System.out.println("д��ɹ���" + monster);
				}
			}
		}
		
	}
	
	private static void addContainerZhanShenGoodsToMonster() {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		List<String> mContainerZhanShen= DataProvider.getContainerXingWangMonster();
		Map<String,Integer> zhanShenMap = DataProvider.getBaolvRemindDataForZhanShen();
		for(String monster:monsters){
			String simpleMonster = monster.replace(".txt", "");
			if(mContainerZhanShen.contains(simpleMonster)){
				boolean isChanged = false;
				String pathname= root+monster;
				String content = FileUtil.getTxtFileContenet(pathname);
				StringBuffer sb = new StringBuffer(content);
				for(String key:zhanShenMap.keySet()){
					if(!content.contains(key)){
						isChanged = true;
						Integer baolv = zhanShenMap.get(key);
						sb.append("1/"+baolv+" "+key+"\n");
						
						System.out.println(monster+" "+ "1/"+baolv+" "+key);
					}
				}
		        if (isChanged) {
					FileUtil.writeContent(root, monster, sb.toString());
					System.out.println("д��ɹ���" + monster);
				}
			}
		}
	}

	private static void addContainerQiangHuaGoodsToMonster() {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		List<String> mContainerQiangHua= DataProvider.getContainerQiangHuaMonster();
		Map<String,Integer> qiangHuaMap = DataProvider.getBaolvRemindDataForQiangHua();
		for(String monster:monsters){
			String simpleMonster = monster.replace(".txt", "");
			if(mContainerQiangHua.contains(simpleMonster)){
				boolean isChanged = false;
				String pathname= root+monster;
				String content = FileUtil.getTxtFileContenet(pathname);
				StringBuffer sb = new StringBuffer(content);
				for(String key:qiangHuaMap.keySet()){
					if(!content.contains(key)){
						isChanged = true;
						Integer baolv = qiangHuaMap.get(key);
						sb.append("1/"+baolv+" "+key+"\n");
						
						System.out.println(monster+" "+ "1/"+baolv+" "+key);
					}
				}
		        if (isChanged) {
					FileUtil.writeContent(root, monster, sb.toString());
					System.out.println("д��ɹ���" + monster);
				}
			}
		}
	}

	private static void deleteNoContainerZhanShenXingWangGoodsInfo() {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		List<String> mContainerZhanShen= DataProvider.getContainerXingWangMonster();
		Map<String,List<String>> map = DataProvider.getGoodsGrade();
		for(String monster:monsters){
			String simpleMonster = monster.replace(".txt", "");
			if(!mContainerZhanShen.contains(simpleMonster)){
				boolean isChanged = false;
				String pathname= root+monster;
				FileReader reader = null;
		        BufferedReader br = null;
		        StringBuffer sb = new StringBuffer();       
		        try{
		        	reader = new FileReader(pathname);
		    		br = new BufferedReader(reader);
		            String line;
		            while ((line = br.readLine()) != null) {
		            	if(!"".equals(line)&&isExsitZhanShen(line, map)) {
		            		isChanged = true;
		            		System.out.println(monster+"  "+line + "���滻");
		            		sb.append("");
		            	}else{
		            		sb.append(line + "\n");
		            	}
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }finally{
		        	try {
		        		if (br!=null) {
							br.close();
						}
						if(reader!=null){
							reader.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
		        	if (isChanged) {
						FileUtil.writeContent(root, monster, sb.toString());
						System.out.println("д��ɹ���" + monster);
					}
		        }
			}
		}
	}
	
	private static boolean isExsit42clothes(String line,Map<String,List<String>> map){
		List<String> list = map.get("42clothes");
		for(String goods:list){
			if(line.contains(goods)){
				return true;
			}
		}
		return false;
	}
	
	private static boolean isExsitZumaGoods(String line,Map<String,List<String>> map){
		List<String> list = map.get("zumaGoods");
		for(String goods:list){
			if(line.contains(goods)){
				return true;
			}
		}
		return false;
	}
	
	private static boolean isExsit40clothes(String line,Map<String,List<String>> map){
		List<String> list = map.get("40clothes");
		for(String goods:list){
			if(line.contains(goods)){
				return true;
			}
		}
		return false;
	}
	
	private static boolean isExsitLeiting(String line,Map<String,List<String>> map){
		List<String> list = map.get("leiting");
		for(String goods:list){
			if(line.contains(goods)){
				return true;
			}
		}
		return false;
	}
	
	private static boolean isExsitChiYue(String line,Map<String,List<String>> map){
		List<String> list = map.get("chiyue");
		for(String goods:list){
			if(line.contains(goods)){
				return true;
			}
		}
		return false;
	}
	
	private static boolean isExsitZhanShen(String line,Map<String,List<String>> map){
		List<String> list = map.get("zhangshenXingwang");
		for(String goods:list){
			if(line.contains(goods)){
				return true;
			}
		}
		return false;
	}
	
	private static boolean isExsitQianghua(String line,Map<String,List<String>> map){
		List<String> list = map.get("qianghua");
		for(String goods:list){
			if(line.contains(goods)){
				return true;
			}
		}
		return false;
	}

	private static void remindBaoLv(Map<String,List<String>> map, String root) {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		for(String monster:monsters){
			int bl = DataProvider.isExsitBoss(monster,map);
			if(bl!=0) {
				boolean isChanged = false;
				String pathname= root+monster;
				FileReader reader = null;
		        BufferedReader br = null;
		        StringBuffer sb = new StringBuffer();       
		        try{
		        	reader = new FileReader(pathname);
		    		br = new BufferedReader(reader);
		            String line;
		            while ((line = br.readLine()) != null) {
		            	if(!"".equals(line)) {
		            		String baolv = line.substring(line.indexOf("/")+1, line.indexOf(" "));
		            		String goodsInfo = line.substring(line.indexOf(" "),line.length());
		            		int bv = Integer.parseInt(baolv);
		            		if(bv>5) {
		            			isChanged = true;
		            			System.out.print(monster+" "+line+"<--->");
		            			bv = (int) ((1-bl/100f)*bv);
		            			line = "1/"+bv+" "+goodsInfo;
		            			System.out.println(line);
		            		}
		            		sb.append(line+"\n");
		            	}
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }finally{
		        	try {
		        		if (br!=null) {
							br.close();
						}
						if(reader!=null){
							reader.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
		        	if (isChanged) {
						FileUtil.writeContent(root, monster, sb.toString());
						System.out.println("д��ɹ���" + monster);
					}
		        }
			}
		}
	}

	private static void checkMonster(String monsterName, String root) {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		for(String monster:monsters){
			if(monster.contains(monsterName)) {
				System.out.println(monster.replace(".txt",""));
			}
		}
		
	}

	private static void checkGoods(String obtainGoods, String pathname) {
		FileReader reader = null;
        BufferedReader br = null;
        try{
        	reader = new FileReader(pathname);
    		br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
            	if(!"".equals(line)&&line.contains(obtainGoods)) {
            		System.out.println(line);
            	}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
        	try {
        		if (br!=null) {
					br.close();
				}
				if(reader!=null){
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
		
	}

	private static void addGoods(String obtainGoods, String addGoods, int baolv) {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		for(String monster:monsters){
			boolean isChanged = false;
			String pathname= root+monster;
			FileReader reader = null;
	        BufferedReader br = null;
	        StringBuffer sb = new StringBuffer();       
	        try{
	        	reader = new FileReader(pathname);
	    		br = new BufferedReader(reader);
	            String line;
	            while ((line = br.readLine()) != null) {
	            	if(!"".equals(line)&&line.contains(obtainGoods)) {
	            		isChanged = true;
	            		sb.append("1/"+baolv+" "+addGoods+"\n");
	            	}
	            	sb.append(line+"\n");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally{
	        	try {
	        		if (br!=null) {
						br.close();
					}
					if(reader!=null){
						reader.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
	        	if (isChanged) {
					FileUtil.writeContent(root, monster, sb.toString());
					System.out.println("д��ɹ���" + monster);
				}
	        }
		}
		
	}
	
	private static boolean isExistGoods(String line,Map<String,Integer> map) {
		Iterator iterator  = map.keySet().iterator();
		while(iterator.hasNext()) {
			String key = (String) iterator.next();
			if(line.contains(key)) {
				return true;
			}
		}
		return false;
	}

	private static void remindAllBaolv(Map<String,Integer> map, String root) {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		for(String monster:monsters){
			boolean isChanged = false;
			String pathname= root+monster;
			FileReader reader = null;
	        BufferedReader br = null;
	        StringBuffer sb = new StringBuffer();       
	        try{
	        	reader = new FileReader(pathname);
	    		br = new BufferedReader(reader);
	            String line;
	            while ((line = br.readLine()) != null) {
	            	if(!"".equals(line)&&isExistGoods(line,map)) {
	            		String goodsInfo = line.substring(line.indexOf(" "),line.length());
            			isChanged = true;
            			System.out.print(line+"<--->");
            			int baolv = map.get(goodsInfo.trim());
            			line = "1/"+baolv+goodsInfo;
            			System.out.println(line);
	            	}
	            	sb.append(line+"\n");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally{
	        	try {
	        		if (br!=null) {
						br.close();
					}
					if(reader!=null){
						reader.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
	        	if (isChanged) {
					FileUtil.writeContent(root, monster, sb.toString());
					System.out.println("д��ɹ���" + monster);
				}
	        }
		}
	}
	
	public static void checkGoodsWhereBao(String goods,String root) {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		for(String monster:monsters){
			FileReader reader = null;
	        BufferedReader br = null;
	        try{
	        	reader = new FileReader(root+monster);
	    		br = new BufferedReader(reader);
	            String line;
	            while ((line = br.readLine()) != null) {
	            	if(!"".equals(line)&&line.contains(goods)) {
	            		System.out.println(monster+" -- " + line);
	            	}
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally{
	        	try {
	        		if (br!=null) {
						br.close();
					}
					if(reader!=null){
						reader.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
		}
	}
	
	public static void deleteMonster(String root,String name) {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		for(String monster:monsters){
			if(monster.contains(name)) {
				FileUtil.deleteFiles(root+monster);
				System.out.println("ɾ����"+monster);
			}
		}
	}
	
	/**
	 * ���ɹ�������sql
	 */
	public static void genarateMonsterNameSQL() {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		for(String monster:monsters){
			if (monster.contains(".txt")) {
				System.out.println("insert into monster(name) values('" + monster.replace(".txt", "');"));
			}
		}
	}
	
	
	
}
