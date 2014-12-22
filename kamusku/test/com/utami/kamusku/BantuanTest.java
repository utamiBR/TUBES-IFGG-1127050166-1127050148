package com.utami.kamusku;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.util.TypedValue;
import android.widget.TextView;

public class BantuanTest {

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
		class Bantuan extends ActionBarActivity {

			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.bantuan);
				TextView tv = (TextView) findViewById(R.id.textView1);
			      tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
			      tv.setText(Html.fromHtml("<body><p><strong>Aplikasi ini terdiri dari beberapa Menu Pilihan</strong></p></title><strong>1. Cari</strong><br/>Merupakan menu untuk mencari istilah yang Anda cari. <br/><br/><strong>2. Bantuan</strong><br/>Merupakan menu untuk membantu Anda menggunakan aplikasi ini.<br/><br/>Terima Kasih. <br/><br/><u>utamirahayu94@gmail.com</u></body>"));
			}

	}

}
}
