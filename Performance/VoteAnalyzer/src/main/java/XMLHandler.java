import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;

public class XMLHandler extends DefaultHandler {
    private static StringBuilder insertQuery = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("voter")) {
            countVoterBuilder(attributes.getValue("name"), attributes.getValue("birthDay"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("voter")) {
            if (insertQuery.length() > 500_000) {
                try {
                    DBConnection.executeMultiInsert(insertQuery);
                    insertQuery = new StringBuilder();
                    System.out.println("SQL Query");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        if (qName.equals("voters")) {
            try {
                DBConnection.executeMultiInsert(insertQuery);
                System.out.println("Last SQL Query");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            insertQuery = new StringBuilder();
        }
    }

    public static void countVoterBuilder(String name, String birthDay) {
        birthDay = birthDay.replace('.', '-');
        insertQuery.append(insertQuery.length() == 0 ? "" : ",").append("('").append(name)
                .append("', '").append(birthDay).append("', 1)");
    }
}