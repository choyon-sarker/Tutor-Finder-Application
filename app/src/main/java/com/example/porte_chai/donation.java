package com.example.porte_chai;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class donation extends AppCompatActivity {
    private String abc;
    DatabaseReference acc2;
    prodata datap;
    private ValueEventListener eventListener2;
    MyAdapter2 myadapter2;
    ArrayList<prodata> prolist2;
    RecyclerView recycle2;
    private DatabaseReference refrence2;
    private String userId;
    FirebaseUser vapar2;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        checkconnection();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        this.recycle2 = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.recycle2.setLayoutManager(new LinearLayoutManager(this));
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        this.vapar2 = currentUser;
        this.userId = currentUser.getUid();
        this.prolist2 = new ArrayList<>();
        MyAdapter2 myAdapter2 = new MyAdapter2(this, this.prolist2);
        this.myadapter2 = myAdapter2;
        this.recycle2.setAdapter(myAdapter2);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(this.userId + "given");
        this.refrence2 = reference;
        reference.addValueEventListener(new ValueEventListener() {
            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot snapshot) {
                donation.this.prolist2.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
                    prodata dete = (prodata) itemSnapshot.getValue(prodata.class);
                    donation.this.prolist2.add(dete);
                }
                donation.this.myadapter2.notifyDataSetChanged();
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError error) {
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent(this, slideactivity.class);
        startActivity(intent);
    }

    public void checkconnection() {
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activenetwork = manager.getActiveNetworkInfo();
        if (activenetwork == null) {
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }
}