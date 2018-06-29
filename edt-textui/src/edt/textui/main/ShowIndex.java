/** @version $Id: ShowIndex.java,v 1.1 2015/10/05 16:00:36 david Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Editor;
import edt.Document;
import edt.Section;

/**
 * §2.1.4.
 */
public class ShowIndex extends Command<Editor> {
	public ShowIndex(Editor receiver) {
		super(MenuEntry.SHOW_INDEX, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		Document document = _receiver.getDocument();
		IO.println(document.toString());
		for(Section section : document.getSubsections()) 
			IO.println(Message.sectionIndexEntry(section.getUnique(), section.getTitle()));
	}
}
