import java.util.ArrayList;

public class Niveau {
	protected Immobile[][] grille ;
	protected ArrayList<Position> cibles;
	private final int x;
	private final int y;

	public Niveau(int x, int y){
		this.x=x;
		this.y=y;
		cibles= new ArrayList<Position>();
		grille=new Immobile[x][y];
		
		for (int i=0;i<x ;i++ ) {
			grille[0][i] = new Mur();

			for (int j=0;j<y ;j++ ) {
				grille[j][0] = new Mur();
				if(grille[i][j]==null){

					grille[i][j]=new Case();
				}
				grille[j][y-1] = new Mur();
			}
			grille[x-1][i] = new Mur();
			
		}
	}
	public Immobile get(Position position){
		return this.grille[position.x][position.y];
	}
	public ArrayList<Position> getCibles(){
		return this.cibles;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}

	public boolean addCible(Position position){
		if (!(this.get(position) instanceof Mur) &&  !(estCible(position))){
			cibles.add(position);
			return true;
		}
		return false;
	}
	
	public boolean addMur(Position position){
		if (this.get(position) instanceof Case ){
			this.grille[position.x][position.y]=new Mur();
			return true;
		}
		return false;
	}

	public boolean estCible(Position position){
		return this.getCibles().contains(position);

	}
	public boolean estVide(Position position){
		return this.grille[position.x][position.y] instanceof Case;
	}

	
}