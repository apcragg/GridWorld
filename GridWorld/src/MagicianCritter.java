import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/*
 * Author:       Andrew Cragg
 * Date Created: Feb 24, 2014
 */

public class MagicianCritter extends Critter
{
	public MagicianCritter()
	{
		super();
	}
	
	public void processActors(ArrayList<Actor> actors)
	{
		for(Actor a : actors)
		{
			if(a instanceof Bug)
			{
				Data<Actor> d = new Data<Actor>(a);
				a = d.resetActor(Actor.class);
			}
			
			else if(a instanceof Critter && !(a instanceof MagicianCritter))
			{
				Data<Bug> d = new Data<Bug>(a);
				a = d.resetActor(Bug.class);
			}
			
			else if(a instanceof Rock)
			{
				Data<Flower> d = new Data<Flower>(a);
				a = d.resetActor(Flower.class);
			}
			
			else if(a instanceof Flower)
			{
				Data<Rock> d = new Data<Rock>(a);
				a = d.resetActor(Rock.class);
			}
			
			else
			{
				Data<Critter> d = new Data<Critter>(a);
				a = d.resetActor(Critter.class);
			}
		}
	}
	
	private class Data<T extends Actor>
	{
		private Color c;
		private int d;
		private Location l;
				
		public Data(Actor a)
		{
			c = a.getColor();
			d = a.getDirection();
			l = a.getLocation();
			
			a.removeSelfFromGrid();
		}
		
		public T resetActor(Class<T> cl)
		{	
			T a = null;
			
			try { a = cl.newInstance(); }
			catch (Exception e) {}

			a.setColor(c);
			a.setDirection(d);
			
			a.putSelfInGrid(getGrid(), l);
			
			return a;
		}
	}
}
