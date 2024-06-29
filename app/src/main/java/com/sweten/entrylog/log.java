package com.sweten.entrylog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class log extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
AppCompatButton b1,b2;
String apiUrl="http://10.0.4.16:3000/api/students";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log);
        ed1=(EditText) findViewById(R.id.lname);
        ed2=(EditText) findViewById(R.id.ano);
        ed3=(EditText) findViewById(R.id.dept);
        ed4=(EditText) findViewById(R.id.sno);
        b1=(AppCompatButton) findViewById(R.id.logoutbtn);
        b2=(AppCompatButton) findViewById(R.id.addbtn);



             b1.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent i =new Intent(getApplicationContext(), MainActivity.class);
                       startActivity(i);
                   }
               });
             b2.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                     //value reading
                     String getLname = ed1.getText().toString();
                     String getadmsno = ed2.getText().toString();
                     String getdept = ed3.getText().toString();
                     String getLsno = ed4.getText().toString();

                     //json object crration
                     JSONObject student =new JSONObject();
                     try {
                      student.put("name",getLname);
                      student.put("admission_number",getadmsno);
                      student.put("system_number",getLsno);
                      student.put("department",getdept);

                     } catch (JSONException e) {
                         throw new RuntimeException(e);
                     }
                     //JSON object request creation
                     JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(


                             Request.Method.POST,
                             apiUrl,
                             student,
                             new Response.Listener<JSONObject>() {
                                 @Override
                                 public void onResponse(JSONObject response) {
                                     Toast.makeText(getApplicationContext(), "added succesfully", Toast.LENGTH_SHORT).show();
                                 }
                             },
                             new Response.ErrorListener() {
                                 @Override
                                 public void onErrorResponse(VolleyError error) {
                                     Toast.makeText(getApplicationContext(), "something went wrong", Toast.LENGTH_SHORT).show();
                                 }
                             }

                     );
                     RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                     requestQueue.add(jsonObjectRequest);
                 }
             });
    }}
