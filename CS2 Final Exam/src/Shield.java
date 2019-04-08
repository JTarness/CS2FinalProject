
public class Shield implements Equipment {
	public String name;
	public int attack;
	public int speed;
	public int defense;
	
	public Shield(String name, int attack, int defense, int speed) {
		this.name=name;
		this.attack=attack;
		this.speed=speed;
		this.defense=defense;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getAttack() {
		return attack;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public int getDefense() {
		return defense;
	}

}
