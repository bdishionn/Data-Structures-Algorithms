package xmlvalidator;

import static java.lang.System.*;

import java.util.*;

public class BasicXmlTagStack implements XmlTagStack {
	private List<XmlTag> elements = new ArrayList<XmlTag>();
	private int count;

	@Override
	public void push(XmlTag item) {
		elements.add(item);
		count++;

	}


	@Override
	public XmlTag pop() {
		if (count > 0) {
			var tmp = elements.remove(count - 1);
			count--;
			return tmp;
		} else
			return null;
	}


	@Override
	public XmlTag peek(int position) {
		return elements.get(elements.size() - (position + 1));

	}


	@Override
	public int getCount() {
		return count;
	}

}
