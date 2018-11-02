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

public class ParentsFragment extends Fragment {

    View v;
    private RecyclerView myRecycleView;
    private List<Person_test> Parents;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Parents = new ArrayList<>();


        //Groupban levő gyerek lista feltöltése
        Parents.add(new Person_test("Bélabács"));
        Parents.add(new Person_test("Marika"));
        Parents.add(new Person_test("Asszonyság"));
        Parents.add(new Person_test("Bélabács"));
        Parents.add(new Person_test("Marika"));
        Parents.add(new Person_test("Asszonyság"));
        Parents.add(new Person_test("Bélabács"));
        Parents.add(new Person_test("Marika"));
        Parents.add(new Person_test("Asszonyság"));
        Parents.add(new Person_test("Bélabács"));
        Parents.add(new Person_test("Marika"));
        Parents.add(new Person_test("Asszonyság"));
        Parents.add(new Person_test("Bélabács"));
        Parents.add(new Person_test("Marika"));
        Parents.add(new Person_test("Asszonyság"));

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.parents_fragment, container, false);
        myRecycleView = (RecyclerView) v.findViewById(R.id.parentsRecycleView);
        RecyclerViewAdapter recycleAdapter = new RecyclerViewAdapter(getContext(),Parents);
        myRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecycleView.setAdapter(recycleAdapter);
        return v;
    }
}
