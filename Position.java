public final class Position {
	public int x;
	public int y;

	public Position(int x, int y){
		this.x=x;
		this.y=y;
	}
	public Position(Position position ){
		 this.x=position.x;
		 this.y=position.y;
	}

	public Position add(Direction direction){
		return new Position (this.x+direction.getX(),this.y+direction.getY());

	}

	public Position sub(Direction direction){
		return new Position (this.x-direction.getX(),this.y-direction.getY());
		
	}
	
	public boolean equals(Object o){
		if(this == o) return true;
		if(o == null) return false;
		if(getClass() != o.getClass()) return false;
		Position p = (Position) o;
		return x==p.x && y==p.y;
		//return (o!=null && o instanceof Position && ((Position)o).x==this.x && ((Position)o).y==this.y );

	}

}