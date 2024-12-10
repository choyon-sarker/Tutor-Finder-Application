package com.example.porte_chai;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/* loaded from: classes3.dex */
public class profilephoto extends AppCompatActivity {
    ImageButton i1;
    ImageButton i2;
    ImageButton i3;
    ImageButton i4;
    ImageButton i5;
    ImageButton i6;
    ImageButton i7;
    ImageButton i8;
    ImageButton i9;
    String l1;
    String l2;
    String l3;
    String l4;
    String l5;
    String l6;
    String l7;
    String l8;
    String l9;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilephoto);
        this.i1 = (ImageButton) findViewById(R.id.imageButton1);
        this.i2 = (ImageButton) findViewById(R.id.imageButton22);
        this.i3 = (ImageButton) findViewById(R.id.imageButton33);
        this.i4 = (ImageButton) findViewById(R.id.imageButton44);
        this.i5 = (ImageButton) findViewById(R.id.imageButton55);
        this.i6 = (ImageButton) findViewById(R.id.imageButton66);
        this.i7 = (ImageButton) findViewById(R.id.imageButton77);
        this.i8 = (ImageButton) findViewById(R.id.imageButton88);
        this.i9 = (ImageButton) findViewById(R.id.imageButton109);
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(getResources().getColor(R.color.yellow));
        this.i1.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConnectivityManager manager = (ConnectivityManager) profilephoto.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activenetwork = manager.getActiveNetworkInfo();
                if (activenetwork != null) {
                    profilephoto.this.l1 = "https://firebasestorage.googleapis.com/v0/b/job-portal-app-ac291.appspot.com/o/1_jHCR_94Xae5KMtRgVb70jw.jpg?alt=media&token=9444e736-8d78-4655-9c7d-1a069c57e04f";
                    FirebaseDatabase.getInstance().getReference().child("users").child(FirebaseAuth.getInstance().getUid()).child("slink").setValue(profilephoto.this.l1).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override // com.google.android.gms.tasks.OnCompleteListener
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(profilephoto.this, "Profile pic uploaded successfully!", Toast.LENGTH_SHORT).show();
                                profilephoto.this.startActivity(new Intent(profilephoto.this, profile_edit.class));
                                return;
                            }
                            Toast.makeText(profilephoto.this, "Action failed!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    return;
                }
                Toast.makeText(profilephoto.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
        this.i2.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConnectivityManager manager = (ConnectivityManager) profilephoto.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activenetwork = manager.getActiveNetworkInfo();
                if (activenetwork != null) {
                    profilephoto.this.l2 = "https://firebasestorage.googleapis.com/v0/b/job-portal-app-ac291.appspot.com/o/femaleteacher.png?alt=media&token=65ed5be7-1e5d-46e8-8816-5c3f5dc238e8";
                    FirebaseDatabase.getInstance().getReference().child("users").child(FirebaseAuth.getInstance().getUid()).child("slink").setValue(profilephoto.this.l2).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override // com.google.android.gms.tasks.OnCompleteListener
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(profilephoto.this, "Profile pic uploaded successfully!", Toast.LENGTH_SHORT).show();
                                profilephoto.this.startActivity(new Intent(profilephoto.this, profile_edit.class));
                                return;
                            }
                            Toast.makeText(profilephoto.this, "Action failed!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    return;
                }
                Toast.makeText(profilephoto.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
        this.i3.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConnectivityManager manager = (ConnectivityManager) profilephoto.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activenetwork = manager.getActiveNetworkInfo();
                if (activenetwork != null) {
                    profilephoto.this.l3 = "https://firebasestorage.googleapis.com/v0/b/job-portal-app-ac291.appspot.com/o/teachers.png?alt=media&token=6b0a727f-121f-481d-8ff0-72ddf4e12b3f";
                    FirebaseDatabase.getInstance().getReference().child("users").child(FirebaseAuth.getInstance().getUid()).child("slink").setValue(profilephoto.this.l3).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override // com.google.android.gms.tasks.OnCompleteListener
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(profilephoto.this, "Profile pic uploaded successfully!", Toast.LENGTH_SHORT).show();
                                profilephoto.this.startActivity(new Intent(profilephoto.this, profile_edit.class));
                                return;
                            }
                            Toast.makeText(profilephoto.this, "Action failed!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    return;
                }
                Toast.makeText(profilephoto.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
        this.i4.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConnectivityManager manager = (ConnectivityManager) profilephoto.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activenetwork = manager.getActiveNetworkInfo();
                if (activenetwork != null) {
                    profilephoto.this.l4 = "https://firebasestorage.googleapis.com/v0/b/job-portal-app-ac291.appspot.com/o/male.png?alt=media&token=b45a0819-75ee-4d23-a2b6-18a9e8f4e083";
                    FirebaseDatabase.getInstance().getReference().child("users").child(FirebaseAuth.getInstance().getUid()).child("slink").setValue(profilephoto.this.l4).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override // com.google.android.gms.tasks.OnCompleteListener
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(profilephoto.this, "Profile pic uploaded successfully!", Toast.LENGTH_SHORT).show();
                                profilephoto.this.startActivity(new Intent(profilephoto.this, profile_edit.class));
                                return;
                            }
                            Toast.makeText(profilephoto.this, "Action failed!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    return;
                }
                Toast.makeText(profilephoto.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
        this.i5.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConnectivityManager manager = (ConnectivityManager) profilephoto.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activenetwork = manager.getActiveNetworkInfo();
                if (activenetwork != null) {
                    profilephoto.this.l5 = "https://firebasestorage.googleapis.com/v0/b/job-portal-app-ac291.appspot.com/o/boy.png?alt=media&token=87947337-8063-47f8-8f9f-75770f8cc7bd";
                    FirebaseDatabase.getInstance().getReference().child("users").child(FirebaseAuth.getInstance().getUid()).child("slink").setValue(profilephoto.this.l5).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override // com.google.android.gms.tasks.OnCompleteListener
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(profilephoto.this, "Profile pic uploaded successfully!", Toast.LENGTH_SHORT).show();
                                profilephoto.this.startActivity(new Intent(profilephoto.this, profile_edit.class));
                                return;
                            }
                            Toast.makeText(profilephoto.this, "Action failed!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    return;
                }
                Toast.makeText(profilephoto.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
        this.i6.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConnectivityManager manager = (ConnectivityManager) profilephoto.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activenetwork = manager.getActiveNetworkInfo();
                if (activenetwork != null) {
                    profilephoto.this.l6 = "https://firebasestorage.googleapis.com/v0/b/job-portal-app-ac291.appspot.com/o/woman.png?alt=media&token=115caddc-0c6b-4899-a8b7-68179155aff5";
                    FirebaseDatabase.getInstance().getReference().child("users").child(FirebaseAuth.getInstance().getUid()).child("slink").setValue(profilephoto.this.l6).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override // com.google.android.gms.tasks.OnCompleteListener
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(profilephoto.this, "Profile pic uploaded successfully!", Toast.LENGTH_SHORT).show();
                                profilephoto.this.startActivity(new Intent(profilephoto.this, profile_edit.class));
                                return;
                            }
                            Toast.makeText(profilephoto.this, "Action failed!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    return;
                }
                Toast.makeText(profilephoto.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
        this.i7.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConnectivityManager manager = (ConnectivityManager) profilephoto.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activenetwork = manager.getActiveNetworkInfo();
                if (activenetwork != null) {
                    profilephoto.this.l7 = "https://firebasestorage.googleapis.com/v0/b/job-portal-app-ac291.appspot.com/o/female.png?alt=media&token=7b835bb2-04fe-49c6-b35e-9966712a4962";
                    FirebaseDatabase.getInstance().getReference().child("users").child(FirebaseAuth.getInstance().getUid()).child("slink").setValue(profilephoto.this.l7).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override // com.google.android.gms.tasks.OnCompleteListener
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(profilephoto.this, "Profile pic uploaded successfully!", Toast.LENGTH_SHORT).show();
                                profilephoto.this.startActivity(new Intent(profilephoto.this, profile_edit.class));
                                return;
                            }
                            Toast.makeText(profilephoto.this, "Action failed!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    return;
                }
                Toast.makeText(profilephoto.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
        this.i8.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConnectivityManager manager = (ConnectivityManager) profilephoto.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activenetwork = manager.getActiveNetworkInfo();
                if (activenetwork != null) {
                    profilephoto.this.l8 = "https://firebasestorage.googleapis.com/v0/b/job-portal-app-ac291.appspot.com/o/student.png?alt=media&token=c23320ad-ea8c-4e5e-9b86-806200b37320";
                    FirebaseDatabase.getInstance().getReference().child("users").child(FirebaseAuth.getInstance().getUid()).child("slink").setValue(profilephoto.this.l8).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override // com.google.android.gms.tasks.OnCompleteListener
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(profilephoto.this, "Profile pic uploaded successfully!", Toast.LENGTH_SHORT).show();
                                profilephoto.this.startActivity(new Intent(profilephoto.this, profile_edit.class));
                                return;
                            }
                            Toast.makeText(profilephoto.this, "Action failed!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    return;
                }
                Toast.makeText(profilephoto.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
        this.i9.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConnectivityManager manager = (ConnectivityManager) profilephoto.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activenetwork = manager.getActiveNetworkInfo();
                if (activenetwork != null) {
                    profilephoto.this.l9 = "https://firebasestorage.googleapis.com/v0/b/job-portal-app-ac291.appspot.com/o/studentm.png?alt=media&token=5c3a9669-c03b-4ddc-8668-9e5395b250dd";
                    FirebaseDatabase.getInstance().getReference().child("users").child(FirebaseAuth.getInstance().getUid()).child("slink").setValue(profilephoto.this.l9).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override // com.google.android.gms.tasks.OnCompleteListener
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(profilephoto.this, "Profile pic uploaded successfully!", Toast.LENGTH_SHORT).show();
                                profilephoto.this.startActivity(new Intent(profilephoto.this, profile_edit.class));
                                return;
                            }
                            Toast.makeText(profilephoto.this, "Action failed!", Toast.LENGTH_SHORT).show();
                        }

                    });
                    return;
                }
                    Toast.makeText(profilephoto.this, "No Internet Connection", Toast.LENGTH_SHORT).show();


            }
        });
    }
}