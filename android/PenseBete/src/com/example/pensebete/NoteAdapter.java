package com.example.pensebete;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NoteAdapter extends BaseAdapter{


		  // Une liste de notes
		  private List<Note> listeNotes;
		  //Le contexte dans lequel est présent notre adapter
		  private Context mContext;
		  //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
		  private LayoutInflater mInflater;
	
		  // le constructeur
		  public NoteAdapter(Context context, List<Note> aListP) {
			  mContext = context;
			  setListeNotes(aListP);
			  //Le LayoutInflater permet de parser un layout XML et de te transcoder en IHM Android.
			  mInflater = LayoutInflater.from(mContext);
		  }
	
		  //Pour respecter l'interface BaseAdapter, il nous faut spécifier la méthode "count()".
		  public int getCount() {
		    return getListeNotes().size();
		  }
	
		  public Object getItem(int position) {
		    return getListeNotes().get(position);
		  }
	
		  public long getItemId(int position) {
		    return position;
		  }

		  // Maintenant il faut surcharger la méthode pour renvoyer une "View"
		  // en fonction d'une position donnée.
		  public View getView(int position, View convertView, ViewGroup parent) {
			  OnClickListener ClickListener =  new OnClickListener() {
					
					public void onClick(View v) {
						//Lorsque l'on clique sur le nom, on récupère la position de la "Ville"
						Integer position = (Integer)v.getTag();
						
						System.out.println("*******************" + getListeNotes());
						Log.i("info", "*******************" + v.getTag());
						//On prévient les listeners qu'il y a eu un clic sur le TextView "TV_Nom".
						sendListener(getListeNotes().get(position), position);
					}  
			  };
			  
			LinearLayout layoutItem;
		    //(1) : Réutilisation des layouts
		    if (convertView == null) {
			  		//Initialisation de notre item à partir du  layout XML "villee_layout.xml"
			    	layoutItem = (LinearLayout) mInflater.inflate(R.layout.note_layout, parent, false);
			    } else {
			    	layoutItem = (LinearLayout) convertView;
		    }
	
		  //(2) : Récupération des TextView de notre layout
		  TextView tv_Nom = (TextView)layoutItem.findViewById(R.id.TV_Nom);
		     
		  //(3) : Renseignement des valeurs
		  tv_Nom.setText(getListeNotes().get(position).getTitre());
		  
		  tv_Nom.setTag(position);
		  tv_Nom.setOnClickListener(ClickListener);
		  
		  //On retourne l'item créé.
		  return layoutItem;
		}
	
	  	// Interface pour écouter les évènements sur le nom d'une ville
		public interface NotesAdapterListener {
			public void onClickNom(Note item, int position);
		}

		//Contient la liste des listeners
		private ArrayList<NotesAdapterListener> mListListener = new ArrayList<NotesAdapterListener>();

		// Pour ajouter un listener sur notre adapter
		public void addListener(NotesAdapterListener aListener) {
			mListListener.add(aListener);
		}

		// permet de prévenir tous les listeners
		private void sendListener(Note item, int position) {
			for(int i = mListListener.size()-1; i >= 0; i--) {
				mListListener.get(i).onClickNom(item, position);
			}
		}

		public List<Note> getListeNotes() {
			return listeNotes;
		}

		public void setListeNotes(List<Note> listeNotes) {
			this.listeNotes = listeNotes;
		}

	
}
