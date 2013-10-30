package main;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;

import com.artemis.Entity;
import com.artemis.World;
import com.artemis.managers.GroupManager;
import components.Bounds;
import components.CardComponent;
import components.Expires;
import components.SpatialForm;
import components.TileComponent;
import components.Transform;
import components.Velocity;

public class EntityFactory {
	
	public static Entity createParticle(World world, float x, float y, float vx, float vy) {
		Entity e = world.createEntity();
		
		e.addComponent(new Transform(x, y));
		e.addComponent(new Velocity(vx, vy));
		e.addComponent(new Expires(6000));
		e.addComponent(new SpatialForm("PARTICLE"));
		e.addComponent(new Bounds(5));
		
		world.getManager(GroupManager.class).add(e, "PARTICLES");
		
		return e;
	}
	
	public static Entity createCard(World world, float x, float y, String type, Color color){
		Entity e = world.createEntity();
		
		e.addComponent(new Transform(x, y));
		e.addComponent(new SpatialForm("CARD"));
		e.addComponent(new CardComponent(type, color));
		
		world.getManager(GroupManager.class).add(e, "CARDS");
		
		return e;
	}
	
	public static Entity createTile(World world, float x, float y, Color color, boolean isGray) throws SlickException {
		Entity e = world.createEntity();
		
		e.addComponent(new Transform(x, y));
		e.addComponent(new SpatialForm("TILE"));
		e.addComponent((isGray) ? new TileComponent(true) : new TileComponent(color));
		
		world.getManager(GroupManager.class).add(e, "TILES");
		
		return e;
	}
	
}
