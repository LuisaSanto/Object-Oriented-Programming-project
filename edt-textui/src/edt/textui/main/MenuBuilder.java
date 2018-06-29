/** @version $Id: MenuBuilder.java,v 1.2 2015/10/15 07:40:55 ist13500 Exp $ */
package edt.textui.main;

import ist.po.ui.Command;
import ist.po.ui.Menu;

/* FIXME: import core classes here */
import edt.Editor;
import edt.Document;

public abstract class MenuBuilder {
  public static void menuFor(Editor editor) {
    Menu menu = new Menu(MenuEntry.TITLE,
        new Command<?>[] { //
            new New(editor), //
            new Open(editor), //
            new Save(editor), //
            new ShowMetadata(editor), //
            new AddAuthor(editor), //
            new ShowIndex(editor), //
            new ShowTextElement(editor), //
            new Edit(editor), //
    });
    menu.open();
  }
}
