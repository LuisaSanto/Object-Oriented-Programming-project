package edt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Reader {
	private int index = 0;
	
	Document document = new Document("");
	Section section = document;
	
	public Document getDocument(){
		return document;
	}
	
	public void readImportFile(String name) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(name));
		String line;
	    while ((line = reader.readLine()) != null) {
	    	String[] fields = line.split("\\|");
	        registerFromFields(fields);
	    }
		reader.close();
	}
		
	void registerFromFields(String[] fields){
		// Regular expression pattern to match an Title.
		Pattern patTitle = Pattern.compile(".+"); // Any String
		// Regular expression pattern to match a message.
		Pattern patAuthors = Pattern.compile(".+/.+"); // Any String/String
		// Regular expression pattern to match a publication.
		Pattern parSection = Pattern.compile("^(SECTION)");
		// Regular expression pattern to match a publication.
		Pattern parParagraph = Pattern.compile("^(PARAGRAPH)");
		
		if (parParagraph.matcher(fields[0]).matches()) {
			registerParagraph(fields[1]);
		} else if (parSection.matcher(fields[0]).matches()) {
			registerSection(fields);
		} else if (patAuthors.matcher(fields[0]).matches()) {
			registerAuthors(fields);
		} else if (patTitle.matcher(fields[0]).matches()) {
			registerTitle(fields[0]);
		} else {
		        //throw new UnknownDataException(fields[0]);
		        System.out.println(fields);
		}
	}
		
	void registerTitle(String title) {
		document.setTitle(title);
	}
		
	void registerAuthors(String... fields) {
		for(int i = 0; i < fields.length; i++){
			String authors[] = fields[i].split("/");
			document.addAuthor(authors[0], authors[1]);
		} 		
	}

	void registerSection(String... fields) {
		section = new Section(fields[2], fields[1]);
		if(!(fields[1].equals(""))){
			document.insertUniqueElement(fields[1], section);
		}
		document.insertSection(null, section);
		index++;
	}
	
	void registerParagraph(String content){ 
		Paragraph paragraph = new Paragraph(content);
		/** inserts the paragraph in the last section created (or in the document by default) */
		section.insertParagraph(null, paragraph);
		index++;
	}
		
		
}