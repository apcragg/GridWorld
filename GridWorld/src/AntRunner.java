import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;


/*
 * Author:       Andrew Cragg
 * Date Created: Feb 27, 2014
 */

public class AntRunner
{
	public static void main(String[] argStrings)
	{
		ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(15, 15));
		
		world.add(new AntHill(20));
		
		world.add(new Food(15));
		world.add(new Food(15));
		world.add(new Food(15));
		world.add(new Food(15));
		world.add(new Food(15));
		world.add(new Food(15));
		
		world.show();
	}
}
