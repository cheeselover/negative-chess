package systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import components.Bounds;
import components.Transform;

public class SetBoundsSystem extends EntityProcessingSystem {

	@Mapper ComponentMapper<Bounds> bm;
	@Mapper ComponentMapper<Transform> tm;
	
	@SuppressWarnings("unchecked")
	public SetBoundsSystem() {
		super(Aspect.getAspectForAll(Bounds.class, Transform.class));
	}

	@Override
	protected void process(Entity e) {
		if(bm.has(e)){
			bm.get(e).getBounds().setX(tm.get(e).getX());
			bm.get(e).getBounds().setY(tm.get(e).getY());
		}
	}

}
