package hu.kindergartendeveloperteam.app.groupactivity.GroupFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.Test_classes.Person_test;
import hu.kindergartendeveloperteam.app.groupactivity.R;
import io.swagger.client.model.User;

public class ParentsFragment extends Fragment {

    View v;
    private RecyclerView myRecycleView;
    private List<User> Parents;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Parents = new ArrayList<>();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.parents_fragment, container, false);
        myRecycleView = (RecyclerView) v.findViewById(R.id.parentsRecycleView);
        UserRecyclerViewAdapter recycleAdapter = new UserRecyclerViewAdapter(getContext(),Parents);
        myRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecycleView.setAdapter(recycleAdapter);
        return v;
    }
}
