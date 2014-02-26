import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;


public class CharismaCritter extends Critter
{
	private int numFriends;
	
	public CharismaCritter(int numFriends)
	{
		this.numFriends = numFriends;
	}
	
	 public ArrayList<Actor> getActors()
	 {
		 	int r = getLocation().getRow();
		 	int c = getLocation().getCol();
		 	
		 	ArrayList<Actor> actors = new ArrayList<Actor>();
		 	
		 	//so ugly
		 	for(Location loc : getGrid().getOccupiedLocations())
		 	{
		 		Actor actor = getGrid().get(loc);
		 		
		 		if(actor.getLocation() != this.getLocation() && actor instanceof Critter)
		 		{
		 			if(actor.getLocation().getRow() - r >= -2 && actor.getLocation().getRow() - r <= 2)
		 			{
		 				if(actor.getLocation().getCol() - c >= -2 && actor.getLocation().getCol() - c <= 2)
			 			{
			 				actors.add(actor);
			 			}
		 			}
		 		}
		 	}
		 
	        return actors;
	        	
	 }

	 public void processActors(ArrayList<Actor> actors)
	 {
	     if(actors.size() < numFriends)
	     {
	    	 setColor(darken(getColor()));
	     }
	     
	     if(actors.size() > numFriends)
	     {
	    	 setColor(lighten(getColor()));
	     }
	 }
	 
	 private Color darken(Color c)
	 {
		 int r = (int) (c.getRed() * .9f);
		 int g = (int) (c.getGreen() * .9f);
		 int b = (int) (c.getBlue() * .9f);
		 
		 return new Color(r,g,b);
	 }
	 
	 private Color lighten(Color c)
	 { 
		 int r = (int) (c.getRed() / .9f);
		 int g = (int) (c.getGreen() / .9f);
		 int b = (int) (c.getBlue() / .9f);
		 
		 r = r <= 255 ? r : 255;
		 g = g <= 255 ? g : 255;
		 b = b <= 255 ? b : 255;
		 
		 return new Color(r,g,b);
	 }

}
