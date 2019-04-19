

public class skeleton extends Enemy {

	public skeleton(String name) {
		super(name, 12,5,4,4);
	}

	@Override
	public int attack() {
		return 5;
	}

	@Override
	public int hp() {
		return hp;
	}

	@Override
	public int defense() {
		return 5;
	}

	@Override
	public int speed() {
		return 5;
	}
	
	@Override
	public void reset() {
		hp = 12;
	}
	
}
