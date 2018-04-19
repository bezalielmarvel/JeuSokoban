import java.util.*;
public class Test{
	public static void main(String[] args) {   
		Position positionjoueur=new Position(5,5);  
		
		Niveau lvl=new Niveau(10,10);
		Configuration c=new Configuration(lvl,positionjoueur);
		
		//lvl.addMur(new Position(3,2));
		Position p1 = new Position(3,3);
		Position p2 = new Position(3,4);
		Position p3 = new Position(4,3);
		Position p4 = new Position(4,4);
		c.niveau.addCible(p1);
		c.addCaisse(p2);
		c.niveau.addCible(p3);
		c.addCaisse(p4);
		//c.addCaisse(new Position(2,1));
		/*c.addCaisse(new Position(2,2));*/
		//c.addCaisse(new Position(3,3));

		/*c.addCaisse(new Position(2,4));
		c.addCaisse(new Position(2,5));
		c.addCaisse(new Position(2,6));
		c.addCaisse(new Position(2,7));
		Position pos = new Position(2,8);
		c.addCaisse(pos);
		c.addCaisse(pos);
		c.addCaisse(pos);
		c.niveau.addCible(new Position(2,1));*/
		/*
		System.out.println(c);
		c.getJoueur().bougerVers(Direction.GAUCHE);
		System.out.println(c);
		*/
		//System.out.println(c.get(p1).getType());
		//System.out.println(c.get(p2).getType());
		//System.out.println(c.get(positionjoueur).getType());

		SokobanUI sokoban = new SokobanUI();

		//c.victoire();

		Solver s = new Solver(c);
		
		while(true){
			sokoban.show(c);
			s.step();
			System.out.println(c);
			System.out.println(c.getJoueur().getHisto());

			System.out.println(s.getTotalSteps());
			try{
				Thread.sleep(100); // 100 ms
				}catch(Exception e){
					e.printStackTrace();
				}
				if(s.stop()){
					break;
				}
			}
		
		sokoban.endGame(c);
	}
}
