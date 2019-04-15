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
	private static String root = "C:/Users/Administrator/git/repository/LegendModifier/��������/MonItems/MonItems/";
	private static String goodsFile = "C:/Users/Administrator/git/repository/LegendModifier/��������/��Ʒ����.txt";
	private static String noRepeatgoodsFile = "C:/Users/Administrator/git/repository/LegendModifier/��������/��Ʒ����-�����ظ�.txt";
	private static String mapDataFile = "C:/Users/Administrator/git/repository/LegendModifier/��������/��ͼ����.txt";
	
	public static void main(String[] args){
//		FileUtil.errorRecovery(goodsFile,root);//��鱬���ļ����ڵĸ�ʽ����
//		FileUtil.checkRepeatGoods(goodsFile,noRepeatgoodsFile,root);//��鱬���ļ����Ƿ�����ظ�����Ʒ
//		FileUtil.showGoodsIsBAOCHU(true, goodsFile, root);//��ʾ�ɱ������ɱ�����Ʒ
//		FileUtil.checkGoodsWhereBao("0����44��", root);//�����Ʒ���ı�	
//		FileUtil.showMonster(false,root,mapDataFile);//��ʾ��ͼ�� ���ڡ������ڵĹ���
//		FileUtil.replaceChatT(root);//�滻��'\t'Ϊ' '
//		FileUtil.rejectMonsterNoBaoGoods(goodsFile,root);//�޳������ļ��в����ڵ���Ʒ
//		FileUtil.showMonsterGoodsNum(root);//��ʾ����ɱ���Ʒ����
		
		
//		genarateMonsterNameSQL();//���ɹ�������sql
//		deleteMonster(root,"��ɷ");
//		checkGoods("ǿ��",goodsFile);
		checkGoodsWhereBao("ʥħ",root);//�����Ʒ���ı�	
//		remindAllBaolv(DataProvider.getBaolvRemindDataForLowZhuangBei(), root);//�趨���б���(�Ƕ���װ��)
//		remindBaoLv(DataProvider.getBaoLvForBoss(),root);//�趨��֮С�֡�boos����boos����
//		remindAllBaolv(DataProvider.getBaolvRemindData(), root);//�趨���б���
//		addGoods("����ս��","����ѫ��",200);//�����Ʒ
//		checkMonster("��֮",root);//������
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
