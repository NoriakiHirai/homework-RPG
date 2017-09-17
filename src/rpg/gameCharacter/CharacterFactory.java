package rpg.gameCharacter;

import rpg.gameCharacter.thiefJob.lowerThiefClass.Thief;
import rpg.gameCharacter.villagerJob.lowerVillagerClass.Villager;
import rpg.gameCharacter.warriorJob.lowerWarriorClass.Warrior;
import rpg.gameCharacter.wizardJob.lowerWizardClass.Wizard;

public class CharacterFactory {
	public static GameCharacter getCharacter(String name, String jobNumber) {
		switch (jobNumber) {
		case "1":
			return new Warrior(name);
		case "2":
			return new Wizard(name);
		case "3":
			return new Thief(name);
		default:
			return new Villager(name);
		}
	}
}
