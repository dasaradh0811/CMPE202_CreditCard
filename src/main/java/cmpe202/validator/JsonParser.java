package cmpe202.validator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonParser implements FileStrategy{
    private ArrayList<String> test = new ArrayList<>();
    private ArrayList<String> cards = new ArrayList<>();
    String cardType;
    @Override
    public void getData(String file) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray cardNumber = (JSONArray)jsonObject.get("cards");

            for (int i = 0; i < cardNumber.size(); i++)
            {
                JSONObject jsonObject1 = (JSONObject) cardNumber.get(i);
                if(jsonObject1.get("cardNumber")!=null)
                    test.add(jsonObject1.get("cardNumber").toString());
                else test.add("");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        this.processData(test);

    }

    @Override
    public void processData(ArrayList<String> test) {
        ValidationFactory validationFactory =  new ValidationFactory();
        for(String str : test){
//            System.out.println(str);
//            if(str ==null) str = "&";
            Validation card = validationFactory.checkCard(str);
            cardType = card.validCard();
            cards.add(cardType);
        }
        this.writeData(test,cards);
    }

    @Override
    public void writeData(ArrayList<String> test, ArrayList<String> cards) {
        try{
            File jsonfile = new File("test.json");
            FileWriter myWriter = new FileWriter("test.json");

            ArrayList<JSONObject> jobj = new ArrayList<>();
            for(int i = 0; i<test.size();i++) {
                JSONObject ouputObj = new JSONObject();
                ouputObj.put("CardNumber", test.get(i));
                ouputObj.put("CardType",cards.get(i));
                jobj.add(ouputObj);
            }
            JSONObject finalJobj = new JSONObject();
            finalJobj.put("cards", jobj);
            myWriter.write(finalJobj.toJSONString());
            myWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
