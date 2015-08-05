package com.google.android.gms.location.app.gpsmybus;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.location.sample.locationupdates.R;

/**
 * Created by C5207534 on 5/9/2015.
 */
public class Enter_bus_route extends Activity{

    // UI references.
    private AutoCompleteTextView mUserName;
    private AutoCompleteTextView mSource,mDestination;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    public static final String PREF_NAME = "To Store data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_route);

        mUserName = (AutoCompleteTextView) findViewById(R.id.email);
        mSource = (AutoCompleteTextView) findViewById(R.id.source);
        mDestination = (AutoCompleteTextView) findViewById(R.id.destination);

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                route_Install();
            }
        });

    }

    @SuppressLint("NewApi")
    public void route_Install() {

        String user_name = mUserName.getText().toString();
        String Source = mSource.getText().toString().toLowerCase();
        String Destination = mDestination.getText().toString().toLowerCase();


        if (((Source.isEmpty()) && (Destination.isEmpty()) ))
        {
            Toast.makeText(this, "Please Enter Source and Destination", Toast.LENGTH_SHORT).show();
        }


        else if(Source.isEmpty())
        {
            Toast.makeText(this, "Please Enter Source", Toast.LENGTH_SHORT).show();
        }
        else if(Destination.isEmpty())
        {
            Toast.makeText(this, "Please Enter Destination", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Intent intent = new Intent(Enter_bus_route.this, hotels.class);
            String source_destination = Source+"-"+Destination;





//Create the bundle
            Bundle bundle = new Bundle();

//Add your data to bundle
//            bundle.putString( "Bus_Route_no", route_no);
//            bundle.putString("Source_Destination", source_destination);



//Add the bundle to the intent
//            intent.putExtras(bundle);

//Fire that second activity

            //include the string in your intent
//            intent.putExtra("Bus_Route_no", route_no);
//            intent.putExtra("Source_Destination", source_destination);
//            intent.putExtra("Destination", Destination);
//            SharedPreferences.Editor editor = getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
//            editor.putString("Bus_Route_no", route_no);
//            editor.putString("Source_Destination", source_destination);
//            editor.commit();


            // 0 - for private mode`
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);

            SharedPreferences.Editor editor1 = pref.edit();


            editor1.putString("user_name", user_name);
            editor1.putString("Source_Destination", source_destination);
            editor1.commit();

            startActivity(intent);
            finish();
        }



    }
}
