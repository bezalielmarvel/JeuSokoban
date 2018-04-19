public class Solver implements SolverInterface{

	private Configuration config;
	private static int totalSteps;

	public Solver(Configuration config){
		this.config = config;
		totalSteps = 0;
	}

	public boolean stop(){
		for(Caisse c : this.config.getCaisses()){
			System.out.println("Caisse : ("+c.position.x+","+c.position.y+")");

			Position p = new Position(c.position);

			Position haut = p.add(Direction.HAUT);
			Position bas = p.add(Direction.BAS);
			Position gauche = p.add(Direction.GAUCHE);
			Position droite = p.add(Direction.DROITE);

			if(((this.config.get(haut).getType() == Type.MUR) && (this.config.get(droite).getType() == Type.MUR))
				|| ((this.config.get(haut).getType() == Type.MUR) && (this.config.get(gauche).getType() == Type.MUR))
				|| ((this.config.get(bas).getType() == Type.MUR) && (this.config.get(droite).getType() == Type.MUR))
				|| ((this.config.get(bas).getType() == Type.MUR) && (this.config.get(gauche).getType() == Type.MUR))){

				return true;
			}
		}
		return this.config.victoire();

	}

	public void step(){
		totalSteps++;
		int random = (int) (Math.random()*4);
		System.out.println(random);
		switch(random){
			case 0:
				this.config.bougerJoueurVers(Direction.HAUT);
				break;
			case 1:
				this.config.bougerJoueurVers(Direction.BAS);
				break;
			case 2:
				this.config.bougerJoueurVers(Direction.GAUCHE);
				break;
			default:
				this.config.bougerJoueurVers(Direction.DROITE);

		}

	}

	public int getTotalSteps(){
		return this.totalSteps;
	}

	public Configuration getConfiguration(){
		return this.config;
	}

	public void set(Configuration sokoban){
		this.config = sokoban;
	}

}