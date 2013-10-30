package systems;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import spatials.Card;
import spatials.Particle;
import spatials.Spatial;
import spatials.Tile;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.artemis.utils.Bag;
import components.SpatialForm;
import components.Transform;

public class RenderSystem extends EntityProcessingSystem {

	private Graphics g;
	private Bag<Spatial> spatials;
	
	@Mapper ComponentMapper<SpatialForm> sfm;
	@Mapper ComponentMapper<Transform> tm;
	
	@SuppressWarnings("unchecked")
	public RenderSystem(GameContainer gc) {
		super(Aspect.getAspectForAll(Transform.class, SpatialForm.class));
		this.g = gc.getGraphics();
		spatials = new Bag<>();
	}

	@Override
	protected void process(Entity e) {
		Spatial spatial = spatials.get(e.getId());
		if(spatial != null) spatial.render(g);
	}
	
	@Override
	protected void inserted(Entity e){
		Spatial spatial = createSpatial(e);
		
		if(spatial != null){
			spatial.initialize();
			spatials.set(e.getId(), spatial);
		}
	}
	
	@Override
	protected void removed(Entity e){
		spatials.set(e.getId(), null);
	}
	
	private Spatial createSpatial(Entity e){
		SpatialForm spatialForm = sfm.get(e);
		String spatialFormFile = spatialForm.getSpatialForm();
		
		if("PARTICLE".equalsIgnoreCase(spatialFormFile)){
			return new Particle(world, e);
		} else if("CARD".equalsIgnoreCase(spatialFormFile)){
			return new Card(world, e);
		} else if("TILE".equalsIgnoreCase(spatialFormFile)){
			return new Tile(world, e);
		}
		
		return null;
	}

}
