package reportbuilders;

import analyzers.Analyzer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import util.XMLUtils;
import java.io.File;
import java.util.Map;

public class XMLReportBuilder implements ReportBuilder{

    private final Analyzer analyzer;

    public XMLReportBuilder(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    @Override
    public void makeReport() {
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Map<String, Integer> tokenMap = analyzer.getTokenMap();
            Element rootElement = document.createElement("Tokens");
            document.appendChild(rootElement);
            int numOfToken = 0;
            for(String token: tokenMap.keySet()){
                numOfToken += tokenMap.get(token);
            }
            rootElement.appendChild(XMLUtils.getTokenElements(document, "NumOfTokens", String.valueOf(numOfToken)));
            for(String token: tokenMap.keySet()){
                rootElement.appendChild(XMLUtils.getToken(document, "Token", token, String.valueOf(tokenMap.get(token))));
            }
            TransformerFactory transformerFactory =  TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result =  new StreamResult(new File(System.getProperty("user.dir") + "/Task4/report.xml"));
            transformer.transform(source, result);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
