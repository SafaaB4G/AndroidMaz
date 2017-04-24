import android.text.Editable;
import android.text.Html;

import org.xml.sax.XMLReader;

/**
 * Created by macbookair on 10/04/2017.
 */

public class FormatUl implements Html.TagHandler{
    @Override
    public void handleTag(boolean opening, String tag, Editable output,
                          XMLReader xmlReader) {
        if(tag.equals("ul") && !opening) output.append("\n");
        if(tag.equals("li") && opening) output.append("\n\t•");
    }
}