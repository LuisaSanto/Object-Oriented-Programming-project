/** @version $Id: RemoveParagraph.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Document;
import edt.Section;
import edt.TextElement;
import edt.Paragraph;

/**
 * §2.2.11.
 */
public class RemoveParagraph extends SectionCommand {
	public RemoveParagraph(Section receiver, Document document) {
		super(MenuEntry.REMOVE_PARAGRAPH, receiver, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
      	int elementId = IO.readInteger(Message.requestParagraphId());
      	TextElement element = _receiver.getElement(elementId);

      	if(element != null && element instanceof Paragraph){
      		_receiver.removeElement(element);
      		_document.touch();
      	}
      	else
      		IO.println(Message.noSuchParagraph(elementId));
	}

}
