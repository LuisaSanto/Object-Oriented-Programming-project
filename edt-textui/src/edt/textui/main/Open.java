/** @version $Id: Open.java,v 1.1 2015/10/05 16:00:36 david Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;
import java.io.FileNotFoundException;

/* FIXME: import core classes here */
import edt.Editor;

/**
 * Open existing document.
 */
public class Open extends Command<Editor> {
	public Open(Editor receiver) {
		super(MenuEntry.OPEN, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		String datafile = IO.readString(Message.openFile());
		try{
			_receiver.open(datafile);
		}
		catch(ClassNotFoundException cnfe){ System.err.println("Class not found!"); }
		catch(FileNotFoundException fnfe){ IO.println(Message.fileNotFound()); }
	}

}
