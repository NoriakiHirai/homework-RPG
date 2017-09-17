package test;

import java.math.BigDecimal;


public class UserWAR implements User {

	private final String userName;
	private final UserType userType;
	private BigDecimal str;		//攻撃力
	private BigDecimal agi;		//素早さ
	private BigDecimal hp;		//体力

	public UserWAR(String userName,
			UserType userType,
			String str,
			String agi,
			String hp) {
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
		this.str = this.str.add(new BigDecimal("3"));
		this.agi = this.agi.multiply(new BigDecimal("1.3"));
		this.hp = this.hp.add(
				this.str.divide(new BigDecimal("2")));
		System.out.println(this.userName + "がレベルアップしました！");
		System.out.println();
	}

}

