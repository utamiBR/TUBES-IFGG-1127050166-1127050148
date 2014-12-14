package com.utami.kamus;

import android.support.v7.app.ActionBarActivity;
import com.utami.kamus.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends ActionBarActivity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		  View btn1 = findViewById(R.id.cari);
	      btn1.setOnClickListener(this);
	      View btn2 = findViewById(R.id.bantuan);
	      btn2.setOnClickListener(this);
	      
	}
	
	public void onClick(View v) {
        // TODOAuto-generated method stub
        switch (v.getId()){
       
        case R.id.cari:
        Intent myAplikasi1 = new Intent(this, Cari.class);
        startActivity(myAplikasi1);
        break;
        case R.id.bantuan:
            Intent myAplikasi2 = new Intent(this, Bantuan.class);
            startActivity(myAplikasi2);
            break;
        }
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




	