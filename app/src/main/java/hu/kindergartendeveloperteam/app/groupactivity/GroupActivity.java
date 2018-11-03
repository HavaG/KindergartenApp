package hu.kindergartendeveloperteam.app.groupactivity;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.ChildrenFragment;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.ParentsFragment;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.PostsFragment;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.TeacherFragment;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.ViewPagerAdapter;
import io.swagger.client.api.DefaultApi;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class GroupActivity extends AppCompatActivity {

    private ViewPagerAdapter adapter;

    private ViewPager viewPager;

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager_id);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new PostsFragment(), "Posts");
        adapter.AddFragment(new TeacherFragment(), "Teachers");
        adapter.AddFragment(new ParentsFragment(), "Parents");
        adapter.AddFragment(new ChildrenFragment(), "Children");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_group, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
