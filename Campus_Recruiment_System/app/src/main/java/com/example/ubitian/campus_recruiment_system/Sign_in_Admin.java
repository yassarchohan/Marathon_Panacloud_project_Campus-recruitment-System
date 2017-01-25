package com.example.ubitian.campus_recruiment_system;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;

public class Sign_in_Admin extends AppCompatActivity {

    public static final int RC_Signin = 1;
    private EditText edt;
    private EditText edt2;

    private FirebaseAuth fAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
  //  private String musername;
    private ChildEventListener mchildlistener;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in__admin);

        edt = (EditText) findViewById(R.id.Adminemail);
        edt2 = (EditText) findViewById(R.id.Adminpassword);
        fAuth = FirebaseAuth.getInstance();

        Authsetup();
    }


    public void Authsetup() {


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Toast.makeText(Sign_in_Admin.this, "login succesfully", Toast.LENGTH_LONG).show();
                } else {
                    // User is signed out
                    Toast.makeText(Sign_in_Admin.this, "user is signed out", Toast.LENGTH_SHORT).show();

                }


            }

        };
    }


    @Override
    public void onStart() {
        super.onStart();
        fAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            fAuth.removeAuthStateListener(mAuthListener);

        }
    }


    public void forsignin(View v) {

        fAuth.signInWithEmailAndPassword(edt.getText().toString(), edt2.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(Sign_in_Admin.this, "sorry to sign in plz sign up first", Toast.LENGTH_LONG).show();

//                        gm.setUsername(musername);


                        if (!task.isSuccessful()) {
                            //    txt.setText("error handling auth" + task.getException());
                        } else {
                            Intent intent = new Intent(Sign_in_Admin.this, Admin_panel.class);
                            startActivity(intent);
                             Toast.makeText(Sign_in_Admin.this, "welcome sir please observe the new requests", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
    }

}
