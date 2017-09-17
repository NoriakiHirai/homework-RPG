package rpgGame;


import java.util.Scanner;

import rpgGame.gameCharacter.*;

public class Main {

	public static void main(String[] args) {
		GameCharacter player = createPlayer();
		
		System.out.println("\nあなたのステータスは以下の通りです。\n");
		displayStatus(player);
	}

	private static GameCharacter createPlayer() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("操作キャラクターを作成します。");
		System.out.println("名前と職業を入力してください。");
		
		System.out.print("名前：");
		String playerName = scanner.nextLine();
		
		System.out.print("職業（1⇒戦士,2⇒魔法使い,3⇒盗賊）：");
		String jobNumber = scanner.nextLine();
		
		scanner.close();
		
		return CharacterFactory.getCharacter(playerName, jobNumber);
	}

	// 作成したクラスからステータスを取得し、コンソールに表示する
	private static void displayStatus(GameCharacter player) {
		// コンソールに表示する値を生成する
		StringBuilder sbStatusTitle = new StringBuilder().append("■").append(player.getName()).append("のステータス");
		StringBuilder sbJob = new StringBuilder().append("職業:").append(player.getJobCategory());
		StringBuilder sbHp = new StringBuilder().append(Message.HP).append(player.getHp());
		StringBuilder sbAggresivity = new StringBuilder().append(Message.AGGRESSIVITY).append(player.getAggressivity());
		StringBuilder sbQuickness = new StringBuilder().append(Message.QUICKNESS).append(player.getQuickness());
		
		// ステータスをコンソールに表示する。
		System.out.println(sbStatusTitle.toString());
		System.out.println(sbJob.toString());
		System.out.println(sbHp.toString());
		System.out.println(sbAggresivity.toString());
		System.out.println(sbQuickness.toString());
	}
	
}