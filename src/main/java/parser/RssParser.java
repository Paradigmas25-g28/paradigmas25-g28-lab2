package parser;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import feed.Article;

/* Esta clase implementa el parser de feed de tipo rss (xml)
 * https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm 
 * */

public class RssParser extends GeneralParser {

    private List<Article> articles;

    @Override
    public void parse(String path) {
        try {
            File xmlFile = new File(path);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList items = doc.getElementsByTagName("item");

            this.articles = new ArrayList<>();

            for (int i = 0; i < items.getLength(); i++) {
                Node node = items.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element item = (Element) node;

                    String title = getText(item, "title");
                    String description = getText(item, "description");
                    Date pubDate = parseDate(getText(item, "pubDate"));
                    String link = getText(item, "link");

                    articles.add(new Article(title, description, pubDate, link));
                }
            }
        } catch (Exception e) {
            System.err.println("Error al parsear RSS: " + e.getMessage());
            this.articles = null;
        }
    }

    private String getText(Element element, String tagName) {
        NodeList list = element.getElementsByTagName(tagName);
        return (list.getLength() > 0) ? list.item(0).getTextContent() : "";
    }

    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            return format.parse(dateStr);
        } catch (Exception e) {
            return new Date(); 
        }
    }

    public List<Article> getArticles() {
        return articles;
    }

}


