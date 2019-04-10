
public abstract class Enemy {
	String name;
	int hp;
	int defense;
	int attack;
	int speed;
	boolean alive;
	
	public Enemy(String name, int a, int b, int c, int d) {
		this.name = name;
		hp = a;
		attack = b;
		speed = c;
		defense = d;
		alive = true;
	}
	
	public String getName() {
		return name;
	}
	
	public int hpLost(int hpDamage) {
		if(hpDamage - defense <= 0) {
			hpDamage =1;
		}else {
			hpDamage = hpDamage -defense;
		}
		hp = hp - hpDamage;
		if(hp<0) {
			hp=0;
		}
		return hp;
	}
	
	public boolean isAlive() {
		return alive;
	}
	public void dead() {
		alive = false;
	}
	
	abstract public int attack();
	abstract public int hp();
	abstract public int defense();
	abstract public int speed();

}
