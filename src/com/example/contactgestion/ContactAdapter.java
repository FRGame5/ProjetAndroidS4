package com.example.contactgestion;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ContactAdapter extends BaseAdapter {
	
	private Context context;
	private ArrayList<String> surnoms;
	private ArrayList<String> telephones;
	private ArrayList<Long> ids;
	
	private static LayoutInflater inflater = null;
	
	public ContactAdapter(Context context, ArrayList<String> surnoms, ArrayList<String> telephones, ArrayList<Long> ids) {
		this.context = context;
		this.surnoms = surnoms;
		this.telephones = telephones;
		this.ids = ids;
		
		inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		return this.surnoms.size();
	}

	@Override
	public Object getItem(int position) {
		return this.surnoms.get(position);
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 * retourne l'identifiant de la personne dans la BD
	 */
	@Override
	public long getItemId(int position) {
		return this.ids.get(position);
	}

	@Override
	public View getView(int position, View previousView, ViewGroup parent) {	
		View previous = previousView;
		
		if(previous == null)
			previous = inflater.inflate(R.layout.contact, null); // null => pas de racine
		
		TextView txt_surnom = (TextView) previous.findViewById(R.id.surnom);
		txt_surnom.setText(this.surnoms.get(position));
		
		TextView txt_telephone = (TextView) previous.findViewById(R.id.telephone);
		txt_telephone.setText(this.telephones.get(position));
		
		return previous;
	}

}
