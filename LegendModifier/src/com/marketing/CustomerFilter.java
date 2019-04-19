package com.marketing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class CustomerFilter {
	private static String root = "F:/github/LegendModifier/LegendModifier/Marketing/";
	private static String fileName = "customer.txt";
	
	public static void main(String[] args) {
		String newName = filterUser();
		generateUserQQ(newName);
	}
	
	private static void generateUserQQ(String newName){
		FileReader reader = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();     
        int nums = 0;
        int count = 0;
        try{
        	reader = new FileReader(root+newName);
    		br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
            	if(!"".equals(line)) {
            		String[] arr = line.split(",");
            		if(arr.length>0&&arr[0].length()>=5){
            			sb.append(arr[0]+"@qq.com"+"\r\n");
            			count++;
            			if(count==50) {
            				nums++;
            				count=0;
            				writeContent(root+"QQ"+nums+"_"+newName, sb.toString());
            				sb.delete(0, sb.toString().length());
            			}
            		}
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
        	if(count>0) {
        		nums++;
        		writeContent(root+"QQ"+nums+"_"+newName, sb.toString());
        	}
        }
	}
	
	private static List<String> getFilterUser(){
		List<String> list = new ArrayList<>();
		list.add("主播");
		list.add("客服");
		list.add("担保");
		list.add("不管事");
		list.add("管理");
		list.add("商行");
		list.add("充值");
		list.add("举报");
		list.add("元宝");
		list.add("商人");
		return list;
	}
	
	private static boolean isInnerFilterUser(String line, List<String> userList) {
		for(String user:userList){
			if(line.contains(user)){
				return true;
			}
		}
		return false;
	}
	
	public static String filterUser(){
		String newName = null;
		List<String> userList = getFilterUser();
		InputStreamReader reader = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();       
        try{
        	reader = new InputStreamReader(new FileInputStream(root+fileName),"UTF-8");
    		br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
            	if("".equals(line)||isInnerFilterUser(line,userList)){
            		System.out.println(line + "  被删除");
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
        	newName = "handled_"+fileName;
        	writeContent(root+newName, sb.toString());
        }
        return newName;
	}

	/**
	 * 往文件中写入内容
	 * @param fileName
	 * @param content
	 */
	public static void writeContent(String filePath,String content) {
        File file = null;
        BufferedWriter fw = null;
        file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"GBK"));
            fw.write(content);
            fw.flush();
            System.out.println(filePath+"写入成功！");
        } catch (IOException e) {
        	System.out.println(filePath+"写入失败！");
            e.printStackTrace();
        } finally {
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
