import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import file.FileUtil;

public class Modifier {
	private static String root = "C:/Users/Administrator/Desktop/��������/���ƺϻ�/MonItems/MonItems/";
	private static String goodsFile = "C:/Users/Administrator/Desktop/��������/���ƺϻ�/��Ʒ����.txt";
	private static String mapDataFile = "C:/Users/Administrator/Desktop/��������/���ƺϻ�/��ͼ����.txt";
	
	public static void main(String[] args) throws IOException {
//		FileUtil.errorRecovery(goodsFile,root);//��鱬���ļ����ڵĸ�ʽ����
//		FileUtil.showGoodsIsBAOCHU(true, goodsFile, root);//��ʾ�ɱ������ɱ�����Ʒ
//		FileUtil.checkGoodsWhereBao("ŭն", root);//�����Ʒ���ı�	
//		FileUtil.showMonster(false,root,mapDataFile);//��ʾ��ͼ�� ���ڡ������ڵĹ���
//		FileUtil.replaceChatT(root);//�滻��'\t'Ϊ' '
//		FileUtil.rejectMonsterNoBaoGoods(goodsFile,root);//�޳������ļ��в����ڵ���Ʒ
//		FileUtil.showMonsterGoodsNum(root);//��ʾ����ɱ���Ʒ����
		
		
//		genarateMonsterNameSQL();//���ɹ�������sql
//		deleteMonster(root,"��ɷ");
//		checkGoodsWhereBao("ս��",root);//�����Ʒ���ı�	
//		remindBaolv("���",30, root);//�޸ı���
//		addGoods("����ս��","����ѫ��",200);//�����Ʒ
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

	private static void remindBaolv(String goodsName, int balv, String root) {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		for(String monster:monsters){
//			if(monster.contains("��")
//			||monster.contains("��")
//			||monster.contains("��Ѫ")
//			||monster.contains("���ұ��ռ�")
//			||monster.contains("��֮���¶�ħ.")
//			||monster.contains("����")
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
