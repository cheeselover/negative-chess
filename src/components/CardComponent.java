package components;

import org.newdawn.slick.Color;

import com.artemis.Component;

public class CardComponent extends Component {
	
	private String type;
	private Color color;
	
	public CardComponent(String type, Color color){
		this.type = type;
		this.color = color;
	}
	
	public String getType() {
		return type;
	}
	
	public Color getColor() {
		return color;
	}
	
}
