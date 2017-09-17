package rpgGame;


import java.util.Scanner;

import rpgGame.gameCharacter.*;

public class Main {

	public static void main(String[] args) {
		GameCharacter player = createPlayer();
		
		System.out.println("\n���Ȃ��̃X�e�[�^�X�͈ȉ��̒ʂ�ł��B\n");
		displayStatus(player);
	}

	private static GameCharacter createPlayer() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("����L�����N�^�[���쐬���܂��B");
		System.out.println("���O�ƐE�Ƃ���͂��Ă��������B");
		
		System.out.print("���O�F");
		String playerName = scanner.nextLine();
		
		System.out.print("�E�Ɓi1�ː�m,2�˖��@�g��,3�˓����j�F");
		String jobNumber = scanner.nextLine();
		
		scanner.close();
		
		return CharacterFactory.getCharacter(playerName, jobNumber);
	}

	// �쐬�����N���X����X�e�[�^�X���擾���A�R���\�[���ɕ\������
	private static void displayStatus(GameCharacter player) {
		// �R���\�[���ɕ\������l�𐶐�����
		StringBuilder sbStatusTitle = new StringBuilder().append("��").append(player.getName()).append("�̃X�e�[�^�X");
		StringBuilder sbJob = new StringBuilder().append("�E��:").append(player.getJobCategory());
		StringBuilder sbHp = new StringBuilder().append(Message.HP).append(player.getHp());
		StringBuilder sbAggresivity = new StringBuilder().append(Message.AGGRESSIVITY).append(player.getAggressivity());
		StringBuilder sbQuickness = new StringBuilder().append(Message.QUICKNESS).append(player.getQuickness());
		
		// �X�e�[�^�X���R���\�[���ɕ\������B
		System.out.println(sbStatusTitle.toString());
		System.out.println(sbJob.toString());
		System.out.println(sbHp.toString());
		System.out.println(sbAggresivity.toString());
		System.out.println(sbQuickness.toString());
	}
	
}