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
		System.out.println("*** ���푕�����j���[ ***");
		HashMap<String, String> weapons = ItemUtility.getWeapons();
		// �����i�����݂��Ȃ��ꍇ�́A���b�Z�[�W���o��
		if (weapons.size() > 0) {
			String selectedEquipment = selectEquipment(weapons, "�U���͏㏸�l");

			try {
				if (weapons.containsKey(selectedEquipment)) {
					user.attachEquipment(EquipType.WEAPON, selectedEquipment);
					user.strengthen(StatusType.STRENGTH, new BigDecimal(weapons.get(selectedEquipment)));
				} else {
					System.out.println("���͂��ꂽ�����A�C�e���͏������Ă��܂���B");
					System.out.println();
				}
				
			} catch (NullPointerException e) {
				logger.warning("�s���ȑ����i�f�[�^�ł��B");
			} catch (NumberFormatException e) {
				logger.warning(String.format("�����i���ɕs���ȃf�[�^�����݂��܂��B"));
			}

		} else {
			System.out.println("���ݑ����ł��镐��͂���܂���B");
			System.out.println();

		}

	}

	@Override
	public void equipArmor(User user) {
		System.out.println("*** �h������j���[ ***");

		HashMap<String, String> armors = ItemUtility.getArmors();
		// �����i�����݂��Ȃ��ꍇ�́A���b�Z�[�W���o��
		if (armors.size() > 0) {
			String selectedEquipment = selectEquipment(armors, "HP�㏸�l");

			try {
				if (armors.containsKey(selectedEquipment)) {
					user.attachEquipment(EquipType.ARMOR, selectedEquipment);
					user.strengthen(StatusType.HP, new BigDecimal(armors.get(selectedEquipment)));
				} else {
					System.out.println("���͂��ꂽ�����A�C�e���͏������Ă��܂���B");
					System.out.println();
				}

			} catch (NullPointerException e) {
				logger.warning("�s���ȑ����i�f�[�^�ł��B");
			} catch (NumberFormatException e) {
				logger.warning(String.format("�����i���ɕs���ȃf�[�^�����݂��܂��B"));
			}

		} else {
			System.out.println("���ݑ����ł��镐��͂���܂���B");
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

		System.out.print("��������A�C�e������͂��Ă��������B>");
		return sc.nextLine();
	}

}
