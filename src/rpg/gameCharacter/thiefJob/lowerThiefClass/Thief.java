package rpg.gameCharacter.thiefJob.lowerThiefClass;

import java.math.BigDecimal;

import rpg.gameCharacter.GameCharacter;
import rpg.gameCharacter.JobCategory;

public class Thief extends GameCharacter {

	public Thief(String name) {
		// 盗賊の初期能力値を設定する。
		super(name, JobCategory.THIEF, "8", "10", "15");
	}

	public void levelUp() {
		hp = hp.add(aggressivity.divide(BigDecimal.valueOf(3)));
		aggressivity = aggressivity.add(BigDecimal.valueOf(2));
		quickness = quickness.multiply(BigDecimal.valueOf(1.5));
		
		System.out.println();
		System.out.println(name + "がレベルアップしました!");
	}

}
