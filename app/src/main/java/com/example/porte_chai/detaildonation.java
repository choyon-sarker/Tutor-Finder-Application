package com.example.porte_chai;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/* loaded from: classes3.dex */
public class detaildonation extends AppCompatActivity {
    DatabaseReference acc2;
    DatabaseReference acc3;
    DatabaseReference acc4;
    Button b1;
    String ke2;
    String ke3;
    String name = "";
    String st;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    TextView t7;
    String userId;
    FirebaseUser vapar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaildonation);
        this.t1 = (TextView) findViewById(R.id.dettextView1);
        this.t2 = (TextView) findViewById(R.id.dettextView2);
        this.t3 = (TextView) findViewById(R.id.dettextView3);
        this.t4 = (TextView) findViewById(R.id.dettextView4);
        this.t5 = (TextView) findViewById(R.id.dettextView5);
        this.t6 = (TextView) findViewById(R.id.dettextView6);
        this.t7 = (TextView) findViewById(R.id.dettextView7);
        this.b1 = (Button) findViewById(R.id.button7d);
        this.vapar = FirebaseAuth.getInstance().getCurrentUser();
        this.acc2 = FirebaseDatabase.getInstance().getReference().child("users");
        this.acc3 = FirebaseDatabase.getInstance().getReference(FirebaseAuth.getInstance().getUid() + "given");
        this.acc4 = FirebaseDatabase.getInstance().getReference("city");
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
        }
        String obj = this.t7.getText().toString();
        this.name = obj;
        this.st = obj.toString();
        this.b1.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConnectivityManager manager = (ConnectivityManager) detaildonation.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activenetwork = manager.getActiveNetworkInfo();
                if (activenetwork != null) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(detaildonation.this);
                    alertDialog.setTitle("Delete");
                    alertDialog.setMessage("Are you sure you want to Delete Donation?");
                    alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            detaildonation.this.acc3.child(detaildonation.this.name).removeValue();
                            Toast.makeText(detaildonation.this, "Your Donation has been Deleted!", Toast.LENGTH_LONG).show();
                            detaildonation.this.startActivity(new Intent(detaildonation.this.getApplicationContext(), donation.class));
                            detaildonation.this.delete2();
                            detaildonation.this.finish();
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
                Toast.makeText(detaildonation.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void delete2() {
        this.acc4.child(this.name).removeValue();
        Toast.makeText(this, "Your Donation has been Deleted!", Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(), donation.class));
        finish();
    }
}