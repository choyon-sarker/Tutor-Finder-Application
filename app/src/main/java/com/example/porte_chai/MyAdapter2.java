package com.example.porte_chai;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class MyAdapter2 extends RecyclerView.Adapter<productviewholder2> {
    private Context pcontext2;
    private List<prodata> prolist2;

    public MyAdapter2(Context pcontext2, List<prodata> prolist2) {
        this.pcontext2 = pcontext2;
        this.prolist2 = prolist2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public productviewholder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.donationxml, parent, false);
        return new productviewholder2(mView2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final productviewholder2 holder, int position) {
        holder.jtitle.setText(this.prolist2.get(position).getJtitle());
        holder.jcity.setText(this.prolist2.get(position).getJcity());
        holder.jsalary.setText(this.prolist2.get(position).getJsalary());
        holder.jtime.setText(this.prolist2.get(position).getJtime());
        holder.jdes.setText(this.prolist2.get(position).getJdes());
        holder.jphone.setText(this.prolist2.get(position).getJnumber());
        holder.jkey.setText(this.prolist2.get(position).getJkey());
        holder.jccard.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(MyAdapter2.this.pcontext2, detaildonation.class);
                intent.putExtra("Title", ((prodata) MyAdapter2.this.prolist2.get(holder.getAdapterPosition())).getJtitle());
                intent.putExtra("City", ((prodata) MyAdapter2.this.prolist2.get(holder.getAdapterPosition())).getJcity());
                intent.putExtra("Salary", ((prodata) MyAdapter2.this.prolist2.get(holder.getAdapterPosition())).getJsalary());
                intent.putExtra("Time", ((prodata) MyAdapter2.this.prolist2.get(holder.getAdapterPosition())).getJtime());
                intent.putExtra("Des", ((prodata) MyAdapter2.this.prolist2.get(holder.getAdapterPosition())).getJdes());
                intent.putExtra("Phone", ((prodata) MyAdapter2.this.prolist2.get(holder.getAdapterPosition())).getJnumber());
                intent.putExtra("Key", ((prodata) MyAdapter2.this.prolist2.get(holder.getAdapterPosition())).getJkey());
                MyAdapter2.this.pcontext2.startActivity(intent);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.prolist2.size();
    }

    public void filteredlist2(ArrayList<prodata> filterlist2) {
        this.prolist2 = filterlist2;
        notifyDataSetChanged();
    }
}


/* compiled from: MyAdapter2.java */
/* loaded from: classes3.dex */
class productviewholder2 extends RecyclerView.ViewHolder {
    CardView jccard;
    TextView jcity;
    TextView jdes;
    TextView jkey;
    TextView jphone;
    TextView jsalary;
    TextView jtime;
    TextView jtitle;

    public productviewholder2(View itemView) {
        super(itemView);
        this.jtitle = (TextView) itemView.findViewById(R.id.jTitleTextViewgi);
        this.jcity = (TextView) itemView.findViewById(R.id.jCityTextViewgi);
        this.jsalary = (TextView) itemView.findViewById(R.id.jSalaryTextViewgi);
        this.jtime = (TextView) itemView.findViewById(R.id.jTimeTextViewgi);
        this.jdes = (TextView) itemView.findViewById(R.id.jDesTextViewgi);
        this.jphone = (TextView) itemView.findViewById(R.id.jPhoneTextViewgi);
        this.jkey = (TextView) itemView.findViewById(R.id.jKeyTextViewgi);
        this.jccard = (CardView) itemView.findViewById(R.id.mycardgi);
    }
}
