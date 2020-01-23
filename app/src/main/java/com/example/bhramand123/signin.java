package com.example.bhramand123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signin extends AppCompatActivity {
private EditText memail;
private EditText mpassword;
private Button msignin;
private FirebaseAuth mauth;
private FirebaseAuth.AuthStateListener mlistener;

private FirebaseUser muser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        memail=findViewById(R.id.email2);
        mpassword=findViewById(R.id.password2);
        msignin=findViewById(R.id.singin);
        mauth=FirebaseAuth.getInstance();

        muser=mauth.getCurrentUser();
        mlistener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            if(muser!=null)
            {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
            }
        };
        msignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=memail.getText().toString().trim();
                String password=mpassword.getText().toString().trim();
                signi(email,password);

            }
        });
    }
    private void signi(String email,String password)
    {mauth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
        @Override
        public void onSuccess(AuthResult authResult) {
            Toast.makeText(getApplicationContext(),"Signed in successfully",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),HomeActivity.class));

        }
    }).addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            Toast.makeText(getApplicationContext(),"Sorry try again",Toast.LENGTH_SHORT).show();
            memail.setText("");
            mpassword.setText("");

        }
    });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mauth.addAuthStateListener(mlistener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mlistener!=null)
            mauth.removeAuthStateListener(mlistener);
    }
}
