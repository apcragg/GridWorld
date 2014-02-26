import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;


public class PoliceOfficerCritter extends Critter
{	
	public PoliceOfficerCritter()
	{
		super();
	}
	
	public ArrayList<Actor> getActors()
	{
		ArrayList<Actor> actors = new ArrayList<Actor>();
		
		for(int i = -2; i <= 2; i++)
		{
			for(int j = -2; j <= 2; j++)
			{			
				Location temp = new Location(getLocation().getRow() + i, getLocation().getCol() + j);
				
				if(!getGrid().isValid(temp)) continue;
				
				Actor aTemp = getGrid().get(temp);
				
				if(aTemp != null)
					actors.add(aTemp);
			}
		}
		
		return actors;	
	}
	
	public void processActors(ArrayList<Actor> actors)
	{
		for(Actor actor : actors)
			if(actor instanceof CriminalCritter) actor.removeSelfFromGrid();
	}
	
	public ArrayList<Location> getMoveLocations()
	{
		ArrayList<Location> locations = new ArrayList<Location>();
		
		for(int i = -2; i <= 2; i++)
		{
			for(int j = -2; j <= 2; j++)
			{
				Location temp = new Location(getLocation().getRow() + i, getLocation().getCol() + j);
				
				//oh dear god this is an ugly way to disclude the 3x3 internal square
				if(!getGrid().getValidAdjacentLocations(getLocation()).contains(temp) && getGrid().isValid(temp) && !(i == 0 && j == 0))
				{
					if(getGrid().get(temp) == null) locations.add(temp);
				}
			}
		}
		
		return locations;
	}
	
}
