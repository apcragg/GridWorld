import info.gridworld.actor.Actor;


/*
 * Author:       Andrew Cragg
 * Date Created: Feb 27, 2014
 */

public class AntHill extends Actor
{
	private int maxsAnts;
	private int numFood;
	
	public AntHill(int maxAnts)
	{
		this.maxsAnts = maxAnts;
		this.numFood = numFood;
	}
	
	public void act()
	{
		//10 percent chance of acting
		if((int) (10 * Math.random()) == 4)
		{
			int i = (int) (Math.floor(getGrid().getEmptyAdjacentLocations(getLocation()).size() * Math.random()));
			
			AntCritter newAntCritter = new AntCritter(this);
			newAntCritter.setDirection((int) (Math.floor(Math.random() * 8)) * 45);
			
			getGrid().put(getGrid().getEmptyAdjacentLocations(getLocation()).get(i), newAntCritter);
		}
	}
	
	public void depositFood()
	{
		this.numFood++;
	}
	
	public int geStoredFood()
	{
		return numFood;
	}
}
