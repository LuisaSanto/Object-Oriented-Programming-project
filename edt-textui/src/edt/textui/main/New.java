/** @version $Id: New.java,v 1.1 2015/10/05 16:00:36 david Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

/* FIXME: import core classes here */
import edt.Editor;

/**
 * Open a new document.
 */
public class New extends Command<Editor> {
	public New(Editor receiver) {
		super(MenuEntry.NEW, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		_receiver.create();
	}

}
