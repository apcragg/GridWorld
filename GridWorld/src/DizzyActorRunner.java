import info.gridworld.actor.ActorWorld;

/*
 * Author:       Andrew Cragg
 * Date Created: Feb 17, 2014
 */

public class DizzyActorRunner
{
	public static void main(String qq[])
	{
		ActorWorld w = new ActorWorld();
		w.add(new DizzyActor());
		w.show();
	}
}
