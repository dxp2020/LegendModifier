import java.io.IOException;

import file.FileUtil;

public class Modifier {
	private static String root = "C:/Users/Administrator/Desktop/��������/���ƺϻ�/MonItems/MonItems/";
	private static String goodsFile = "C:/Users/Administrator/Desktop/��������/���ƺϻ�/��Ʒ����.txt";
	private static String mapDataFile = "C:/Users/Administrator/Desktop/��������/���ƺϻ�/��ͼ����.txt";
	
	public static void main(String[] args) throws IOException {
//		FileUtil.errorRecovery(goodsFile,root);//��鱬���ļ����ڵĸ�ʽ����
//		FileUtil.showGoodsIsBAOCHU(true, goodsFile, root);//��ʾ�ɱ������ɱ�����Ʒ
//		FileUtil.checkGoodsWhereBao("����", root);//�����Ʒ���ı�	
//		FileUtil.showMonster(false,root,mapDataFile);//��ʾ��ͼ�� ���ڡ������ڵĹ���
//		FileUtil.replaceChatT(root);//�滻��'\t'Ϊ' '
//		FileUtil.rejectMonsterNoBaoGoods(goodsFile,root);//�޳������ļ��в����ڵ���Ʒ
		FileUtil.showMonsterGoodsNum(root);//��ʾ����ɱ���Ʒ����
    }
	
	
	
}
