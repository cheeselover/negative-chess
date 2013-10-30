package spatials;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.World;
import components.Transform;

public class Particle extends Spatial {
	
	private Transform transform;
	Random r;
	Color c;
	
	public Particle(World world, Entity owner) {
		super(world, owner);
	}

	@Override
	public void initialize() {
		ComponentMapper<Transform> tm = world.getMapper(Transform.class);
		transform = tm.get(owner);
		r = new Random();
		c = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat(), 1);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(c);
		g.fillRect(transform.getX(), transform.getY(), 5, 5);
	}

}
