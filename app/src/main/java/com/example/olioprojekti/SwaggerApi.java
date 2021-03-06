package com.example.olioprojekti;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class SwaggerApi {
    public void SwaggerApi() {
        return;
    }
    Gson gson = new Gson();
    static ArrayList<String> arrayList = new ArrayList<>();

    // Generates API request URL.
    public String generateApiRequest(String diet, String lowCarbonPreference, String beefLevel, String fishLevel, String porkPoultryLevel, String dairyLevel, String cheeseLevel, String riceLevel, String eggLevel, String winterSaladLevel, String restaurantSpending) {
        StringBuilder stringBuild = new StringBuilder("https://ilmastodieetti.ymparisto.fi/ilmastodieetti/calculatorapi/v1/FoodCalculator");
        stringBuild.append("?query.diet=" + diet);
        stringBuild.append("&query.lowCarbonPreference=" + lowCarbonPreference);
        stringBuild.append("&query.beefLevel=" + beefLevel);
        stringBuild.append("&query.fishLevel=" + fishLevel);
        stringBuild.append("&query.porkPoultryLevel=" + porkPoultryLevel);
        stringBuild.append("&query.dairyLevel=" + dairyLevel);
        stringBuild.append("&query.cheeseLevel=" + cheeseLevel);
        stringBuild.append("&query.riceLevel=" + riceLevel);
        stringBuild.append("&query.eggLevel=" + eggLevel);
        stringBuild.append("&query.winterSaladLevel=" + winterSaladLevel);
        stringBuild.append("&query.restaurantSpending=" + restaurantSpending);
        return stringBuild.toString();
    }

    // Makes api request based on String "apiRequestUrl" and brings the site content back as String "result".
    public String readJsonPage(String apiRequestUrl){
        URL url = null;
        String result = null;
        try {
            url = new URL(apiRequestUrl);
            Scanner sc = null;
            sc = new Scanner(url.openStream());
            StringBuffer sb = new StringBuffer();
            while(sc.hasNext()) {
                sb.append(sc.next());
            }
            result = sb.toString();
            Log.d("Contents: ", result);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return result;
    }



}
