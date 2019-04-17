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
	 * 显示怪物可爆物品数量
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
	 * 剔除爆率文件中不存在的物品
	 */
	public static void rejectMonsterNoBaoGoods(String goodsFile,String root) {
		String goodsList = FileUtil.getTxtFileContenet(goodsFile);
		String[] listDir = FileUtil.getDirectoryFileList(root);
		for(String fileName : listDir){
			if(!fileName.contains(".txt")) {
				continue;
			}
			boolean isChanged = false;//是否存在
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
	            			System.out.println(line + " 被替换");
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
	 * 替换掉'\t'为' '
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
	 * 往文件中写入内容
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
            System.out.println(fileName+"写入成功！");
        } catch (IOException e) {
        	System.out.println(fileName+"写入失败！");
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
	 * 显示可爆、不可爆的物品
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
	 * 检查物品是否可爆
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
	 * 查看物品在哪爆
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
	 * 查看地图中 存在、不存在的怪物
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
					System.out.println("地图中有"+monster);
				}
			}else{
				if(!isShowExsit) {
					System.out.println("地图中没有"+monster);
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
	 * 显示文件文本内容
	 * @param fileDir 目录
	 * @param fileName 文件名称
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
	 * 获取文件文本内容
	 * @param fileDir 目录
	 * @param fileName 文件名称
	 */
	public static String getTxtFileContenet(String fileDir,String fileName) {
        return getTxtFileContenet(fileDir+fileName);
    }
	
	/**
	 * 获取文件文本内容
	 * @param fileDir 目录
	 * @param fileName 文件名称
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
	 * 显示目录下文件名称
	 * @param dir 目录
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
	 * 获取目录下文件名称
	 * @param dir 目录
	 */
	public static String[] getDirectoryFileList(String dir){
		File file = new File(dir);
		if(file.isDirectory()){
			return file.list();
		}
		return new String[]{};
	}
	
	/**
	 * 读取文件中是否 含有关键字的信息
	 * @param filePath 文件路径
	 * @param key	   关键字	
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
        return "无";
	}
	
	/**
	 * 检查爆率文件错误
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
	 * 查看物品在哪爆
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
	 * 获取文本内有多少有效行数
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
