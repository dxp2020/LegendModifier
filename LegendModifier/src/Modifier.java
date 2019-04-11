import java.io.IOException;

import file.FileUtil;

public class Modifier {
	private static String root = "C:/Users/Administrator/Desktop/开服资料/风云合击/MonItems/MonItems/";
	private static String goodsFile = "C:/Users/Administrator/Desktop/开服资料/风云合击/物品名称.txt";
	private static String mapDataFile = "C:/Users/Administrator/Desktop/开服资料/风云合击/地图数据.txt";
	
	public static void main(String[] args) throws IOException {
//		FileUtil.errorRecovery(goodsFile,root);//检查爆率文件存在的格式错误
//		FileUtil.showGoodsIsBAOCHU(true, goodsFile, root);//显示可爆、不可爆的物品
//		FileUtil.checkGoodsWhereBao("屠龙", root);//检查物品在哪爆	
//		FileUtil.showMonster(false,root,mapDataFile);//显示地图中 存在、不存在的怪物
//		FileUtil.replaceChatT(root);//替换掉'\t'为' '
//		FileUtil.rejectMonsterNoBaoGoods(goodsFile,root);//剔除爆率文件中不存在的物品
		FileUtil.showMonsterGoodsNum(root);//显示怪物可爆物品数量
    }
	
	
	
}
