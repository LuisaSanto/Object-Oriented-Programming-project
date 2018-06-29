/** @version $Id: EditParagraph.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Document;
import edt.Section;
import edt.TextElement;
import edt.Paragraph;

/**
 * §2.2.10.
 */
public class EditParagraph extends SectionCommand {
	public EditParagraph(Section receiver, Document document) {
		super(MenuEntry.EDIT_PARAGRAPH, receiver, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	  	int elementId = IO.readInteger(Message.requestParagraphId());
	  	String newContent = IO.readString(Message.requestParagraphContent());

	  	TextElement element = _receiver.getElement(elementId);
	  	if(element != null && element instanceof Paragraph){
	  		((Paragraph) element).setContent(newContent);
	  		_document.touch();
	  	}
	  	else
	  		IO.println(Message.noSuchParagraph(elementId));
	}
}
