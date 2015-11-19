import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by u2346 on 11/18/15.
 */
public class LeadObjectUtilities {
    public static List<Lead> getListOfLeadsFromFile(String filePath) {
        JSONParser parser = new JSONParser();
        List<Lead> newLeads = new ArrayList<Lead>();


        try {

            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray leadsList = (JSONArray) jsonObject.get("leads");

            Iterator<JSONObject> iterator = leadsList.iterator();
            while (iterator.hasNext()) {
                JSONObject object = iterator.next();

                ObjectMapper mapper = new ObjectMapper();
                //mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
                Lead thisLead = mapper.readValue(object.toString(), Lead.class);
                newLeads.add(thisLead);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return newLeads;

    }

    public static String writeListToJson (List <Lead> leadList) {

        JSONObject json = null;
        JSONArray jsonArray = null;

        if (leadList != null) {
            json = new JSONObject();
            jsonArray = new JSONArray();

            for(Lead temp : leadList) {
                JSONObject userJson = new JSONObject();
                userJson.put("_id", temp.getId());
                userJson.put("email", temp.getEmail());
                userJson.put("firstName", temp.getFirstName());
                userJson.put("lastName", temp.getLastName());
                userJson.put("address", temp.getAddress());
                userJson.put("entryDate", temp.getEntryDate());
                jsonArray.add(userJson);
            }

            json.put("leads", jsonArray);

            return json.toJSONString();


        }

        return null;
    }

    public static void writeListToJsonFile (List <Lead> leadList, String pathToFile) {
        //
        try {

            FileWriter file = new FileWriter(pathToFile);
            file.write(writeListToJson(leadList));
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static List<Lead> removeDuplicates(List<Lead> list) {

        List<Lead> result = null;
        Set<String> setList = null;

        if (list != null) {
            result = new ArrayList<Lead>();
            setList = new HashSet<String>();
            for (Lead item : list) {
                System.out.println(item.getFirstName() + " " + item.getLastName());
                if (setList.add(item.getEmail()) && setList.add(item.getId())) {
                    System.out.println("ADDED : " + item.getFirstName() + " " + item.getLastName());
                    result.add(item);

                }
            }
        }

        return result;

    }

    public static String loggingChanges (List <Lead> listWithDup, List<Lead> listWithoutDup) {
        String recordChange = "";
        for (Lead tempWithDup : listWithDup ) {
            for (Lead tempWithoutDup : listWithoutDup ) {
                if (tempWithoutDup.getId().equalsIgnoreCase(tempWithDup.getId())) {
                    if (tempWithoutDup.compare(tempWithDup) == 1)
                        //System.out.println("ID : " + tempWithoutDup.getId() + "changed FROM : " + tempWithDup.toString() + " TO : " + tempWithoutDup.toString());
                        recordChange += "ID : " + tempWithoutDup.getId() + "changed FROM : " + tempWithDup.toString() + " TO : " + tempWithoutDup.toString() + "\n";

                }

            }
        }
        return recordChange;

    }

}
