package usuario.example.com.scrollingactivityexample;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class MovieDetailsFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int NUM_PAGES = 4;
    private String tabTitles[] = new String[NUM_PAGES];
    private Context context;

    public MovieDetailsFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabTitles[0] = "OPCIÓN 1";
        tabTitles[1] = "OPCIÓN 2";
        tabTitles[2] = "OPCIÓN 3";
        tabTitles[3] = "OPCIÓN 4";
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MediaFragment();
            case 1:
                return new MediaFragment();
            case 2:
                return new MediaFragment();
            default:
                return new MediaFragment();
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position.
        return tabTitles[position];
    }
}