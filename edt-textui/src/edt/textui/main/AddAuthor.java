/** @version $Id: AddAuthor.java,v 1.1 2015/10/05 16:00:36 david Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Document;
import edt.Editor;

/**
 * §2.1.3.
 */
public class AddAuthor extends Command<Editor> {
	public AddAuthor(Editor receiver) {
		super(MenuEntry.ADD_AUTHOR, receiver);
	}
	
	

	@Override
	public final void execute() throws DialogException, IOException {
	  	Document document = _receiver.getDocument();
	  	try{
	  		String name = IO.readString(Message.requestAuthorName());
	  		String email = IO.readString(Message.requestEmail());
	  		if(document.hasAuthor(name)) 
	  			IO.println(Message.duplicateAuthor(name));
	  		else
	  			document.addAuthor(name, email);		
	  	}
	  	catch(IOException ioe){ ioe.printStackTrace(); }
	}
}
