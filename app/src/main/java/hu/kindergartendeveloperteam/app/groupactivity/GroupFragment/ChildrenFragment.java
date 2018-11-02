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

public class ChildrenFragment extends Fragment {

    View v;
    private RecyclerView myRecycleView;
    private List<Person_test> Children;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Children = new ArrayList<>();

        //Groupban levő gyerek lista feltöltése
        Children.add(new Person_test("Gyuluska"));
        Children.add(new Person_test("Bélácska"));
        Children.add(new Person_test("Gáborka"));
        Children.add(new Person_test("Gyuluska"));
        Children.add(new Person_test("Bélácska"));
        Children.add(new Person_test("Gáborka"));
        Children.add(new Person_test("Gyuluska"));
        Children.add(new Person_test("Bélácska"));
        Children.add(new Person_test("Gáborka"));
        Children.add(new Person_test("Gyuluska"));
        Children.add(new Person_test("Bélácska"));
        Children.add(new Person_test("Gáborka"));
        Children.add(new Person_test("Gyuluska"));
        Children.add(new Person_test("Bélácska"));
        Children.add(new Person_test("Gáborka"));

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.children_fragment, container, false);
        myRecycleView = (RecyclerView) v.findViewById(R.id.childrenRecycleView);
        RecyclerViewAdapter recycleAdapter = new RecyclerViewAdapter(getContext(),Children);
        myRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecycleView.setAdapter(recycleAdapter);
        return v;
    }
}
