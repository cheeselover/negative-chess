package systems;

import java.util.Random;

import main.EntityFactory;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.managers.TagManager;
import com.artemis.systems.IntervalEntitySystem;
import com.artemis.utils.ImmutableBag;
import components.Transform;
import components.Velocity;

public class BlockSpawnSystem extends IntervalEntitySystem {
	
	Random r;
	@Mapper ComponentMapper<Transform> tm;
	@Mapper ComponentMapper<Velocity> vm;
	Transform playerLocation;
	Velocity playerVelocity;
	
	public BlockSpawnSystem(float interval) {
		super(Aspect.getEmpty(), interval);
		r = new Random();
	}

	@Override
	protected void processEntities(ImmutableBag<Entity> entities) {
		playerLocation = tm.get(world.getManager(TagManager.class).getEntity("PLAYER"));
		playerVelocity = vm.get(world.getManager(TagManager.class).getEntity("PLAYER"));
		for(int i = 0; i < 20; i++){
			EntityFactory.createParticle(world, playerLocation.getX(), playerLocation.getY(), -0.1f * (float) Math.cos(Math.toRadians(i * 5 + playerVelocity.getRotation())), -0.1f * (float) Math.sin(Math.toRadians(i * 5 + playerVelocity.getRotation()))).addToWorld();
		}
	}

}
