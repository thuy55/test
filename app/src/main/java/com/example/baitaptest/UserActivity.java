package com.example.baitaptest;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class UserActivity extends AppCompatActivity {

    ListView lv;
    ListUserApdapter adApdapter;

    private FirebaseFirestore db;
    private DocumentReference documentReference;
    private User user;
    private String url="https://60b0943c1f26610017ffe7e4.mockapi.io/User";
    private ArrayList<User> arrayList= new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listitem);

    }
    private void getData(){
        RequestQueue request= new JsonRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                lv.setVisibility(View.VISIBLE);
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = (JSONObject) response.get(i);
                        int id = object.getInt("id");
                        String name = object.getString("name");
                        String email = object.getString("email");
                        int age = object.getInt("age");
                        arrayList.add(new User(id, email, name, age));


                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                    buildListView();

                }


                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UserActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }


                    private void buildListView() {
                        adApdapter = new ListUserApdapter(this.arrayList, R.layout.item);
                        lv = findViewById(R.id.lv);

                    }

                }
            }
        }
    }