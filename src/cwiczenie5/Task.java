package cwiczenie5;

import java.io.Serializable;

public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3052176774007622918L;
	private String name;
	private String description;
	private boolean isAcomplished = false;
	
	public Task(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public boolean isAcomplished() {
		return isAcomplished;
	}

	public void setAcomplished(boolean isAcomplished) {
		this.isAcomplished = isAcomplished;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	
}
