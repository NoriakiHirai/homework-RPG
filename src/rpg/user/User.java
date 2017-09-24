package rpg.user;

import java.math.BigDecimal;

public interface User {
	void levelUp();
	void equipWeapon(String weaponName, String strVariation);
	void equipArmor(String armorName, String hpVariation);
	String getUserName();
	UserType getUserType();
	BigDecimal getStr();
	BigDecimal getAgi();
	BigDecimal getHp();
}
