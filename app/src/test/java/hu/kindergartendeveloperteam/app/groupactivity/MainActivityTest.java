package hu.kindergartendeveloperteam.app.groupactivity;

import android.widget.FrameLayout;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import androidx.appcompat.widget.LinearLayoutCompat;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private MainActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void shouldHaveDefaultMargin() throws Exception {
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.fragment_container);
        int bottomMargin = ((LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams()).bottomMargin;
        assertEquals(5, bottomMargin);
        int topMargin = ((LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams()).topMargin;
        assertEquals(5, topMargin);
        int rightMargin = ((LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams()).rightMargin;
        assertEquals(10, rightMargin);
        int leftMargin = ((LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams()).leftMargin;
        assertEquals(10, leftMargin);
    }
}