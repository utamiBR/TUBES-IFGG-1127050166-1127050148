package com.utami.kamusku;


	import android.app.Activity;
	import android.content.Intent;
	import android.os.Bundle;
	import android.os.Handler;

	public class Splash extends Activity{
	 
	        // Menset waktu kemunculan yang akan dipakai pada Handler.postDelayed
	     
	    private static int waktukemunculan = 3000;
	 
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.splash);
	         
	        new Handler().postDelayed(new Runnable() {
	 
	            @Override
	            public void run() {
	                // Metode Ini akan dijalankan setelah timer selesai menghitung
	                                // Program akan masuk ke MainActivity
	                Intent i = new Intent(Splash.this, MainActivity.class);
	                startActivity(i);
	                 
	                                // Menutup aktivitas
	                finish();
	            }
	             
	         
	             
	        }, waktukemunculan);
	         
	    }
}
