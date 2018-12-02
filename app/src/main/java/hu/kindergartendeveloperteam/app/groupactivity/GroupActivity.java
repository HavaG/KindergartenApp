package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.ChildrenFragment;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.ParentsFragment;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.PostsFragment;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.TeacherFragment;

public class GroupActivity extends AppCompatActivity {

    private ViewPagerAdapter adapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    public static String GROUP_ID = "gruop_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_activity);

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewPager_id);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        Boolean onlyMessage = getIntent().getBooleanExtra("only_message", false);

        int  groupId = getIntent().getIntExtra("groupId", 0);
        Bundle b = new Bundle();
        b.putInt(GROUP_ID, groupId);

        TeacherFragment tf = new TeacherFragment();
        ParentsFragment pf = new ParentsFragment();
        PostsFragment pof = new PostsFragment();
        ChildrenFragment cf = new ChildrenFragment();

        tf.setArguments(b);
        pf.setArguments(b);
        pof.setArguments(b);
        cf.setArguments(b);

        if(onlyMessage){
            adapter.AddFragment(tf, "Teachers");
            adapter.AddFragment(pf, "Parents");
        }
        else{
            adapter.AddFragment(pof, "Posts");
            adapter.AddFragment(tf, "Teachers");
            adapter.AddFragment(pf, "Parents");
            adapter.AddFragment(cf, "Children");
        }

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
    }
}