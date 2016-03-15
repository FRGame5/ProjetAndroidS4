package com.example.contactgestion;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private List<String> liste;
	private ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.updateListView();
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
	
	public void updateListView()
	{
		ListView lView = (ListView)findViewById(R.id.listView1);
	}
	
	
}
