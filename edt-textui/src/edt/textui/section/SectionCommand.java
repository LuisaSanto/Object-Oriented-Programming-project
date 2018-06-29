/** @version $Id: SectionCommand.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import ist.po.ui.Command;

import edt.Section;
import edt.Document;
/**
 * Superclass of all section-context commands.
 */
public abstract class SectionCommand extends Command<Section> {
  
  	public Document _document;
  
	public SectionCommand(String title, Section receiver, Document document) {
		super(title, receiver);

		_document = document;
	}
}