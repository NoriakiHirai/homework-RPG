package rpg.user;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.logging.Logger;

public class UserTHI implements User {

	private final Logger logger = Logger.getLogger("UserTHILogging");
	private final String userName;
	private final UserType userType;
	private BigDecimal str; // 攻撃力
	private BigDecimal agi; // 素早さ
	private BigDecimal hp; // 体力
	private HashMap<String, String> equipments = new HashMap<>(); // 装備品

	public UserTHI(String userName, UserType userType, String str, String agi, String hp) {
		super();
		this.userName = userName;
		this.userType = userType;
		this.str = new BigDecimal(str);
		this.agi = new BigDecimal(agi);
		this.hp = new BigDecimal(hp);
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

	@Override
	public void levelUp() {
		this.str = this.str.add(new BigDecimal("2"));
		this.agi = this.agi.multiply(new BigDecimal("1.5"));
		this.hp = this.hp.add(this.str.divide(new BigDecimal("3")));
		System.out.println(this.userName + "がレベルアップしました！");
		System.out.println();
	}

	@Override
	public void equipWeapon(String weaponName, String strVariation) {
		try {
			this.equipments.put("weapon", weaponName);
			this.str = this.str.add(new BigDecimal(strVariation));
			System.out.println(this.userName + "は、" + weaponName + "を装備しました。");
			System.out.println("攻撃力が" + strVariation + "上昇しました。");
			System.out.println();
		} catch (NullPointerException e) {
			logger.warning("不正な装備品データです。");
		} catch (NumberFormatException e) {
			logger.warning(String.format("装備品情報に不正なデータが存在します。"));
		}
	}

	@Override
	public void equipArmor(String armorName, String hpVariation) {
		try {
			this.equipments.put("armor", armorName);
			this.hp = this.hp.add(new BigDecimal(hpVariation));
			System.out.println(this.userName + "は、" + armorName + "を装備しました。");
			System.out.println("HPが" + hpVariation + "上昇しました。");
			System.out.println();
		} catch (NullPointerException e) {
			logger.warning("不正な装備品データです。");
		} catch (NumberFormatException e) {
			logger.warning(String.format("装備品情報に不正なデータが存在します。"));
		}
	}

}
