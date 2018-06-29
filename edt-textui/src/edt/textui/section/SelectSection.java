/** @version $Id: SelectSection.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Document;
import edt.TextElement;
import edt.Section;

/**
 * §2.2.4.
 */
public class SelectSection extends SectionCommand {
	public SelectSection(Section receiver, Document document) {
		super(MenuEntry.SELECT_SECTION, receiver, document);
	}

	@Override
	public final void execute() throws DialogException, IOException  {
	 	
	 	int sectionId = IO.readInteger(Message.requestSectionId());
	 	Section section = _receiver.getSection(sectionId);
	 	if(section != null){
	 		IO.println(Message.newActiveSection(sectionId));
	 		edt.textui.section.MenuBuilder.menuFor(section, _document);
	 	}
	 	else
	 		IO.println(Message.noSuchSection(sectionId));
	}
}
