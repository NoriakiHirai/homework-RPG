package rpg.ui;

import java.io.IOException;

import rpg.user.User;

public interface Equipment {
	void equipWeapon(User user) throws IOException;
	void equipArmor(User user) throws IOException;
}
