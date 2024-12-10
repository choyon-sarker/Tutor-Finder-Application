package com.example.porte_chai;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.text.DateFormat;
import java.util.Calendar;

/* loaded from: classes3.dex */
public class upload extends AppCompatActivity {
    private static final int PICK_IMAGE = 1;
    DatabaseReference acc2;
    DatabaseReference acc3;
    private String anurag;
    FirebaseAuth au;
    public Button donate;
    Uri imageUri;
    String imageUrl;
    String imageUrlg;
    public EditText jjcity;
    public EditText jjdesc;
    public EditText jjsalary;
    public EditText jphone;
    public EditText jtime;
    public EditText jtitle;
    String mel;
    ProgressBar p1;
    String photochilink;
    TextView photolink;
    TextView textView;
    private String userId;
    FirebaseUser vapar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(getResources().getColor(R.color.yellow));
        setContentView(R.layout.activity_upload);
        this.p1 = (ProgressBar) findViewById(R.id.progressBar11);
        this.jphone = (EditText) findViewById(R.id.editTextTextPhone);
        this.jtitle = (EditText) findViewById(R.id.editTextTextPersonName9);
        this.jjcity = (EditText) findViewById(R.id.editTextTextPersonName12);
        this.jjdesc = (EditText) findViewById(R.id.editTextTextPersonName10);
        this.jjsalary = (EditText) findViewById(R.id.editTextTextPersonName11);
        this.jtime = (EditText) findViewById(R.id.timePicker);
        this.donate = (Button) findViewById(R.id.button4);
        this.vapar = FirebaseAuth.getInstance().getCurrentUser();
        this.acc2 = FirebaseDatabase.getInstance().getReference().child("users");
        this.acc3 = FirebaseDatabase.getInstance().getReference().child("users");
        this.au = FirebaseAuth.getInstance();
        this.userId = this.vapar.getUid();
        this.acc2.child(FirebaseAuth.getInstance().getUid()).addValueEventListener(new ValueEventListener() {
            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot snapshot) {
                users profile = (users) snapshot.getValue(users.class);
                upload.this.imageUrl = profile.sphone;
                upload.this.jphone.setText(upload.this.imageUrl);
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError error) {
            }
        });
        this.donate.setOnClickListener(new AnonymousClass2());
    }

    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ConnectivityManager manager = (ConnectivityManager) upload.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activenetwork = manager.getActiveNetworkInfo();
            if (activenetwork != null) {
                if (upload.this.jtitle.length() < 2 || upload.this.jtitle.length() > 50) {
                    upload.this.jtitle.setError("Enter Proper Job Name");
                }
                if (upload.this.jjcity.length() < 2 || upload.this.jjcity.length() > 30) {
                    upload.this.jjcity.setError("Enter Proper City");
                }
                if (upload.this.jphone.length() != 10) {
                    upload.this.jjcity.setError("Enter Proper Phone number");
                }
                if (upload.this.jjsalary.length() < 3 || upload.this.jjsalary.length() > 7) {
                    upload.this.jjsalary.setError("Enter Proper Salary");
                }
                if (upload.this.jtime.length() != 5 ) {
                    upload.this.jtime.setError("Enter Proper Time Like This: 10:00");
                }
                if (upload.this.jjdesc.length() < 3 || upload.this.jjdesc.length() > 80) {
                    upload.this.jjdesc.setError("Enter Proper Description");
                    return;
                }
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(upload.this);
                alertDialog.setTitle("Submit");
                alertDialog.setMessage("Is information correct?");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        upload.this.p1.setVisibility(View.VISIBLE);
                        String jname = upload.this.jtitle.getText().toString();
                        String jcity = upload.this.jjcity.getText().toString();
                        String jclock = upload.this.jtime.getText().toString();
                        String jsalary = upload.this.jjsalary.getText().toString();
                        String jdesc = upload.this.jjdesc.getText().toString();
                        final String jkey = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
                        String pstr = upload.this.jphone.getText().toString();
                        final prodata p = new prodata(pstr, jkey, jname, jcity, jclock, jsalary, jdesc);
                        FirebaseDatabase.getInstance().getReference().child("city").child(jkey).setValue(p).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override // com.google.android.gms.tasks.OnCompleteListener
                            public void onComplete(Task<Void> task) {
                                if (task.isSuccessful()) {
                                    FirebaseDatabase.getInstance().getReference().child(upload.this.userId + "given").child(jkey).setValue(p);
                                    Toast.makeText(upload.this, "Job is Online!", Toast.LENGTH_SHORT).show();
                                    upload.this.startActivity(new Intent(upload.this, homepage2.class));
                                }
                            }
                        });
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
            Toast.makeText(upload.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }
}