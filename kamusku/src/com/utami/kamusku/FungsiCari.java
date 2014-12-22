package com.utami.kamusku;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class FungsiCari extends Activity {
	private ListView listView;
	private DB_Function aksesDB;
	private String[] arrayistilah,arrayarti;
	private EditText istilah;
	private ArtiActivity kirimdata;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cari);
		aksesDB = new DB_Function(this);
		kirimdata = new ArtiActivity();
		setListView("select istilah, arti from tb_data");
		setIstilah();
		listViewdiklik();
		listView.setEmptyView(findViewById(R.id.empty));
	}
	
	private void setIstilah(){
		istilah = (EditText)findViewById(R.id.istilah);
		istilah.setOnKeyListener(new View.OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				if(istilah.getText().toString().equalsIgnoreCase("")){
					setListView("select istilah, arti from tb_data");
				}else{
					setListView("select istilah, arti from tb_data where istilah like'%"+istilah.getText().toString()+"%'");
				}
				return false;
			}
		});
	}
	
	private void listViewdiklik(){
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent inten = new Intent(view.getContext(),ArtiActivity.class);
				inten.putExtra("istilah", arrayistilah[position]);
				inten.putExtra("arti", arrayarti[position]);
				startActivity(inten);
			}
		});
	}
	
	private void setListView(String perintahSQL){
		aksesDB.ambilData(perintahSQL);
		arrayistilah= new String[aksesDB.resultSet.getCount()];
		arrayarti = new String[aksesDB.resultSet.getCount()];
		int a=0;
		while(aksesDB.resultSet.moveToNext()){
			arrayistilah[a]=aksesDB.resultSet.getString(0);
			arrayarti[a]=aksesDB.resultSet.getString(1);
			Log.d("ieu istilah", arrayistilah[a]);
			Log.d("ieu arti",arrayarti[a]);
			a++;
		}
		ArrayAdapter<String> lvadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayistilah);
		listView = (ListView)findViewById(R.id.lv_data);
		listView.setAdapter(lvadapter);
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
