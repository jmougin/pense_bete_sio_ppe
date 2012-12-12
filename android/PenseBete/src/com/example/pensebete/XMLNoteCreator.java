package com.example.pensebete;

import java.io.*;
import java.util.ArrayList;

import android.util.Log;

public class XMLNoteCreator {
	
	private String fileToSave;
	
	public XMLNoteCreator(String fileName){
		this.fileToSave = fileName;
	}
	public void saveVillesIntoXML(ArrayList<Note> lesNotes)
	{
		File file = new File("/data/data/com.example.PenseBete/"+this.fileToSave);
		BufferedWriter writer = null;
		try {
			file.createNewFile();
			writer = new BufferedWriter(new FileWriter(file));
			Log.w("Message", "writer créé : " + writer.toString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		StringBuilder stb = new StringBuilder();
		stb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		stb.append("<listenotes>");
		int i = 0;
		
		for (Note note : lesNotes) {
			i++;
			stb.append("<note>\n");
			stb.append("<id>"+i+"</id>\n");
			stb.append("<titre>"+note.getTitre()+"</titre>\n");
			stb.append("<contenu>"+note.getContenu()+"</contenu>\n");
			stb.append("<date>"+note.getDate()+"</date>\n");
			stb.append("<dateExpi>"+note.getDateExpi()+"</dateExpi>\n");
			stb.append("</note>");
		}
		stb.append("</listenotes>");
		try {
			writer.write(stb.toString());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}