import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import bean.DataProvider;
import file.FileUtil;

public class Modifier {
	private static String root = "C:/Users/Administrator/git/repository/LegendModifier/星王传奇/MonItems/MonItems/";
	private static String goodsFile = "C:/Users/Administrator/git/repository/LegendModifier/星王传奇/物品名称.txt";
	private static String noRepeatgoodsFile = "C:/Users/Administrator/git/repository/LegendModifier/星王传奇/物品名称-不可重复.txt";
	private static String mapDataFile = "C:/Users/Administrator/git/repository/LegendModifier/星王传奇/地图数据.txt";
	
	public static void main(String[] args){
//		FileUtil.errorRecovery(goodsFile,root);//检查爆率文件存在的格式错误
//		FileUtil.checkRepeatGoods(goodsFile,noRepeatgoodsFile,root);//检查爆率文件中是否存在重复的物品
//		FileUtil.showGoodsIsBAOCHU(true, goodsFile, root);//显示可爆、不可爆的物品
//		FileUtil.checkGoodsWhereBao("0斗笠44号", root);//检查物品在哪爆	
//		FileUtil.showMonster(false,root,mapDataFile);//显示地图中 存在、不存在的怪物
//		FileUtil.replaceChatT(root);//替换掉'\t'为' '
//		FileUtil.rejectMonsterNoBaoGoods(goodsFile,root);//剔除爆率文件中不存在的物品
//		FileUtil.showMonsterGoodsNum(root);//显示怪物可爆物品数量
		
		
//		genarateMonsterNameSQL();//生成怪物名称sql
//		deleteMonster(root,"地煞");
//		checkGoods("强化",goodsFile);
		checkGoodsWhereBao("圣魔",root);//检查物品在哪爆	
//		remindAllBaolv(DataProvider.getBaolvRemindDataForLowZhuangBei(), root);//设定固有爆率(非顶级装备)
//		remindBaoLv(DataProvider.getBaoLvForBoss(),root);//设定暗之小怪、boos、大boos爆率
//		remindAllBaolv(DataProvider.getBaolvRemindData(), root);//设定固有爆率
//		addGoods("星王战戒","白银勋章",200);//添加物品
//		checkMonster("暗之",root);//检查怪物
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
