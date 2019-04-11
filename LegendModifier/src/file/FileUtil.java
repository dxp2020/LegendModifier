package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
	
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
}
