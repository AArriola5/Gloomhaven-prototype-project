package gloomhavenPrototype;


public class Enemy{
    String name = "";
    int level;
    int health;
    int movement;
    int shield;
    int mapPosX = 2;
    int mapPosY = 0;
    int attack;
    int range;

    public Enemy(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public int getLevel() {
		return this.level;
	}
	public int getHealth() {
		return this.health;
	}
	public int getMapPosX() {
		return this.mapPosX;
	}
	public int getMapPosY() {
		return this.mapPosY;
	}
	public void setEMapPosX(int newMapPosX) {
		this.mapPosX = newMapPosX;
	}
	public void setEMapPosY(int newMapPosY) {
		this.mapPosY = newMapPosY;
	}
}
