package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import hu.kindergartendeveloperteam.app.groupactivity.MyChildFragment.NotesRecyclerViewAdapter;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Child;
import io.swagger.client.model.KindergartenChild;
import io.swagger.client.model.Note;
import io.swagger.client.model.Presence;

public class MyChildActivity extends AppCompatActivity {

    CompactCalendarView compactCalendar;
    SimpleDateFormat dateFormatMonth = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    KindergartenChild child;
    List<Note> notes;
    DefaultApi db = new DefaultApi();
    List<Presence> presences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_child_activity);

        int childId = getIntent().getIntExtra(MyChildChooseActivity.CHILD_ID, 0);

        try {

            child = db.getChild(childId);
            presences = child.getPresences();
            notes = child.getNotes();

        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        }


        compactCalendar = findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String firstMonth = dateFormatMonth.format(compactCalendar.getFirstDayOfCurrentMonth());
        toolbar.setTitle(firstMonth.substring(0,1).toUpperCase() + firstMonth.substring(1).toLowerCase());



        setNotesAdapter();
        fillCalendarPresences();

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {

            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                String month = dateFormatMonth.format(firstDayOfNewMonth);
                toolbar.setTitle(month.substring(0,1).toUpperCase() + month.substring(1).toLowerCase());
            }
        });

    }

    private long dateToMillis(int y, int m, int d){
        long year = y-1970;
        long month = m-1;
        long day = d-1;
        return (long) ((3155.6926 * 10000000 * year) + (2.62974383 * 1000000000 * month) + (86400000 * day));
    }

    private void fillCalendarPresences() {
        //get the presences from database, create events, safe events for compare?
        try {

            for(int i = 0; i < presences.size(); i++){
                long time = dateFormatMonth.parse(presences.get(i).getDate()).getTime();
                Event e = new Event(Color.RED, time, "Elivleg ez nem is látszik");
                compactCalendar.addEvent(e);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void setNotesAdapter() {
        // Lookup the recyclerview in activity layout
        RecyclerView rvNotes = findViewById(R.id.notes_container);

        // Create adapter passing in the sample user data
        NotesRecyclerViewAdapter adapter = new NotesRecyclerViewAdapter(notes);

        // Attach the adapter to the recyclerview to populate items
        rvNotes.setAdapter(adapter);

        // Set layout manager to position the items
        rvNotes.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
    }
}
