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

public class TeacherFragment extends Fragment {

    View v;
    private RecyclerView myRecycleView;
    private List<Person_test> Teachers;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Teachers = new ArrayList<>();

        //Groupban levő gyerek lista feltöltése
        Teachers.add(new Person_test("Mercz"));
        Teachers.add(new Person_test("Norbi"));
        Teachers.add(new Person_test("Dobrosi"));
        Teachers.add(new Person_test("Mercz"));
        Teachers.add(new Person_test("Norbi"));
        Teachers.add(new Person_test("Dobrosi"));
        Teachers.add(new Person_test("Mercz"));
        Teachers.add(new Person_test("Norbi"));
        Teachers.add(new Person_test("Dobrosi"));
        Teachers.add(new Person_test("Mercz"));
        Teachers.add(new Person_test("Norbi"));
        Teachers.add(new Person_test("Dobrosi"));

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.teachers_fragment, container, false);
        myRecycleView = (RecyclerView) v.findViewById(R.id.teachersRecycleView);
        RecyclerViewAdapter recycleAdapter = new RecyclerViewAdapter(getContext(),Teachers);
        myRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecycleView.setAdapter(recycleAdapter);
        return v;
    }
}
