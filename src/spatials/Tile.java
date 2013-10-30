package spatials;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import com.artemis.Entity;
import com.artemis.World;
import components.TileComponent;
import components.Transform;

public class Tile extends Spatial {

	TileComponent tile;
	Transform transform;
	
	public Tile(World world, Entity owner) {
		super(world, owner);
	}

	@Override
	public void initialize() {
		tile = world.getMapper(TileComponent.class).get(owner);
		transform = world.getMapper(Transform.class).get(owner);
	}

	@Override
	public void render(Graphics g) {
		if(!tile.isGray()){
			g.setColor(tile.getColor());
			g.fillRect(transform.getX() - 2, transform.getY() - 2, 36, 36);
			g.setColor((tile.getColor() == Color.black) ? Color.white : Color.black);
			g.fillRect(transform.getX(), transform.getY(), 32, 32);
			g.setColor(tile.getColor());
			g.fillRect(transform.getX() + 2, transform.getY() + 2, 28, 28);
		} else {
			g.drawImage(tile.getGray(), transform.getX(), transform.getY());
		}
		
	}

}
