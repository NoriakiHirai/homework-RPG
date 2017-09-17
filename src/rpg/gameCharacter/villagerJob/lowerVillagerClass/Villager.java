package rpg.gameCharacter.villagerJob.lowerVillagerClass;

import java.math.BigDecimal;

import rpg.gameCharacter.GameCharacter;
import rpg.gameCharacter.JobCategory;

public class Villager extends GameCharacter {

	public Villager(String name) {
		// ���l�̏����\�͒l��ݒ肷��B
		super(name, JobCategory.VILLAGER, "5", "5", "10");
	}
	
	public void levelUp() {
		hp = hp.add(aggressivity.divide(BigDecimal.valueOf(2)));
		aggressivity = aggressivity.add(BigDecimal.valueOf(3));
		quickness = quickness.multiply(BigDecimal.valueOf(0.8));
		
		System.out.println();
		System.out.println(name + "�����x���A�b�v���܂���!");
	}
	
}
