package components;

import com.artemis.Component;

public class Expires extends Component {

	private int delay;

	public Expires(int delay){
		this.delay = delay;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}
	
	public boolean isExpired(){
		return delay <= 0;
	}
	
	public void tick(float delta){
		delay -= delta;
	}
}
