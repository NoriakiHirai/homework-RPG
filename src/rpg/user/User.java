package rpg.user;

import java.math.BigDecimal;

public interface User {
	void levelUp();
	void equipWeapon();
	void equipArmor();
	String getUserName();
	UserType getUserType();
	BigDecimal getStr();
	BigDecimal getAgi();
	BigDecimal getHp();
}
