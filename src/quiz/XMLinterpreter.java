package quiz;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLinterpreter {
    public String dat;


        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        DefaultHandler handle = new DefaultHandler() {
            public boolean type1Question = false;
            public ArrayList<String> type1QArrayList = new ArrayList<String>();
            public boolean type2Question = false;
            public boolean type3Question = false;
            public boolean type4Question = false;
            public boolean type5Question = false;
            public boolean Title = false;
            public boolean Q = false;
            public boolean AnswerChoice = false;
            public boolean correctAnswer = false;

            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (attributes.equals("1")) {
                    type1Question = true;
                }
                if (attributes.equals("2")) {
                    type2Question = true;
                }
                if (attributes.equals("3")) {
                    type3Question = true;
                }
                if (attributes.equals("4")) {
                    type4Question = true;
                }
                if (attributes.equals("5")) {
                    type5Question = true;
                }
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                if(type1Question){
                    dat = new String(ch, start, length);
                    type1QArrayList.add(dat);
                    System.out.println(type1QArrayList);

                }
            }
        };


    public XMLinterpreter() throws ParserConfigurationException, SAXException {
    }
}


