/** @version $Id: InsertSection.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Document;
import edt.Section;
import edt.TextElement;

/**
 * §2.2.5.
 */
public class InsertSection extends SectionCommand {
    public InsertSection(Section receiver, Document document){
        super(MenuEntry.INSERT_SECTION, receiver, document);
    }

    @Override
    public final void execute() throws DialogException, IOException {
        int elementId = IO.readInteger(Message.requestSectionId());
        String title = IO.readString(Message.requestSectionTitle());
        Section section = new Section(title);

        TextElement reference = _receiver.getElement(elementId);
        _receiver.insertSection(reference, section);

        _document.touch();
    }
}
