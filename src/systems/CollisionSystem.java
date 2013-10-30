package systems;

import java.util.Random;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.annotations.Mapper;
import com.artemis.managers.GroupManager;
import com.artemis.utils.Bag;
import com.artemis.utils.ImmutableBag;
import components.Bounds;
import components.Transform;
import components.Velocity;

public class CollisionSystem extends EntitySystem {

	@Mapper ComponentMapper<Transform> tm;
	@Mapper ComponentMapper<Velocity> vm;
	@Mapper ComponentMapper<Bounds> bm;
	private Bag<CollisionGroup> collisionGroups;
	private Random r;
	
	@SuppressWarnings("unchecked")
	public CollisionSystem() {
		super(Aspect.getAspectForAll(Transform.class));
	}
	
	@Override
	public void initialize(){
		collisionGroups = new Bag<>();
	}

	@Override
	protected boolean checkProcessing() {
		return true;
	}

	@Override
	protected void processEntities(ImmutableBag<Entity> entities) {
		for(int i = 0; i < collisionGroups.size(); i++){
			collisionGroups.get(i).checkCollisions();
		}
	}
	
	private boolean collisionExists(Entity e1, Entity e2){
        Bounds b1 = bm.get(e1);
        Bounds b2 = bm.get(e2);
        
        return b1.getBounds().intersects(b2.getBounds());
	}
	
	private class CollisionGroup {
		private ImmutableBag<Entity> entitiesA;
		private ImmutableBag<Entity> entitiesB;
		private CollisionHandler handler;
		
		public CollisionGroup(String group1, String group2, CollisionHandler handler){
			entitiesA = world.getManager(GroupManager.class).getEntities(group1);
			entitiesB = world.getManager(GroupManager.class).getEntities(group2);
			this.handler = handler;
		}
		
		public void checkCollisions(){
			for(int i = 0; i < entitiesA.size(); i++){
				for(int j = 0; j < entitiesB.size(); j++){
					Entity entityA = entitiesA.get(i);
					Entity entityB = entitiesB.get(j);
					
					if(collisionExists(entityA, entityB)){
						handler.handleCollision(entityA, entityB);
					}
				}
			}
		}
	}
	
	private interface CollisionHandler {
		public void handleCollision(Entity a, Entity b);
	}

}
