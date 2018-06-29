/** @version $Id: RemoveSection.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Document;
import edt.TextElement;
import edt.Section;

/**
 * §2.2.7.
 */
public class RemoveSection extends SectionCommand {
	public RemoveSection(Section receiver, Document document) {
		super(MenuEntry.REMOVE_SECTION, receiver, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int sectionId = IO.readInteger(Message.requestSectionId());
      	Section section = _receiver.getSection(sectionId);

      	if(section != null){
      		_receiver.removeElement(section);
      		_document.touch();
      	}
      	else
      		IO.println(Message.noSuchSection(sectionId));
	}
  
}
