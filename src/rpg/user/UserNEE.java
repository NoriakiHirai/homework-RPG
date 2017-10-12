package rpg.user;

import java.math.BigDecimal;
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
			String hp) {
		super();
		this.userName = userName;
		this.userType = userType;
		try {
			this.str = new BigDecimal(str);
			this.agi = new BigDecimal(agi);
			this.hp = new BigDecimal(hp);
		} catch (NumberFormatException e) {
			logger.severe("入力ステータスに不正な値が存在します。");
			throw e;
		}
	}

	public String getUserName() {
		return this.userName;
	}

	public UserType getUserType() {
		return this.userType;
	}

	public BigDecimal getStr() {
		return this.str;
	}

	public BigDecimal getAgi() {
		return this.agi;
	}

	public BigDecimal getHp() {
		return this.hp;
	}
	
	public Equipment getWeapon() {
		return this.weapon;
	}

	public void setWeapon(Equipment weapon) {
		this.weapon = weapon;
	}

	public Equipment getArmor() {
		return this.armor;
	}

	public void setArmor(Equipment armor) {
		this.armor = armor;
	}
	
	@Override
	public void levelUp() {
		this.str = this.str.add(new BigDecimal("1"));
		this.agi = this.agi.multiply(new BigDecimal("1.1"));
		this.hp = this.hp.add(
				this.str.divide(new BigDecimal("5")));
		System.out.println(this.userName + "がレベルアップしました！");
		System.out.println();
	}

	@Override
	public void enhanceByEquipment(Equipment equipment) {
		this.hp = this.hp.add(equipment.getHp());
		this.str = this.str.add(equipment.getStrength());
		this.agi = this.agi.add(equipment.getAgility());

	}


}
