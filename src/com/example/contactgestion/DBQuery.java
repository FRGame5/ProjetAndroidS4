package com.example.contactgestion;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBQuery extends SQLiteOpenHelper{
	
	private static final String DB_NAME = "contacts.db";
	private static final int DB_VERSION = 1;
	
	private Context context;

	public DBQuery(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(this.context.getString(R.string.CREATE_CONTACTS));
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//db.execSQL(this.context.getString(R.string.DELETE_CONTACTS));
		onCreate(db);
	}
	
	@Override
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		super.onDowngrade(db, oldVersion, newVersion);
	}
	
	public void insertContact(String surnom, String sexe, String telephone)
	{
		
		
		
		
	}

}
