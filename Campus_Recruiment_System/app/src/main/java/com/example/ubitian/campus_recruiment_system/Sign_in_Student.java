package com.example.ubitian.campus_recruiment_system;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_in_Student extends AppCompatActivity {

    private EditText edt;
    private Button btn,btn2;
    private EditText edt2;
    private ChildEventListener mchildlistener;
    private DatabaseReference mDatabase;
    FirebaseDatabase fb;
    private Getter_methods gm;


    String username;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_student);



        btn = (Button) findViewById(R.id.Student_submit);
        edt = (EditText) findViewById(R.id.Studentemail);
        edt2 = (EditText) findViewById(R.id.Studentpassword);

        gm = new Getter_methods();

        fb = FirebaseDatabase.getInstance();
        mDatabase = fb.getReference().child("Users").child("Students");

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = edt.getText().toString();
                password = edt2.getText().toString();
                String key = mDatabase.push().getKey();

                if(username == null || password == null){
                    Toast.makeText(Sign_in_Student.this, "Could not regsiter please enter correct name and password(At least 6 chars)", Toast.LENGTH_SHORT).show();
                }

                else {
                    Getter_methods gmre = new Getter_methods(username,password,key);
                    mDatabase.push().setValue(gmre);
                }

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





            }
        });

        mchildlistener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mDatabase.addChildEventListener(mchildlistener);

    }




}
