package edt;

import java.io.Serializable;

public class Paragraph extends TextElement implements Serializable{

	private String _content;

	/**
	 *	@param content
	 *				the paragraph's content
	 */
	public Paragraph(String content){
		_content = content;
	}

	/** sets (edits) the paragraph's content */
	public void setContent(String content){
		_content = content;
	}

	/** returns the paragraph's content */
	public String getContent(){
		return _content;
	}

	/** Returns the size of this paragraph in bytes */
	public int getSize(){
		return _content.length();
	}

	/** see java.lang.Object#toString() */
	@Override
	public String toString(){
		return _content;
	}

}