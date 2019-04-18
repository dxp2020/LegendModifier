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
	private static String goodsFile = "F:/github/LegendModifier/LegendModifier/XingWangLegend/物品名称.txt";
	private static String noRepeatgoodsFile = "F:/github/LegendModifier/LegendModifier/XingWangLegend/物品名称-不可重复.txt";
	private static String mapDataFile = "F:/github/LegendModifier/LegendModifier/XingWangLegend/地图数据.txt";
	
	public static void main(String[] args){
//		FileUtil.errorRecovery(goodsFile,root);//检查爆率文件存在的格式错误
//		FileUtil.checkRepeatGoods(goodsFile,noRepeatgoodsFile,root);//检查爆率文件中是否存在重复的物品
//		FileUtil.showGoodsIsBAOCHU(true, goodsFile, root);//显示可爆、不可爆的物品
//		FileUtil.checkGoodsWhereBao("圣战手镯", root);//检查物品在哪爆	
//		FileUtil.showMonster(false,root,mapDataFile);//显示地图中 存在、不存在的怪物
//		FileUtil.replaceChatT(root);//替换掉'\t'为' '
//		FileUtil.rejectMonsterNoBaoGoods(goodsFile,root);//剔除爆率文件中不存在的物品
//		FileUtil.showMonsterGoodsNum(root);//显示怪物可爆物品数量
//		fixNoAutoNew();//解决了没有自动换行的问题
//		remindBaoLv(DataProvider.getBaoLvForBoss(),root);//根据怪物等级设定爆率
		
//		genarateMonsterNameSQL();//生成怪物名称sql
//		deleteMonster(root,"地煞");
//		checkGoods("星王",goodsFile);
//		checkGoodsWhereBao("====",root);//检查物品在哪爆	
//		remindBaoLv(DataProvider.getBaoLvForBoss(),root);//设定暗之小怪、boos、大boos爆率
//		addGoods("星王战戒","白银勋章",200);//添加物品
//		checkMonster("暗之",root);//检查怪物
//		deleteContainerZuMaMonter();//删除含有祖玛装备的怪物
//		deleteContainer40LevelClothesMonster();//删除怪物中40级衣服
//		deleteContainer42LevelClothesMonster();//删除怪物中42级衣服
//		deleteNoContainerChiYueGoodsInfo();//删除不该包含赤月装备的怪物
//		deleteNoContainerLeiTingGoodsInfo();//删除不该包含雷霆装备的怪物
//		deleteNoContainerZhanShenXingWangGoodsInfo();//删除不该包含战神装备的怪物
//		deleteContainerQiangHuaGoodsToMonster();//删除不该包含强化装备的怪物
//		addZumaToMonster();//添加祖玛装备到怪物中
//		add40LevelClothesToMonster();//添加40级衣服到怪物中，六大暗之爆40级衣服
//		add42LevelClothesToMonster();//添加42级衣服到怪物中
//		addContainerQiangHuaGoodsToMonster();//添加强化装备到怪物中
//		addContainerZhanShenGoodsToMonster();//添加战神装备到怪物中
//		addContainerXingWangGoodsToMonster();//添加星王装备到怪物中
//		remindAllBaolv(DataProvider.getBaolvRemindDataForLowZhuangBei(), root);//设定固有爆率(非顶级装备)
//		remindAllBaolv(DataProvider.getBaolvRemindData(), root);//设定固有爆率
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
					System.out.println("写入成功：" + monster);
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
		            		System.out.println(monster+"  "+line + "被替换");
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
						System.out.println("写入成功：" + monster);
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
				System.out.println("写入成功：" + monster);
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
				System.out.println("写入成功：" + monster);
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
		            		System.out.println(monster+"  "+line + "被替换");
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
						System.out.println("写入成功：" + monster);
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
		            		System.out.println(monster+"  "+line + "被替换");
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
						System.out.println("写入成功：" + monster);
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
		            		System.out.println(monster+"  "+line + "被替换");
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
						System.out.println("写入成功：" + monster);
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
		            		System.out.println(monster+"  "+line + "被替换");
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
						System.out.println("写入成功：" + monster);
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
		            		System.out.println(monster+"  "+line + "被替换");
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
						System.out.println("写入成功：" + monster);
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
					System.out.println("写入成功：" + monster);
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
					System.out.println("写入成功：" + monster);
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
					System.out.println("写入成功：" + monster);
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
		            		System.out.println(monster+"  "+line + "被替换");
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
						System.out.println("写入成功：" + monster);
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
						System.out.println("写入成功：" + monster);
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
					System.out.println("写入成功：" + monster);
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
					System.out.println("写入成功：" + monster);
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
				System.out.println("删除了"+monster);
			}
		}
	}
	
	/**
	 * 生成怪物名称sql
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
