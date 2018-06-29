package edt;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Document extends Section implements Serializable {
	
	/** Indicates whether or not the document has been changed since it was last saved */
	private boolean _changed = true;
	
	/** Holds the document's authors */
	private Map<String, Author> _authors;

	/** Map with uniquely identified sections or paragraphs */
	private Map<String, TextElement> _uniques;
	
	/** Name of the file associated with the document for saving purposes */
	private String _fileName ="";

	/**
	 *	@param title
	 *				the document's title
	 */
	public Document(String title) {
		super(title);
		_authors = new TreeMap<String, Author>();
		_uniques = new TreeMap<String, TextElement>();
	}	
	
	/** Returns whether the document was changed since it was last saved */
	public boolean changed(){
		return _changed;
	}

	/** Sets the _changed value because the document has been changed in some way */
	public void touch(){
		_changed = true;
	}

	/** Sets the _changed value because the document has been saved */
	public void saved(){
		_changed = false;
	}

	/** Returns the name of the file associated with this document */
	public String getFileName(){
		return _fileName;
	}

	/** Sets the name of the file associated with this document */
	public void setFileName(String name){
		_fileName = name;
	}

	/** Returns the list of authors associated with this document */
	public Map<String, Author> getAuthors(){
		return _authors;
	}
	
	/** Adds an author to the list */
	public void addAuthor(String name, String email){
		Author author = new Author(name, email);
		_authors.put(name, author);
		touch();
	}
	
	/** Verifies if a given author is already associated with this document */
	public boolean hasAuthor(String name){
		return _authors.containsKey(name);
	}

	/** Returns the size of the document */
	public int getDocumentSize(){
		return getSize();
	}

	/** Returns the number of uniquely identified text elements in this document */
	public int getUniqueCount(){
		return _uniques.size();
	}	

	/** Inserts an element with a unique identifier in the uniquely identified elements list */
	public boolean insertUniqueElement(String unique, TextElement element){
		boolean hasElement = false;
		String keyToRemove = "";
		
		for(Map.Entry<String, TextElement> entry : _uniques.entrySet()){
			if(entry.getKey().equals(unique)){
				// We have to update the previous element with this name
				entry.getValue().setUnique("");
			}
			else if(entry.getValue().equals(element)){
				// We have to remove the previous tree node with this element or else we would have a duplicate
				keyToRemove = entry.getKey();
				hasElement = true;
			}
		}
		
		// The removal is out of the for cycle to avoid ConcurrentModificationException
		if(hasElement) _uniques.remove(keyToRemove);
		
		element.setUnique(unique);
		_uniques.put(unique, element);
		return hasElement; 
	}

	/** Returns a certain element from the list of uniquely identified elements of this document */
	public TextElement getUniqueElement(String unique){
		return _uniques.get(unique);
	}
	
	/** Removes a uniquely identified element from this document */
	public void removeUniqueElement(String unique){
		_uniques.remove(unique);
	}
	
	/** see java.lang.Object#toString() */
	@Override
	public String toString(){
		return "{" + getTitle() + "}";
	}
}