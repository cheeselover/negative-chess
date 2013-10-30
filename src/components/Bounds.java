package components;

import org.newdawn.slick.geom.Rectangle;

import com.artemis.Component;

public class Bounds extends Component {

	private Rectangle bounds;
	
	public Bounds(float size){
		this.bounds = new Rectangle(0, 0, size, size);
	}

	public Rectangle getBounds() {
		return bounds;
	}
	
}
