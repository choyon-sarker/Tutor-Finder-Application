package com.example.porte_chai;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/* loaded from: classes3.dex */
public class homepage extends AppCompatActivity {
    EditText age;
    EditText city;
    EditText name;
    ProgressBar p1;
    EditText phone;
    ImageButton profpic;
    EditText skills;
    EditText street;
    Button submit;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        this.submit = (Button) findViewById(R.id.button3);
        this.name = (EditText) findViewById(R.id.editTextTextPersonName3);
        this.phone = (EditText) findViewById(R.id.editTextTextPersonName4);
        this.age = (EditText) findViewById(R.id.editTextTextPersonName7);
        this.skills = (EditText) findViewById(R.id.editTextTextPersonName6);
        this.street = (EditText) findViewById(R.id.editTextTextPersonName8);
        this.city = (EditText) findViewById(R.id.editTextTextPersonName5);

        this.p1 = (ProgressBar) findViewById(R.id.progressBar5);
        this.submit.setOnClickListener(new AnonymousClass1());
    }

    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ConnectivityManager manager = (ConnectivityManager) homepage.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activenetwork = manager.getActiveNetworkInfo();
            if (activenetwork != null) {
                if (homepage.this.name.length() < 2 || homepage.this.name.length() > 50) {
                    homepage.this.name.setError("Enter Proper Name");
                }
                if (homepage.this.phone.length() < 11 || homepage.this.phone.length() > 11) {
                    homepage.this.phone.setError("Enter 10 digit number");
                }
                if (homepage.this.age.length() < 1 || homepage.this.age.length() > 3) {
                    homepage.this.age.setError("Enter Proper Age");
                }
                if (homepage.this.skills.length() < 3 || homepage.this.skills.length() > 20) {
                    homepage.this.skills.setError("Enter Proper Skills");
                    return;
                }
                if (homepage.this.street.length() < 3 || homepage.this.street.length() > 40) {
                    homepage.this.street.setError("Enter Proper Address");
                }
                if (homepage.this.city.length() < 3 || homepage.this.city.length() > 20) {
                    homepage.this.city.setError("Enter Proper City");
                }

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(homepage.this);
                alertDialog.setTitle("Submit");
                alertDialog.setMessage("Is information correct?");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        homepage.this.p1.setVisibility(View.VISIBLE);
                        String sname = homepage.this.name.getText().toString();
                        String sphone = homepage.this.phone.getText().toString();
                        String sage = homepage.this.age.getText().toString();
                        String skilo = homepage.this.skills.getText().toString();
                        String sstreet = homepage.this.street.getText().toString();
                        String scity = homepage.this.city.getText().toString();

                        users u = new users(sname, sphone, sage, skilo, sstreet, scity, "https://firebasestorage.googleapis.com/v0/b/job-portal-app-ac291.appspot.com/o/1_jHCR_94Xae5KMtRgVb70jw.jpg?alt=media&token=9444e736-8d78-4655-9c7d-1a069c57e04f",
                               "https://firebasestorage.googleapis.com/v0/b/job-portal-app-ac291.appspot.com/o/3%20-%201%20-%20%E0%A6%95%E0%A6%A5%E0%A7%87%E0%A6%BE%E0%A6%AA%E0%A6%95%E0%A6%A5%E0%A6%A8%E0%A7%87%E0%A6%B0%20%E0%A6%B6%E0%A6%BE%E0%A6%B2%E0%A7%80%E0%A6%A8%E0%A6%A4%E0%A6%BE.mp4?alt=media&token=d7326f76-93c1-40a2-a86b-bd60653cacf1" );
                        FirebaseDatabase.getInstance().getReference().child("users").child(FirebaseAuth.getInstance().getUid()).setValue(u).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override // com.google.android.gms.tasks.OnCompleteListener
                            public void onComplete(Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(homepage.this, "Profile created!", Toast.LENGTH_SHORT).show();
                                    homepage.this.startActivity(new Intent(homepage.this, homepage2.class));
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
            Toast.makeText(homepage.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent(this, loginregister.class);
        startActivity(intent);
    }
}