public class Caisse extends Mobile{

	public Caisse(Configuration config, Position position){
		super(Type.CAISSE, config, position);
	}
	public boolean bougerVers(Direction direction){
		Position position = this.position.add(direction);
		if (this.config.estVide(position)){
			setPosition(position);
			return true ;
		}
		return false;
	}

	
}
