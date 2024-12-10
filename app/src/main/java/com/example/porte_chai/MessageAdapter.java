package com.example.porte_chai;

 // Replace with your package name

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<productviewholder4> {
    private Context pcontext4;
    private List<prodata> prolist4;

    public MessageAdapter(Context pcontext4, List<prodata> prolist4) {
        this.pcontext4 = pcontext4;
        this.prolist4 = prolist4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public productviewholder4 onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(this.pcontext4).inflate(R.layout.messagecard, parent, false);
        return new productviewholder4(mView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final productviewholder4 holder, int position) {
        holder.nameTextView.setText(this.prolist4.get(position).getJdes()+" Application");
        holder.numberTextView.setText(this.prolist4.get(position).getJcity());
        holder.text1TextView.setText(this.prolist4.get(position).getJtitle());
        holder.text2TextView.setText(this.prolist4.get(position).getJtime());
        holder.text3TextView.setText(this.prolist4.get(position).getJnumber());
        holder.text4TextView.setText(this.prolist4.get(position).getJsalary());
        Uri videoUri = Uri.parse(this.prolist4.get(position).getJkey());
        holder.mcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.videoView.setVideoURI(videoUri);
                holder.videoView.start();

            }
        });
        holder.call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String phoneNumber = holder.numberTextView.getText().toString();  // Assuming number is stored in message
                        Toast.makeText(pcontext4, phoneNumber, Toast.LENGTH_SHORT).show();
                        if (phoneNumber != null) {
                            // Create an intent to dial the phone number
                            Intent intent = new Intent(Intent.ACTION_DIAL);
                            intent.setData(Uri.parse("tel:" + phoneNumber));
                            pcontext4.startActivity(intent);
                        } else {
                            Toast.makeText(pcontext4, "Phone number not available", Toast.LENGTH_SHORT).show();
                        }
                    }
                });





    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.prolist4.size();
    }

    public void filteredlist(ArrayList<prodata> filterlist) {
        this.prolist4 = filterlist;
        notifyDataSetChanged();
    }

}

     class productviewholder4 extends RecyclerView.ViewHolder {

        VideoView videoView;
       TextView nameTextView;
        TextView numberTextView;
        TextView text1TextView;
        TextView text2TextView;
         TextView text3TextView;
        TextView text4TextView;

         CardView mcard;
         Button call;

        public productviewholder4(@NonNull View itemView) {
            super(itemView);

            this.videoView = itemView.findViewById(R.id.message_video);
            this.nameTextView = itemView.findViewById(R.id.message_name);
            this.numberTextView = itemView.findViewById(R.id.message_number);
            this.text1TextView = itemView.findViewById(R.id.message_text1);
            this.text2TextView = itemView.findViewById(R.id.message_text2);
            this.text3TextView = itemView.findViewById(R.id.message_text3);
            this.text4TextView = itemView.findViewById(R.id.message_text4);
            this.mcard = (CardView) itemView.findViewById(R.id.video_card);
            this.call = (Button) itemView.findViewById(R.id.callButton);
        }

    }

