package entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: zone
 *
 */
@Entity

public class zone implements Serializable {

	   
	@Id
	private int id;
	private String ref;
	private float dimension;
	private static final long serialVersionUID = 1L;

	public zone() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getRef() {
		return this.ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}   
	public float getDimension() {
		return this.dimension;
	}

	public void setDimension(float dimension) {
		this.dimension = dimension;
	}
   
}
