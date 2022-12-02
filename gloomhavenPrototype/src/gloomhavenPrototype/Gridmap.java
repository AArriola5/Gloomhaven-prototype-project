package gloomhavenPrototype;

//Hex Grid map for now only has a check whether tile is occupied or not.
//Could add type of tile eventually
public class Gridmap {
	boolean occupied = false;
	
	public Gridmap() {
		this.occupied = false;
	}
	public void setOccupied(boolean newOccupied) {
		this.occupied = newOccupied;
	}
	public boolean getOccupied() {
		return this.occupied;
	}
}
