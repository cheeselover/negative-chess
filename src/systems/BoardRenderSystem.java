package systems;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.artemis.systems.VoidEntitySystem;

public class BoardRenderSystem extends VoidEntitySystem {

	Graphics g;
	GameContainer gc;
	
	public BoardRenderSystem(GameContainer gc){
		this.gc = gc;
		this.g = gc.getGraphics();
	}

	@Override
	protected void processSystem() {

	}

}
