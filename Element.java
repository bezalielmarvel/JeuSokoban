public abstract class Element {
	public Type type;

	public Element(Type type){
		this.type=type;
	}

	public Type getType(){
		return this.type;
	}
	public abstract boolean bougerVers(Direction direction);
}