package util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLUtils {
    public static Node getToken(Document doc, String tagName, String name, String num) {
        Element token = doc.createElement(tagName);
        token.appendChild(getTokenElements(doc, "name", name));
        token.appendChild(getTokenElements(doc, "num", num));
        return token;
    }

    public static Node getTokenElements(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
