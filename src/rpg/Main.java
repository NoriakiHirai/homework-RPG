package rpg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import rpg.items.EquipType;
import rpg.items.Equipment;
import rpg.user.*;

public class Main {
	private final static Logger logger = Logger.getLogger("RpgLogging");
	private final static String STRENGTH = "攻撃力:";
	private final static String AGILITY = "素早さ:";
	private final static String HP = "HP:";
	private final static String NONEQUIP = "装備なし";

	public static void main(String[] args) {
		try {
			User player = inputUser();
			printStatus(player);
	
			equipper(player);
			printStatus(player);
		} catch (InputMismatchException | NumberFormatException | IOException e) {
			e.printStackTrace();
			return;
		}
		
		// player.levelUp();
		
	}

	static User inputUser() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		User user = null;
		try {
			System.out.println("ユーザーを作成します");
			System.out.print("名前：");
			String userName = sc.nextLine();
			System.out.print("職業(1⇒戦士,2⇒魔法使い,3⇒盗賊)：");
			int kariType = sc.nextInt();
			UserType userType = null;
			switch (kariType) {
			case 1:
				userType = UserType.WARRIOR;
				break;
			case 2:
				userType = UserType.WIZARD;
				break;
			case 3:
				userType = UserType.THIEF;
				break;
			default:
				userType = UserType.NEET;
			}
			System.out.print("攻撃力：");
			String str = sc.next();
			System.out.print("素早さ：");
			String agi = sc.next();
			System.out.print("HP：");
			String hp = sc.next();
			System.out.println();
			user = createUser(userName, userType, str, agi, hp);
			// sc.close();
		} catch (InputMismatchException e) {
			logger.severe("不正な職業選択です。");
			throw e;
		} catch (NumberFormatException e) {
			throw e;
		}
		return user;
	}

	static User createUser(String userName, UserType userType, String str, String agi, String hp) {
		try {
			switch (userType) {
			case WARRIOR:
				return new UserWAR(userName, userType, str, agi, hp);
			case WIZARD:
				return new UserWIZ(userName, userType, str, agi, hp);
			case THIEF:
				return new UserTHI(userName, userType, str, agi, hp);
			default:
				return new UserNEE(userName, userType, str, agi, hp);
			}
		} catch (NumberFormatException e) {
			throw e;
		}
	}

	static void printStatus(User user) {
		StringBuilder sb1 = new StringBuilder();
		sb1.append("■").append(user.getUserName()).append("のステータス");
		System.out.println(sb1);
		StringBuilder sb2 = new StringBuilder();
		sb2.append("通り名:").append(user.getUserType()).append(user.getUserName());
		System.out.println(sb2);
		
		String equipWeapon;
		String equipArmor;

		Equipment weapon = user.getWeapon();
		Equipment armor = user.getArmor();

		// 各種ステータスは、装備品のステータスを加算して表示する。
		BigDecimal hp = user.getHp();
		BigDecimal strength = user.getStr();
		BigDecimal agility = user.getAgi();
		
		if (weapon == null) {
			equipWeapon = NONEQUIP;
		} else {
			equipWeapon = weapon.getName();
			user.enhanceByEquipment(weapon);
		}

		if (armor == null) {
			equipArmor = NONEQUIP;
		} else {
			equipArmor = armor.getName();
			user.enhanceByEquipment(armor);
		}
		
		System.out.println(HP + hp);
		System.out.println(STRENGTH + strength);
		System.out.println(AGILITY + agility);
		System.out.println("武器：" + equipWeapon);
		System.out.println("防具：" + equipArmor);
		System.out.println();
	}

	private static void equipper(User user) throws IOException {
		HashMap<String, Equipment> weapons, armors;

		// 所持している装備品の取得
		try {
			weapons = getEquipments("src/rpg/items/WeaponList.csv");
			armors = getEquipments("src/rpg/items/ArmorList.csv");
		} catch (IOException e) {
			throw e;
		}

		// 装備するアイテムの選択 
		String selectedWeapon = selectEquipment(weapons, EquipType.WEAPON);
		// 装備アイテムのセット
		if (weapons.containsKey(selectedWeapon)) {
			user.setWeapon(weapons.get(selectedWeapon));
		} else {
			System.out.println("入力された装備アイテムを所持していません。");
			System.out.println();
		}

		String selectedArmor = selectEquipment(armors, EquipType.ARMOR);
		if (armors.containsKey(selectedArmor)) {
			user.setArmor(armors.get(selectedArmor));
		} else {
			System.out.println("入力された装備アイテムを所持していません。");
			System.out.println();
		}

	}

	private static HashMap<String, Equipment> getEquipments(String fileName) throws IOException {
		HashMap<String, Equipment> equipmentMap = new HashMap<String, Equipment>();
		try (
				// ファイルを読み込む
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);) {
			// 読み込んだファイルを１行ずつ処理する
			String line;
			while ((line = br.readLine()) != null) {
				// 区切り文字","で分割する
				String[] equipmentInfo = line.split(",");
				// 分割した文字列を引数にアイテムインスタンスを作成する。
				Equipment equipment = new Equipment(equipmentInfo[0], equipmentInfo[1], equipmentInfo[2],
						equipmentInfo[3]);
				// 作成したアイテムインスタンスをマップに格納する
				equipmentMap.put(equipment.getName(), equipment);
			}
		} catch (FileNotFoundException e) {
			logger.severe(String.format("以下のファイルがみつかりません。\n%s\n", fileName));
			throw e;
		} catch (IOException e) {
			logger.severe(String.format("以下のファイルの読み込みに失敗しました。\n%s\n", fileName));
			throw e;
		} catch (ArrayIndexOutOfBoundsException e) {
			logger.severe(String.format("以下の装備品ファイル内に不正データなデータが存在します。\n%s\n", fileName));
			throw e;
		} catch (NumberFormatException e) {
			throw e;
		}

		return equipmentMap;
	}

	private static String selectEquipment(HashMap<String, Equipment> equipmentMap, EquipType equipType) {
		switch (equipType) {
		case WEAPON:
			System.out.println("*** 武器装備メニュー ***");
			break;
		case ARMOR:
			System.out.println("*** 防具装備メニュー ***");
			break;
		}
		
		if (equipmentMap.size() != 0) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);

			for (String key : equipmentMap.keySet()) {
				System.out.println(key);
				System.out.println("    " + STRENGTH + equipmentMap.get(key).getStrength());
				System.out.println("    " + AGILITY + equipmentMap.get(key).getAgility());
				System.out.println("    " + HP + equipmentMap.get(key).getHp());
				System.out.println("--------------");
			}

			System.out.print("装備するアイテムを入力してください。>");
			return sc.nextLine();
			
		} else {
			System.out.println("現在装備できる武器はありません。");
			System.out.println();
			
		}
		
		return "";
	}

}