package components;

import com.artemis.Component;
import com.artemis.utils.Utils;

public class Transform extends Component {
	
	private float x, y; //x and y coordinates (pixel locations)
	
	public Transform(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	public void addX(float x){
		this.x += x;
	}
	
	public void addY(float y){
		this.y += y;
	}
	
	public void setLocation(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public float getDistanceTo(Transform t){
		return Utils.distance(t.getX(), t.getY(), x, y);
	}
	
}
