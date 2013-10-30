package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import systems.*;

import com.artemis.World;
import com.artemis.managers.GroupManager;
import com.artemis.managers.TagManager;

public class NegativeChess extends BasicGame {

	GameContainer container;
	World world;
	RenderSystem renderSystem;
	BoardRenderSystem boardRenderSystem; 
	
	public static void main(String[] args) throws SlickException{
		AppGameContainer app = new AppGameContainer(new NegativeChess("TEST"));
		
		app.setDisplayMode(733, 523, false);
		app.setTargetFrameRate(60);
		app.setShowFPS(false);
		app.start();
	}
	
	public NegativeChess(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		this.container = gc;

		try{
			renderSystem = new RenderSystem(gc);
		} catch (Exception e){
			e.printStackTrace();
		}

		boardRenderSystem = new BoardRenderSystem(gc);
		
		world = new World();
		
		world.setManager(new GroupManager());
		world.setManager(new TagManager());
		
		world.setSystem(renderSystem, true);
		world.setSystem(boardRenderSystem, true);
		
		world.setSystem(new MovementSystem());
		world.setSystem(new ExpireSystem());
		world.setSystem(new CollisionSystem());
		world.setSystem(new SetBoundsSystem());
		world.setSystem(new InputSystem(gc));
		world.setSystem(new CardHandSystem());
		
		world.initialize();
		
		initBoard();
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		boardRenderSystem.process();
		renderSystem.process();
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		world.setDelta(delta);
		world.process();
	}
	
	private void initBoard() throws SlickException {
		for(int i = 0; i < 14; i++){
			for(int j = 0; j < 14; j++){
				EntityFactory.createTile(world, (5 * (i + 1) + i * 32) + 105, 5 * (j + 1) + j * 32, (j < 7) ? Color.white : Color.black, false).addToWorld();
			}
		}
	}

}
