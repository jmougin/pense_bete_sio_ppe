package com.example.pensebete;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pensebete.*;
import com.example.pensebete.NoteAdapter.NotesAdapterListener;

public class PenseBeteActivity extends Activity implements NotesAdapterListener{

	private ArrayList<ArrayList> ToutesNotes;
	private ExpListDateAdapter adapter;
	private ExpandableListView expandableList = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	Log.w("Message", "onCreate de l'application");

    	LaDate uneDate = new LaDate("Aujourdhui");
    	ToutesNotes = new ArrayList<ArrayList>();
    	// Cr�ation d'une liste de note test
    	ArrayList<Note> lesNotes=new ArrayList<Note>();
    	lesNotes.add(new Note("Anniversaire"));
    	lesNotes.add(new Note("M�decin"));
    	lesNotes.add(new Note("Morgue"));
    	
    	uneDate.setLesNotes(lesNotes);

    	ToutesNotes.add(uneDate.getAujourdhui());
    	ToutesNotes.add(uneDate.getAujourdhui());
		
    	// XML -------------------------------------------------------------
    	//XMLNoteCreator writerXml = new XMLNoteCreator("lesVilles.xml");
    	//writerXml.saveVillesIntoXML(lesNotes);
    	// -----------------------------------------------------------------
    
    	super.onCreate(savedInstanceState);
    	/*
        setContentView(R.layout.activity_main);
    	
    	adapter = new NoteAdapter(this, lesNotes);
    	adapter.addListener(this);
    	
        //R�cup�ration du composant ListView
        ListView list = (ListView)findViewById(R.id.ListView01);
        
        //Initialisation de la liste avec les donn�es
        list.setAdapter(adapter);
        */
    	
    	setContentView(R.layout.detail_note_layout);
    	
    	expandableList = (ExpandableListView) findViewById(R.id.expandableListView1);
		
		adapter = new ExpListDateAdapter(this, ToutesNotes);
		//ListView list = (ListView)findViewById(R.id.ListView01);
		expandableList.setAdapter(adapter);
		
		registerForContextMenu(expandableList);
    	
        //registerForContextMenu(list);
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClickNom(Note item, int position) {
		
		//On instancie notre layout en tant que View
        LayoutInflater factory = LayoutInflater.from(this);
        final View alertDialogView = factory.inflate(R.layout.note_detail, null);
 
        //Cr�ation de l'AlertDialog
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
 
        //On affecte la vue personnalis� que l'on a cr�e � notre AlertDialog
        adb.setView(alertDialogView);
 
        //On donne un titre � l'AlertDialog
        adb.setTitle("Pense Bete " + item.getId());
        
        EditText nbG = (EditText)alertDialogView.findViewById(R.id.titre);
        nbG.setText(""+item.getTitre()+"");
        
        EditText nbP = (EditText)alertDialogView.findViewById(R.id.contenu);
        nbP.setText(""+item.getContenu()+"");
 
        //On modifie l'ic�ne de l'AlertDialog pour le fun ;)
        adb.setIcon(android.R.drawable.ic_dialog_alert);
 
        //On affecte un bouton "OK" � notre AlertDialog et on lui affecte un �v�nement
        adb.setPositiveButton("Choisir", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            	//On affiche dans un Toast le texte contenu dans l'EditText de notre AlertDialog
            	Toast.makeText(PenseBeteActivity.this, "Choix effectu�", Toast.LENGTH_SHORT).show();
            	
          } });
 
        //On cr�e un bouton "Annuler" � notre AlertDialog et on lui affecte un �v�nement
        adb.setNegativeButton("Retour", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	//Lorsque l'on cliquera sur annuler on quittera l'application
            	Toast.makeText(PenseBeteActivity.this, "Retour", Toast.LENGTH_SHORT).show();
          } });
        adb.show();
        
	}
}
