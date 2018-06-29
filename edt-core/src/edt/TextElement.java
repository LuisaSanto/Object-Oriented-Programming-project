package edt;

import java.io.Serializable;

public abstract class TextElement implements Serializable {

	/** Holds the unique identifier of this text element (empty by default) */
	private String _unique = "";

	/** Returns the unique identifier of this text element */
	public String getUnique(){
		return _unique;
	}

	/** Sets the unique identifier of this text element */
	public void setUnique(String unique){
		_unique = unique;
	}
	
}