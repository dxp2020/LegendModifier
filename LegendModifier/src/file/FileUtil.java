package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
	
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
        String pathname = fileDir+fileName; 
        FileReader reader = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();       
        try{
        	reader = new FileReader(pathname);
    		br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
            	sb.append(line);
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
}
