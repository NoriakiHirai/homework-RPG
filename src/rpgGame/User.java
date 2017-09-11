package rpgGame;

import java.math.BigDecimal;

public interface User {
	String getUserName();
	UserType getUserType();
	BigDecimal getUserStr();
	BigDecimal getUserAgi();
	BigDecimal getUserHp();
	void levelUp();
}
