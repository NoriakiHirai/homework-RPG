package rpg.items.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

public class ItemUtility {
	private final static Logger logger = Logger.getLogger("RpgLogging");

	public static HashMap<String, String> getWeapons() throws IOException {
		String weaponFile = "src/rpg/items/weapons/WeaponList.csv";
		return getItems(weaponFile);
	}

	public static HashMap<String, String> getArmors() throws IOException {
		String armorFile = "src/rpg/items/armors/ArmorList.csv";
		return getItems(armorFile);
	}

	private static HashMap<String, String> getItems(String fileName) throws IOException {
		HashMap<String, String> itemMap = new HashMap<String, String>();
		try (
			// ファイルを読み込む
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
		) {
			// 読み込んだファイルを１行ずつ処理する
			String line;
			while ((line = br.readLine()) != null) {
				// 区切り文字","で分割する
				String[] itemInfo = line.split(",");
				// 分割した文字列をマップに格納する
				itemMap.put(itemInfo[0], itemInfo[1]);
			}
		} catch (FileNotFoundException e) {
			logger.warning(String.format("以下のファイルがみつかりません。\n%s\n", fileName));
			throw e;
		} catch (IOException e) {
			logger.warning(String
					.format("以下のファイルの読み込みに失敗しました。\n%s\n", fileName));
			throw e;
		} catch (ArrayIndexOutOfBoundsException e) {
			logger.warning(String
					.format("以下のファイル内に不正データなデータが存在します。\n%s\n", fileName));
			throw e;
		}
		return itemMap;
	}
}