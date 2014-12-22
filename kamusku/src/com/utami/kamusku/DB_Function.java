package com.utami.kamusku;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_Function extends SQLiteOpenHelper {
	private static String DB_PATH = "/data/data/com.utami.kamusku/";
    private static String DB_NAME = "DB_KAMUS_DOKTER";
    private SQLiteDatabase myDataBase; 
    private final Context myContext;
    public Cursor resultSet;
    
    public DB_Function(Context context) {
    	super(context, DB_NAME, null, 1);
        this.myContext = context;
    }
 
    public void createDataBase() throws IOException{
    	if(checkDataBase()){
    	}else{
        	this.getReadableDatabase();
        	try {
    			copyDataBase();
    		} catch (IOException e) {
        	}
    	}
    }
 
    private boolean checkDataBase(){
    	File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }
 
    private void copyDataBase() throws IOException{
    	InputStream myInput = myContext.getAssets().open(DB_NAME);
    	OutputStream myOutput = new FileOutputStream(DB_PATH + DB_NAME);
    	byte[] buffer = new byte[1024];
    	int length;
    	while ((length = myInput.read(buffer))>0){
    		myOutput.write(buffer, 0, length);
    	}
    	myOutput.flush();
    	myOutput.close();
    	myInput.close();
    }
 
    public void openDataBase() throws SQLException{
    	myDataBase = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);
    }
    
    public void opendataBase(){
    	if(myDataBase==null){
    		openDataBase();
    	}
    }
 
    public void ambilData(String perintahSQL){
		try{
			opendataBase();
			resultSet = myDataBase.rawQuery(perintahSQL, null);
		}catch(Exception e){
		}
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
