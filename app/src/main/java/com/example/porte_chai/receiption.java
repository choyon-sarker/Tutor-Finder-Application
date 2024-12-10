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
public class receiption extends AppCompatActivity {
    private String abc;
    DatabaseReference acc2;
    prodata datap;
    private ValueEventListener eventListener;
    MyAdapter3 myadapter3;
    ArrayList<prodata> prolist3;
    RecyclerView recycle3;
    private DatabaseReference refrence3;
    private String userId;
    FirebaseUser vapar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiption);
        checkconnection();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView3);
        this.recycle3 = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.recycle3.setLayoutManager(new LinearLayoutManager(this));
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        this.vapar = currentUser;
        this.userId = currentUser.getUid();
        this.prolist3 = new ArrayList<>();
        MyAdapter3 myAdapter3 = new MyAdapter3(this, this.prolist3);
        this.myadapter3 = myAdapter3;
        this.recycle3.setAdapter(myAdapter3);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(this.userId + "taken");
        this.refrence3 = reference;
        reference.addValueEventListener(new ValueEventListener() {
            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot snapshot) {
                receiption.this.prolist3.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
                    prodata dete = (prodata) itemSnapshot.getValue(prodata.class);
                    receiption.this.prolist3.add(dete);
                }
                receiption.this.myadapter3.notifyDataSetChanged();
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