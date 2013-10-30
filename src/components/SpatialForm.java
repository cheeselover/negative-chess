package components;

import com.artemis.Component;

public class SpatialForm extends Component {
	
	private String spatialForm;
	
	public SpatialForm(String spatialForm){
		this.spatialForm = spatialForm;
	}

	public String getSpatialForm() {
		return spatialForm;
	}

}
