package tools;

import android.os.StrictMode;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import junit.framework.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by nabil on 4/13/17.
 */

public class CallWebService {


    public static List CallMazaganWebServicePincipale(String Titre) {

        StrictMode.ThreadPolicy tp = new  StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tp);
        String url_web_service = "http://beyond4edges.com/mazagan/MazaganWebService/public/index.php/Mazagan/GetDescriptionMenuPrincipale/"+Titre;
        try {
            URL url = new URL(url_web_service);
            HttpURLConnection urlConnection =(HttpURLConnection) url.openConnection();
            if(urlConnection.getResponseCode()==HttpURLConnection.HTTP_OK){
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                Gson gson = new Gson();

                Type listType = new TypeToken<ArrayList<MenuPrincipale>>(){}.getType();
                List<MenuPrincipale> menu = new Gson().fromJson(inputStreamReader, listType);
                Log.d("My Log","My Object"+menu);

                return menu;


            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("","InputStream inputStream = urlConnection.getInputStream();\n");
        }
        return null;


    }


    public static List CallMazaganWebSousMenu(String Titre) {

        StrictMode.ThreadPolicy tp = new  StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tp);
        String url_web_service = "http://beyond4edges.com/mazagan/MazaganWebService/public/index.php/Mazagan/GetDescription/"+Titre;

        try {

            URL url = new URL(url_web_service);
            HttpURLConnection urlConnection =(HttpURLConnection) url.openConnection();
            if(urlConnection.getResponseCode()==HttpURLConnection.HTTP_OK){
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                Gson gson = new Gson();
                //JsonArray jsonArray = gson.fromJson(inputStreamReader ,new TypeToken<Object>(){}.getType());

                Type listType = new TypeToken<ArrayList<Menus>>(){}.getType();
                List<Menus> menu = new Gson().fromJson(inputStreamReader, listType);

                Log.println(Log.ASSERT,"My Log","My Object"+menu);
                 //MyList = (ArrayList) menu;
                Log.d("kkkkkkkkkkkkkkkk","kkkkkkkkkkkk: ");

                return menu;

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {

            Log.d("","InputStream inputStream = urlConnection.getInputStream();\n");
            e.printStackTrace();
        }

        return null;

    }



    public static List CallMazaganWebphoto(String Titre) {

        StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tp);
        String url_web_service = "http://beyond4edges.com/mazagan/MazaganWebService/public/index.php/Mazagan/GetPhoto/" + Titre;
        Log.println(Log.ASSERT,"url",""+url_web_service);

        try {

            URL url = new URL(url_web_service);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<Photos>>(){}.getType();
                List<Photos> photos = new Gson().fromJson(inputStreamReader, listType);
                Log.println(Log.ASSERT, "My Log", "My Object" + photos.get(0).getPhoto());
                return photos;

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {

            Log.d("", "InputStream inputStream = urlConnection.getInputStream();\n");
            e.printStackTrace();
        }
        catch (Exception e){

            e.printStackTrace();
            Log.println(Log.ASSERT,"My exception","crash");
        }

        return null;

    }









}
