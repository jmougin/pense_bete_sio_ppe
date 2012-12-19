package com.example.pensebete;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
	
	
public class ExpListDateAdapter extends BaseExpandableListAdapter {

		private Context context;
		private ArrayList<ArrayList> NoteGroupes;
		private LayoutInflater inflater;	 
		
		public ExpListDateAdapter(Context context, ArrayList<ArrayList> groupes) {
			this.context = context;
			this.NoteGroupes = groupes;
		    inflater = LayoutInflater.from(context);
		}
		
		public ExpListDateAdapter(PenseBeteActivity context2,
				ArrayList<Note> lesNotes) {
			// TODO Auto-generated constructor stub
		}

		@Override
		public boolean areAllItemsEnabled() {
		    return true;
		}
		
		public Object getChild(int gPosition, int cPosition) {
			// TODO Auto-generated method stub
			return NoteGroupes.get(gPosition).get(cPosition);
		}

		public long getChildId(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return childPosition;
		}

		public View getChildView(final int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			final Note n = (Note) getChild(groupPosition, childPosition);
			ChildViewHolder childViewHolder;
			
			// détermine si on a choisi les gratuits ou les payants
			String categ = "";
			switch (groupPosition){
				case 0 : 
					categ = "Aujourd'hui";
					break;
				case 1 :
					categ = "Plus tard";
					break;
			}
			final String categorie = categ;
			
			if (convertView == null) {
			    childViewHolder = new ChildViewHolder();
			    convertView = inflater.inflate(R.layout.detail_note_layout_level2, null);
			    childViewHolder.textViewChild = (TextView) convertView.findViewById(R.id.tv_note_nom);
			    childViewHolder.buttonChildSup = (Button) convertView.findViewById(R.id.BTSupNote);
			    convertView.setTag(childViewHolder);
			} else {
			    childViewHolder = (ChildViewHolder) convertView.getTag();
			}
				 
			childViewHolder.textViewChild.setText(n.getTitre());
				 
			
			
			childViewHolder.buttonChildSup.setText("X");

			childViewHolder.buttonChildSup.setOnClickListener(new OnClickListener() {
				 
			      public void onClick(View v) {
			           NoteGroupes.get(groupPosition).remove(n);
			           notifyDataSetChanged();
			      }
			});
				
				 
			return convertView;
		}

		public int getChildrenCount(int gPosition) {
			return NoteGroupes.get(gPosition).size();
		}

		public Object getGroup(int groupPosition) {
			return NoteGroupes.get(groupPosition);
		}

		public int getGroupCount() {
			return NoteGroupes.size();
		}

		public long getGroupId(int groupPosition) {
			// TODO Auto-generated method stub
			return groupPosition;
		}

		public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
			GroupViewHolder gholder;
			// détermine si on a choisi les gratuits ou les payants
			String categ = "";
			switch (groupPosition){
				case 0 : 
					categ = "Aujourd'hui";
					break;
				case 1 :
					categ = "Plus tard";
					break;
			}
			final String categorie = categ;

			if (convertView == null) {
				gholder = new GroupViewHolder();
	 
				convertView = inflater.inflate(R.layout.detail_note_layout_level1, null);
				gholder.textViewGroup = (TextView) convertView.findViewById(R.id.TVGroup);
				convertView.setTag(gholder);
			} else {
				gholder = (GroupViewHolder) convertView.getTag();
			}
			gholder.textViewGroup.setText(categorie);
			return convertView;
		}

		public boolean hasStableIds() {
			// TODO Auto-generated method stub
			return true;
		}

		public boolean isChildSelectable(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return true;
		}
		
		class GroupViewHolder {
			public TextView textViewGroup;
		}

		class ChildViewHolder {
	        public TextView textViewChild;
			public Button buttonChildSup;
		}
	

	
	
	
	

}
