/** @version $Id: InsertParagraph.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Document;
import edt.Section;
import edt.Paragraph;
import edt.TextElement;

/**
 * §2.2.8.
 */
public class InsertParagraph extends SectionCommand {
	public InsertParagraph(Section receiver, Document document) {
		super(MenuEntry.INSERT_PARAGRAPH, receiver, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int elementId = IO.readInteger(Message.requestParagraphId());
		String content = IO.readString(Message.requestParagraphContent());
		Paragraph paragraph = new Paragraph(content);
		
		TextElement reference = _receiver.getElement(elementId);
        _receiver.insertParagraph(reference, paragraph);

		_document.touch();
	}
}
