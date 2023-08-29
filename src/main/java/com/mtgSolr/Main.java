package com.mtgSolr;

import com.mtgSolr.Utils.JsonParserUtils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Properties;

public class Main {
    /*
    To Do
    Create property class
    Replace all sout statements with log4 statements
    Add log statements to all catch blocks.
     */

    private static String Data = "data";

    private static String allPrintingsJson = null;

    /*
    This method serves no purpose other than show how to get the values from a property file. Need to find a way to be able to use the path
    that is listed in the property file instead of passing the path to the files as parameters when running the application. 
     */
    protected static void init(String propertiesFiles) throws IOException, ParseException {
        FileInputStream inputFileStream = null;
        try{
            Properties property = new Properties();
            inputFileStream = new FileInputStream(propertiesFiles);
            property.load(inputFileStream);
            allPrintingsJson = property.getProperty("allprintings_json");
            System.out.println(allPrintingsJson);

        } finally {
            if( inputFileStream != null){
                inputFileStream.close();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Generating json files for all known Magic the Gathering Cards.");
        JSONParser jsonParser = new JSONParser();

        try {
            init(args[0]);

            BufferedReader bufferedReader = new BufferedReader((new FileReader(args[1])));
            JSONObject object = (JSONObject) jsonParser.parse(bufferedReader);
            JSONObject dataMap = (JSONObject) object.get(Data);

            JsonParserUtils jsonParserUtils = new JsonParserUtils();
            jsonParserUtils.getSetData(dataMap, args[2]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
