import info.gridworld.actor.Actor;

/*
 * Author:       Andrew Cragg
 * Date Created: Feb 17, 2014
 */

public class DizzyActor extends Actor
{ 
	public DizzyActor(){}
	public void act(){ setDirection(getDirection() - 45);}
}