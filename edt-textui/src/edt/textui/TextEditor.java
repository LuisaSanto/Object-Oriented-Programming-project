/** @version $Id: TextEditor.java,v 1.1 2015/10/05 16:00:34 david Exp $ */
package edt.textui;

import static ist.po.ui.Dialog.IO;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

import edt.Editor;
import edt.Document;
import edt.Reader;

/**
 * Class that starts the application's textual interface.
 */
public class TextEditor {
	public static void main(String[] args) {
		Editor editor = new Editor();
		Document document = new Document("");
		
		String datafile = System.getProperty("import"); //$NON-NLS-1$
		if (datafile != null) {
			try{
				Reader reader = new Reader();
				reader.readImportFile(datafile);
				document = reader.getDocument();
			}
			catch(FileNotFoundException fnfe){ fnfe.printStackTrace(); }
			catch(IOException ioe){ ioe.printStackTrace(); }

		}

		editor.setDocument(document);
		edt.textui.main.MenuBuilder.menuFor(editor);
		IO.closeDown();
	}
}
