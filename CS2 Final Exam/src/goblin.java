

public class goblin extends Enemy {

	public goblin(String name) {
		super(name, 10, 2, 3, 2);
	}

	@Override
	public int attack() {
		return 2;
	}

	@Override
	public int hp() {
		return hp;
	}

	@Override
	public int defense() {
		return 2;
	}

	@Override
	public int speed() {
		return 3;
	}

	@Override
	public void reset() {
		hp = 10;
	}
}
