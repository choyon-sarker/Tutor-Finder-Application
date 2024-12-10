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
public class detailreceiption extends AppCompatActivity {
    DatabaseReference acc3;
    Button b1;

    String name = "";
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    TextView t7;
    private String userId;
    FirebaseUser vapar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailreceiption);
        this.t1 = (TextView) findViewById(R.id.tettextView1);
        this.t2 = (TextView) findViewById(R.id.tettextView2);
        this.t3 = (TextView) findViewById(R.id.tettextView3);
        this.t4 = (TextView) findViewById(R.id.tettextView4);
        this.t5 = (TextView) findViewById(R.id.tettextView5);
        this.t6 = (TextView) findViewById(R.id.tettextView6);
        this.t7 = (TextView) findViewById(R.id.tettextView7);
        this.b1 = (Button) findViewById(R.id.button7r);
        this.vapar = FirebaseAuth.getInstance().getCurrentUser();
        this.acc3 = FirebaseDatabase.getInstance().getReference(FirebaseAuth.getInstance().getUid() + "taken");
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
        this.name = this.t7.getText().toString();
        this.b1.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConnectivityManager manager = (ConnectivityManager) detailreceiption.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activenetwork = manager.getActiveNetworkInfo();
                if (activenetwork != null) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(detailreceiption.this);
                    alertDialog.setTitle("Delete");
                    alertDialog.setMessage("Are you sure you want to Delete Data?");
                    alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            detailreceiption.this.acc3.child(detailreceiption.this.name).removeValue();
                            Toast.makeText(detailreceiption.this, "Your Data is Deleted!", Toast.LENGTH_LONG).show();
                            detailreceiption.this.startActivity(new Intent(detailreceiption.this.getApplicationContext(), receiption.class));
                            detailreceiption.this.finish();
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
                Toast.makeText(detailreceiption.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}