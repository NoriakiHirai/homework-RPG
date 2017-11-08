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

	public Equipment(String name, String strength, String agility, String hp) throws Exception {
		super(name);
		logger.log(Level.FINE, " Equipment(Constructor) start ");
		try {
			this.strength = new BigDecimal(strength);
			this.agility = new BigDecimal(agility);
			this.hp = new BigDecimal(hp);
		} catch (NumberFormatException e) {
			logger.log(Level.SEVERE, "装備品ファイル内に不正なデータが存在します。");
			throw new Exception("装備品ファイル内に不正データなデータが存在します。");
		}
		logger.log(Level.FINE, " Equipment(Constructor) end ");
	}

	public BigDecimal getStrength() {
		logger.log(Level.FINE, " getStrength run ");
		return this.strength;
	}

	public BigDecimal getAgility() {
		logger.log(Level.FINE, " getAgility run ");
		return this.agility;
	}

	public BigDecimal getHp() {
		logger.log(Level.FINE, " getHp run ");
		return this.hp;
	}

}
