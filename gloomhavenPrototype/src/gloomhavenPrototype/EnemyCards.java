public class EnemyCards {
	private int attack;
	private int range;
	private int movement;
	private int shield;
	private int heal;
    private int mapPosX;
    private int mapPosY;
	
	EnemyCards
    (int attack, int range, int movement, int shield, 
    int heal, int mapPosX, int mapPosY){
		this.attack = attack;
		this.range = range;
		this.movement = movement;
		this.shield = shield;
		this.heal = heal;
        this.mapPosX;
        this.mapPosY;
    }    
	public int getAttack() {
		return attack;
	}

	public int getMovement() {
		return movement;
	}

	public int getShield() {
		return shield;
	}

	public int getHeal() {
		return heal;
	}
	public int getmapPosX() {
		return range;
	}
    public int getmapPosY() {
		return range;
    }   
	public int getRange() {
		return range;
    }
}