package com.example.contactgestion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void ajouterContact(View v) {
		if (v instanceof Button) {
			Button b = (Button) v;
			switch(b.getId()) {
			case R.id.button1:
				Intent intent = new Intent(this,Ajout_ModifContact.class);
				startActivity(intent);
				break;
			}
		}
	}
}
