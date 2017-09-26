package rpg.user;

import java.math.BigDecimal;
import java.util.HashMap;

import rpg.items.EquipType;

public interface User {
	void levelUp();
	void attachEquipment(EquipType equipType, String equipment);
	void varyStatus(StatusType statusType, BigDecimal statusVariation);
	HashMap<String, String> getEquipments();
	String getUserName();
	UserType getUserType();
	BigDecimal getStr();
	BigDecimal getAgi();
	BigDecimal getHp();
}
