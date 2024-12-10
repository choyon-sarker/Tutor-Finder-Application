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
public class MyAdapter3 extends RecyclerView.Adapter<productviewholder3> {
    private Context pcontext3;
    private List<prodata> prolist3;

    public MyAdapter3(Context pcontext3, List<prodata> prolist3) {
        this.pcontext3 = pcontext3;
        this.prolist3 = prolist3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public productviewholder3 onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.receiptionxml, parent, false);
        return new productviewholder3(mView3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final productviewholder3 holder, int position) {
        holder.jtitle.setText(this.prolist3.get(position).getJtitle());
        holder.jcity.setText(this.prolist3.get(position).getJcity());
        holder.jsalary.setText(this.prolist3.get(position).getJsalary());
        holder.jtime.setText(this.prolist3.get(position).getJtime());
        holder.jdes.setText(this.prolist3.get(position).getJdes());
        holder.jphone.setText(this.prolist3.get(position).getJnumber());
        holder.jkey.setText(this.prolist3.get(position).getJkey());
        holder.jccard.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(MyAdapter3.this.pcontext3, detailreceiption.class);
                intent.putExtra("Title", ((prodata) MyAdapter3.this.prolist3.get(holder.getAdapterPosition())).getJtitle());
                intent.putExtra("City", ((prodata) MyAdapter3.this.prolist3.get(holder.getAdapterPosition())).getJcity());
                intent.putExtra("Salary", ((prodata) MyAdapter3.this.prolist3.get(holder.getAdapterPosition())).getJsalary());
                intent.putExtra("Time", ((prodata) MyAdapter3.this.prolist3.get(holder.getAdapterPosition())).getJtime());
                intent.putExtra("Des", ((prodata) MyAdapter3.this.prolist3.get(holder.getAdapterPosition())).getJdes());
                intent.putExtra("Phone", ((prodata) MyAdapter3.this.prolist3.get(holder.getAdapterPosition())).getJnumber());
                intent.putExtra("Key", ((prodata) MyAdapter3.this.prolist3.get(holder.getAdapterPosition())).getJkey());
                MyAdapter3.this.pcontext3.startActivity(intent);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.prolist3.size();
    }

    public void filteredlist(ArrayList<prodata> filterlist) {
        this.prolist3 = filterlist;
        notifyDataSetChanged();
    }
}
class productviewholder3 extends RecyclerView.ViewHolder {
    CardView jccard;
    TextView jcity;
    TextView jdes;
    TextView jkey;
    TextView jphone;
    TextView jsalary;
    TextView jtime;
    TextView jtitle;

    public productviewholder3(View itemView) {
        super(itemView);
        this.jtitle = (TextView) itemView.findViewById(R.id.jTitleTextViewre);
        this.jcity = (TextView) itemView.findViewById(R.id.jCityTextViewre);
        this.jsalary = (TextView) itemView.findViewById(R.id.jSalaryTextViewre);
        this.jtime = (TextView) itemView.findViewById(R.id.jTimeTextViewre);
        this.jdes = (TextView) itemView.findViewById(R.id.jDesTextViewre);
        this.jphone = (TextView) itemView.findViewById(R.id.jPhoneTextViewre);
        this.jkey = (TextView) itemView.findViewById(R.id.jKeyTextViewre);
        this.jccard = (CardView) itemView.findViewById(R.id.mycardre);
    }
}

