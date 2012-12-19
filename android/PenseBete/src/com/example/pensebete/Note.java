package com.example.pensebete;

import java.util.ArrayList;



public class Note {
	
	private int id;
	private String titre;
	private String contenu;
	private String date;
	private String dateExpi;
	private String importance;
	
	private ArrayList<Note> lesNotes;
	
	
	/**
	 * Constructeur de la note
	 * @param t titre de la note
	 */
	public Note(String t){
		this.setTitre(t);
		this.setContenu("Contenu de la note...");
		
		lesNotes = new ArrayList<Note>();
	}
	
	public Note() {
	}

	
	public ArrayList<Note> getAujourdhui(){
		ArrayList<Note> aujourdhui = new ArrayList<Note>();
		for (Note note : this.lesNotes) {
			
				aujourdhui.add(note);
			
		}
		return aujourdhui;
	}
	
	
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	public String getDate(){
		return date;
	}
	
	public void setDate(String date){
		this.date = date;
	}
	
	public String getDateExpi(){
		return dateExpi;
	}
	
	public void setDateExpi(String dateExpi){
		this.dateExpi = dateExpi;
	}
	
	public String getImportance(){
		return importance;
	}
	
	public void setImportance(String importance){
		this.importance = importance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
