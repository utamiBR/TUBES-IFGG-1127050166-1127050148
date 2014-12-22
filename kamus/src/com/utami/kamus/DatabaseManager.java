package com.utami.kamus;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager extends SQLiteOpenHelper {
			

	private static final String DATABASE_NAME = "dbkamusdokter";
	private static final String ISTILAH = "istilah";
	private static final String ARTI = "arti";
	
	
	//constructor
	public DatabaseManager(Context context) {
		super(context, DATABASE_NAME, null, 1);
		}

	//methode
	public void createTable(SQLiteDatabase db) {
		db.execSQL("DROP TABLE IF EXISTS kamus");
		db.execSQL("CREATE TABLE if not exists kamus (id INTEGER PRIMARY KEY AUTOINCREMENT, istilah TEXT, arti TEXT);");
	}
	
	//method generate data
	public void generateData(SQLiteDatabase db){
		ContentValues cv = new ContentValues();
		cv.put(ISTILAH, "A1C");
		cv.put(ARTI, "A1C adalah tes yang mengukur kadar glukosa darah rata-rata seseorang selama 2 sampai 3 bulan terakhir. Hemoglobin adalah bagian dari sel darah merah yang membawa oksigen ke sel-sel dan kadang-kadang bergabung dengan glukosa dalam aliran darah. Juga disebut hemoglobin A1C atau hemoglobin glikosilasi, tes ini menunjukkan jumlah glukosa yang menempel pada sel darah merah, yang proporsional dengan jumlah glukosa dalam darah. Ini adalah tes darah diberikan kepada penderita diabetes untuk menentukan seberapa baik kondisi mereka di bawah kontrol. Interval referensi;  0-6%.");
		db.insert("kamus", ISTILAH, cv);
		cv.put(ISTILAH, "Aarskog-Scott (Sindrom)");
		cv.put(ARTI, " Aarskog-Scott (Sindrom) adalah sebuah sindrom mata spasi lebar (hipertelorisme okular), lubang hidung menghadap ke depan , bibir atas yang lebar, cacat kantong pelir (skrotum), dan kelemahan ligamen yang mengakibatkan layuh belakang lutut (genu recurvatum), kaki datar, dan jari-jari terlalu mengembang. Ada bentuk-bentuk penyakit terkait gen. Gen untuk bentuk terkait-X telah dipetakan ke band kromosom Xp11.21 dan diidentifikasi sebagai gen FGD1. Penyakit ini dinamai sesuai penemunya DJ Aarskog (1928 -) dan CI Scott, Jr (1934 -), dokter anak Norwegia dan Amerika, yang melaporkannya pada tahun 1970 dan 1971.  Sindrom ini juga dikenal sebagai sindrom Aarskog, displasia faciodigitogenital, dan displasia faciogenital.");
		db.insert("kamus", ISTILAH, cv);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
	}
}
