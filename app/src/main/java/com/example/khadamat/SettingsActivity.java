package com.example.khadamat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }


    public void editInformaion(TextView textView , EditText editText){
        textView.setVisibility(View.GONE);
        editText.setVisibility(View.VISIBLE);

    }


    public void edit(View view)
    {
        switch(view.getId())
        {
            case R.id.edit_name:
                textView =(TextView) findViewById(R.id.full_name);
                editText = (EditText) findViewById(R.id.editable_name);
                editInformaion(textView, editText);
                break;
            case R.id.edit_city:
                textView =(TextView) findViewById(R.id.city);
                editText = (EditText) findViewById(R.id.editable_city);
                editInformaion(textView, editText);
                break;
            case R.id.edit_phone:
                textView =(TextView) findViewById(R.id.phone);
                editText = (EditText) findViewById(R.id.editable_phone);
                editInformaion(textView, editText);
                break;
            case R.id.edit_email:
                textView =(TextView) findViewById(R.id.email);
                editText = (EditText) findViewById(R.id.editable_email);
                editInformaion(textView, editText);
                break;
            case R.id.edit_profession:
                textView =(TextView) findViewById(R.id.profession);
                editText = (EditText) findViewById(R.id.editable_profession);
                editInformaion(textView, editText);
                break;
            case R.id.edit_description:
                textView =(TextView) findViewById(R.id.description);
                editText = (EditText) findViewById(R.id.editable_description);
                editInformaion(textView, editText);
                break;
            default:
                break;
        }
    }

}