package com.example.arifin.contacts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ContactsAdapter<T> extends ArrayAdapter<T> implements SectionIndexer {

    ArrayList<String> elements;
    HashMap<String, Integer> azIndexer;
    String[] sections;

    public ContactsAdapter(Context context, int textViewResourceId, List<T> objects) {
        super(context, textViewResourceId, objects);
        elements = (ArrayList<String>) objects;
        azIndexer = new HashMap<String, Integer>(); //stores the positions for the start of each letter

        int size = elements.size();
        for (int i = size - 1; i >= 0; i--) {
            String element = elements.get(i);
            //We store the first letter of the word, and its index.
            azIndexer.put(element.substring(0, 1), i);
        }

        Set<String> keys = azIndexer.keySet(); // set of letters

        Iterator<String> it = keys.iterator();
        ArrayList<String> keyList = new ArrayList<String>();

        while (it.hasNext()) {
            String key = it.next();
            keyList.add(key);
        }
        Collections.sort(keyList);//sort the keylist
        sections = new String[keyList.size()]; // simple conversion to array
        keyList.toArray(sections);
    }


    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return 0;
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }



}
