import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;


public class CharismaCritterRunner
{
	public static void main(String args[])
	{
		World<Actor> world =  new ActorWorld(new BoundedGrid<Actor>(7, 7));
		
		world.add(new Location(3,  3), new CharismaCritter(1));
		world.add(new Location(3,  4), new Critter());
		world.add(new Location(3,  2), new Critter());
		world.add(new Location(2,  4), new Critter());
		
		world.show();
	}
}
