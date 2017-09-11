package rpgGame;

import java.math.BigDecimal;

public class UserTHI implements User {
	private final String name;
	private UserType userType;
	private BigDecimal aggressivity;
	private BigDecimal quickness;
	private BigDecimal hp;

	/**
	 * @param name
	 * @param userType
	 * @param aggressivity
	 * @param quickness
	 * @param hp
	 */
	public UserTHI(String name, UserType userType, BigDecimal aggressivity, BigDecimal quickness, BigDecimal hp) {
		super();
		this.name = name;
		this.userType = userType;
		this.aggressivity = aggressivity;
		this.quickness = quickness;
		this.hp = hp;
	}

	@Override
	public String getUserName() {
		return name;
	}

	@Override
	public UserType getUserType() {
		return userType;
	}

	@Override
	public BigDecimal getUserStr() {
		return aggressivity;
	}

	@Override
	public BigDecimal getUserAgi() {
		return quickness;
	}

	@Override
	public BigDecimal getUserHp() {
		return hp;
	}

	@Override
	public void levelUp() {
		hp = hp.add(aggressivity.divide(BigDecimal.valueOf(3)));
		aggressivity = aggressivity.add(BigDecimal.valueOf(2));
		quickness = quickness.multiply(BigDecimal.valueOf(1.5));
		
		System.out.println();
		System.out.println(name + "がレベルアップしました!");
	}

}
