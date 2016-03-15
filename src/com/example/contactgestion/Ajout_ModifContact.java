package com.example.contactgestion;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Ajout_ModifContact extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ajout__modif_contact);
	}
	
	public void insertContact(View v)
	{
		String surnom = ((EditText)findViewById(R.id.textSurnom)).getText().toString();
		String telephone = ((EditText)findViewById(R.id.textTelephone)).getText().toString();
		
		RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
		
		String sexe = ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString() ;
		
		DBQuery db = new DBQuery(this);
		
		SQLiteDatabase bdd = db.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put("surnom", surnom);
		values.put("sexe", sexe);
		values.put("telephone", telephone);
		
		bdd.insert("Contacts", null, values);
		Toast.makeText(this, "ajout de "+surnom+" effectué", Toast.LENGTH_SHORT).show();
		bdd.close();
		this.finish();
	}
	
}
