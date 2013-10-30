package components;

import com.artemis.Component;

public class Velocity extends Component {

	private float vx, vy; //velocities in x and y components
	private float rotation;
	
	public Velocity(float vx, float vy){
		this.vx = vx;
		this.vy = vy;
	}
	
	public Velocity(){
		this(0, 0);
	}
	
	public float getVelocityX(){
		return vx;
	}
	
	public float getVelocityY(){
		return vy;
	}
	
	public float getRotation(){
		return rotation;
	}
	
	public void setVelocityX(float vx){
		this.vx = vx;
	}
	
	public void setVelocityY(float vy){
		this.vy = vy;
	}
	
	public void setRotation(float rotation){
		this.rotation = rotation;
	}
	
	public void addVelocityX(float vx){
		this.vx += vx;
	}
	
	public void addVelocityY(float vy){
		this.vy += vy;
	}
	
	public void addRotation(float angle){
		this.rotation = (rotation + angle) % 360;
	}
	
	public float getRotationRadians(){
		return (float) Math.toRadians(rotation);
	}
	
}
