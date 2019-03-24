package com.example.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdditionActivity extends AppCompatActivity {


    private EditText myPortalTitle, myPortalUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.return_button);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });


        //Init local variables
        myPortalTitle = findViewById(R.id.editTextTitle);
        myPortalUrl = findViewById(R.id.editTextUrl);

//Obtain the parameters provided by MainActivity

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textTitle = myPortalTitle.getText().toString();
                String textUrl = myPortalUrl.getText().toString();
                if (TextUtils.isEmpty(textTitle)) {
                    Snackbar.make(view, getResources().getString(R.string.needTitle), Snackbar.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(textUrl)) { // check if url is empty
                    Snackbar.make(view, getResources().getString(R.string.needUrl), Snackbar.LENGTH_LONG).show();
                } else { // if url and name is not empty, passes the values back through the intent
                    Intent intentResult = new Intent();
                    intentResult.putExtra(MainActivity.EXTRATEXT_NAME, textTitle);
                    intentResult.putExtra(MainActivity.EXTRATEXT_URL, textUrl);
                    setResult(Activity.RESULT_OK, intentResult);
                    finish();
                    //Prepare the return parameter and return
                }
            }
        });
    }
}
