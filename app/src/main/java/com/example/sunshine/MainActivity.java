package com.example.sunshine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button getId,byCity,byId;
    EditText inputText;
    ListView options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign values to each control on the layout
        getId=findViewById(R.id.button);
        byCity=findViewById(R.id.button3);
        byId=findViewById(R.id.button2);
        inputText=(EditText)findViewById(R.id.plain_text_input);
        options=findViewById(R.id.options);

        //listners for buttons
        extractdata Extractdata=new extractdata(MainActivity.this);

        getId.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                       Extractdata.getcityId(inputText.getText().toString(), new extractdata.VolleyResponseListener() {
                       @Override
                       public void onError(String message) {
                           Toast toast=Toast.makeText(MainActivity.this,"Erorrrrrrrrrrrrrr!",Toast.LENGTH_LONG);
                           toast.show();
                       }

                       @Override
                       public void onResponse(String response) {
                           Toast toast=Toast.makeText(MainActivity.this,"City id of "+inputText.getText().toString()+" is "+response,Toast.LENGTH_LONG);
                           toast.show();
                       }
                   });
            }
        });

        byCity.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               Extractdata.getforcastbycity(MainActivity.this, inputText.getText().toString(), new extractdata.ForcastbyID() {
                   @Override
                   public void onError(String message) {
                       Toast tt=Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT);
                       tt.show();
                   }

                   @Override
                   public void onResponse(List<whetherReportmodel> response) {

                       ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,response);
                       options.setAdapter(arrayAdapter);
                   }
               });
            }
        });

        byId.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               Extractdata.getforcastbyId(MainActivity.this,inputText.getText().toString(), new extractdata.ForcastbyID() {
                   @Override
                   public void onError(String message) {
                       Toast toast=Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT);
                       toast.show();
                   }

                   @Override
                   public void onResponse(List<whetherReportmodel> response) {
                       //put the entire list into listview

                       ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,response);
                       options.setAdapter(arrayAdapter);


                   }
               });
            }
        });



    }
}