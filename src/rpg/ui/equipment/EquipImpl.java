package rpg.ui.equipment;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;

import rpg.items.EquipType;
import rpg.items.util.ItemUtility;
import rpg.ui.Equip;
import rpg.user.StatusType;
import rpg.user.User;

public class EquipImpl implements Equip {

	private final Logger logger = Logger.getLogger("EquipImplLogging");

	@Override
	public void equipWeapon(User user) {
		System.out.println("*** 武器装備メニュー ***");
		HashMap<String, String> weapons = ItemUtility.getWeapons();
		// 装備品が存在しない場合は、メッセージを出力
		if (weapons.size() > 0) {
			String selectedEquipment = selectEquipment(weapons, "攻撃力上昇値");

			try {
				if (weapons.containsKey(selectedEquipment)) {
					user.attachEquipment(EquipType.WEAPON, selectedEquipment);
					user.strengthen(StatusType.STRENGTH, new BigDecimal(weapons.get(selectedEquipment)));
				} else {
					System.out.println("入力された装備アイテムは所持していません。");
					System.out.println();
				}
				
			} catch (NullPointerException e) {
				logger.warning("不正な装備品データです。");
			} catch (NumberFormatException e) {
				logger.warning(String.format("装備品情報に不正なデータが存在します。"));
			}

		} else {
			System.out.println("現在装備できる武器はありません。");
			System.out.println();

		}

	}

	@Override
	public void equipArmor(User user) {
		System.out.println("*** 防具装備メニュー ***");

		HashMap<String, String> armors = ItemUtility.getArmors();
		// 装備品が存在しない場合は、メッセージを出力
		if (armors.size() > 0) {
			String selectedEquipment = selectEquipment(armors, "HP上昇値");

			try {
				if (armors.containsKey(selectedEquipment)) {
					user.attachEquipment(EquipType.ARMOR, selectedEquipment);
					user.strengthen(StatusType.HP, new BigDecimal(armors.get(selectedEquipment)));
				} else {
					System.out.println("入力された装備アイテムは所持していません。");
					System.out.println();
				}

			} catch (NullPointerException e) {
				logger.warning("不正な装備品データです。");
			} catch (NumberFormatException e) {
				logger.warning(String.format("装備品情報に不正なデータが存在します。"));
			}

		} else {
			System.out.println("現在装備できる武器はありません。");
			System.out.println();

		}

	}

	private static String selectEquipment(HashMap<String, String> itemMap, String paramTitle) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		for (String key : itemMap.keySet()) {
			System.out.println(key);
			System.out.println("    " + paramTitle + ":" + itemMap.get(key));
			System.out.println("--------------");
		}

		System.out.print("装備するアイテムを入力してください。>");
		return sc.nextLine();
	}

}
