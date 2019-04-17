package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	
	/**
	 * ��ʾ����ɱ���Ʒ����
	 * @param root
	 */
	public static void showMonsterGoodsNum(String root) {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		for(String monster:monsters){
			int line = FileUtil.getTxtFileContenetLines(root+monster);
			System.out.println(monster + "--goods num--"+line);
		}
	}
	
	/**
	 * �޳������ļ��в����ڵ���Ʒ
	 */
	public static void rejectMonsterNoBaoGoods(String goodsFile,String root) {
		String goodsList = FileUtil.getTxtFileContenet(goodsFile);
		String[] listDir = FileUtil.getDirectoryFileList(root);
		for(String fileName : listDir){
			if(!fileName.contains(".txt")) {
				continue;
			}
			boolean isChanged = false;//�Ƿ����
			FileReader reader = null;
	        BufferedReader br = null;
	        StringBuffer sb = new StringBuffer();       
	        try{
	        	reader = new FileReader(root+"/"+fileName);
	    		br = new BufferedReader(reader);
	            String line;
	            while ((line = br.readLine()) != null) {
	            	if(!"".equals(line)){
	            		line = line.trim();
	            		String goodsName = line.substring(line.lastIndexOf(' '), line.length()).trim();
	            		if(!goodsList.contains(goodsName)) {
	            			System.out.println(line + " ���滻");
	            			isChanged = true;
	            			line="";
	            		}
	            	}
	            	sb.append(line+"\n");
	            }
	        } catch (Exception e) {
	        	System.out.println(fileName+"+++++++++");
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
					FileUtil.writeContent(root, fileName, sb.toString());
				}
	        }
		}
	}
	
	
	/**
	 * �滻��'\t'Ϊ' '
	 */
	public static void replaceChatT(String root){
		String[] listDir = FileUtil.getDirectoryFileList(root);
		for(String fileName : listDir){
			String content = FileUtil.getTxtFileContenet(root+fileName);
			content = content.replace('\t', ' ');
			writeContent(root,fileName, content);
		}
	}
	
	/**
	 * ���ļ���д������
	 * @param fileName
	 * @param content
	 */
	public static void writeContent(String root,String fileName,String content) {
        File file = null;
        FileWriter fw = null;
        file = new File(root + fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            System.out.println(fileName+"д��ɹ���");
        } catch (IOException e) {
        	System.out.println(fileName+"д��ʧ�ܣ�");
            e.printStackTrace();
        }finally{
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	/**
	 * ��ʾ�ɱ������ɱ�����Ʒ
	 * @param isKeBao
	 * @param goodsFile
	 * @param root
	 */
	public static void showGoodsIsBAOCHU(boolean isKeBao,String goodsFile,String root) {
		String pathname = goodsFile; 
        FileReader reader = null;
        BufferedReader br = null;
        try{
        	reader = new FileReader(pathname);
    		br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
               if(!"".equals(line)) {
            	   checkIsMonsterInner(isKeBao,line,root);
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
	
	/**
	 * �����Ʒ�Ƿ�ɱ�
	 * @param line
	 * @param root
	 * @return
	 */
	public static boolean checkIsMonsterInner(boolean isKeBao,String line,String root) {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		for(String monster:monsters){
			String content = FileUtil.getTxtFileContenet(root+monster);
			if(content.contains(line)){
				if (isKeBao) {
					System.out.println(line);
				}
				return true;
			}
		}
		if (!isKeBao) {
			System.out.println(line);
		}
		return false;
	}
	
	/**
	 * �鿴��Ʒ���ı�
	 * @param line
	 * @param root
	 * @return
	 */
	public static void checkGoodsWhereBao(String goods,String root) {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		for(String monster:monsters){
			String content = FileUtil.getTxtFileContenet(root+monster);
			if(content.contains(goods)){
				System.out.println(monster);	
			}
		}
	}
	
	/**
	 * �鿴��ͼ�� ���ڡ������ڵĹ���
	 * @param isShowExsit
	 * @param root
	 * @param mapDataFile
	 */
	public static void showMonster(boolean isShowExsit,String root,String mapDataFile) {
		String content = FileUtil.getTxtFileContenet(mapDataFile);
		String[] monsters = FileUtil.getDirectoryFileList(root);
		for(String monster:monsters){
			monster = FileUtil.formartMonsterName(monster);
			if(content.contains(monster)){
				if(isShowExsit) {
					System.out.println("��ͼ����"+monster);
				}
			}else{
				if(!isShowExsit) {
					System.out.println("��ͼ��û��"+monster);
				}
			}
		}
	}
	
	public static String formartMonsterName(String name){
		name = name.replace(".txt", "");
		for(int i=0;i<10;i++){
			name = name.replace(String.valueOf(i), "");
		}
		return name;
	}
	
	/**
	 * ��ʾ�ļ��ı�����
	 * @param fileDir Ŀ¼
	 * @param fileName �ļ�����
	 */
	public static void showTxtFileContenet(String fileDir,String fileName) {
        String pathname = fileDir+fileName; 
        FileReader reader = null;
        BufferedReader br = null;
        try{
        	reader = new FileReader(pathname);
    		br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
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
	
	/**
	 * ��ȡ�ļ��ı�����
	 * @param fileDir Ŀ¼
	 * @param fileName �ļ�����
	 */
	public static String getTxtFileContenet(String fileDir,String fileName) {
        return getTxtFileContenet(fileDir+fileName);
    }
	
	/**
	 * ��ȡ�ļ��ı�����
	 * @param fileDir Ŀ¼
	 * @param fileName �ļ�����
	 */
	public static String getTxtFileContenet(String pathname) {
        FileReader reader = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();       
        try{
        	reader = new FileReader(pathname);
    		br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
            	if(!"".equals(line)) {
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
			}
        }
        return sb.toString();
    }
	
	/**
	 * ��ʾĿ¼���ļ�����
	 * @param dir Ŀ¼
	 */
	public static void showDirectoryFileList(String dir){
		File file = new File(dir);
		if(file.isDirectory()){
			String[] list = file.list();
			for(String fileName : list){
				System.out.println(fileName);
			}
		}
	}
	
	/**
	 * ��ȡĿ¼���ļ�����
	 * @param dir Ŀ¼
	 */
	public static String[] getDirectoryFileList(String dir){
		File file = new File(dir);
		if(file.isDirectory()){
			return file.list();
		}
		return new String[]{};
	}
	
	/**
	 * ��ȡ�ļ����Ƿ� ���йؼ��ֵ���Ϣ
	 * @param filePath �ļ�·��
	 * @param key	   �ؼ���	
	 * @return
	 */
	public static String readGoodsInfo(String filePath,String key){
		File file = new File(filePath);
		FileReader reader = null;
        BufferedReader br = null;
        try{
        	reader = new FileReader(file);
    		br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
            	if(!"".equals(line)&&line.contains(key)){
            		return line +" "+ file.getName();
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
        return "��";
	}
	
	/**
	 * ��鱬���ļ�����
	 * @param goodsFile
	 * @param root
	 */
	public static void errorRecovery(String goodsFile,String root){
		FileReader reader = null;
        BufferedReader br = null;
        try{
        	reader = new FileReader(goodsFile);
    		br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
            	if(!"".equals(line)) {
            		checkGoodsWhereBao2(line,root);
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
	
	
	/**
	 * �鿴��Ʒ���ı�
	 * @param line
	 * @param root
	 * @return
	 */
	public static void checkGoodsWhereBao2(String goods,String root) throws IOException {
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
	            		line = line.trim().replace("\t"," ");
	            		System.out.println(line +"  " + monster);
	            		String[] arr = line.split(" ");
	            		String baolv = arr[0];
	            		String goodsName = arr[1];
	            	}
	            }
	        }finally{
        		if (br!=null) {
					br.close();
				}
				if(reader!=null){
					reader.close();
				}
	        }
		}
	}

	/**
	 * ��ȡ�ı����ж�����Ч����
	 * @param filePath
	 * @return
	 */
	public static int getTxtFileContenetLines(String filePath) {
		File file = new File(filePath);
		FileReader reader = null;
        BufferedReader br = null;
        int goodsNums=0;
        try{
        	reader = new FileReader(file);
    		br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
            	if(!"".equals(line)){
            		goodsNums++;
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
		return goodsNums;
	}

	public static void deleteFiles(String filePath) {
		File file = new File(filePath);
		if(file.exists()) {
			file.delete();
		}
	}
	

	public static List<String> getGoodsList(String goodsFile){
		FileReader reader = null;
        BufferedReader br = null;
        List<String> list = new ArrayList();       
        try{
        	reader = new FileReader(goodsFile);
    		br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
            	if(!"".equals(line)) {
            		list.add(line);
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
        return list;
	}
	
	public static void checkRepeatGoods(String goodsFile,String noRepeatgoodsFile, String root) {
		String[] monsters = FileUtil.getDirectoryFileList(root);
		List<String> goodslist = getGoodsList(goodsFile);
		List<String> noRepeatgoodslist = getGoodsList(noRepeatgoodsFile);
		for(String monster:monsters){
			if(!monster.contains(".txt")) {
				continue;
			}
			for(String goods:goodslist) {
				if(!noRepeatgoodslist.contains(goods)) {
					continue;
				}
				int count = 0;
				FileReader reader = null;
		        BufferedReader br = null;
		        try{
		        	reader = new FileReader(root+monster);
		    		br = new BufferedReader(reader);
		            String line;
		            while ((line = br.readLine()) != null) {
		            	if(!"".equals(line)) {
		            		String goodsInfo = line.substring(line.indexOf(" "),line.length()).trim();
		            		if(goodsInfo.equals(goods)) {
		            			count++;
		            		}
		            	}
		            	if(count>1) {
		            		System.out.println(monster+"---" + goods);
		            		String s = null;
		            		s.toString();
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
		
	}
	
	
}
