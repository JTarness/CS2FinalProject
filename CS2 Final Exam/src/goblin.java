

public class goblin extends Enemy {

	public goblin(String name) {
		super(name);
	}

	@Override
	public int attack() {
		return 2;
	}

	@Override
	public int hp() {
		return 10;
	}

	@Override
	public int defense() {
		return 2;
	}

	@Override
	public int speed() {
		return 3;
	}

}
