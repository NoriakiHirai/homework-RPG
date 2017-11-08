package rpg.user;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import rpg.items.Equipment;

public class UserNEE implements User {

	private final static Logger logger = Logger.getLogger("RpgLogging");
	private final String userName;
	private final UserType userType;
	private BigDecimal str;		//攻撃力
	private BigDecimal agi;		//素早さ
	private BigDecimal hp;		//体力
	private Equipment weapon;	//武器
	private Equipment armor;	//防具
	
	public UserNEE(String userName,
			UserType userType,
			String str,
			String agi,
			String hp) throws Exception {
		super();
		logger.log(Level.FINE, " UserNEE(Constructor) start ");
		this.userName = userName;
		this.userType = userType;
		try {
			this.str = new BigDecimal(str);
			this.agi = new BigDecimal(agi);
			this.hp = new BigDecimal(hp);
		} catch (NumberFormatException e) {
			logger.log(Level.SEVERE, "引数に不正な値が存在します。");
			throw new Exception("引数に不正な値が存在します。");
		}
		logger.log(Level.FINE, " UserNEE(Constructor) end ");
	}

	public String getUserName() {
		logger.log(Level.FINE, " getUserName run ");
		return this.userName;
	}

	public UserType getUserType() {
		logger.log(Level.FINE, " getUserType run ");
		return this.userType;
	}

	public BigDecimal getStr() {
		logger.log(Level.FINE, " getStr run ");
		return this.str;
	}

	public BigDecimal getAgi() {
		logger.log(Level.FINE, " getAgi run ");
		return this.agi;
	}

	public BigDecimal getHp() {
		logger.log(Level.FINE, " getHp run ");
		return this.hp;
	}

	public Equipment getWeapon() {
		logger.log(Level.FINE, " getWeapon run ");
		return this.weapon;
	}

	public void setWeapon(Equipment weapon) {
		logger.log(Level.FINE, " setWeapon run ");
		this.weapon = weapon;
	}

	public Equipment getArmor() {
		logger.log(Level.FINE, " getArmor run ");
		return this.armor;
	}

	public void setArmor(Equipment armor) {
		logger.log(Level.FINE, " setArmor run ");
		this.armor = armor;
	}
	
	@Override
	public void levelUp() {
		logger.log(Level.FINE, " levelUp start ");
		this.str = this.str.add(new BigDecimal("1"));
		this.agi = this.agi.multiply(new BigDecimal("1.1"));
		this.hp = this.hp.add(
				this.str.divide(new BigDecimal("5")));
		System.out.println(this.userName + "がレベルアップしました！");
		System.out.println();
		logger.log(Level.FINE, " levelUp end ");
	}

}
