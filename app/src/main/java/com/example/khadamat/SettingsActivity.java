package com.example.khadamat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    ImageButton takePic;
    ImageView profileImg;
    int REQUEST_CAMERA =1;
    int SELECT_FILE =0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Settings");
        goToEditDescription();
        changePic();
    }

    public void changePic(){
        takePic = findViewById(R.id.takePic);
        profileImg = findViewById(R.id.profileImg);
        takePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });
        }
    public void goToEditDescription(){

        TextView edit =findViewById(R.id.edit_description);

        edit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this, EditDescriptionActivity.class));
            }
        });
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
                 goToEditDescription();
                break;
            default:
                break;
        }
    }


    private void selectImage(){
        final CharSequence[] items = {"Camera", "Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
        builder.setTitle("add image");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if (items[i].equals("Camera")){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);

                }else if (items[i].equals("Gallery")){
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(intent.createChooser(intent, "select file"),SELECT_FILE);

                }else if (items[i].equals("Cancel")){
                    dialog.dismiss();
                }
            }
        });
        builder.show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK)
        {
            if (requestCode == REQUEST_CAMERA)
            {
                Bundle bundle = data.getExtras();
                final Bitmap bmp = (Bitmap) bundle.get("data");
                profileImg.setImageBitmap(bmp);

            }else  if (requestCode ==SELECT_FILE)
            {
                Uri selectImageUri =data.getData();
                profileImg.setImageURI(selectImageUri);
            }
        }


    }
}