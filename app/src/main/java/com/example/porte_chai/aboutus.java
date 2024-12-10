package com.example.porte_chai;
import android.content.Context;
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
public class aboutus extends AppCompatActivity {

    DatabaseReference acc2;
    public String city;


    MessageAdapter myadapter;

    ArrayList<prodata> prolist4;

    public String userId,phonekey;
    FirebaseUser vapar;
    DatabaseReference refff ;
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkconnection();
        setContentView(R.layout.activity_aboutus);


        RecyclerView recyclerView = findViewById(R.id.message_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        prolist4 = new ArrayList<>();  // Initialize message list
        myadapter = new MessageAdapter(this,this.prolist4);
        recyclerView.setAdapter(myadapter);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        this.vapar = currentUser;
        this.userId = currentUser.getUid();
        this.acc2 = FirebaseDatabase.getInstance().getReference().child("users");



        this.refff=FirebaseDatabase.getInstance().getReference().child("users").child(userId);
        this.refff.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    phonekey = (String) dataSnapshot.child("sphone").getValue();

                    FirebaseDatabase refrence = FirebaseDatabase.getInstance();
                    refrence.getReference(phonekey+"Messages")
                            .addValueEventListener(new ValueEventListener() {
                                @Override // com.google.firebase.database.ValueEventListener
                                public void onDataChange(DataSnapshot snapshot) {
                                    aboutus.this.prolist4.clear();
                                    for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
                                        prodata dete = (prodata) itemSnapshot.getValue(prodata.class);
                                        aboutus.this.prolist4.add(dete);

                                    }
                                    aboutus.this.myadapter.notifyDataSetChanged();
                                }

                                @Override // com.google.firebase.database.ValueEventListener
                                public void onCancelled(DatabaseError error) {
                                }
                            });


                } else {

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




        ;




    }
    public void checkconnection() {
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activenetwork = manager.getActiveNetworkInfo();
        if (activenetwork == null) {
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }
}