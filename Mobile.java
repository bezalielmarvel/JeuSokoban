 public class Mobile extends Element {
	public Configuration config;
	public Position position;

	public Mobile(Type type, Configuration config,Position position){
		super(type);
		this.config=config;
		this.position=position;
	}
	public boolean bougerVers(Direction direction){
		return true;
	}

	public boolean setPosition(Position position){
			
		this.position = position;
		if(this.position != null){
			return true;
		}
		return false;
	}

	public Position getPosition(){
		return position;
	}
	
}