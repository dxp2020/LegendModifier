import file.FileUtil;

public class Modifier {
	private static String root = "D:/Documents/Tencent Files/364499854/FileRecv/MonItems/MonItems/";
	private static String goodsFile = "D:/Documents/Tencent Files/364499854/FileRecv/��Ʒ����.txt";
	private static String mapDataFile = "D:/Documents/Tencent Files/364499854/FileRecv/��ͼ����.txt";
	
	public static void main(String[] args) {
//		FileUtil.errorRecovery(goodsFile,root);
		String content = FileUtil.getTxtFileContenet("D:/Documents/Tencent Files/364499854/FileRecv/", "��ͼ����.txt");
		
		String[] monsters = FileUtil.getDirectoryFileList(root);
		for(String monster:monsters){
			monster = formartMonsterName(monster);
			if(content.contains(monster)){
//				System.out.println("��ͼ����"+monster);
			}else{
				System.out.println("��ͼ��û��"+monster);
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
