/** @version $Id: Save.java,v 1.1 2015/10/05 16:00:36 david Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

/* FIXME: import core classes here */
import edt.Editor;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class Save extends Command<Editor> {
	public Save(Editor receiver) {
		super(MenuEntry.SAVE, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		try{
			if(_receiver.documentChanged()){
				String datafile = _receiver.getDocumentFileName();
				if(datafile.equals("")) datafile = IO.readString(Message.newSaveAs());
				_receiver.save(datafile);
			}
		}
		catch(IOException ioe){ ioe.printStackTrace(); }
	}
}
