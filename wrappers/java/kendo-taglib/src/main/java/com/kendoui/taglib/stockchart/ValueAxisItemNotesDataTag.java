
package com.kendoui.taglib.stockchart;


import com.kendoui.taglib.BaseTag;




import java.util.ArrayList;
import java.util.Map;
import java.util.List;

import javax.servlet.jsp.JspException;

@SuppressWarnings("serial")
public class ValueAxisItemNotesDataTag extends BaseTag /* interfaces */ /* interfaces */ {
    
    @Override
    public int doEndTag() throws JspException {
//>> doEndTag
//<< doEndTag
        ValueAxisItemNotesTag parent = (ValueAxisItemNotesTag)findParentWithClass(ValueAxisItemNotesTag.class);

        parent.setData(this);

        return super.doEndTag();
    }

    @Override
    public void initialize() {
//>> initialize

        data = new ArrayList<Map<String, Object>>();

//<< initialize

        super.initialize();
    }

    @Override
    public void destroy() {
//>> destroy
//<< destroy

        super.destroy();
    }

//>> Attributes

    private List<Map<String, Object>> data;

    public List<Map<String, Object>> data() {
        return data;
    }

    public static String tagName() {
        return "stockChart-valueAxisItem-notes-data";
    }

    public void addDataItem(ValueAxisItemNotesDataItemTag value) {
        data.add(value.properties());
    }

//<< Attributes

}
