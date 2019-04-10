

public class dragon extends Enemy {

	public dragon(String name) {
		super(name, 50, 10, 10, 10);
	}

	@Override
	public int attack() {
		return 10;
	}

	@Override
	public int hp() {
		return hp;
	}

	@Override
	public int defense() {
		return 10;
	}

	@Override
	public int speed() {
		return 10;
	}
	
	@Override
	public void reset() {
		hp = 50;
	}
}
