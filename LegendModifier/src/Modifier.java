import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import file.FileUtil;

public class Modifier {
	private static String root = "C:/Users/Administrator/Desktop/开服资料/风云合击/MonItems/MonItems/";
	private static String goodsFile = "C:/Users/Administrator/Desktop/开服资料/风云合击/物品名称.txt";
	private static String mapDataFile = "C:/Users/Administrator/Desktop/开服资料/风云合击/地图数据.txt";
	
	public static void main(String[] args) throws IOException {
//		FileUtil.errorRecovery(goodsFile,root);//检查爆率文件存在的格式错误
//		FileUtil.showGoodsIsBAOCHU(true, goodsFile, root);//显示可爆、不可爆的物品
//		FileUtil.checkGoodsWhereBao("怒斩", root);//检查物品在哪爆	
//		FileUtil.showMonster(false,root,mapDataFile);//显示地图中 存在、不存在的怪物
//		FileUtil.replaceChatT(root);//替换掉'\t'为' '
//		FileUtil.rejectMonsterNoBaoGoods(goodsFile,root);//剔除爆率文件中不存在的物品
//		FileUtil.showMonsterGoodsNum(root);//显示怪物可爆物品数量
		
		
//		genarateMonsterNameSQL();//生成怪物名称sql
//		deleteMonster(root,"地煞");
//		checkGoodsWhereBao("战神",root);//检查物品在哪爆	
//		remindBaolv("真魂",30, root);//修改爆率
//		addGoods("星王战戒","白银勋章",200);//添加物品
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

	private static void remindBaolv(String goodsName, int balv, String root) {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		for(String monster:monsters){
//			if(monster.contains("王")
//			||monster.contains("主")
//			||monster.contains("嗜血")
//			||monster.contains("打我爆终极")
//			||monster.contains("暗之赤月恶魔.")
//			||monster.contains("绝岭")
//			) {
//				continue;
//			}
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
	            	if(!"".equals(line)&&line.contains(goodsName)) {
	            		String baolv = line.substring(line.indexOf("/")+1, line.indexOf(" "));
	            		String goodsInfo = line.substring(line.indexOf(" "),line.length());
	            		int bv = Integer.parseInt(baolv);
	            		if(bv<balv) {
	            			isChanged = true;
	            			System.out.print(line+"<--->");
	            			line = "1/"+balv+goodsInfo;
	            			System.out.println(line);
	            		}
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
