package edt;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;

public class Editor {

	/** Holds the current document. */
	private Document _document;
	
	/** Creates new empty document without a title. */
	public void create(){
		_document = new Document("");
	}
	
	/** Loads a Document object by reading it from a file. */
	public void open(String datafile) throws ClassNotFoundException, IOException{
		ObjectInputStream in = 
			new ObjectInputStream(new BufferedInputStream(new FileInputStream(datafile)));
		Document document = (Document) in.readObject();
		setDocument(document);
	}
	
	/** Saves a Document object to a file. */
	public void save(String datafile) throws IOException{
		setDocumentFileName(datafile);
		ObjectOutputStream out = 
			new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(datafile)));
		out.writeObject(_document);
		out.close();
	}
	
	/** Returns whether the current document was changed since it was last saved */
	public boolean documentChanged(){
		return _document.changed();
	}

	/** Returns the name of the file associated with the current document if it exists */
	public String getDocumentFileName(){
		return _document.getFileName();
	}

	/** Sets the name of the file associated with the current document */
	public void setDocumentFileName(String name){
		_document.setFileName(name);
	}

	/** Sets the current document */
	public void setDocument(Document document){
		_document = document;
	}
	
	/** Returns the current document */
	public Document getDocument(){
		return _document;
	}
}