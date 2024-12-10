package com.example.porte_chai;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

/* loaded from: classes3.dex */
public class detailtake extends AppCompatActivity {
    DatabaseReference acc2;
    Button b1,appapply;
    String ke2;
    String ke3;
    String phone;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    TextView t7;

    private String userId;
    FirebaseUser vapar;
    String MyVideo,MyName,MyPhone,MyAge,MySkill,MyCity;


    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailtake);
        this.t1 = (TextView) findViewById(R.id.jobTitleTextViewq);
        this.t2 = (TextView) findViewById(R.id.locationTextViewq);
        this.t3 = (TextView) findViewById(R.id.salaryTextViewq);
        this.t4 = (TextView) findViewById(R.id.timeTextViewq);
        this.t5 = (TextView) findViewById(R.id.descriptionTextViewq);
        this.t6 = (TextView) findViewById(R.id.phoneTextViewq);
        this.t7 = (TextView) findViewById(R.id.keyTextViewq);
        this.b1 = (Button) findViewById(R.id.applyNowButtonq);
        this.appapply = (Button) findViewById(R.id.appbutton7) ;
        this.vapar = FirebaseAuth.getInstance().getCurrentUser();
        this.acc2 = FirebaseDatabase.getInstance().getReference().child("users");
        this.userId = this.vapar.getUid();
        Bundle mbundle = getIntent().getExtras();
        if (mbundle != null) {
            this.t1.setText(mbundle.getString("Title"));
            this.t2.setText(mbundle.getString("City"));
            this.t3.setText(mbundle.getString("Salary"));
            this.t4.setText(mbundle.getString("Time"));
            this.t5.setText(mbundle.getString("Des"));
            this.t6.setText(mbundle.getString("Phone"));
            this.t7.setText(mbundle.getString("Key"));
            this.ke2 = mbundle.getString("Phone");
            this.ke3 = mbundle.getString("Key");
        }
        this.acc2.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called whenever the data changes
                if (dataSnapshot.exists()) {
                    // Extract the data
                    MyVideo = (String) dataSnapshot.child("svideoIntro").getValue();
                    MyName = (String) dataSnapshot.child("sname").getValue();
                    MyPhone = (String) dataSnapshot.child("sphone").getValue();
                    MyAge = (String) dataSnapshot.child("sage").getValue();
                    MySkill = (String) dataSnapshot.child("skilo").getValue();
                    MyCity = (String) dataSnapshot.child("scity").getValue();


                    // Update your UI or perform actions with the retrieved data
                    // (e.g., display marks, phone, or salary in TextViews)
                } else {
                    // Handle the case where data doesn't exist
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle errors during data retrieval
            }
        });
        this.appapply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ConnectivityManager manager = (ConnectivityManager) detailtake.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activenetwork = manager.getActiveNetworkInfo();
                if (activenetwork != null) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(detailtake.this);
                    alertDialog.setTitle("Apply");
                    alertDialog.setMessage("Want to send your Information to Employer? Information Includes Your Name, Number, Age, Intro Video, City, Skill");
                    alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            Date date = new Date();
                            int hours = date.getHours();
                            int minutes = date.getMinutes();
                            int seconds = date.getSeconds();
                            long milliseconds = date.getTime(); // Gets milliseconds since Jan 1, 1970, 00:00:00 GMT

                            // Build the String without separators
                            String key = "date" + hours + minutes + seconds + milliseconds;
                            prodata p = new prodata( MyAge,MyVideo, MyName, MyPhone, MySkill, MyCity, t1.getText().toString());
                            FirebaseDatabase.getInstance().getReference().child(t6.getText().toString() + "Messages").child(MyPhone).setValue(p);

                            String jname = detailtake.this.t1.getText().toString();
                            String jcity = detailtake.this.t2.getText().toString();
                            String jclock = detailtake.this.t4.getText().toString();
                            String jsalary = detailtake.this.t3.getText().toString();
                            String jdesc = detailtake.this.t5.getText().toString();
                            String ph = detailtake.this.t6.getText().toString();
                            String ke = detailtake.this.t7.getText().toString();
                            prodata p2 = new prodata(ph, ke, jname, jcity, jclock, jsalary, jdesc);
                            FirebaseDatabase.getInstance().getReference().child(detailtake.this.userId + "taken").child(ke).setValue(p2);
                            Toast.makeText(detailtake.this, "User got Your Information, You will be Contacted!", Toast.LENGTH_LONG).show();
                            detailtake.this.startActivity(new Intent(detailtake.this, homepage2.class));
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
                Toast.makeText(detailtake.this, "No Internet Connection", Toast.LENGTH_SHORT).show();

            }
        });
        this.b1.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConnectivityManager manager = (ConnectivityManager) detailtake.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activenetwork = manager.getActiveNetworkInfo();
                if (activenetwork != null) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(detailtake.this);
                    alertDialog.setTitle("Message on WhatsApp");
                    alertDialog.setMessage("Are you sure you want to Message?");
                    alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            String jname = detailtake.this.t1.getText().toString();
                            String jcity = detailtake.this.t2.getText().toString();
                            String jclock = detailtake.this.t4.getText().toString();
                            String jsalary = detailtake.this.t3.getText().toString();
                            String jdesc = detailtake.this.t5.getText().toString();
                            String ph = detailtake.this.t6.getText().toString();
                            String ke = detailtake.this.t7.getText().toString();
                            prodata p = new prodata(ph, ke, jname, jcity, jclock, jsalary, jdesc);
                            FirebaseDatabase.getInstance().getReference().child(detailtake.this.userId + "taken").child(ke).setValue(p);
                            Log.d("Debug", "Message content: Hello, this is my WhatsApp message.");
                            Uri uri = Uri.parse("smsto:" + ph);
                            Intent sendIntent = new Intent("android.intent.action.SENDTO", uri);
                            sendIntent.setPackage("com.whatsapp");
                            sendIntent.putExtra("sms_body", "Hello, this is my WhatsApp message.");
                            try {
                                detailtake.this.startActivity(sendIntent);
                            } catch (ActivityNotFoundException e) {
                                Toast.makeText(detailtake.this, "Please install WhatsApp", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(detailtake.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}