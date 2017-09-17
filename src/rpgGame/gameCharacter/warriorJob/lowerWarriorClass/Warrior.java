package rpgGame.gameCharacter.warriorJob.lowerWarriorClass;

import java.math.BigDecimal;

import rpgGame.gameCharacter.GameCharacter;
import rpgGame.gameCharacter.JobCategory;

public class Warrior extends GameCharacter {

	public Warrior(String name) {
		// ��m�̏����\�͒l��ݒ肷��B
		super(name, JobCategory.WARRIOR, "10", "8", "20");
	}

	public void levelUp() {
		hp = hp.add(aggressivity.divide(BigDecimal.valueOf(2)));
		aggressivity = aggressivity.add(BigDecimal.valueOf(3));
		quickness = quickness.multiply(BigDecimal.valueOf(1.3));
		
		System.out.println();
		System.out.println(name + "�����x���A�b�v���܂���!");
	}

}
