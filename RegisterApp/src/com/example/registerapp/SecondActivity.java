package com.example.registerapp;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	}
	
	public void save (View v) throws FileNotFoundException, IOException{
		Intent data = new Intent (SecondActivity.this,MainActivity.class);
		
	//write to file
		
		BufferedWriter bufferuser = null;
		BufferedWriter bufferpass = null;
		
		
		try {
		FileOutputStream outputuser = openFileOutput("Username",Context.MODE_PRIVATE);
		bufferuser = new BufferedWriter(new OutputStreamWriter(outputuser));
		
		bufferuser.write(((EditText)this.findViewById(R.id.typeusertext)).getText().toString());
		
		FileOutputStream outputpass = openFileOutput("Password",Context.MODE_PRIVATE);
		bufferpass = new BufferedWriter(new OutputStreamWriter(outputpass));			
			
		bufferpass.write(((EditText)this.findViewById(R.id.typepasstext)).getText().toString());	
			
			
			
		}finally{
			bufferuser.close();
			bufferpass.close();
			
		}
		
		startActivity(data);
		}	
		
		
		
		
		
		
		
//		EditText typeusertext = (EditText)findViewById(R.id.typeusertext);
//		EditText typepasstext = (EditText)findViewById(R.id.typepasstext);
		
//		data.putExtra("username", typeusertext.toString());
//		data.putExtra("password", typepasstext.toString());
		
	
	
	public void cancel (View v){
		Intent i = new Intent(SecondActivity.this,MainActivity.class);
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
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
