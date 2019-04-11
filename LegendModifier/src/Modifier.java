import file.FileUtil;

public class Modifier {
	private static String root = "D:/Documents/Tencent Files/364499854/FileRecv/MonItems/MonItems/";
	private static String goodsFile = "D:/Documents/Tencent Files/364499854/FileRecv/物品名称.txt";
	private static String mapDataFile = "D:/Documents/Tencent Files/364499854/FileRecv/地图数据.txt";
	
	public static void main(String[] args) {
//		FileUtil.errorRecovery(goodsFile,root);
		String content = FileUtil.getTxtFileContenet("D:/Documents/Tencent Files/364499854/FileRecv/", "地图数据.txt");
		
		String[] monsters = FileUtil.getDirectoryFileList(root);
		for(String monster:monsters){
			monster = formartMonsterName(monster);
			if(content.contains(monster)){
//				System.out.println("地图中有"+monster);
			}else{
				System.out.println("地图中没有"+monster);
			}
			
		}
    }
	
	private static String formartMonsterName(String name){
		name = name.replace(".txt", "");
		for(int i=0;i<10;i++){
			name = name.replace(String.valueOf(i), "");
		}
		return name;
	}
	
	
	
	
	
}
