package com.example.recyclerview_test1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Icon_RecyclerViewAdapter extends RecyclerView.Adapter<Icon_RecyclerViewAdapter.Icon_ViewHolder>{
    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    ArrayList<IconListModel> iconListArray;

    public Icon_RecyclerViewAdapter(RecyclerViewInterface recyclerViewInterface, Context context, ArrayList<IconListModel> iconListArray) {
        this.recyclerViewInterface = recyclerViewInterface;
        this.context = context;
        this.iconListArray = iconListArray;
    }

    @NonNull
    @Override
    public Icon_RecyclerViewAdapter.Icon_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //RecyclerView calls this method whenever it needs to create a new viewHolder, but data not yet be bound with.
        //Create a new view, which defines the UI of the list item
        //This is where you inflate the layout (giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent,false);//inflate function:input layout xml return a view/view group
        return new Icon_RecyclerViewAdapter.Icon_ViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Icon_RecyclerViewAdapter.Icon_ViewHolder holder, int position) {
        //RecyclerView calls this method to associate a ViewHolder with data.
        //Assigning values to the views we created in the recycler_view_row layout file
        //Based on the position of the recycler view
        holder.tvShort.setText(iconListArray.get(position).getIconShort());
        holder.tvName.setText(iconListArray.get(position).getIconName());
        holder.tvNumber.setText(iconListArray.get(position).getIconNumber());
        holder.ivIcon.setImageResource(iconListArray.get(position).getIconImage());
    }

    @Override
    public int getItemCount() {
        //return the size of your dataset
        //The recycler view just wants to know the number of items you want to display
        return iconListArray.size();
    }

    //Provide a reference to the type of views that you are using
    public static class Icon_ViewHolder extends RecyclerView.ViewHolder{
        //Grabbing the views from our recycler_view_row layout file
        //kinda like in the onCreate method
        //for here: 1*imageView + 3*TextView
        ImageView ivIcon;
        TextView tvName,tvShort,tvNumber;

        public Icon_ViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            ivIcon = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.textView1);
            tvNumber = itemView.findViewById(R.id.textView2);
            tvShort = itemView.findViewById(R.id.textView3);

            //attach an onCLickListener to itemView
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        //grab the position from adapter
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });

        }
    }
}
