package com.example.pockemonrecycle;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Asycdata extends AsyncTask<String, Integer, String> {

    Context c;


    public Asycdata(Context c) {
        this.c = c;
    }

    @Override
    protected void onPreExecute() {



        super.onPreExecute();
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);


    }

    @Override
    protected void onPostExecute(String s) {


    }

    @Override
    protected String doInBackground(String... strings) {

        publishProgress(1);

        String jsonurl = strings[0];
        String json="";


            publishProgress(2);
            Httphandler sh = new Httphandler();

            json = sh.makeServiceCall(jsonurl);
            System.out.println("This is Json :"+json);


        try {
            JSONObject mainobj = new JSONObject(json);

            JSONArray mainarray = mainobj.getJSONArray("Pokemon");
            int size = mainarray.length();

            publishProgress(size);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return json;
    }
}
