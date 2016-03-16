package com.example.contactgestion;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.MonthDisplayHelper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private ArrayList<String> surnoms;
	private ArrayList<String> telephones;
	private ContactAdapter adapteur;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.surnoms = new ArrayList<String>();
		this.telephones = new ArrayList<String>();
		
		// initialisation de la listView
		ListView lView = (ListView)findViewById(R.id.listView1);
				
		// remplissage des tableaux contenant les surnoms et les numéros de téléphone
		this.updateDataSource();
//		this.surnoms.add("Loic");
//		this.telephones.add("0629490277");
		
		// initialisation de l'adapteur
		adapteur = new ContactAdapter(this, this.surnoms, this.telephones);
		
		lView.setAdapter(adapteur);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		this.updateDataSource();
		this.adapteur.notifyDataSetChanged();
	}
	
	/**
	 * lance l'activité permettant d'ajouter un contact
	 * @param v
	 */
	public void ajouterContact(View v) {
		if (v instanceof Button) {
			Button b = (Button) v;
			switch(b.getId()) {
			case R.id.bt_annuler_ajout_contact:
				// lance l'activité permettant d'ajouter un contact
				Intent intent = new Intent(this,Ajout_ModifContact.class);
				startActivity(intent);
				break;
			}
		}
	}
	
	private void updateDataSource() {
		
		// connexion à la base de données
		DBQuery db = new DBQuery(this);
		
		SQLiteDatabase bdd = db.getReadableDatabase();
		Cursor curs = bdd.rawQuery(getResources().getString(R.string.QUERY_CONTACTS), null);
		
		// parcours des résultats de la requête et remplissage des listes
		if (curs.moveToFirst()) {
			do{
				this.surnoms.add(curs.getString(curs.getColumnIndexOrThrow("surnom")));
				this.telephones.add(curs.getString(curs.getColumnIndexOrThrow("telephone")));
			}while(curs.moveToNext());
		}
		curs.close();
		bdd.close();
	}
	
	
}
