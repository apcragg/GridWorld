import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;


/*
 * Author:       Andrew Cragg
 * Date Created: Feb 24, 2014
 */

public class FlyingActorRunner
{
	public static void main(String args[])
	{
		World<Actor> world = new ActorWorld(new BoundedGrid<Actor>(14, 14));
		
		world.add(new Location(5, 5), new FlyingActor());
		world.add(new Location(13, 4), new Rock());
		world.add(new Location(5, 8), new Rock());
		world.add(new Location(9, 11), new Rock());
		world.add(new Location(11, 2), new Rock());
		world.show();		
	}
}
