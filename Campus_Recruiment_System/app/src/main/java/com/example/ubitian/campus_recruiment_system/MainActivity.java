package com.example.ubitian.campus_recruiment_system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

    Button btn,btn1,btn2,btn3 ;
    public static final int RC_Signin = 1;
    private EditText edt;
    private EditText edt2;

    private FirebaseAuth fAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String musername;
    private ChildEventListener mchildlistener;

    private DatabaseReference mDatabase;
//    private GoogleApiClient mGoogleApiClient;
//    private GoogleSignInResult result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.signinForAdmin);
        btn1 = (Button) findViewById(R.id.signinForCompany);
        btn2 = (Button) findViewById(R.id.signinForStudent);
        btn3 = (Button) findViewById(R.id.for_sign_up);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this , Sign_in_Admin.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Sign_in_Company.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Sign_in_Student.class);
                startActivity(intent);
            }
        });


    }
}
