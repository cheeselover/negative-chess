package components;

import org.newdawn.slick.Color;

import com.artemis.Component;

public class CardComponent extends Component {
	
	private String type;
	private Color color;
	private boolean hidden;
	
	public CardComponent(String type, Color color, boolean hidden){
		this.type = type;
		this.color = color;
		this.hidden = hidden;
	}
	
	public String getType() {
		return type;
	}
	
	public Color getColor() {
		return color;
	}

	public boolean isHidden(){
		return hidden;
	}

	public void setHidden(boolean hidden){
		this.hidden = hidden;
	}
	
}
