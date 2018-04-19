import java.util.*;

public class Configuration {
	private ArrayList <Caisse> caisses;
	public Joueur joueur;
	public Niveau niveau;

	public Configuration(Niveau niveau,Position positionJoueur){
		this.niveau = new Niveau(niveau.getX(), niveau.getY());
		this.joueur=new Joueur(this,positionJoueur);
		caisses= new ArrayList<Caisse>();

	}
	public Configuration(Configuration configuration){
		this.caisses=configuration.caisses;
		this.joueur=configuration.joueur ;
		this.niveau=configuration.niveau;
	}
	public int getX(){
		return this.niveau.getX();
	}

	public int getY(){
		return this.niveau.getY();
	}
	public ArrayList<Caisse> getCaisses(){
		return this.caisses;
	}

	public Joueur getJoueur(){
		return this.joueur;
	}

	public Niveau getNiveau(){
		return this.niveau;
	}

	public Element get(Position position){

		if(this.joueur.getPosition().equals(position)){
			return this.joueur;
		}
		
		for(Caisse c : this.getCaisses()){
			if(c.getPosition().equals(position))
			return c;
		}
		
		return niveau.get(position);


	}

	public boolean estCaisse(Position position){
		for(Caisse c : this.caisses){
			if(c.position.equals(position)){
				return true;
			}
		}
		return false;
	}

	public boolean addCaisse(Position position){
		Caisse boite = new Caisse(this,position);

			if(!(this.estCaisse(position))){
				this.caisses.add(boite);
				return true;
			}
		return false;
	}
	public boolean estCible(Position position){	
		return this.niveau.estCible(position);
	}
	public boolean estVide(Position position){	
		return this.niveau.estVide(position);
	}
	public boolean bougerJoueurVers(Direction direction){	
		 return this.joueur.bougerVers(direction);
	}

	public boolean victoire(){
		int cpt = 0;
		if(this.caisses.size()!= this.niveau.getCibles().size()){

			System.out.println("Erreur");

			return false;
		}
		
		for(Caisse a: this.caisses){
			
			for(Position b:this.niveau.getCibles()){
				
				if (a.position.equals(b)){
					cpt++;
				}
			}
		}

		if(cpt==this.caisses.size()){
			System.out.println("Gagné!");
			return true;
		}
		return false;
	}

	public String toString(){
		String s = "";
		Position pos;
		for(int i = 0; i<this.niveau.getX(); i++){
		 	s+="\n";
		 	for(int j = 0; j<this.niveau.getY(); j++){
		 		pos=new Position(i,j);
		 		Caisse caisse = new Caisse(this,pos);

				if ( this.estCible(pos)&& pos.equals(this.joueur.position)) {
					s+="+ ";	
				}
				else{
					if (this.estCaisse(pos)&& this.estCible(pos)) {
						s+="* ";
					}
					else{
						if (this.estCaisse(pos)) {
							s+="$ ";	
						}
						else{
							if(this.niveau.get(pos) instanceof Case && this.estCible(pos)){
								s+=". ";
							}
							else{
								if (this.niveau.get(pos) instanceof Mur) {
									s+="# ";
								}
								else{
									if (pos.equals(this.joueur.position)) {
										s+="@ ";
									}
									else{		
										s+="  ";
									}
								}
							}
						}
						
					}

				}
			}
		}
		return s;
	}

}