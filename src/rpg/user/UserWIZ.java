package rpg.user;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.logging.Logger;

import rpg.items.EquipType;


public class UserWIZ implements User {

	private final Logger logger = Logger.getLogger("UserWIZLogging");
	private final String userName;
	private final UserType userType;
	private BigDecimal str;		//攻撃力
	private BigDecimal agi;		//素早さ
	private BigDecimal hp;		//体力
	private HashMap<String, String> equipments = new HashMap<>(); //装備品
	
	public UserWIZ(String userName,
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
			logger.severe("不正な入力ステータスです。");
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
	
	public HashMap<String, String> getEquipments() {
		return this.equipments;
	}

	@Override
	public void levelUp() {
		this.str = this.str.add(new BigDecimal("4"));
		this.agi = this.agi.multiply(new BigDecimal("1.4"));
		this.hp = this.hp.add(
				this.str.divide(new BigDecimal("4")));
		System.out.println(this.userName + "がレベルアップしました！");
		System.out.println();
	}

	@Override
	public void strengthen(StatusType statusType, BigDecimal statusVariation) {
		switch (statusType) {
		case STRENGTH:
			this.str = this.str.add(statusVariation);
			System.out.println("攻撃力が" + statusVariation + "上昇しました。");
			System.out.println();
			break;
		case AGILITY:
			this.agi = this.agi.add(statusVariation);
			System.out.println("素早さが" + statusVariation + "上昇しました。");
			System.out.println();
			break;
		case HP:
			this.hp = this.hp.add(statusVariation);
			System.out.println("HPが" + statusVariation + "上昇しました。");
			System.out.println();
			break;
		default:
			break;
		}
	}

	@Override
	public void attachEquipment(EquipType equipType, String equipment) {
		switch (equipType) {
		case WEAPON:
			this.equipments.put("weapon", equipment);
			System.out.println(this.userName + "は、" + equipment + "を装備しました。");
			break;
		case ARMOR:
			this.equipments.put("armor", equipment);
			System.out.println(this.userName + "は、" + equipment + "を装備しました。");
			break;
		default:
			break;
		}
	}

}
