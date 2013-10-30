package components;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.artemis.Component;

public class TileComponent extends Component {

	private Color color;
	private Image grayWall;
	private boolean isGray;
	
	public TileComponent(Color color) throws SlickException {
		this.color = color;
		isGray = false;
		this.grayWall = new Image("res/gray_wall.png");
	}
	
	public TileComponent(boolean isGray) throws SlickException {
		this.color = Color.transparent;
		this.isGray = true;
		this.grayWall = new Image("res/gray_wall.png");
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Image getGray(){
		return grayWall;
	}
	
	public boolean isGray(){
		return isGray;
	}
	
	public void setIsGray(boolean isGray) {
		this.isGray = isGray;
	}
	
}
