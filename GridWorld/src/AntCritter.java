import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;


/*
 * Author:       Andrew Cragg
 * Date Created: Feb 27, 2014
 */

public class AntCritter extends Critter
{
	private AntHill home;
	private Food food;
	private boolean hasFood;
	
	public AntCritter(AntHill a)
	{
		this.home = a;
		this.setFood(null);
	}
	
	public ArrayList<Location> getMoveLocations()
	{
		ArrayList<Location> locations = new ArrayList<Location>();
		
		if(food == null)
			locations = getGrid().getEmptyAdjacentLocations(getLocation());
		else if(hasFood)
		{
			setDirection(getLocation().getDirectionToward(home.getLocation()));
			locations.add(getLocation().getAdjacentLocation(getDirection()));
		}
		else if(!hasFood)
		{
			setDirection(getLocation().getDirectionToward(food.getLocation()));
			locations.add(getLocation().getAdjacentLocation(getDirection()));
		}
		
		return locations;
	}
	
	public void processActors(ArrayList<Actor> actors)
	{
		if(getGrid().get(food.getLocation()) == null)
			food = null;
		
		for(Actor actor : actors)
		{
			if(actor instanceof Food && actor.getLocation().equals(food.getLocation()))
			{
				((Food) actor).takeSomeFood();
					hasFood = true;
			}
			
			if(actor instanceof AntHill && actor.getLocation().equals(home.getLocation()))
			{
				((AntHill) actor).depositFood();				
					hasFood = false;
			}
		}
	}

	public boolean isHasFood()
	{
		return hasFood;
	}

	public void setHasFood(boolean hasFood)
	{
		this.hasFood = hasFood;
	}

	public Food getFood()
	{
		return food;
	}

	public void setFood(Food food)
	{
		this.food = food;
	}
}
