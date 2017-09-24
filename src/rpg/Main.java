package rpg;

import java.util.HashMap;
import java.util.Scanner;

import rpg.items.util.ItemUtility;
import rpg.ui.equipment.Equiq;
import rpg.user.*;

public class Main {

	public static void main(String[] args) {

		User player = inputUser();
		printStatus(player);

		HashMap<String, String> weapons = ItemUtility.getWeapons();
		// �����i�����݂��Ȃ��ꍇ�́A���b�Z�[�W���o��
		if (weapons.size() > 0) {
			Equiq.EquipWeapon(player, weapons);
		} else {
			System.out.println("���ݑ����ł��镐��͂���܂���B");
			System.out.println();
		}

		HashMap<String, String> armors = ItemUtility.getArmors();
		// �����i�����݂��Ȃ��ꍇ�́A���b�Z�[�W���o��
		if (armors.size() > 0) {
			Equiq.EquipArmor(player, armors);
		} else {
			System.out.println("���ݑ����ł���h��͂���܂���B");
			System.out.println();
		}

		// player.levelUp();
		
		// �����֘A�̃��\�b�h�����s���Ă���ԁA2�x�ڂ�printStatus�����s����Ȃ��悤
		// ���Lsleep�Ŗ{���\�b�h�̎��s�𒆒f����B
		try {
			Thread.sleep(300);
			printStatus(player);
		} catch (InterruptedException e) { // ��~���ɃX���b�h�����݂���������ƁA�G���[���X���[�����B
			e.printStackTrace();
		}
	}

	static User inputUser() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("���[�U�[���쐬���܂�");
		System.out.print("���O�F");
		String userName = sc.nextLine();
		System.out.print("�E��(1�ː�m,2�˖��@�g��,3�˓���)�F");
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
		System.out.print("�U���́F");
		String str = sc.next();
		System.out.print("�f�����F");
		String agi = sc.next();
		System.out.print("HP�F");
		String hp = sc.next();
		System.out.println();
		User user = createUser(userName, userType, str, agi, hp);
		// sc.close();
		return user;
	}

	static User createUser(String userName, UserType userType, String str, String agi, String hp) {

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
	}

	static void printStatus(User user) {
		StringBuilder sb1 = new StringBuilder();
		sb1.append("��").append(user.getUserName()).append("�̃X�e�[�^�X");
		System.out.println(sb1);

		StringBuilder sb2 = new StringBuilder();
		sb2.append("�ʂ薼:").append(user.getUserType()).append(user.getUserName());
		System.out.println(sb2);

		System.out.println("HP�F" + user.getHp());
		System.out.println("�U���́F" + user.getStr());
		System.out.println("�f�����F" + user.getAgi());

		HashMap<String, String> equipments = user.getEquipments();
		if (equipments.get("weapon") == null) {
			System.out.println("����F�����Ȃ�");
		} else {
			System.out.println("����F" + equipments.get("weapon"));
		}

		if (equipments.get("armor") == null) {
			System.out.println("�h��F�����Ȃ�");
		} else {
			System.out.println("�h��F" + equipments.get("armor"));
		}

		System.out.println();
		
	}
}
