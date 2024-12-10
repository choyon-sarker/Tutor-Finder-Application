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
public class MyAdapter extends RecyclerView.Adapter<productviewholder> {
    private Context pcontext;
    private List<prodata> prolist;

    public MyAdapter(Context pcontext, List<prodata> prolist) {
        this.pcontext = pcontext;
        this.prolist = prolist;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public productviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(this.pcontext).inflate(R.layout.cardiii, parent, false);
        return new productviewholder(mView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final productviewholder holder, int position) {
        holder.jtitle.setText(this.prolist.get(position).getJtitle());
        holder.jcity.setText(this.prolist.get(position).getJcity());
        holder.jsalary.setText(this.prolist.get(position).getJsalary());
        holder.jtime.setText(this.prolist.get(position).getJtime());
        holder.jdes.setText(this.prolist.get(position).getJdes());
        holder.jphone.setText(this.prolist.get(position).getJnumber());
        holder.jkey.setText(this.prolist.get(position).getJkey());
        holder.jccard.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(MyAdapter.this.pcontext, detailtake.class);
                intent.putExtra("Title", ((prodata) MyAdapter.this.prolist.get(holder.getAdapterPosition())).getJtitle());
                intent.putExtra("City", ((prodata) MyAdapter.this.prolist.get(holder.getAdapterPosition())).getJcity());
                intent.putExtra("Salary", ((prodata) MyAdapter.this.prolist.get(holder.getAdapterPosition())).getJsalary());
                intent.putExtra("Time", ((prodata) MyAdapter.this.prolist.get(holder.getAdapterPosition())).getJtime());
                intent.putExtra("Des", ((prodata) MyAdapter.this.prolist.get(holder.getAdapterPosition())).getJdes());
                intent.putExtra("Phone", ((prodata) MyAdapter.this.prolist.get(holder.getAdapterPosition())).getJnumber());
                intent.putExtra("Key", ((prodata) MyAdapter.this.prolist.get(holder.getAdapterPosition())).getJkey());
                MyAdapter.this.pcontext.startActivity(intent);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.prolist.size();
    }

    public void filteredlist(ArrayList<prodata> filterlist) {
        this.prolist = filterlist;
        notifyDataSetChanged();
    }
}
class productviewholder extends RecyclerView.ViewHolder {
    CardView jccard;
    TextView jcity;
    TextView jdes;
    TextView jkey;
    TextView jphone;
    TextView jsalary;
    TextView jtime;
    TextView jtitle;

    public productviewholder(View itemView) {
        super(itemView);
        this.jtitle = (TextView) itemView.findViewById(R.id.jTitleTextView);
        this.jcity = (TextView) itemView.findViewById(R.id.jCityTextView);
        this.jsalary = (TextView) itemView.findViewById(R.id.jSalaryTextView);
        this.jtime = (TextView) itemView.findViewById(R.id.jTimeTextView);
        this.jdes = (TextView) itemView.findViewById(R.id.jDesTextView);
        this.jphone = (TextView) itemView.findViewById(R.id.jPhoneTextView);
        this.jkey = (TextView) itemView.findViewById(R.id.jKeyTextView);
        this.jccard = (CardView) itemView.findViewById(R.id.mycard);
    }
}
