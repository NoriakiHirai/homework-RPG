package rpg.items;

import java.math.BigDecimal;
import java.util.logging.Logger;

public class Equipment extends Item {
	private final static Logger logger = Logger.getLogger("RpgLogging");
	private BigDecimal strength;
	private BigDecimal agility;
	private BigDecimal hp;

	public Equipment(String name, String strength, String agility, String hp) throws NumberFormatException {
		super(name);
		try {
			this.strength = new BigDecimal(strength);
			this.agility = new BigDecimal(agility);
			this.hp = new BigDecimal(hp);
		} catch (NumberFormatException e) {
			logger.severe("装備品ファイル内に不正なデータが存在します。");
			throw e;
		}
	}

	public BigDecimal getStrength() {
		return strength;
	}

	public void setStrength(BigDecimal strength) {
		this.strength = strength;
	}

	public BigDecimal getAgility() {
		return agility;
	}

	public void setAgility(BigDecimal agility) {
		this.agility = agility;
	}

	public BigDecimal getHp() {
		return hp;
	}

	public void setHp(BigDecimal hp) {
		this.hp = hp;
	}

}
