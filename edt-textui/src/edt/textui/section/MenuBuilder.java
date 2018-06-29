/** @version $Id: MenuBuilder.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import ist.po.ui.Command;
import ist.po.ui.Menu;

import edt.Document;
import edt.Section;

/**
 * Menu builder for search operations.
 */
public class MenuBuilder {
  public static void menuFor(Section section, Document document) {
    Menu menu = new Menu(MenuEntry.TITLE,
        new Command<?>[] { //
            new ChangeTitle(section, document), //
            new ListSections(section, document), //
            new ShowContent(section, document), //
            new SelectSection(section, document), //
            new InsertSection(section, document), //
            new NameSection(section, document), //
            new RemoveSection(section, document), //
            new InsertParagraph(section, document), //
            new NameParagraph(section, document), //
            new EditParagraph(section, document), //
            new RemoveParagraph(section, document), //
    });
    menu.open();
  }
}
