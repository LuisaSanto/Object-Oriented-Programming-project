/** @version $Id: ChangeTitle.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Document;
import edt.Section;

/**
 * §2.2.1.
 */
public class ChangeTitle extends SectionCommand {
	public ChangeTitle(Section receiver, Document document) {
		super(MenuEntry.CHANGE_TITLE, receiver, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
    	String newTitle = IO.readString(Message.requestSectionTitle());
    	_receiver.setTitle(newTitle);
    	_document.touch();
	}
}
