package AppProgram.Assignment1.CE203AssignmentCode2223;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

//used to control the maximum width of the accetable limit to input

public class TextFieldLimit extends PlainDocument {
    private int limit;

    //calls super method and sets the private method limit
    public TextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    public TextFieldLimit(int limit, boolean upper) {
        super();
        this.limit = limit;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}