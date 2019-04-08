import java.util.ArrayList;

public class hero {
	String name;
	int hp;
	int attack;
	int defense;
	int speed;
	ArrayList<Equipment> equipment;
	int keys = 0;
	final int baseHp;
	final int baseAttack;
	final int baseDefense;
	final int baseSpeed;

	public hero(String name, int hp, int attack, int defense, int speed) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.baseAttack=attack;
		this.baseDefense=defense;
		this.baseHp=hp;
		this.baseSpeed=speed;
	}

	public String getName() {
		return name;
	}

	public int getHP() {
		return hp;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getBaseAttack() {
		return baseAttack;
	}
	
	public int getBaseDefense() {
		return baseDefense;
	}
	
	public int getBaseHp() {
		return baseHp;
	}
	
	public int getBaseSpeed() {
		return baseSpeed;
	}

	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}

	public int getKeys() {
		return keys;
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

	public int hpINC(int INC) {
		hp = baseHp + INC;
		return hp;
	}

	public int attackINC(int INC) {
		attack = baseAttack + INC;
		return attack;
	}

	public int defenseINC(int INC) {
		defense = baseDefense + INC;
		return defense;
	}

	public int speedINC(int INC) {
		speed = baseSpeed + INC;
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

}
