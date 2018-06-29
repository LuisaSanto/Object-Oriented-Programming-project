package edt;

import java.util.List;
import java.io.Serializable;
import java.util.LinkedList;

public class Section extends TextElement implements Serializable {

	/** The section's title (empty by default). */
	private String _title = "";
	
	/** Holds the section's elements, identified by a local id (index in this list) */
	private List<TextElement> _elements;
	
	/** The section's list of subsections. */
	private  List<Section> _subsections;

	/** The section's list of paragraphs. */
	private  List<Paragraph> _paragraphs;

	/**
	 * @param title
	 * 				the section's title.
	 */
	public Section(String title){
		_title = title;
		_elements = new LinkedList<TextElement>();
		_subsections = new LinkedList<Section>();
		_paragraphs = new LinkedList<Paragraph>();
	}
	
	public Section(String title, String unique){
		_title = title;
		setUnique(unique);
		_elements = new LinkedList<TextElement>();
		_subsections = new LinkedList<Section>();
		_paragraphs = new LinkedList<Paragraph>();
	}
	
	/** Returns the section's title */
	public String getTitle(){
		return _title;
	}
	
	/** Changes the section's title. */
	public void setTitle(String title){
		_title = title;
	}
	
	/** Returns the size of this section in bytes */
	public int getSize(){
		int size = _title.length();
		for(Section section : _subsections){
			size += section.getSize();
		}
		for(Paragraph paragraph : _paragraphs){
			size += paragraph.getSize();
		}
		return size;
	}

	/** Returns the number os subsections of this section */
	public int getSectionCount(){
		return _subsections.size();
	}
	
	/** Returns a TextElement from the local list */
	public TextElement getElement(int index){
		if(index < _elements.size())
			return _elements.get(index);
		return null;
	}
	
	/** Returns the list of text elements of this section */
	public List<TextElement> getElements(){
		return _elements;
	}
	
	/** Returns the list of TOP subsections of this section */
	public List<Section> getSubsections(){
		return _subsections;
	}

	/** Returns the list of paragraphs of this section */
	public List<Paragraph> getParagraphs(){
		return _paragraphs;
	}
	
	/** Returns a subsection from this section */
	public Section getSection(int index){
		if(index < _subsections.size() && index >= 0) return _subsections.get(index);
		else return null;
	}
	
	/** Returns a paragraph from this section */
	public Paragraph getParagraph(int index){
		if(index < _paragraphs.size() && index >= 0) return _paragraphs.get(index);
		else return null;
	}
	
	/** Adds a new subsection to this section */
	public void insertSection(TextElement element, Section section){
		if(element != null && element instanceof Section){
			Section reference = (Section) element;
			_elements.add(_elements.indexOf(reference), section);
			_subsections.add(_subsections.indexOf(reference), section);
		}else{
			_elements.add(section);
			_subsections.add(section);
		}
	}
	
	/** Adds a new  paragraph to this section */
	public void insertParagraph(TextElement element, Paragraph paragraph){
		if(element != null && element instanceof Paragraph){
			Paragraph reference = (Paragraph) element;
			_elements.add(_elements.indexOf(reference), paragraph);
			_paragraphs.add(_paragraphs.indexOf(reference), paragraph);
		}else{
			_elements.add(paragraph);
			_paragraphs.add(paragraph);
		}
	}
	
	/** Removes a certain element from the LOCAL list of this section */
	public void removeElement(TextElement element){
		_elements.remove(element);
		if(element instanceof Section)
			_subsections.remove((Section) element);
		else
			_paragraphs.remove((Paragraph) element);
	}

	/** Prints out the full content of this section. */
	public String getContent(){
		String content = this.toString();
		for(TextElement element : _elements){
			if(element instanceof Section)
				content += "\n" + ((Section) element).getContent();
			else
				content += "\n" + ((Paragraph) element).toString();
		}
		return content;
	}

	/** see java.lang.Object#equals() */
	@Override
	@SuppressWarnings("nls")
	public boolean equals(Object o){
		if(o instanceof Section){
			Section section = (Section) o;
			return _title.equals(section.getTitle());
		}
		return false;
	}
	
	/** see java.lang.Object#toString() */
	@Override
	public String toString(){
		return "[" + getUnique() + "] {" + _title + "}";
	}

}