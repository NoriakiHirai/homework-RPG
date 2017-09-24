package rpg.user;

import java.math.BigDecimal;
import java.util.HashMap;

public interface User {
	void levelUp();
	void equipWeapon(String weaponName, String strVariation);
	void equipArmor(String armorName, String hpVariation);
	String getUserName();
	UserType getUserType();
	BigDecimal getStr();
	BigDecimal getAgi();
	BigDecimal getHp();
	HashMap<String, String> getEquipments();
}
