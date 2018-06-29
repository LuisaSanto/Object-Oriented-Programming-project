/** @version $Id: ShowContent.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Document;
import edt.Section;

/**
 * §2.2.3.
 */
public class ShowContent extends SectionCommand {
	public ShowContent(Section receiver, Document document) {
		super(MenuEntry.SHOW_CONTENT, receiver, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	  	IO.println(_receiver.getContent());
	}
}
