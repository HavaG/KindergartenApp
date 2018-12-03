package hu.kindergartendeveloperteam.app.groupactivity.GroupFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import hu.kindergartendeveloperteam.app.groupactivity.R;
import io.swagger.client.model.Comment;

public class AnswerRecyclerViewAdapter extends RecyclerView.Adapter<AnswerRecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<String> mData;

    public AnswerRecyclerViewAdapter(Context mContext, List<String> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.post_answers_item,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.option.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private RadioButton option;

        public MyViewHolder(View itemView) {
            super(itemView);

            option = (RadioButton) itemView.findViewById(R.id.option);
        }
    }
}
