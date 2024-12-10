package com.example.porte_chai;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public class profile_edit extends AppCompatActivity {
    private String abc;
    DatabaseReference acc2;
    private String age;
    CircleImageView change;
    private String city;
    Button delete,uploadv;
    ProgressDialog progressDialog;
    EditText e1;
    EditText e2;
    EditText e3;
    EditText e4;
    EditText e5;
    FirebaseAuth fauth;
    private String name;
    private String number;
    ProgressBar p1;
    private String skilo;
    private String state;
    private String street;
    TextView t1;
    Button update;
    private String url;
    private String userId;
    FirebaseUser vapar;
    String x1;
    String x2;
    String x3;
    String x4;
    String x5;
    String x6;
    VideoView v1;

    public String initial_video_link;
     DatabaseReference refff ;


    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        this.change = (CircleImageView) findViewById(R.id.loadface);
        this.fauth = FirebaseAuth.getInstance();
        this.p1 = (ProgressBar) findViewById(R.id.progressBar7);
        this.t1 = (TextView) findViewById(R.id.textView5);
        this.e1 = (EditText) findViewById(R.id.editTextTextPersonName13);
        this.e2 = (EditText) findViewById(R.id.editTextTextPersonName14);
        this.e3 = (EditText) findViewById(R.id.editTextTextPersonName15);
        this.e4 = (EditText) findViewById(R.id.editTextTextPersonName16);
        this.e5 = (EditText) findViewById(R.id.editTextTextPersonName17);
        this.update = (Button) findViewById(R.id.button5);
        this.delete = (Button) findViewById(R.id.button6);
        this.v1 = (VideoView) findViewById(R.id.videoView);



        uploadv = findViewById(R.id.uploadv);
        uploadv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for showing progressDialog while uploading
                progressDialog = new ProgressDialog(profile_edit.this);
                choosevideo();
            }
        });

        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(getResources().getColor(R.color.yellow));
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        this.vapar = currentUser;
        this.userId = currentUser.getUid();
        DatabaseReference child = FirebaseDatabase.getInstance().getReference().child("users");
        this.acc2 = child;
        this.refff=FirebaseDatabase.getInstance().getReference().child("users").child(userId);




        // Read from the database
        refff.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    initial_video_link = (String) dataSnapshot.child("svideoIntro").getValue();
                    Uri videoUri = Uri.parse(initial_video_link);
                    v1.setVideoURI(videoUri);
                    MediaController mediaController = new MediaController(profile_edit.this);
                    mediaController.setAnchorView(v1);
                    v1.setMediaController(mediaController);
                    v1.start();


                } else {

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });






        child.child(this.userId).addValueEventListener(new ValueEventListener() {
            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot snapshot) {
                users profile = (users) snapshot.getValue(users.class);
                profile_edit.this.number = profile.sphone;
                profile_edit.this.t1.setText(profile_edit.this.number);
                profile_edit.this.name = profile.sname;
                profile_edit.this.e1.setText(profile_edit.this.name);
                profile_edit.this.age = profile.sage;
                profile_edit.this.e2.setText(profile_edit.this.age);
                profile_edit.this.skilo = profile.skilo;
                profile_edit.this.e3.setText(profile_edit.this.skilo);
                profile_edit.this.street = profile.sstreet;
                profile_edit.this.e4.setText(profile_edit.this.street);
                profile_edit.this.city = profile.scity;
                profile_edit.this.e5.setText(profile_edit.this.city);
                profile_edit.this.url = profile.slink;
                Glide.with((FragmentActivity) profile_edit.this).load(profile_edit.this.url).into(profile_edit.this.change);
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError error) {
            }
        });

        this.change.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConnectivityManager manager = (ConnectivityManager) profile_edit.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activenetwork = manager.getActiveNetworkInfo();
                if (activenetwork != null) {
                    profile_edit.this.startActivity(new Intent(profile_edit.this, profilephoto.class));
                } else {
                    Toast.makeText(profile_edit.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });
        this.update.setOnClickListener(new AnonymousClass3());
        this.delete.setOnClickListener(new AnonymousClass4());
    }


    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ConnectivityManager manager = (ConnectivityManager) profile_edit.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activenetwork = manager.getActiveNetworkInfo();
            if (activenetwork != null) {
                if (profile_edit.this.e1.length() < 2 || profile_edit.this.e1.length() > 50) {
                    profile_edit.this.e1.setError("Enter Proper Name");
                }
                if (profile_edit.this.e2.length() > 3) {
                    profile_edit.this.e2.setError("Enter Proper Age");
                }
                if (profile_edit.this.e3.length() < 3 || profile_edit.this.e3.length() > 40) {
                    profile_edit.this.e3.setError("Enter Proper Skill");
                }
                if (profile_edit.this.e4.length() < 3 || profile_edit.this.e4.length() > 40) {
                    profile_edit.this.e4.setError("Enter Proper Street Address");
                }
                if (profile_edit.this.e5.length() < 3 || profile_edit.this.e5.length() > 20) {
                    profile_edit.this.e5.setError("Enter Proper City");
                    return;
                }
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(profile_edit.this);
                alertDialog.setTitle("Delete");
                alertDialog.setMessage("Are you sure you want to Update Account?");
                alertDialog.setPositiveButton("Yes", new AnonymousClass1());
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
                return;
            }
            Toast.makeText(profile_edit.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }

        class AnonymousClass1 implements DialogInterface.OnClickListener {
            AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                profile_edit.this.p1.setVisibility(View.VISIBLE);
                profile_edit.this.acc2.child(profile_edit.this.userId).addValueEventListener(new ValueEventListener() {
                    @Override // com.google.firebase.database.ValueEventListener
                    public void onDataChange(DataSnapshot snapshot) {
                        users profile = (users) snapshot.getValue(users.class);
                        profile_edit.this.abc = profile.slink;
                        profile_edit.this.x1 = profile_edit.this.e1.getText().toString();
                        profile_edit.this.x2 = profile_edit.this.t1.getText().toString();
                        profile_edit.this.x3 = profile_edit.this.e2.getText().toString();
                        profile_edit.this.x4 = profile_edit.this.e3.getText().toString();
                        profile_edit.this.x5 = profile_edit.this.e4.getText().toString();
                        profile_edit.this.x6 = profile_edit.this.e5.getText().toString();
                        users u = new users(profile_edit.this.x1, profile_edit.this.x2, profile_edit.this.x3, profile_edit.this.x4, profile_edit.this.x5, profile_edit.this.x6, profile_edit.this.abc,initial_video_link);
                        FirebaseDatabase.getInstance().getReference().child("users").child(FirebaseAuth.getInstance().getUid()).setValue(u).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override // com.google.android.gms.tasks.OnCompleteListener
                            public void onComplete(Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(profile_edit.this, "Profile Updated!", Toast.LENGTH_SHORT).show();
                                    profile_edit.this.startActivity(new Intent(profile_edit.this, slideactivity.class));
                                }
                            }
                        });
                    }

                    @Override // com.google.firebase.database.ValueEventListener
                    public void onCancelled(DatabaseError error) {
                    }
                });
            }
        }
    }

    class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ConnectivityManager manager = (ConnectivityManager) profile_edit.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activenetwork = manager.getActiveNetworkInfo();
            if (activenetwork != null) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(profile_edit.this);
                alertDialog.setTitle("Delete");
                alertDialog.setMessage("Are you sure you want to Delete Account?");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        if (profile_edit.this.vapar != null) {
                            profile_edit.this.vapar.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override // com.google.android.gms.tasks.OnCompleteListener
                                public void onComplete(Task<Void> task) {
                                    Toast.makeText(profile_edit.this, "Account Deleted Successfully!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(profile_edit.this, loginregister.class);
                                    profile_edit.this.startActivity(intent);
                                }
                            });
                        }
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
                return;
            }
            Toast.makeText(profile_edit.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent(this, slideactivity.class);
        startActivity(intent);
    }





    private void choosevideo() {
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 5);
    }
    Uri videouri;
    // startActivityForResult is used to receive the result, which is the selected video.
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            videouri = data.getData();
            progressDialog.setTitle("Uploading...");
            progressDialog.show();
            uploadvideo();
        }
    }
    private String getfiletype(Uri videouri) {
        ContentResolver r = getContentResolver();
        // get the file type ,in this case its mp4
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(r.getType(videouri));
    }
    private void uploadvideo() {
        if (videouri != null) {
            // save the selected video in Firebase storage
            final StorageReference reference = FirebaseStorage.getInstance().getReference("Files/" + System.currentTimeMillis() + "." + getfiletype(videouri));
            reference.putFile(videouri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                    while (!uriTask.isSuccessful()) ;
                    // get the link of video
                    String downloadUri = uriTask.getResult().toString();
                    refff.child("svideoIntro").setValue(downloadUri);
                    // Video uploaded successfully
                    // Dismiss dialog
                    progressDialog.dismiss();
                    Toast.makeText(profile_edit.this, "Video Uploaded!!", Toast.LENGTH_SHORT).show();
                    profile_edit.this.startActivity(new Intent(profile_edit.this, slideactivity.class));
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    // Error, Image not uploaded
                    progressDialog.dismiss();
                    Toast.makeText(profile_edit.this, "Failed " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                // Progress Listener for loading
                // percentage on the dialog box
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    // show the progress bar
                    double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                    progressDialog.setMessage("Uploaded " + (int) progress + "%");
                }
            });
        }
    }

}