import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;


/*
 * Author:       Andrew Cragg
 * Date Created: Feb 24, 2014
 */

public class FlyingActor extends Actor
{
	public FlyingActor()
	{
		super();
	}
	
	public void act()
	{
		Grid<Actor> g = getGrid();
		
		int x = g.getNumCols();
		int y = g.getNumRows();
		
		x = (int) Math.floor((x) * Math.random());
		y = (int) Math.floor((y) * Math.random());
		
		assert g.isValid(new Location(y,x)) : "Bug: How is the location outside the grid? (Location(" + y + ", " + x + ")";
		
		if(g.get(new Location(y, x)) !=null)
			System.out.println("Tried to move to occupied cell.");
		else
			moveTo(new Location(y, x));
	}
}
