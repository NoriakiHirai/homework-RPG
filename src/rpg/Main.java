package rpg;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;
import rpg.ui.Equipment;
import rpg.ui.equipment.EquipmentImpl;
import rpg.user.*;

public class Main {
	private final static Logger logger = Logger.getLogger("RpgLogging");

	public static void main(String[] args) {
		try {
			User player = inputUser();
			printStatus(player);
			Equipment equip = new EquipmentImpl();
			equip.equipWeapon(player);
			equip.equipArmor(player);
			// 装備関連のメソッドを実行している間、2度目のprintStatusが実行されないよう
			// 下記sleepで本メソッドの実行を中断する。
			Thread.sleep(300);
			printStatus(player);
		} catch (InterruptedException | InputMismatchException
				| NumberFormatException e) {
			e.printStackTrace();
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

	static User createUser(String userName, UserType userType, String str,
			String agi, String hp) {
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
		sb2.append("通り名:").append(user.getUserType())
				.append(user.getUserName());
		System.out.println(sb2);
		System.out.println("HP：" + user.getHp());
		System.out.println("攻撃力：" + user.getStr());
		System.out.println("素早さ：" + user.getAgi());
		HashMap<String, String> equipments = user.getEquipments();
		if (equipments.get("weapon") == null) {
			System.out.println("武器：装備なし");
		} else {
			System.out.println("武器：" + equipments.get("weapon"));
		}
		if (equipments.get("armor") == null) {
			System.out.println("防具：装備なし");
		} else {
			System.out.println("防具：" + equipments.get("armor"));
		}
		System.out.println();
	}
}