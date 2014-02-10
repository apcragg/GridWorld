import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;


public class PokeyBugRunner
{
	private ActorWorld world;
	
	public PokeyBugRunner()
	{
		world = new ActorWorld(new BoundedGrid<Actor>(14, 14));
		
		setup();
		run();
	}

	private void setup()
	{
		world.add(new PokeyBug(new Color(.5f, .5f, .7f)));
		world.add(new PokeyBug(new Color(.7f, .5f, .5f)));
		world.add(new SpeedyBug(new Color(.5f, .7f, .5f)));
	}
	
	private void run()
	{
		world.show();
	}
	
	
	public static void main(String bugArgs[])
	{
		new PokeyBugRunner();
	}
}
