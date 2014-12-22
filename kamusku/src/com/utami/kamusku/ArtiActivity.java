package com.utami.kamusku;

import com.utami.kamusku.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

public class ArtiActivity extends Activity {
	private TextView txtArti, txtIstilah;
	public String istilah,arti;
	protected void onCreate (Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_arti);
		txtArti = (TextView) findViewById(R.id.arti);
		txtIstilah = (TextView) findViewById(R.id.istilah);
		Intent inten = this.getIntent();
		txtIstilah.setText(inten.getStringExtra("istilah"));
		txtArti.setText(inten.getStringExtra("arti"));
	}
}
