

public class dragon extends Enemy {

	public dragon(String name) {
		super(name, 16, 8, 4, 6);
	}

	@Override
	public int attack() {
		return 8;
	}

	@Override
	public int hp() {
		return hp;
	}

	@Override
	public int defense() {
		return 6;
	}

	@Override
	public int speed() {
		return 10;
	}
	
	@Override
	public void reset() {
		hp = 16;
		alive = true;
	}
}
