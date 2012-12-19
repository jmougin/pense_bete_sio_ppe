package com.example.pensebete;

import java.util.ArrayList;

public class LaDate {
	
	private String nom;
	private ArrayList<Note> lesNotes;
	
	public LaDate(String n){
		this.setNom(n);
		ArrayList<Note> lesNotes = new ArrayList<Note>();
	}
	public LaDate(){
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	public ArrayList<Note> getAujourdhui(){
		ArrayList<Note> aujourdhui = new ArrayList<Note>();
		//ArrayList<Note> plustard = new ArrayList<Note>();
		
		//dateactuelle = "?????" ;
		
		for (Note note : this.getLesNotes()) {
			
			/*if(dateactuelle = dateExpi){
				aujourdhui.add(note);
			}*/
			aujourdhui.add(note);
			
		}
		return aujourdhui;
	}
	
	
	
	
	
	
	public ArrayList<Note> getLesNotes() {
		return lesNotes;
	}
	public void setLesNotes(ArrayList<Note> lesNotes) {
		this.lesNotes = lesNotes;
	}
	

}
