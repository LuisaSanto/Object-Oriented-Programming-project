/** @version $Id: NameParagraph.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Document;
import edt.Section;
import edt.TextElement;
import edt.Paragraph;

/**
 * §2.2.9.
 */
public class NameParagraph extends SectionCommand {
	public NameParagraph(Section receiver, Document document) {
		super(MenuEntry.NAME_PARAGRAPH, receiver, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	    int paragraphId = IO.readInteger(Message.requestParagraphId());
	    String uniqueId = IO.readString(Message.requestUniqueId());
		
		Paragraph paragraph = _receiver.getParagraph(paragraphId);
		if(paragraph != null){
			if(_document.insertUniqueElement(uniqueId, paragraph))
				IO.println(Message.paragraphNameChanged());
			_document.touch();
		}
		else
			IO.println(Message.noSuchParagraph(paragraphId));
  	}
}
