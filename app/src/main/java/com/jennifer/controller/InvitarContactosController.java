package com.jennifer.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jennifer.R;
import com.jennifer.adapter.ContactosAdapter;
import com.jennifer.model.Contactos;

import java.util.ArrayList;

public class InvitarContactosController extends AppCompatActivity {
    public ArrayList<Contactos> contactosList;
    ContactosAdapter dataAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitar_contactos);
        //Generate list View from ArrayList
        displayListView();

        checkButtonClick();
    }


    private void displayListView(){
        ArrayList<Contactos> contactosList = new ArrayList<Contactos>();
        Contactos Contactos = new Contactos("AFG","Afghanistan",false);
        contactosList.add(Contactos);
        Contactos = new Contactos("ALB","Albania",true);
        contactosList.add(Contactos);
        Contactos = new Contactos("DZA","Algeria",false);
        contactosList.add(Contactos);
        Contactos = new Contactos("ASM","American Samoa",true);
        contactosList.add(Contactos);
        Contactos = new Contactos("AND","Andorra",true);
        contactosList.add(Contactos);
        Contactos = new Contactos("AGO","Angola",false);
        contactosList.add(Contactos);
        Contactos = new Contactos("AIA","Anguilla",false);
        contactosList.add(Contactos);

        //create an ArrayAdaptar from the String Array
        dataAdapter = new ContactosAdapter(this,
                R.layout.content_activity_invitar_contactos, contactosList);
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Contactos contactos = (Contactos) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Clicked on Row: " + contactos.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private void checkButtonClick() {


        Button myButton = (Button) findViewById(R.id.findSelected);
        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer responseText = new StringBuffer();
                responseText.append("The following were selected...\n");

                ArrayList<Contactos> contactosList = dataAdapter.contactosList;
                for (int i = 0; i < contactosList.size(); i++) {
                    Contactos contactos = contactosList.get(i);
                    if (contactos.isSelected()) {
                        responseText.append("\n" + contactos.getName());
                    }
                }
                Toast.makeText(getApplicationContext(),
                        responseText, Toast.LENGTH_LONG).show();
            }
        });

    }

}
