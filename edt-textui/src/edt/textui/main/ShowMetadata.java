/** @version $Id: ShowMetadata.java,v 1.1 2015/10/05 16:00:36 david Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;
import java.util.Map;

import edt.Document;
import edt.Editor;
import edt.Author;

/**
 * §2.1.2.
 */
public class ShowMetadata extends Command<Editor> {
	public ShowMetadata(Editor receiver) {
		super(MenuEntry.SHOW_METADATA, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		Document document = _receiver.getDocument();
		IO.println(Message.documentTitle(document.getTitle()));

		for(Map.Entry<String, Author> entry : (document.getAuthors()).entrySet()) 
			IO.println(Message.author(entry.getKey(), (entry.getValue()).getEmail()));
		IO.println(Message.documentSections(document.getSectionCount()));
		IO.println(Message.documentBytes(document.getDocumentSize()));
		IO.println(Message.documentIdentifiers(document.getUniqueCount()));
	}

}
