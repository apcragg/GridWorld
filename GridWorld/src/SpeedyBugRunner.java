import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;


public class SpeedyBugRunner
{
	private ActorWorld world;
	
	public SpeedyBugRunner()
	{
		world = new ActorWorld(new BoundedGrid<Actor>(14, 14));
		
		setup();
		run();
	}

	private void setup()
	{
		world.add(new SpeedyBug(new Color(.7f, .5f, .5f)));
		world.add(new SpeedyBug(new Color(.95f, .8f, .8f)));
	}
	
	private void run()
	{
		world.show();
	}
	
	
	public static void main(String bugArgs[])
	{
		new SpeedyBugRunner();
	}
}
