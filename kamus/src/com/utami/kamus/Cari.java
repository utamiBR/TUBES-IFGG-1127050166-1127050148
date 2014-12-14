package com.utami.kamus;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Cari extends Activity {
	private SQLiteDatabase db = null;
	private Cursor kamusDokter = null;
	private EditText txtIstilah;
	private EditText txtArti;
	private DatabaseManager datakamus = null;
	public static final String ISTILAH = "istilah";
	public static final String ARTI = "arti";
	
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    
        datakamus = new DatabaseManager(this);
        db = datakamus.getWritableDatabase();
        datakamus.createTable(db);
        datakamus.generateData(db);
        
        setContentView(R.layout.cari);
        
        txtIstilah = (EditText) findViewById(R.id.txtIstilah);
        txtArti = (EditText) findViewById(R.id.txtArti);
    }


    public void getTerjemahan(View view) {
    	String result = "";
    	String word = txtIstilah.getText().toString();
    	kamusDokter = db.rawQuery("SELECT ID, ISTILAH, ARTI " + "FROM kamus where ISTILAH ='" + word + "'ORDER BY ISTILAH", null);
    	
    	//membaca string di index 2
    	if (kamusDokter.moveToFirst()){
    		result = kamusDokter.getString(2);
    		for (;!kamusDokter.isAfterLast();
    				kamusDokter.moveToNext()) {
    			result = kamusDokter.getString(2);
    		}
    	}
    	
    	
    	//menampilkan not found
    	if (result.equals("")){
    		result = "not found";
    	}
    	
    	
    	//menampilkan data 
    	txtArti.setText(result);
    }
    	
    
    @Override
       public void onDestroy() {
    	super.onDestroy();
    	kamusDokter.close();
    	db.close();
    }
    
	 @Override
     public boolean onCreateOptionsMenu(Menu menu) {
		
                     // TODO Auto-generated method stub
                     menu.add(0,0,0, R.string.tentang);
                     menu.add(0,1,1, R.string.exit);
                     menu.add(0,2,2, R.string.action_settings);
                     return super.onCreateOptionsMenu(menu);
     }

	 @Override
     public boolean onOptionsItemSelected(MenuItem item) {
                     // TODO Auto-generated method stub
                    
                     super.onOptionsItemSelected(item);
                    
                     switch(item.getItemId()){
                     case 0:
                                     bukaDialog();
                                     break;
                     case 1 :
                                     tutupDialog();
                                     break;
                     }
                     return true;
     }
	 private void bukaDialog(){
         new AlertDialog.Builder(this)
         .setTitle(R.string.tentang)
         .setMessage(R.string.pesan_tentang)
         .setPositiveButton(R.string.back,
                                         new DialogInterface.OnClickListener() {
                        
                         public void onClick(DialogInterface dialog, int i) {
                                         // TODO Auto-generated method stub
                                        
                         }
         }).show();
         }

private void tutupDialog(){
         new AlertDialog.Builder(this)
         .setTitle(R.string.app_exit)
         .setMessage(R.string.pesan_app_exit)
         .setNegativeButton(R.string.no,
         new DialogInterface.OnClickListener()
         {
         public void onClick(DialogInterface dialoginterface, int i)
         {}
         })
         .setPositiveButton(R.string.ok,
         new DialogInterface.OnClickListener()
         {
         public void onClick(DialogInterface dialoginterface, int i)
         {
          finish();
         }
         })
         .show();
} 
  }
