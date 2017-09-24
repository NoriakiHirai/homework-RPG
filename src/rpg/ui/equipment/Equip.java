package rpg.ui.equipment;

import java.util.HashMap;
import java.util.Scanner;

import rpg.user.User;

public class Equip {

	public static void equipWeapon(User user, HashMap<String, String> itemMap) {
		System.out.println("*** ���푕�����j���[ ***");
		displayEquipments(itemMap, "�U����");

		String choiceItem = choiceItem(itemMap);
		user.equipWeapon(choiceItem, itemMap.get(choiceItem));
	}

	public static void equipArmor(User user, HashMap<String, String> itemMap) {
		System.out.println("*** �h������j���[ ***");
		displayEquipments(itemMap, "�h���");

		String choiceItem = choiceItem(itemMap);
		user.equipArmor(choiceItem, itemMap.get(choiceItem));
	}

	private static void displayEquipments(HashMap<String, String> itemMap, String paramTitle) {
		for (String key : itemMap.keySet()) {
			System.out.println(key);
			System.out.println("    " + paramTitle + ":" + itemMap.get(key));
			System.out.println("--------------");
		}
	}

	private static String choiceItem(HashMap<String, String> itemMap) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("��������A�C�e������͂��Ă��������B>");
		return sc.nextLine();
	}

}
