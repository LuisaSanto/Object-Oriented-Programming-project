/** @version $Id: NameSection.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Document;
import edt.TextElement;
import edt.Section;

/**
 * §2.2.6.
 */
public class NameSection extends SectionCommand {
	public NameSection(Section receiver, Document document) {
		super(MenuEntry.NAME_SECTION, receiver, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int sectionId = IO.readInteger(Message.requestSectionId());
	    String uniqueId = IO.readString(Message.requestUniqueId());
	
		Section section = _receiver.getSection(sectionId);
		if(section != null){
			if(_document.insertUniqueElement(uniqueId, section))
				IO.println(Message.sectionNameChanged());
			_document.touch();
		}
		else
			IO.println(Message.noSuchSection(sectionId));
	}
}
