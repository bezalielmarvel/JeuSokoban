import java.util.ArrayList;

public class Joueur extends Mobile{

	private ArrayList<Direction> histo;

	public Joueur(Configuration configuration ,Position position){
		super(Type.JOUEUR,configuration,position);
		this.histo = new ArrayList<Direction>();
	}
	public Joueur(Configuration configuration ,Joueur joueur){
		super(joueur.type,configuration,joueur.position);
		this.histo = new ArrayList<Direction>();
	}
	public ArrayList<Direction> getHisto(){
		return histo;
	}
	public boolean bougerVers(Direction direction){
		Position position =this.position.add(direction);

		if(this.config.estCaisse(position)){
			this.config.get(position).bougerVers(direction);
			setPosition(position);
			
			histo.add(direction);
			return true;
		}
		if (this.config.estVide(position)){
			histo.add(direction);
			setPosition(position);
			return true ;
		}
		return false;
	}

		
		

}