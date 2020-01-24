package com.example.bhramand123;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.bhramand123.models.Events;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class addevent extends AppCompatActivity {
private ImageButton imageButton;
private EditText evename;
private EditText evedesc;
private EditText evedate;
private EditText eveplace;
private Button publish;
    private static final int GALLERY_CODE=1;
    private Uri mimageuri;
private String eventnam;
private String eventdes;
private String eventplac;
private String eventdat;
private  String uid;
    private StorageReference mstorage;
    private FirebaseUser muser;
    private FirebaseAuth mauth;
    public String durl;
    private FirebaseDatabase mdb;
//private double lattt;
//private double lonng;

    private DatabaseReference mdbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addevent);
        imageButton=findViewById(R.id.imageButton2);
        evename=findViewById(R.id.editText6);
        evedesc=findViewById(R.id.editText7);
        evedate=findViewById(R.id.editText8);
        eveplace=findViewById(R.id.editText9);
        publish=findViewById(R.id.button4);

        mstorage= FirebaseStorage.getInstance().getReference();
        mauth=FirebaseAuth.getInstance();
        muser=mauth.getCurrentUser();
        mdb=FirebaseDatabase.getInstance();
        mdbr=mdb.getReference().child("events");
        uid= mauth.getUid();
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final StorageReference filepath = mstorage.child(mimageuri.getLastPathSegment());

                filepath.putFile(mimageuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                      /* final UploadTask upload = filepath.putFile(mimageuri);
                        upload.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(final UploadTask.TaskSnapshot taskSnapshot) {
                                Task<Uri> tasturl = upload.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {

                                    @Override
                                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                                        durl = taskSnapshot.getDownloadUrl().toString();
                                        return filepath.getDownloadUrl();
                                    }
                                });
                            }
                        });*/
                        filepath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                durl = uri.toString();
                               eventnam  =evename .getText().toString().trim();
                                eventdes = evedesc.getText().toString().trim();
                                eventdat = evedate.getText().toString().trim();
                                eventplac = eveplace.getText().toString().trim();
                               /* Intent i = getIntent();
                                String datalat = i.getExtras().getString("lattitude");
                                String datalon = i.getExtras().getString("longitude");
                                //Toast.makeText(getApplicationContext(),data,Toast.LENGTH_SHORT).show();*/
//                              lattt=MapsActivity.latt;
//                              lonng=MapsActivity.lont;
                                uid = muser.getUid();
                               // Events events=new Events(eventnam,eventdes,eventdat,eventplac,Double.parseDouble(datalat),Double.parseDouble(datalon),uid,durl);
                                Events events=new Events(eventnam,eventdes,eventdat,eventplac,99.8989,89.87878,uid,durl);

                                mdbr.child(eventplac).child(eventnam).setValue(events).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(addevent.this, e.toString(), Toast.LENGTH_SHORT).show();
                                    }
                                });



                            }
                        });

                        //durl=filepath.getDownloadUrl().toString();


                    }


                });
            }

        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryintent=new Intent(Intent.ACTION_GET_CONTENT);
                galleryintent.setType("image/*");
                startActivityForResult(galleryintent,GALLERY_CODE);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GALLERY_CODE &&resultCode==RESULT_OK) {
            mimageuri = data.getData();
            imageButton.setImageURI(mimageuri);
        }

    }
}
