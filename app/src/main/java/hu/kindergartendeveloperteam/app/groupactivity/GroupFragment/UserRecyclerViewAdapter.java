package hu.kindergartendeveloperteam.app.groupactivity.GroupFragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import hu.kindergartendeveloperteam.app.groupactivity.MessageActivity;
import hu.kindergartendeveloperteam.app.groupactivity.MessengerActivity;
import hu.kindergartendeveloperteam.app.groupactivity.R;
import io.swagger.client.model.KindergartenUser;
import io.swagger.client.model.User;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<KindergartenUser> mData;
    boolean onlyMessage;

    public UserRecyclerViewAdapter(Context mContext, List<KindergartenUser> mData, boolean onlyMessage) {
        this.mContext = mContext;
        this.mData = mData;
        this.onlyMessage = onlyMessage;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.group_person_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_name.setText(mData.get(position).getName());

        if (onlyMessage) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(mContext, MessageActivity.class);
                    i.putExtra(MessageActivity.USER_ID, mData.get(position).getId());
                    mContext.startActivity(i);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_name;
        private View mainView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mainView = itemView;
            tv_name = (TextView) itemView.findViewById(R.id.item_name);
        }
    }
}