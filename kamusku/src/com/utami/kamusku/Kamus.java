package com.utami.kamusku;


public class Kamus {
	 private String istilah;
	 private String arti;
	 
	 public String getIstilah()
	 {
	  return istilah;
	 }
	 
	 public void setIstilah(String istilah)
	 {
	  this.istilah = istilah;
	 }
	 
	 public String getArti()
	 {
	  return arti;
	 }
	 
	 public void setArti(String arti)
	 {
	  this.arti = arti;
	 }
	 
	 @Override
	 public String toString()
	 {
	  return this.istilah;
	 }

}
