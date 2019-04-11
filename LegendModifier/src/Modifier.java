import java.util.ArrayList;
import java.util.List;

import bean.GoodsInfo;
import file.FileUtil;

public class Modifier {
	private static String root = "D:/Documents/Tencent Files/364499854/FileRecv/MonItems/MonItems/";
	
	public static void main(String[] args) {
		List<GoodsInfo> list = showGoodsFromWhere(root,"Õ¿¡˙");
		for(GoodsInfo info :list){
			System.out.println(info.toString());
		}
    }
	
	public static List<GoodsInfo> showGoodsFromWhere(String fileDir,String goods){
		List<GoodsInfo> list = new ArrayList<>();
		String[] files = FileUtil.getDirectoryFileList(fileDir);
		for(String fileName: files){
			String content = FileUtil.readGoodsInfo(fileDir+fileName,goods).trim();
			if(!"Œﬁ".equals(content)){
				content = content.replace('\t', ' ');
				String gailv = content.substring(0,content.indexOf(" "));
                String otherInfo = content.substring(content.indexOf(" "),content.length()).trim();
                String[] others = otherInfo.split(" ");
                System.out.println(content);
				GoodsInfo goodsInfo = new GoodsInfo();
				goodsInfo.setGailv(gailv);
				goodsInfo.setName(others[0]);
				goodsInfo.setMonster(others[1]);
				list.add(goodsInfo);
			}
		}
		return list;
	}
	
	
	
}
