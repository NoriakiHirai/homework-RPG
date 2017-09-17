package rpgGame.gameCharacter;

import rpgGame.gameCharacter.thiefJob.lowerThiefClass.Thief;
import rpgGame.gameCharacter.villagerJob.lowerVillagerClass.Villager;
import rpgGame.gameCharacter.warriorJob.lowerWarriorClass.Warrior;
import rpgGame.gameCharacter.wizardJob.lowerWizardClass.Wizard;

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
