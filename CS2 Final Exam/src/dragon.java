

public class dragon extends Enemy {

	public dragon(String name) {
		super(name);
	}

	@Override
	public int attack() {
		return 10;
	}

	@Override
	public int hp() {
		return 50;
	}

	@Override
	public int defense() {
		return 10;
	}

	@Override
	public int speed() {
		return 10;
	}

}
