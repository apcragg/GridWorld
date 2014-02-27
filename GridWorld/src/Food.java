import java.awt.Color;

import info.gridworld.actor.Actor;


/*
 * Author:       Andrew Cragg
 * Date Created: Feb 27, 2014
 */

public class Food extends Actor
{
	private int food;
	
	public Food(int totalFood)
	{
		setColor(Color.GREEN);
		
		this.food = totalFood;
	}
	
	public void takeSomeFood()
	{
		this.food--;
		
		assert food >= 0 : "Food should not be negative.";
		
		if(food <= 0)
		{
			removeSelfFromGrid();
		}
	}
	
	public void act(){}	
	
}
