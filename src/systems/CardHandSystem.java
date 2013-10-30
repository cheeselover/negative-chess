package systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import components.CardComponent;
import components.Transform;
import main.Constants;
import main.EntityFactory;
import org.newdawn.slick.Color;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Siva
 * Date: 10/30/13
 * Time: 8:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class CardHandSystem extends EntityProcessingSystem {

	@Mapper ComponentMapper<CardComponent> ccm;
	Queue<CardComponent> deck;
	Random r;

	public CardHandSystem() {
		super(Aspect.getAspectForAll(Transform.class, CardComponent.class));
		r = new Random();
		deck = new LinkedList<>();
	}

	@Override
	protected void initialize(){
		for(int i = 0; i < 60; i++){
			Entity e = EntityFactory.createCard(world, 5, i * 8, Constants.CARD_TYPES[r.nextInt(4)], Color.black, i % 12 != 0);
			e.addToWorld();
			deck.add(ccm.get(e));
			e = EntityFactory.createCard(world, 628, i * 8, Constants.CARD_TYPES[r.nextInt(4)], Color.white, i % 12 != 0);
			e.addToWorld();
			deck.add(ccm.get(e));
		}
	}

	@Override
	protected void process(Entity entity) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
