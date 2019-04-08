

public class skeleton extends Enemy {

	public skeleton(String name) {
		super(name);
	}

	@Override
	public int attack() {
		return 5;
	}

	@Override
	public int hp() {
		return 30;
	}

	@Override
	public int defense() {
		return 5;
	}

	@Override
	public int speed() {
		return 5;
	}

}
