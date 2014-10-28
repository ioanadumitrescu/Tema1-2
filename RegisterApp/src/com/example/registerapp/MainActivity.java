package com.example.registerapp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void register(View v){
    	Intent i = new Intent(MainActivity.this,SecondActivity.class);
    	startActivity(i);
    }
    
    public void login(View v) throws FileNotFoundException, IOException{
    	
    	BufferedReader bufferuser = null;
    	StringBuilder username = new StringBuilder();
    	
    	BufferedReader bufferpass = null;
    	StringBuilder password = new StringBuilder();
    	
       	
    	try {
			FileInputStream inputuser = openFileInput("C:\\Users\\Ioana\\workspace\\Username.txt");
			bufferuser = new BufferedReader(new InputStreamReader(inputuser));
			String lineuser;
    		
    		 		
    		
			while((lineuser=bufferuser.readLine()) != null){
				username.append(lineuser + "\r\n");
			}
			
			FileInputStream inputpass = openFileInput("C:\\Users\\Ioana\\workspace\\Password.txt");
			bufferpass = new BufferedReader(new InputStreamReader(inputpass));
			String linepass;
    		

    		
			while((linepass=bufferpass.readLine()) != null){
				password.append(linepass + "\r\n");
			}
    		
    		
			
		}finally{
			
			bufferuser.close();
			bufferpass.close();
		}
    	
    				
    	
    	TextView m = (TextView)findViewById(R.id.message);
    	
    	
    	if (((EditText)this.findViewById(R.id.usertext)).getText().toString().equals("admin") && 
    			((EditText)this.findViewById(R.id.passtext)).getText().toString().equals("admin")){
    		m.setText("... " + "Sign In Successful" + " ...");
    	}
    	else    	
    		if (((EditText)this.findViewById(R.id.usertext)).getText().toString().equals(username) && 
    				((EditText)this.findViewById(R.id.passtext)).getText().toString().equals(password)){
    		
    			m.setText("... " + "Sign In Successful" + " ...");}
    		
    		else{
    			m.setText("... " + "Username or Password incorrect!" + " ...");
    		}
			
		}
    	
    	
    	
//    	EditText usertext = (EditText)findViewById (R.id.usertext);
//    	EditText passtext = (EditText)findViewById (R.id.passtext);
    	    	    	
//    	String userstring = getIntent().getStringExtra("username");
//    	String passstring = getIntent().getStringExtra("password");
    	
//   	TextView m1 = (TextView)findViewById(R.id.message);
    	
//    	if (usertext.getText().toString().equals("admin") && passtext.getText().toString().equals("admin")){
//    		m1.setText("... " + "Sign In Successful" + " ...");
//    	}
//    	else if (usertext.getText().toString().equals(userstring) && passtext.getText().toString().equals(passstring)){
//   		m1.setText("... " + "Sign In Successful" + " ...");}
//    	else {
//    		m1.setText("... " + "Username or Password incorrect!" + " ...");
//    	}
    	
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
