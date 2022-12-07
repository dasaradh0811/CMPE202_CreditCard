package cmpe202;

import cmpe202.validator.FileFormat;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, ParseException {
        String csvPath = "/Users/spartan/Downloads/Individual-Project-cmpe202-Dasaradh-main/input_file.csv";
        String jsonPath = "/Users/spartan/Downloads/Individual-Project-cmpe202-Dasaradh-main/input_file.json";
        String xmlPath = "/Users/spartan/Downloads/Individual-Project-cmpe202-Dasaradh-main/input_file.xml";

        FileFormat file = new FileFormat();
       file.parse(csvPath).getData(csvPath);
//        file.parse(xmlPath).getData(xmlPath);
//        file.parse(jsonPath).getData(jsonPath);


    }

}