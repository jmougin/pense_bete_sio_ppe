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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pensebete.NoteAdapter.NotesAdapterListener;

public class PenseBeteActivity extends Activity implements NotesAdapterListener{

	private ArrayList<Note> lesNotes;
	private NoteAdapter adapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	Log.w("Message", "onCreate de l'application");
    	
    	// Création d'une liste de note test
    	lesNotes=new ArrayList<Note>();
    	lesNotes.add(new Note("Anniversaire"));
    	lesNotes.add(new Note("Médecin"));
    	lesNotes.add(new Note("Morgue"));
    	
    	// XML -------------------------------------------------------------
    	//XMLNoteCreator writerXml = new XMLNoteCreator("lesVilles.xml");
    	//writerXml.saveVillesIntoXML(lesNotes);
    	// -----------------------------------------------------------------
    
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    	
    	adapter = new NoteAdapter(this, lesNotes);
    	adapter.addListener(this);
    	
        //Récupération du composant ListView
        ListView list = (ListView)findViewById(R.id.ListView01);
        
        //Initialisation de la liste avec les données
        list.setAdapter(adapter);
        
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
 
        //Création de l'AlertDialog
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
 
        //On affecte la vue personnalisé que l'on a crée à notre AlertDialog
        adb.setView(alertDialogView);
 
        //On donne un titre à l'AlertDialog
        adb.setTitle("Informations sur la ville de " + item.getId());
        
        EditText nbG = (EditText)alertDialogView.findViewById(R.id.titre);
        nbG.setText(""+item.getTitre()+"");
        
        EditText nbP = (EditText)alertDialogView.findViewById(R.id.contenu);
        nbP.setText(""+item.getContenu()+"");
 
        //On modifie l'icône de l'AlertDialog pour le fun ;)
        adb.setIcon(android.R.drawable.ic_dialog_alert);
 
        //On affecte un bouton "OK" à notre AlertDialog et on lui affecte un évènement
        adb.setPositiveButton("Choisir", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            	//On affiche dans un Toast le texte contenu dans l'EditText de notre AlertDialog
            	Toast.makeText(PenseBeteActivity.this, "Choix effectué", Toast.LENGTH_SHORT).show();
            	
          } });
 
        //On crée un bouton "Annuler" à notre AlertDialog et on lui affecte un évènement
        adb.setNegativeButton("Retour", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	//Lorsque l'on cliquera sur annuler on quittera l'application
            	Toast.makeText(PenseBeteActivity.this, "Retour", Toast.LENGTH_SHORT).show();
          } });
        adb.show();
        
	}
}
