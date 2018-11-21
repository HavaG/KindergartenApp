package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import hu.kindergartendeveloperteam.app.groupactivity.MyChildFragment.NotesFragment;

public class MyChildActivity extends AppCompatActivity {

    private ViewPagerAdapter adapter;
    private ViewPager viewPager;
    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_child_activity);

        compactCalendar = findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(dateFormatMonth.format(compactCalendar.getFirstDayOfCurrentMonth()));


        viewPager = findViewById(R.id.viewPager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new NotesFragment(), "Notes");
        viewPager.setAdapter(adapter);



        //Set an event for Teachers' Professional Day 2016 which is 21st of October

        Event ev1 = new Event(Color.RED, 1477040400000L, "Teachers' Professional Day");
        compactCalendar.addEvent(ev1);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();

                Toast.makeText(context, "No Events Planned for that day", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                toolbar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
            }
        });
    }
}
