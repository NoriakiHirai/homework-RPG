package rpgGame;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Scanner�N���X���g�p���āA�l��(���O�A�E�ƁA�U���́A�f�����AHP)���͂�����B
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("���[�U�[���쐬���܂��B");
		
		System.out.print("���O�F");
		String userName = scanner.nextLine();
		
		System.out.print("�E�Ɓi1�ː�m,2�˖��@�g��,3�˓����j�F");
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
		
		// switch�����g���A�E�Ɩ���User�N���X�����������N���X���쐬����B
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
			System.out.println("�s���ȐE�Ƃł��B�������I�����܂��B");
			return;
		}
		
		// �쐬�����N���X����X�e�[�^�X���擾���A�R���\�[���ɕ\������
		displayStatus(user);
		
		// ���x���A�b�v
		user.levelUp();
	
		// �쐬�����N���X����X�e�[�^�X���擾���A�R���\�[���ɕ\������
		displayStatus(user);
		
		scanner.close();
	}

	// �쐬�����N���X����X�e�[�^�X���擾���A�R���\�[���ɕ\������
	private static void displayStatus(User user) {
		// �R���\�[���ɕ\������l�𐶐�����
		StringBuilder sbStatusTitle = new StringBuilder().append("��").append(user.getUserName()).append("�̃X�e�[�^�X");
		StringBuilder sbPopularName = new StringBuilder().append(Message.POPULARNAME).append(user.getUserType()).append(user.getUserName());
		StringBuilder sbHp = new StringBuilder().append(Message.HP).append(user.getUserHp());
		StringBuilder sbAggresivity = new StringBuilder().append(Message.AGGRESSIVITY).append(user.getUserStr());
		StringBuilder sbQuickness = new StringBuilder().append(Message.QUICKNESS).append(user.getUserAgi());
		
		// �X�e�[�^�X���R���\�[���ɕ\������B
		System.out.println();
		System.out.println(sbStatusTitle.toString());
		System.out.println(sbPopularName.toString());
		System.out.println(sbHp.toString());
		System.out.println(sbAggresivity.toString());
		System.out.println(sbQuickness.toString());
	}
	
}
