package usuario.example.com.scrollingactivityexample;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class ScrollingActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Give the TabLayout the ViewPager.
        tabLayout = (TabLayout) findViewById(R.id.movie_details_tab_layout);
        viewPager = (ViewPager) findViewById(R.id.movie_details_viewpager);
        tabLayout.setupWithViewPager(viewPager);

        // Create an adapter that knows which fragment should be shown on each page, set the adapter
        // onto the view pager and go to the current page.
        MovieDetailsFragmentPagerAdapter adapter = new MovieDetailsFragmentPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);

        setTitle("");
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        AppBarLayout.OnOffsetChangedListener listener = new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (collapsingToolbarLayout.getHeight() + verticalOffset < 2 * ViewCompat.getMinimumHeight(collapsingToolbarLayout)) {
                    // CollapsingToolbar esta colapsado
                    //title.animate().alpha(1).setDuration(600);
                    if (getSupportActionBar() != null) {
                        setTitle("Título de la película");
                        getSupportActionBar().show();
                    }
                } else {
                    // CollapsingToolbar esta expandido
                    //title.animate().alpha(0).setDuration(600);
                    if (getSupportActionBar() != null) {
                        setTitle(" ");
                    }
                }
            }
        };
        AppBarLayout appBar = (AppBarLayout) findViewById(R.id.app_bar);
        appBar.addOnOffsetChangedListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.favorites_action) {
            return true;
        }
        if (id == R.id.favorites_share) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
