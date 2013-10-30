package systems;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.IntervalEntitySystem;
import com.artemis.utils.ImmutableBag;
import components.TileComponent;
import components.Transform;

public class InputSystem extends IntervalEntitySystem implements MouseListener {

	@Mapper ComponentMapper<Transform> tm;
	@Mapper ComponentMapper<TileComponent> tcm;
	GameContainer gc;
	Transform click;
	boolean clicked = false;
	
	public InputSystem(GameContainer gc) {
		super(Aspect.getAspectForAll(Transform.class, TileComponent.class), 50);
		this.gc = gc;
	}
	
	@Override
	public void initialize(){
		gc.getInput().addMouseListener(this);
		click = new Transform(0, 0);
	}
	
	@Override
	protected void processEntities(ImmutableBag<Entity> entities) {
		if(clicked){
			for(int i = 0; i < entities.size(); i++){
				if(tcm.has(entities.get(i)) && tm.get(entities.get(i)).getDistanceTo(click) < 36){
					clicked = false;
					tcm.get(entities.get(i)).setColor((tcm.get(entities.get(i)).getColor() == Color.black) ? Color.white : Color.black);
					break;
				}
			}
		}
	}

	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		click.setLocation(x, y);
		clicked = true;
	}

	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(int arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void inputStarted() {
		
	}

	@Override
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	public void setInput(Input arg0) {
		
	}

}
