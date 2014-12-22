package com.utami.kamusku;

import android.support.v7.app.ActionBarActivity;
import android.text.Html;

import com.utami.kamusku.R;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Bantuan extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bantuan);
		TextView tv = (TextView) findViewById(R.id.textView1);
	      tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
	      tv.setText(Html.fromHtml("<body><p><strong>Aplikasi ini terdiri dari beberapa Menu Pilihan</strong></p></title><strong>1. Cari</strong><br/>Merupakan menu untuk mencari istilah yang Anda cari. <br/><br/><strong>2. Bantuan</strong><br/>Merupakan menu untuk membantu Anda menggunakan aplikasi ini.<br/><br/>Terima Kasih. <br/><br/><u>utamirahayu94@gmail.com</u></body>"));
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




	