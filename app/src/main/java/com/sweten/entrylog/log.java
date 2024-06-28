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

public class log extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
AppCompatButton b1,b2;
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
                     String getLname = ed1.getText().toString();
                     String getadmsno = ed2.getText().toString();
                     String getdept = ed3.getText().toString();
                     String getLsno = ed4.getText().toString();

                     Toast.makeText(getApplicationContext(), getLname+getadmsno+getdept+getLsno, Toast.LENGTH_SHORT).show();
                 }
             });
    }
}