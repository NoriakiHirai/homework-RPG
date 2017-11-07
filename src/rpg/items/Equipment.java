package rpg.items;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import rpg.LogFactory;

public class Equipment extends Item {
	private static Logger logger = LogFactory.createLogger(new Object(){}.getClass().getEnclosingClass().getName());
	private BigDecimal strength;
	private BigDecimal agility;
	private BigDecimal hp;

	public Equipment(String name, String strength, String agility, String hp) throws NumberFormatException {
		super(name);
		logger.log(Level.FINE, " Equipment(Constructor) start ");
		try {
			this.strength = new BigDecimal(strength);
			this.agility = new BigDecimal(agility);
			this.hp = new BigDecimal(hp);
		} catch (NumberFormatException e) {
			logger.severe("装備品ファイル内に不正なデータが存在します。");
			throw e;
		}
		logger.log(Level.FINE, " Equipment(Constructor) end ");
	}

	public BigDecimal getStrength() {
		logger.log(Level.FINE, " getStrength run ");
		return strength;
	}

	public BigDecimal getAgility() {
		logger.log(Level.FINE, " getAgility run ");
		return agility;
	}

	public BigDecimal getHp() {
		logger.log(Level.FINE, " getHp run ");
		return hp;
	}

}
