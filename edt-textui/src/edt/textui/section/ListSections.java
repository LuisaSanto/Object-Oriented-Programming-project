/** @version $Id: ListSections.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Document;
import edt.Section;

/**
 * §2.2.2.
 */
public class ListSections extends SectionCommand {
	public ListSections(Section receiver, Document document) {
		super(MenuEntry.LIST_SECTIONS, receiver, document);
	}

	public void listSectionIndex(Section section){
		for(Section next : section.getSubsections()){
			IO.println(Message.sectionIndexEntry(next.getUnique(), next.getTitle()));
			listSectionIndex(next);
		}
	}

	@Override
	public final void execute() throws DialogException, IOException {
    	listSectionIndex(_receiver);
	}
}
