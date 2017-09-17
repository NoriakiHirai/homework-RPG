package rpg.gameCharacter.wizardJob.lowerWizardClass;

import java.math.BigDecimal;

import rpg.gameCharacter.GameCharacter;
import rpg.gameCharacter.JobCategory;

public class Wizard extends GameCharacter {

	public Wizard(String name) {
		// ���@�g���̏����\�͒l��ݒ肷��B
		super(name, JobCategory.WIZARD, "12", "7", "12");
	}

	public void levelUp() {
		hp = hp.add(aggressivity.divide(BigDecimal.valueOf(4)));
		aggressivity = aggressivity.add(BigDecimal.valueOf(4));
		quickness = quickness.multiply(BigDecimal.valueOf(1.4));
		
		System.out.println();
		System.out.println(name + "�����x���A�b�v���܂���!");
	}

}
