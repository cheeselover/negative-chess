package systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import components.Expires;

public class ExpireSystem extends EntityProcessingSystem {

	@Mapper ComponentMapper<Expires> em;
	
	@SuppressWarnings("unchecked")
	public ExpireSystem() {
		super(Aspect.getAspectForAll(Expires.class));
	}

	@Override
	protected void process(Entity e) {
		Expires expires = em.get(e);
		expires.tick(world.getDelta());
		
		if(expires.isExpired()){
			e.deleteFromWorld();
		}
	}

}
