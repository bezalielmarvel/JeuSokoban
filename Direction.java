import java.util.ArrayList;

public enum Direction {
	GAUCHE(0,-1),
	DROITE(0,1),
	HAUT(-1,0),
	BAS(1,0);
	
	private ArrayList <Direction> directions;
	private int dx;
	private int dy;

	Direction(int dx, int dy){
		this.dx = dx;
		this.dy = dy;
	}

	public ArrayList <Direction> getDirections(){
		return directions;
	}

	public int getX(){
		return this.dx;
	}

	public int getY(){
		return this.dy;
	}

	
}