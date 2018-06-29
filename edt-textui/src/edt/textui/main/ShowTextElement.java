/** @version $Id: ShowTextElement.java,v 1.1 2015/10/05 16:00:36 david Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Editor;
import edt.Document;
import edt.TextElement;
import edt.Paragraph;
import edt.Section;

/**
 * §2.1.5.
 */
public class ShowTextElement extends Command<Editor> {
	public ShowTextElement(Editor receiver) {
		super(MenuEntry.SHOW_TEXT_ELEMENT, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		Document document = _receiver.getDocument();
		String uniqueId  = IO.readString(Message.requestElementId());
		TextElement element = document.getUniqueElement(uniqueId);
		if(element == null) 
			IO.println(Message.noSuchTextElement(uniqueId));
		else{
			if(element instanceof Paragraph) IO.println(element.toString());
			else IO.println(((Section) element).getContent());
		}
	}
}
