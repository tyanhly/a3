package com.example.a3;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.ToggleButton;

import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity mainActivity;
    private Button button1;
    private EditText editTextName;
    private EditText editTextEmail;
    private CheckBox checkBox;
    private RadioButton radioButton;
    private ToggleButton toggleButton;
    private Spinner spinner;
    
    @Before
    public void setup() {
        mainActivity = new MainActivity();
        mainActivity.onCreate(null);
        
        button1 = (Button) mainActivity.findViewById(R.id.button1);
        editTextName = (EditText) mainActivity.findViewById(R.id.EditTextName);
        editTextEmail = (EditText) mainActivity
                .findViewById(R.id.EditTextEmail);
        checkBox = (CheckBox) mainActivity.findViewById(R.id.checkBox1);
        radioButton = (RadioButton) mainActivity
                .findViewById(R.id.radioButton1);
        toggleButton = (ToggleButton) mainActivity
                .findViewById(R.id.toggleButton);
        spinner = (Spinner) mainActivity.findViewById(R.id.planetsSpinner);
    }
    
    @Test
    public void shouldHaveValidPropertiesForFormElements() {
        
        Assert.assertEquals(button1.getText().toString(), "Submit");
        Assert.assertEquals(button1.getHint().toString(), "Touch for submit");
        
        Assert.assertEquals(editTextName.getText().toString(), "");
        Assert.assertEquals(editTextName.getHint().toString(), "Full Name");
        
        Assert.assertEquals(editTextEmail.getText().toString(), "");
        Assert.assertEquals(editTextEmail.getHint().toString(),
                "example@email.com");
        
        Assert.assertEquals(checkBox.isChecked(), true);
        Assert.assertEquals(checkBox.getText().toString(), "CheckBox");
        
        Assert.assertEquals(radioButton.isChecked(), false);
        Assert.assertEquals(radioButton.getText().toString(), "RadioButton");
        
        Assert.assertEquals(toggleButton.isChecked(), true);
        
        Assert.assertEquals(spinner.getAdapter().getCount(), 8);
        
    }
    
    @Test
    public void pressingTheButtonShouldChangeValueOfSomeElements()
            throws Exception {
        checkBox.callOnClick();
        button1.performClick();
        
        Assert.assertEquals(editTextName.getText().toString(), "new Value");
        Assert.assertEquals(checkBox.isChecked(), false);
        Assert.assertEquals(radioButton.isChecked(), true);
        Assert.assertEquals(toggleButton.isChecked(), false);
        Assert.assertEquals(spinner.getAdapter().getCount(), 9);
    }
    
}