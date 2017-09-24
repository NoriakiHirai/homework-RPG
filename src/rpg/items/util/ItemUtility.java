package rpg.items.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

public class ItemUtility {
	
	private final static Logger logger = Logger.getLogger("ItemUtilityLogging");
	
	public static HashMap<String, String> getWeapons() {
		String weaponFile = "C:\\Users\\nhirai\\eclipse-workspace\\javase\\8.141\\homework-RPG\\src\\rpg\\items\\weapons\\WeaponList.csv";
		return getItems(weaponFile);
	}

	public static HashMap<String, String> getArmors() {
		String armorFile = "C:\\Users\\nhirai\\eclipse-workspace\\javase\\8.141\\homework-RPG\\src\\rpg\\items\\armors\\ArmorList.csv";
		return getItems(armorFile);
	}

	private static HashMap<String, String> getItems(String fileName) {
		HashMap<String, String> itemMap = new HashMap<String, String>();
		try {
			// �t�@�C����ǂݍ���
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			// �ǂݍ��񂾃t�@�C�����P�s����������
			String line;
			while ((line = br.readLine()) != null) {
				// ��؂蕶��","�ŕ�������
				String[] itemInfo = line.split(",");
				// ����������������}�b�v�Ɋi�[����
				itemMap.put(itemInfo[0], itemInfo[1]);
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			logger.warning(String.format("�ȉ��̃t�@�C�����݂���܂���B\n%s", fileName));
//			e.printStackTrace();
		} catch (IOException e) {
			logger.warning(String.format("�ȉ��̃t�@�C���̓ǂݍ��݂Ɏ��s���܂����B\n%s", fileName));
//			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			logger.warning(String.format("�ȉ��̃t�@�C���ɕs���ȃf�[�^�����݂��܂��B\n%s", fileName));
		}

		return itemMap;

	}

}
