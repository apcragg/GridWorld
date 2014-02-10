
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.awt.color.ColorSpace;

public class SpeedyBug extends Bug
{		
	private static final float DARKEN_FACTOR = .16807f; // .7^5 as .7 is the factor from awt.Color's Darken method
	
	public SpeedyBug()
	{
		this(new Color(0, 0, 255));
	}
	
	
	public SpeedyBug(Color color)
	{
		super(color);
		setDirection((int) Math.floor((Math.random() * 359.99f)) % 90);
	}
	
	public void act()
	{
		super.act();
		super.act();
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
	        
	        Color c = getColor();        
	        
	        Flower flower = new Flower(new Color((int) (c.getRed() * DARKEN_FACTOR), (int) (c.getGreen() * DARKEN_FACTOR), (int) (c.getBlue() * DARKEN_FACTOR)));
	        flower.putSelfInGrid(gr, loc);
	}
}
