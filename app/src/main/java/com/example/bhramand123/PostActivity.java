package com.example.bhramand123;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.bhramand123.models.User;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.UploadTask;
public class PostActivity extends AppCompatActivity {
private ImageButton placeimage;
private EditText placename;
private EditText placedesc;
private EditText location;
private Button post;
private static final int GALLERY_CODE=1;
private Uri mimageuri;

private StorageReference mstorage;
private FirebaseUser muser;
private FirebaseAuth mauth;
public String durl;
private FirebaseDatabase mdb;
//private double lattt;
//private double lonng;

private DatabaseReference mdbr;
private  EditText district;
  private   String dis;
   private String plac ;
   private String uid;
   private String des;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        district=findViewById(R.id.editText5);
        placeimage=findViewById(R.id.imageButton);
        placename=findViewById(R.id.editText2);
        placedesc=findViewById(R.id.editText3);
        location=findViewById(R.id.editText4);
        post=findViewById(R.id.button3);
        mstorage= FirebaseStorage.getInstance().getReference();
        mauth=FirebaseAuth.getInstance();
        muser=mauth.getCurrentUser();
        mdb=FirebaseDatabase.getInstance();
        mdbr=mdb.getReference().child("places");




        placeimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryintent=new Intent(Intent.ACTION_GET_CONTENT);
                galleryintent.setType("image/*");
                startActivityForResult(galleryintent,GALLERY_CODE);
            }
        });
        post.setOnClickListener(new View.OnClickListener() {
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
                              durl=uri.toString();
                              dis=district.getText().toString().trim();
                              plac = placename.getText().toString().trim();
                              des = placedesc.getText().toString().trim();
                              Intent i=getIntent();
                              String datalat=i.getExtras().getString("lattitude");
                              String datalon=i.getExtras().getString("longitude");
                              //Toast.makeText(getApplicationContext(),data,Toast.LENGTH_SHORT).show();
//                              lattt=MapsActivity.latt;
//                              lonng=MapsActivity.lont;
                              uid=muser.getUid();
                              com.example.bhramand123.models.Post post=new com.example.bhramand123.models.Post(plac,dis,durl,Double.parseDouble(datalat),Double.parseDouble(datalon),des,uid);
                              mdbr.child(dis).child(plac).setValue(post);


                              Toast.makeText(getApplicationContext(),"done",Toast.LENGTH_SHORT).show();
                          }
                      });

                        //durl=filepath.getDownloadUrl().toString();


                    }
                });


            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GALLERY_CODE &&resultCode==RESULT_OK) {
            mimageuri = data.getData();
            placeimage.setImageURI(mimageuri);
        }

    }
}





