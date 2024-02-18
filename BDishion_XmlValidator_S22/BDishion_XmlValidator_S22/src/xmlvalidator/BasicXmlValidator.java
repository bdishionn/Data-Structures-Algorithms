package xmlvalidator;

import java.util.*;
import java.util.regex.*;

import org.apache.commons.lang3.*;

public class BasicXmlValidator implements XmlValidator {

	List<String> outcome = new ArrayList<String>();
	Pattern p = Pattern.compile("<[^<>]+>");

	BasicXmlTagStack tagName = new BasicXmlTagStack();

	@Override
	public List<String> validate(String xmlDocument) {
		Matcher m = p.matcher(xmlDocument);
		while (m.find()) {
			String match = m.group();
			if ((match.contains("!") || match.contains("?")))
				continue;

			var tag = match.split(" ");
			var thisTag = tag[0].substring(1).replace(">", "");

			if (!thisTag.startsWith("/")) {
				String under = xmlDocument.substring(0, m.start());
				int line = StringUtils.countMatches(under, "\n") + 1;
				tagName.push(new XmlTag(thisTag, line));
			} else {
				String close = thisTag.substring(1);
				if (tagName.getCount() == 0) {
					outcome.add("Orphan closing tag");
					outcome.add(close);
					String under = xmlDocument.substring(0, m.start());
					int line = StringUtils.countMatches(under, "\n") + 1;
					outcome.add(Integer.toString(line));
					return outcome;
				}
				XmlTag peek = tagName.peek(0);
				if (close.equals(peek.name)) {
					tagName.pop();
				} else {
					outcome.add("Tag mismatch");
					outcome.add(peek.name);
					outcome.add(Integer.toString(peek.index));
					outcome.add(close);
					String under = xmlDocument.substring(0, m.start());
					int line = StringUtils.countMatches(under, "\n") + 1;
					outcome.add(Integer.toString(line));
					return outcome;
				}
			}
		}
		if (tagName.getCount() != 0) {
			outcome.add("Unclosed tag at end");
			outcome.add(tagName.peek(0).name);
			outcome.add(Integer.toString(tagName.peek(0).index));
			return outcome;
		}
		return null;

	}

}
