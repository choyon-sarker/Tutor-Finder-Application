package com.example.porte_chai;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class homepage2 extends AppCompatActivity {
    private String abc;
    DatabaseReference acc2;
    public String city;
    private ValueEventListener eventListener;
    public CircleImageView f1;
    CircleImageView i1;
    MyAdapter myadapter;
    ProgressBar p1;
    ArrayList<prodata> prolist;
    RecyclerView recycle;
    DatabaseReference refrence;
    CircleImageView slide;
    TextView t1;
    EditText txt;
    EditText txt2;
    private String userId;
    FirebaseUser vapar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkconnection();
        setContentView(R.layout.activity_homepage2);
        this.f1 = (CircleImageView) findViewById(R.id.floatingActionButton);
        this.txt = (EditText) findViewById(R.id.search);
        this.txt2 = (EditText) findViewById(R.id.searchcity);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.recycle = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.recycle.setLayoutManager(new LinearLayoutManager(this));
        this.p1 = (ProgressBar) findViewById(R.id.progressBar61);
        this.slide = (CircleImageView) findViewById(R.id.imageButton9);
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        this.vapar = currentUser;
        this.userId = currentUser.getUid();
        this.acc2 = FirebaseDatabase.getInstance().getReference().child("users");
        this.prolist = new ArrayList<>();
        MyAdapter myAdapter = new MyAdapter(this, this.prolist);
        this.myadapter = myAdapter;
        this.recycle.setAdapter(myAdapter);
        this.acc2.child(this.userId).addValueEventListener(new ValueEventListener() {
            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot snapshot) {
                users profile = (users) snapshot.getValue(users.class);
                assert profile != null;
                homepage2.this.abc = profile.slink;
                Glide.with((FragmentActivity) homepage2.this).load(homepage2.this.abc).into(homepage2.this.slide);
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError error) {
            }
        });
        this.refrence = FirebaseDatabase.getInstance().getReference("city");
        this.f1.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                homepage2.this.startActivity(new Intent(homepage2.this, upload.class));
            }
        });
        this.refrence.addValueEventListener(new ValueEventListener() {
            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot snapshot) {
                homepage2.this.prolist.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
                    prodata dete = (prodata) itemSnapshot.getValue(prodata.class);
                    homepage2.this.prolist.add(dete);
                    homepage2.this.p1.setVisibility(View.INVISIBLE);
                }
                homepage2.this.myadapter.notifyDataSetChanged();
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError error) {
            }
        });
        this.txt.addTextChangedListener(new TextWatcher() {
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                homepage2.this.filter(editable.toString());
            }
        });
        this.txt2.addTextChangedListener(new TextWatcher() {
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                homepage2.this.filter2(editable.toString());
            }
        });
        this.slide.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                homepage2.this.startActivity(new Intent(homepage2.this, slideactivity.class));
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(homepage2.this);
        alertDialog.setTitle("Exit");
        alertDialog.setMessage("Do you really want to exit app ?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                homepage2.this.finish();
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.HOME");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                homepage2.this.startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });


        alertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void filter(String text) {
        ArrayList<prodata> filterlist = new ArrayList<>();
        Iterator<prodata> it = this.prolist.iterator();
        while (it.hasNext()) {
            prodata item = it.next();
            if (item.getJtitle().toLowerCase().contains(text.toLowerCase())) {
                filterlist.add(item);
            }
        }
        this.myadapter.filteredlist(filterlist);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void filter2(String text) {
        ArrayList<prodata> filterlist2 = new ArrayList<>();
        Iterator<prodata> it = this.prolist.iterator();
        while (it.hasNext()) {
            prodata item = it.next();
            if (item.getJcity().toLowerCase().contains(text.toLowerCase())) {
                filterlist2.add(item);
            }
        }
        this.myadapter.filteredlist(filterlist2);
    }

    public void checkconnection() {
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activenetwork = manager.getActiveNetworkInfo();
        if (activenetwork == null) {
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }
}
