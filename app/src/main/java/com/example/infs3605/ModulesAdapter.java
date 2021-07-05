package com.example.infs3605;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605.Entities.Modules;

import java.util.ArrayList;


public class ModulesAdapter extends RecyclerView.Adapter<ModulesAdapter.MyViewHolder> {
    private ArrayList<Modules> mModules;
    private RecyclerViewClickListener mListener;
    private Context context;
    private Modules mModule;
    private static final String TAG = "MyAdapter";

    public ModulesAdapter(ArrayList<Modules> modules, RecyclerViewClickListener listener){
        mModules = modules;
        mListener = listener;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //add textview for shit inside the cardview

        public TextView module, moduleSubtitle;

        private RecyclerViewClickListener mListener;

        public MyViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            mListener = listener;
            v.setOnClickListener(this);
            //add find view by id for shit inside card view

            module = v.findViewById(R.id.module);
            moduleSubtitle = v.findViewById(R.id.moduleSubtitle);

        }



        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }





    }

    @Override
    public ModulesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.module_list_row, parent, false);
        return new MyViewHolder(v, mListener);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

      //this is to fill the views

        mModule = mModules.get(position);
        holder.module.setText(mModule.getModuleName());
        holder.moduleSubtitle.setText(mModule.getModuleSubtitle());


    }


    @Override
    public int getItemCount() {
        return mModules.size();
    }


}

