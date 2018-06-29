{"filter":false,"title":"RemoveParagraph.java","tooltip":"/edt-textui/src/edt/textui/section/RemoveParagraph.java","undoManager":{"mark":60,"position":60,"stack":[[{"start":{"row":0,"column":0},"end":{"row":24,"column":0},"action":"remove","lines":["/** @version $Id: RemoveParagraph.java,v 1.1 2015/10/05 16:00:37 david Exp $ */","package edt.textui.section;","","import static ist.po.ui.Dialog.IO;","import ist.po.ui.DialogException;","","import java.io.IOException;","","/* FIXME: import core classes here */","","/**"," * §2.2.11."," */","public class RemoveParagraph extends SectionCommand {","\tpublic RemoveParagraph(/* FIXME: decls of argument(s) for receiver(s) */) {","\t\tsuper(MenuEntry.REMOVE_PARAGRAPH, /* FIXME: receiver(s) */);","\t}","","\t@Override","\tpublic final void execute() throws DialogException, IOException {","      \t\t/* FIXME: implement command */","\t}","","}",""],"id":2},{"start":{"row":0,"column":0},"end":{"row":34,"column":0},"action":"insert","lines":["/** @version $Id: RemoveParagraph.java,v 1.1 2015/10/05 16:00:37 david Exp $ */","package edt.textui.section;","","import static ist.po.ui.Dialog.IO;","import ist.po.ui.DialogException;","","import java.io.IOException;","","import edt.Document;","import edt.TextElement;","import edt.Paragraph;","","/**"," * §2.2.11."," */","public class RemoveParagraph extends SectionCommand {","\tpublic RemoveParagraph(Document receiver) {","\t\tsuper(MenuEntry.REMOVE_PARAGRAPH, receiver);","\t}","","\t@Override","\tpublic final void execute() throws DialogException, IOException {","      \tint elementId = IO.readInteger(Message.requestParagraphId());","      \tTextElement element = _receiverDoc.getElement(elementId);","","      \tif(element != null && element instanceof Paragraph){","      \t\t_receiverDoc.removeElement(element);","      \t\t_receiverDoc.touch();","      \t}","      \telse","      \t\tIO.println(Message.noSuchParagraph(elementId));","\t}","","}",""]}],[{"start":{"row":16,"column":24},"end":{"row":16,"column":32},"action":"remove","lines":["Document"],"id":3},{"start":{"row":16,"column":24},"end":{"row":16,"column":25},"action":"insert","lines":["S"]}],[{"start":{"row":16,"column":25},"end":{"row":16,"column":26},"action":"insert","lines":["e"],"id":4}],[{"start":{"row":16,"column":26},"end":{"row":16,"column":27},"action":"insert","lines":["c"],"id":5}],[{"start":{"row":16,"column":27},"end":{"row":16,"column":28},"action":"insert","lines":["t"],"id":6}],[{"start":{"row":16,"column":28},"end":{"row":16,"column":29},"action":"insert","lines":["i"],"id":7}],[{"start":{"row":16,"column":29},"end":{"row":16,"column":30},"action":"insert","lines":["o"],"id":8}],[{"start":{"row":16,"column":30},"end":{"row":16,"column":31},"action":"insert","lines":["n"],"id":9}],[{"start":{"row":26,"column":19},"end":{"row":26,"column":20},"action":"remove","lines":["c"],"id":10}],[{"start":{"row":26,"column":18},"end":{"row":26,"column":19},"action":"remove","lines":["o"],"id":11}],[{"start":{"row":26,"column":17},"end":{"row":26,"column":18},"action":"remove","lines":["D"],"id":12}],[{"start":{"row":23,"column":40},"end":{"row":23,"column":41},"action":"remove","lines":["c"],"id":13}],[{"start":{"row":23,"column":39},"end":{"row":23,"column":40},"action":"remove","lines":["o"],"id":14}],[{"start":{"row":23,"column":38},"end":{"row":23,"column":39},"action":"remove","lines":["D"],"id":15}],[{"start":{"row":8,"column":20},"end":{"row":9,"column":0},"action":"insert","lines":["",""],"id":16}],[{"start":{"row":9,"column":0},"end":{"row":9,"column":1},"action":"insert","lines":["i"],"id":17}],[{"start":{"row":9,"column":1},"end":{"row":9,"column":2},"action":"insert","lines":["m"],"id":18}],[{"start":{"row":9,"column":2},"end":{"row":9,"column":3},"action":"insert","lines":["o"],"id":19}],[{"start":{"row":9,"column":3},"end":{"row":9,"column":4},"action":"insert","lines":["r"],"id":20}],[{"start":{"row":9,"column":3},"end":{"row":9,"column":4},"action":"remove","lines":["r"],"id":21}],[{"start":{"row":9,"column":2},"end":{"row":9,"column":3},"action":"remove","lines":["o"],"id":22}],[{"start":{"row":9,"column":2},"end":{"row":9,"column":3},"action":"insert","lines":["p"],"id":23}],[{"start":{"row":9,"column":3},"end":{"row":9,"column":4},"action":"insert","lines":["o"],"id":24}],[{"start":{"row":9,"column":4},"end":{"row":9,"column":5},"action":"insert","lines":["r"],"id":25}],[{"start":{"row":9,"column":5},"end":{"row":9,"column":6},"action":"insert","lines":["t"],"id":26}],[{"start":{"row":9,"column":6},"end":{"row":9,"column":7},"action":"insert","lines":[" "],"id":27}],[{"start":{"row":9,"column":7},"end":{"row":9,"column":8},"action":"insert","lines":["e"],"id":28}],[{"start":{"row":9,"column":8},"end":{"row":9,"column":9},"action":"insert","lines":["d"],"id":29}],[{"start":{"row":9,"column":9},"end":{"row":9,"column":10},"action":"insert","lines":["t"],"id":30}],[{"start":{"row":9,"column":10},"end":{"row":9,"column":11},"action":"insert","lines":["."],"id":31}],[{"start":{"row":9,"column":11},"end":{"row":9,"column":12},"action":"insert","lines":["S"],"id":32}],[{"start":{"row":9,"column":12},"end":{"row":9,"column":13},"action":"insert","lines":["e"],"id":33}],[{"start":{"row":9,"column":13},"end":{"row":9,"column":14},"action":"insert","lines":["c"],"id":34}],[{"start":{"row":9,"column":14},"end":{"row":9,"column":15},"action":"insert","lines":["t"],"id":35}],[{"start":{"row":9,"column":15},"end":{"row":9,"column":16},"action":"insert","lines":["i"],"id":36}],[{"start":{"row":9,"column":16},"end":{"row":9,"column":17},"action":"insert","lines":["o"],"id":37}],[{"start":{"row":9,"column":17},"end":{"row":9,"column":18},"action":"insert","lines":["n"],"id":38}],[{"start":{"row":9,"column":18},"end":{"row":9,"column":19},"action":"insert","lines":[";"],"id":39}],[{"start":{"row":17,"column":40},"end":{"row":17,"column":41},"action":"insert","lines":[","],"id":40}],[{"start":{"row":17,"column":41},"end":{"row":17,"column":42},"action":"insert","lines":[" "],"id":41}],[{"start":{"row":17,"column":42},"end":{"row":17,"column":43},"action":"insert","lines":["D"],"id":42}],[{"start":{"row":17,"column":43},"end":{"row":17,"column":44},"action":"insert","lines":["o"],"id":43}],[{"start":{"row":17,"column":44},"end":{"row":17,"column":45},"action":"insert","lines":["c"],"id":44}],[{"start":{"row":17,"column":45},"end":{"row":17,"column":46},"action":"insert","lines":["u"],"id":45}],[{"start":{"row":17,"column":46},"end":{"row":17,"column":47},"action":"insert","lines":["m"],"id":46}],[{"start":{"row":17,"column":47},"end":{"row":17,"column":48},"action":"insert","lines":["e"],"id":47}],[{"start":{"row":17,"column":48},"end":{"row":17,"column":49},"action":"insert","lines":["n"],"id":48}],[{"start":{"row":17,"column":49},"end":{"row":17,"column":50},"action":"insert","lines":["t"],"id":49}],[{"start":{"row":17,"column":50},"end":{"row":17,"column":51},"action":"insert","lines":[" "],"id":50}],[{"start":{"row":17,"column":51},"end":{"row":17,"column":52},"action":"insert","lines":["d"],"id":51}],[{"start":{"row":17,"column":52},"end":{"row":17,"column":53},"action":"insert","lines":["o"],"id":52}],[{"start":{"row":17,"column":53},"end":{"row":17,"column":54},"action":"insert","lines":["c"],"id":53}],[{"start":{"row":17,"column":54},"end":{"row":17,"column":55},"action":"insert","lines":["u"],"id":54}],[{"start":{"row":17,"column":55},"end":{"row":17,"column":56},"action":"insert","lines":["m"],"id":55}],[{"start":{"row":17,"column":56},"end":{"row":17,"column":57},"action":"insert","lines":["n"],"id":56}],[{"start":{"row":17,"column":56},"end":{"row":17,"column":57},"action":"remove","lines":["n"],"id":57}],[{"start":{"row":17,"column":56},"end":{"row":17,"column":57},"action":"insert","lines":["e"],"id":58}],[{"start":{"row":17,"column":57},"end":{"row":17,"column":58},"action":"insert","lines":["n"],"id":59}],[{"start":{"row":17,"column":58},"end":{"row":17,"column":59},"action":"insert","lines":["t"],"id":60}],[{"start":{"row":18,"column":44},"end":{"row":18,"column":54},"action":"insert","lines":[", document"],"id":61}],[{"start":{"row":28,"column":8},"end":{"row":28,"column":20},"action":"remove","lines":["_receiverDoc"],"id":62},{"start":{"row":28,"column":8},"end":{"row":28,"column":17},"action":"insert","lines":["_document"]}]]},"ace":{"folds":[],"scrolltop":0,"scrollleft":0,"selection":{"start":{"row":35,"column":0},"end":{"row":35,"column":0},"isBackwards":false},"options":{"guessTabSize":true,"useWrapMode":false,"wrapToView":true},"firstLineState":0},"timestamp":1447595344000,"hash":"d4afcf6988cc1899ca96159373b33e7aad3d2c67"}