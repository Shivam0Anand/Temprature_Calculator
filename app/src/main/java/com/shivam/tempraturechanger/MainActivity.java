package com.shivam.tempraturechanger;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editCel;
    private EditText editFar;
    private TextView cResult;
    private TextView fResult;

    double c;
    double f;

   public void tempratureConverter(View view) {
       editCel = (EditText) findViewById(R.id.editCel);
       editFar = (EditText) findViewById(R.id.editFar);
       cResult = (TextView) findViewById(R.id.cResult);
       fResult = (TextView) findViewById(R.id.fResult);

       String c_str = editCel.getText().toString();
       String f_str = editFar.getText().toString();

       if (c_str.isEmpty()) {
           c = 0;
       } else {
           c = Double.parseDouble(c_str);
       }

       if (f_str.isEmpty()) {
           f = 0;
       } else
           f = Double.parseDouble(f_str);

       double cR, fR;

       //cR = (f - 32) * 5 / 9;
       //fR = c * 9 / 5 + 32;

       if (!c_str.isEmpty()) {
           fR = c * 9 / 5 + 32;
           fResult.setText((String.valueOf((double) Math.round(fR * 100) / 100) + "F"));
       } else {
           //cR = (f - 32) * 5 / 9;
           fResult.setText(" ");
       }
       if (!f_str.isEmpty()) {
           cR = (f - 32) * 5 / 9;
           cResult.setText(String.valueOf((double) Math.round(cR * 100) / 100) + "C");
       } else{
           cResult.setText(" ");
       }
       if(c==0 && f==0){
           Toast.makeText(getApplicationContext(),"Enter Value", Toast.LENGTH_LONG).show();
       }
   }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
