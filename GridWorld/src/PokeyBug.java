
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class PokeyBug extends Bug
{	
	int step;
	
	public PokeyBug()
	{
		this(new Color(0, 255, 0));
	}
	
	
	public PokeyBug(Color color)
	{
		super(color);
		step = (int) Math.floor((Math.random() * 2.9999f));
	}
	
	public void act()
	{
		if(step == 2)
		{
			super.act();
			
			step = 0;
		}
		
		else step++;		
	}
	
	public void move()
	{
		 Grid<Actor> gr = getGrid();
	        if (gr == null)
	            return;
	        Location loc = getLocation();
	        Location next = loc.getAdjacentLocation(getDirection());
	        if (gr.isValid(next))
	            moveTo(next);
	        else
	            removeSelfFromGrid();
	        Rock rock = new Rock(getColor());
	        rock.putSelfInGrid(gr, loc);
	}
}
