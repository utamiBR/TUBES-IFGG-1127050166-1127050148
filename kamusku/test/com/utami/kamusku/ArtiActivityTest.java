package com.utami.kamusku;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ArtiActivityTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOnCreateBundle() {
		class ArtiActivity extends Activity {
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
	}

}
