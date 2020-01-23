package com.example.bhramand123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bhramand123.models.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class signup extends AppCompatActivity {
    private EditText memail;
    private EditText mpassword;
    private EditText mname;
    private EditText mphoneno;
    private Button msignin;
    private FirebaseAuth mauth;
    private FirebaseDatabase mdb;
    private DatabaseReference mdbr;
    private FirebaseUser muser;
    private String uid;
//private FirebaseAuth.AuthStateListener mlistener;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
            mauth=FirebaseAuth.getInstance();
        memail=findViewById(R.id.email2);
        mpassword=findViewById(R.id.password2);
        msignin=findViewById(R.id.singin);
        mname=findViewById(R.id.user_name);
        mphoneno=findViewById(R.id.editText7);
        mdb=FirebaseDatabase.getInstance();
        mdbr=mdb.getReference().child("users");
        muser=mauth.getCurrentUser();

        msignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=memail.getText().toString().trim();
                String password=mpassword.getText().toString().trim();
                String name=memail.getText().toString().trim();
                String phoneno=mpassword.getText().toString().trim();  uid= mauth.getUid();
                signup(email,password,name,phoneno,uid);

            }
        });


    }

    private void signup(final String email, final String password, final String name, final String phoneno, final String uiid)
    {
mauth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
    @Override
    public void onSuccess(AuthResult authResult) {
       User user=new com.example.bhramand123.models.User(email,name,phoneno,password);
        mdbr.child(uiid).setValue(user);
       /*mdbr.child(uiid).child("name").setValue(name);
        mdbr.child(uiid).child("email").setValue(email);
        mdbr.child(uiid).child("password").setValue(password);
        mdbr.child(uiid).child("phoneno").setValue(phoneno);*/
        Toast.makeText(getApplicationContext(),"Account created successfully",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),signin.class));


    }
}).addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull Exception e) {
        Toast.makeText(getApplicationContext(),"Account not created",Toast.LENGTH_SHORT).show();
        memail.setText("");
        mname.setText("");
        mphoneno.setText("");
        mpassword.setText("");
    }
});
    }
}
