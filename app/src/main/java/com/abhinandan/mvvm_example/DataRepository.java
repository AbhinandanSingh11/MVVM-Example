package com.abhinandan.mvvm_example;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataRepository {
    private static DataRepository instance;
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Places> mList = new ArrayList<>();
    private static MutableLiveData<List<Places>> data;
    public static final String URL = "https://api.nimus.co.in/android/mvvm/demo/data/data.json";

    private DataRepository(){

    }

    public static DataRepository getInstance(){
        if(instance==null){
            instance = new DataRepository();
            data = new MutableLiveData<>();
        }

        return instance;
    }


    // Getting data from the server
    public MutableLiveData<List<Places>> fetchData(Context context){

        Log.d("DataRepository", "Entered the Function ");
        requestQueue = Volley.newRequestQueue(context);
        ;

        request = new JsonArrayRequest(Request.Method.GET,URL,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("DataRepository", "Got the Array");
                Log.d("DataRepository", "Length of Array " + response.length());
                for(int i = 0; i<response.length(); i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        Places mPlaces = new Places(jsonObject.getString("title"),jsonObject.getString("imageURL"));

                        mList.add(mPlaces);
                        data.setValue(mList);
                        Log.d("DataRepository", "Called: "+ i);
                        Log.d("DataRepository", "Place Title "+ jsonObject.getString("title"));
                        Log.d("DataRepository", "Place URL "+ jsonObject.getString("imageURL"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("DataRepository", "Error message: "+ error);
            }
        });


        requestQueue.add(request);
        Log.d("DataRepository", "Size of List at end "+ mList.size());
        data.setValue(mList);
        return data;
    }
}
