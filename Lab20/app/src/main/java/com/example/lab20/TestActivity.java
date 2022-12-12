package com.example.lab20;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class TestActivity extends Activity implements TextView.OnEditorActionListener {

    EditText editSearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_activity);

        editSearch = (EditText) findViewById(R.id.editSearch);
        editSearch.setOnEditorActionListener(this);

        EditText editGo = (EditText) findViewById(R.id.editGo);
        editGo.setOnEditorActionListener(this);

        EditText editNext = (EditText) findViewById(R.id.editNext);
        editNext.setOnEditorActionListener(this);
        EditText editDone = (EditText) findViewById(R.id.editDone);
        editDone.setOnEditorActionListener(this);
        EditText editSend = (EditText) findViewById(R.id.editSend);
        editSend.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            if (!editSearch.getText().toString().equals("cat")) {
                Toast.makeText(this, "Не буду ничего искать!", Toast.LENGTH_LONG).show();
            }
            return true;
        }
        if (actionId == EditorInfo.IME_ACTION_GO) {
            return true;
        }
        return false;
    }
}
