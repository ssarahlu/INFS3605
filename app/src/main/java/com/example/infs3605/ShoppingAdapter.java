package com.example.infs3605;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605.Entities.Shopping;

import java.util.ArrayList;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ViewHolder>{

    private ArrayList<Shopping> mShoppingList;
    private Shopping mShopping;
    private RecyclerViewClickListener mListener;
    private Context context;

    public ShoppingAdapter(ArrayList<Shopping> shopping, RecyclerViewClickListener listener) {
        mShoppingList = shopping;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.shopping_list_item, parent, false);
        return new ViewHolder(view, mListener);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        mShopping = mShoppingList.get(position);

        holder.ivShoppingImage.setImageResource(mShopping.getShoppingImage());
        holder.tvShoppingCategory.setText(mShopping.getShoppingCategory());
        holder.tvShoppingName.setText(mShopping.getShoppingName());
        holder.tvShoppingPrice.setText("$" + Double.toString(mShopping.getShoppingPrice()));
    }

    @Override
    public int getItemCount() {
        return mShoppingList.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView ivShoppingImage;

        public TextView tvShoppingCategory;
        public TextView tvShoppingName;
        public TextView tvShoppingPrice;
        private RecyclerViewClickListener mListener;


        public ViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);

            mListener = listener;
            itemView.setOnClickListener(this);

            ivShoppingImage = itemView.findViewById(R.id.ivShoppingImage);
            tvShoppingCategory = itemView.findViewById(R.id.tvShoppingCategory);
            tvShoppingName = itemView.findViewById(R.id.tvShoppingName);
            tvShoppingPrice = itemView.findViewById(R.id.tvShoppingPrice);
        }

        @Override
        public void onClick(View v) {

        }

    }
}
