package com.example.infs3605;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.bumptech.glide.Glide;
import com.example.infs3605.Entities.Modules;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;


public class ModulesAdapter extends RecyclerView.Adapter<ModulesAdapter.MyViewHolder> {
    private ArrayList<Modules> mModules;
    private RecyclerViewClickListener mListener;
    private Context context;
    private Modules mModule;
    private static final String TAG = "ModulesAdapter";
    MyDatabase myDb;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String email;

    private boolean isVideoViewed, isStoryViewed, isLearningsViewed, isQuizViewed;


    public ModulesAdapter(ArrayList<Modules> modules, RecyclerViewClickListener listener){
        mModules = modules;
        mListener = listener;

    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView module, moduleSubtitle;
        public ImageView tick, modIV;

        private RecyclerViewClickListener mListener;

        public MyViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            mListener = listener;
            v.setOnClickListener(this);
            module = v.findViewById(R.id.module);
            moduleSubtitle = v.findViewById(R.id.moduleSubtitle);
            tick = v.findViewById(R.id.tick);
            modIV = v.findViewById(R.id.modIV);



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
        Glide.with(this.context).load(mModule.getModuleBackgroundImage()).into(holder.modIV);

        int partsCompleted = 0;

        email = user.getEmail();


        //checks whether the user has completed the module i.e. viewed all 4 components
        myDb = Room.databaseBuilder(context, MyDatabase.class, "my-db.db")
                .allowMainThreadQueries()
                .build();

        isVideoViewed = myDb.profileDataDao().getVideoViewed(email, mModule.getModuleId());
        isStoryViewed = myDb.profileDataDao().getStoryViewed(email, mModule.getModuleId());
        isLearningsViewed = myDb.profileDataDao().getLearningsViewed(email, mModule.getModuleId());
        isQuizViewed = myDb.profileDataDao().getQuizViewed(email, mModule.getModuleId());

        if (isVideoViewed == true && isStoryViewed == true && isLearningsViewed == true && isQuizViewed == true){
            holder.tick.setImageResource(R.drawable.viewed);

        } else if (isVideoViewed == true || isStoryViewed == true || isLearningsViewed == true || isQuizViewed == true){
            if (isVideoViewed == true){
                partsCompleted++;
            }
            if (isStoryViewed == true){
                partsCompleted++;
            }
            if (isLearningsViewed == true){
                partsCompleted++;
            }
            if (isQuizViewed == true){
                partsCompleted++;
            }

            if (partsCompleted == 1){
                holder.tick.setImageResource(R.drawable.one_quarter);
            } else if (partsCompleted == 2){
                holder.tick.setImageResource(R.drawable.two_quarter);
            } else if (partsCompleted == 3){
                holder.tick.setImageResource(R.drawable.three_quarter);

            }

        }


    }


    @Override
    public int getItemCount() {
        return mModules.size();
    }


}

