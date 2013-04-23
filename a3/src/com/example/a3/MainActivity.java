package com.example.a3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
    private ArrayAdapter<CharSequence> adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox1);
        checkBox.setChecked(true);
        
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setChecked(true);
        
        Spinner spinner = (Spinner) this.findViewById(R.id.planetsSpinner);
        CharSequence[] itemArray = getResources().getTextArray(
                R.array.planets_array);
        List<CharSequence> itemList = new ArrayList<CharSequence>(
                Arrays.asList(itemArray));
        
        adapter = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_item, itemList);
        
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        spinner.setAdapter(adapter);
        
        findViewById(R.id.button1).setOnClickListener(
                new View.OnClickListener() {
                    
                    @Override
                    public void onClick(View arg0) {
                        EditText editTextName = (EditText) findViewById(R.id.EditTextName);
                        editTextName.setText("new Value");
                        
                        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox1);
                        checkBox.setChecked(false);
                        
                        RadioButton radioButton = (RadioButton) findViewById(R.id.radioButton1);
                        radioButton.setChecked(true);
                        
                        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
                        toggleButton.setChecked(false);
                        
                        adapter.add("another Item");
                        
                        adapter.notifyDataSetChanged();
                        
                    }
                });
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
