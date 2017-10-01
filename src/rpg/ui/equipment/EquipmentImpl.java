package rpg.ui.equipment;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;

import rpg.items.EquipType;
import rpg.items.util.ItemUtility;
import rpg.ui.Equipment;
import rpg.user.StatusType;
import rpg.user.User;

public class EquipmentImpl implements Equipment {

	private final Logger logger = Logger.getLogger("EquipImplLogging");
	private static final String STRENGTHVALIATION = "攻撃力変動値";
	private static final String HPVALIATION = "HP変動値";

	@Override
	public void equipWeapon(User user) {
		HashMap<String, String> weapons = ItemUtility.getWeapons();
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("*** 武器装備メニュー ***");
		// 装備品が存在しない場合は、メッセージを出力
		if (weapons.size() > 0) {
			String selectedEquipment = selectEquipment(weapons, STRENGTHVALIATION);

			try {
				if (weapons.containsKey(selectedEquipment)) {
					user.attachEquipment(EquipType.WEAPON, selectedEquipment);
					user.varyStatus(StatusType.STRENGTH, new BigDecimal(weapons.get(selectedEquipment)));
				} else {
					System.out.println("入力された装備アイテムを所持していません。");
					System.out.println();
				}
				
			} catch (NullPointerException | NumberFormatException e) {
				logger.warning(String.format("装備品情報（『%s』の『%s』）に不正なデータが存在します。ステータスは変動しません。¥n", selectedEquipment, STRENGTHVALIATION));
			}

		} else {
			System.out.println("現在装備できる武器はありません。");
			System.out.println();

		}

	}

	@Override
	public void equipArmor(User user) {
		HashMap<String, String> armors = ItemUtility.getArmors();
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("*** 防具装備メニュー ***");
		// 装備品が存在しない場合は、メッセージを出力
		if (armors.size() > 0) {
			String selectedEquipment = selectEquipment(armors, HPVALIATION);

			try {
				if (armors.containsKey(selectedEquipment)) {
					user.attachEquipment(EquipType.ARMOR, selectedEquipment);
					user.varyStatus(StatusType.HP, new BigDecimal(armors.get(selectedEquipment)));
				} else {
					System.out.println("入力された装備アイテムを所持していません。");
					System.out.println();
				}

			} catch (NullPointerException | NumberFormatException e) {
				logger.warning(String.format("装備品情報（『%s』の『%s』）に不正なデータが存在します。ステータスは変動しません。¥n", selectedEquipment, HPVALIATION));
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
