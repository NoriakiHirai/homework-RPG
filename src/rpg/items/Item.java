package rpg.items;

import java.util.logging.Level;
import java.util.logging.Logger;

import rpg.LogFactory;

public class Item {
	private static Logger logger = LogFactory.createLogger(new Object(){}.getClass().getEnclosingClass().getName());
	private String name;
	
	/**
	 * @param name
	 */
	public Item(String name) {
		super();
		logger.log(Level.FINE, " Item(Constructor) start ");
		this.name = name;
		logger.log(Level.FINE, " Item(Constructor) end ");
	}

	public String getName() {
		logger.log(Level.FINE, " getName run ");
		return this.name;
	}

}
