package hu.kindergartendeveloperteam.app.groupactivity;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.ChildrenFragment;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.ParentsFragment;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.PostsFragment;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.TeacherFragment;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.ViewPagerAdapter;

import android.os.Bundle;

public class GroupActivity extends AppCompatActivity {

    private ViewPagerAdapter adapter;

    private ViewPager viewPager;

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager_id);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        Boolean onlyMessage = getIntent().getBooleanExtra("onlyMessage", false);

        if(onlyMessage){
            adapter.AddFragment(new TeacherFragment(), "Teachers");
            adapter.AddFragment(new ParentsFragment(), "Parents");
        }
        else{
            adapter.AddFragment(new PostsFragment(), "Posts");
            adapter.AddFragment(new TeacherFragment(), "Teachers");
            adapter.AddFragment(new ParentsFragment(), "Parents");
            adapter.AddFragment(new ChildrenFragment(), "Children");
        }

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }
}