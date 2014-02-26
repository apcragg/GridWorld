import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;


public class LawAndOrderRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(12, 12));
		
		world.add(new Cash());
		world.add(new Cash());
		world.add(new Cash());
		world.add(new Cash());
		world.add(new Cash());
		world.add(new Diamond());
		world.add(new Diamond());
		world.add(new Diamond());
		world.add(new Diamond());
		world.add(new Diamond());
		world.add(new Diamond());
		
		world.add(new CriminalCritter());
		world.add(new CriminalCritter());
		world.add(new CriminalCritter());
		world.add(new CriminalCritter());
		world.add(new CriminalCritter());
		world.add(new PoliceOfficerCritter());
		
		world.show();
	}
}
