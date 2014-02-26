import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;


public class CriminalCritter extends Critter
{
	public Location lastLootLocation;
	
	public CriminalCritter()
	{
		super();
		
		setColor(Color.BLACK);
	}
	
	public void processActors(ArrayList<Actor> actors)
	{
		ArrayList<Actor> loot = new ArrayList<Actor>();
		
		for(Actor actor : actors)
		{
			if(actor instanceof Cash || actor instanceof Diamond)
				loot.add(actor);
		}
		
		if(loot.size() == 0)
		{
			lastLootLocation = null;
			return;
		}
		
		int r = (int) (Math.floor(Math.random() * loot.size()));
		
		lastLootLocation = loot.get(r).getLocation();
	}
	
	 public ArrayList<Location> getMoveLocations()
	    {
		 	ArrayList<Location> location = new ArrayList<Location>();
		 
		 	if(lastLootLocation == null)
		 		return getGrid().getEmptyAdjacentLocations(getLocation());
		 	else 
		 	{
		 		location.add(lastLootLocation);
		 		
		 		return location;
			}
	        
	    }
}
