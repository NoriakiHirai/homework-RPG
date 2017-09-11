package rpgGame;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Scannerクラスを使用して、値を(名前、職業、攻撃力、素早さ、HP)入力させる。
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("ユーザーを作成します。");
		
		System.out.print("名前：");
		String userName = scanner.nextLine();
		
		System.out.print("職業（1⇒戦士,2⇒魔法使い,3⇒盗賊）：");
		String jobNumber = scanner.nextLine();
		
		String tmpStr;
		System.out.print(Message.AGGRESSIVITY);
		tmpStr = scanner.nextLine();
		BigDecimal aggressivity = new BigDecimal(tmpStr);
		
		System.out.print(Message.QUICKNESS);
		tmpStr = scanner.nextLine();
		BigDecimal quickness = new BigDecimal(tmpStr);
		
		System.out.print(Message.HP);
		tmpStr = scanner.nextLine();
		BigDecimal hp = new BigDecimal(tmpStr);
		
		// switch文を使い、職業毎にUserクラスを実装したクラスを作成する。
		User user;
		switch(jobNumber) {
		case "1":
			user = new UserWAR(userName, UserType.WARRIOR, aggressivity, quickness, hp);
			break;
		case "2":
			user = new UserWIZ(userName, UserType.WIZARD, aggressivity, quickness, hp);
			break;
		case "3":
			user = new UserTHI(userName, UserType.THIEF, aggressivity, quickness, hp);
			break;
		default:
			System.out.println("不正な職業です。処理を終了します。");
			return;
		}
		
		// 作成したクラスからステータスを取得し、コンソールに表示する
		displayStatus(user);
		
		// レベルアップ
		user.levelUp();
	
		// 作成したクラスからステータスを取得し、コンソールに表示する
		displayStatus(user);
		
		scanner.close();
	}

	// 作成したクラスからステータスを取得し、コンソールに表示する
	private static void displayStatus(User user) {
		// コンソールに表示する値を生成する
		StringBuilder sbStatusTitle = new StringBuilder().append("■").append(user.getUserName()).append("のステータス");
		StringBuilder sbPopularName = new StringBuilder().append(Message.POPULARNAME).append(user.getUserType()).append(user.getUserName());
		StringBuilder sbHp = new StringBuilder().append(Message.HP).append(user.getUserHp());
		StringBuilder sbAggresivity = new StringBuilder().append(Message.AGGRESSIVITY).append(user.getUserStr());
		StringBuilder sbQuickness = new StringBuilder().append(Message.QUICKNESS).append(user.getUserAgi());
		
		// ステータスをコンソールに表示する。
		System.out.println();
		System.out.println(sbStatusTitle.toString());
		System.out.println(sbPopularName.toString());
		System.out.println(sbHp.toString());
		System.out.println(sbAggresivity.toString());
		System.out.println(sbQuickness.toString());
	}
	
}
