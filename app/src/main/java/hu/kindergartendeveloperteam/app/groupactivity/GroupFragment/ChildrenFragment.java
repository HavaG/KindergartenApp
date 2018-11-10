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
import hu.kindergartendeveloperteam.app.groupactivity.R;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Child;

public class ChildrenFragment extends Fragment {

    View v;
    private RecyclerView myRecycleView;
    private List<Child> Children;
    DefaultApi db = new DefaultApi();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Children = new ArrayList<>();

        //TODO:valós adatokkal feltöltött Children database

        /**
        try {
            User parent = new User();
            parent.setId(1);
            parent.setName("Apa");

            Child c = new Child();
            c.setId(1);
            c.setName("Gaborka");
            c.setParent(parent);

            db.createChild(c);
            Children.add(db.getChild(1));

        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        }
         */
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.group_user_fragment, container, false);
        myRecycleView = (RecyclerView) v.findViewById(R.id.userRecycleView);
        ChildrenRecyclerViewAdapter recycleAdapter = new ChildrenRecyclerViewAdapter(getContext(),Children);
        myRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecycleView.setAdapter(recycleAdapter);
        return v;
    }
}
