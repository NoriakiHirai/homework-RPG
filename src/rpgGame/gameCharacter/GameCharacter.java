package rpgGame.gameCharacter;

import java.math.BigDecimal;

public class  GameCharacter {
	protected final String name;
	protected JobCategory jobCategory;
	protected int level;
	protected BigDecimal aggressivity;
	protected BigDecimal quickness;
	protected BigDecimal hp;
	
	public GameCharacter(String name, JobCategory jobCategory, String aggressivity, String quickness, String hp) {
		super();
		this.name = name;
		this.jobCategory = jobCategory;
		this.level = 1;
		this.aggressivity = new BigDecimal(aggressivity);
		this.quickness = new BigDecimal(quickness);
		this.hp = new BigDecimal(hp);
	}

	public JobCategory getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(JobCategory jobCategory) {
		this.jobCategory = jobCategory;
	}

	public BigDecimal getAggressivity() {
		return aggressivity;
	}

	public void setAggressivity(BigDecimal aggressivity) {
		this.aggressivity = aggressivity;
	}

	public BigDecimal getQuickness() {
		return quickness;
	}

	public void setQuickness(BigDecimal quickness) {
		this.quickness = quickness;
	}

	public BigDecimal getHp() {
		return hp;
	}

	public void setHp(BigDecimal hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void levelUp() {
		
	}

}
