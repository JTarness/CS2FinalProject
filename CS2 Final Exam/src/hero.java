import java.util.ArrayList;

public class hero {
	String name;
	int hp;
	int maxHP;
	int attack;
	int defense;
	int speed;
	ArrayList<Equipment> equipment;
	int keys = 0;

	public hero(String name, int hp, int attack, int defense, int speed) {
		this.name = name;
		this.hp = hp;
		this.maxHP = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		equipment = new ArrayList<Equipment>();
		equipment.add(new Sword("", 0,0,0));
		equipment.add(new Shield("", 0,0,0));
	}

	public String getName() {
		return name;
	}

	public int getHP() {
		return hp;
	}

	public int getAttack() {
		return attack + equipment.get(0).getAttack() + equipment.get(1).getAttack();
	}

	public int getDefense() {
		return defense + equipment.get(0).getDefense() + equipment.get(1).getDefense();
	}
	
	public int getSpeed() {
		return speed + equipment.get(0).getSpeed() + equipment.get(1).getSpeed();
	}
	
	public int getBaseAttack() {
		return attack;
	}
	
	public int getBaseDefense() {
		return defense;
	}
	
	public int getBaseHp() {
		return hp;
	}
	
	public int getBaseSpeed() {
		return speed;
	}

	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}

	public int getKeys() {
		return keys;
	}

	public int hpLost(int hpDamage) {
		if(hpDamage - this.getDefense() <= 0) {
			hpDamage =1;
		}else {
			hpDamage = hpDamage -this.getDefense();
		}
		hp = hp - hpDamage;
		if(hp<0) {
			hp=0;
		}
		return hpDamage;
	}

	public int hpINC(int INC) {
		hp = hp + INC;
		return hp;
	}
	
	public int maxHPINC(int INC) {
		maxHP = maxHP + INC;
		return maxHP;
	}

	public int attackINC(int INC) {
		attack = attack + INC;
		return attack;
	}

	public int defenseINC(int INC) {
		defense = defense + INC;
		return defense;
	}

	public int speedINC(int INC) {
		speed = speed + INC;
		return speed;
	}

	// 0 index is sword, 1 for shield
	public ArrayList<Equipment> changeEquipment(Boolean sword, Equipment e) {
		if (sword) {
			equipment.set(0, e);
		} else {
			equipment.set(1, e);
		}
		return equipment;
	}

	public int keysINC(int INC) {
		keys = keys + INC;
		return keys;
	}
	
	public void reset() {
		hp = 10;
		attack = 3;
		defense = 3;
		speed = 3;
		equipment.set(0,new Sword("", 0,0,0));
		equipment.set(0,new Shield("", 0,0,0));
		keys = 0;
	}
	
	public void heal() {
		hp = maxHP;
	}
	
	public void levelUp() {
		attackINC(1);
		defenseINC(1);
		maxHP = maxHPINC(1);
		speedINC(1);
		heal();
	}

}
