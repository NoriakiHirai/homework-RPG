package rpg.user;

import java.math.BigDecimal;

import rpg.items.Equipment;

public interface User {
	void levelUp();
	String getUserName();
	UserType getUserType();
	BigDecimal getStr();
	BigDecimal getAgi();
	BigDecimal getHp();
	Equipment getWeapon();
	void setWeapon(Equipment weapon);
	Equipment getArmor();
	void setArmor(Equipment armor);
}
