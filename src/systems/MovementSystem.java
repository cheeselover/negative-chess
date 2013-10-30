package systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import components.Transform;
import components.Velocity;

public class MovementSystem extends EntityProcessingSystem {

	@Mapper ComponentMapper<Transform> tm;
	@Mapper ComponentMapper<Velocity> vm;
	
	@SuppressWarnings("unchecked")
	public MovementSystem() {
		super(Aspect.getAspectForAll(Transform.class, Velocity.class));
	}

	@Override
	protected void process(Entity e) {
		if(vm.has(e)){
			Transform transform = tm.get(e);
			Velocity velocity = vm.get(e);
			
			transform.addX(velocity.getVelocityX() * world.delta);
			transform.addY(velocity.getVelocityY() * world.delta);
		}
	}

}
