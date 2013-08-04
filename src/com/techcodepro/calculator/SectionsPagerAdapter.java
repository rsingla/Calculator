/*package com.techcodepro.calculator;

import java.util.Locale;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/** 
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to 
 * one of the sections/tabs/pages. 
 */  
/*public class SectionsPagerAdapter extends FragmentPagerAdapter {  

    public SectionsPagerAdapter(FragmentManager fm) {  
        super(fm);  
    }  

    @Override  
    public Fragment getItem(int position) {  
        // getItem is called to instantiate the fragment for the given page.  
        // Return a DummySectionFragment (defined as a static inner class  
        // below) with the page number as its lone argument.  
        Fragment fragment = new DummySectionFragment();  
        Bundle args = new Bundle();  
        args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);  
        fragment.setArguments(args);  
        return fragment;  
    }  

    @Override  
    public int getCount() {  
        // Show 3 total pages.  
        return 3;  
    }  

    @Override  
    public CharSequence getPageTitle(int position) {  
        Locale l = Locale.getDefault();  
        switch (position) {  
        case 0:  
            return getString(R.string.title_activity_currency).toUpperCase(l);  
        case 1:  
            return getString(R.string.title_section2).toUpperCase(l);  
        case 2:  
            return getString(R.string.title_section3).toUpperCase(l);  
        }  
        return null;  
    }  
}  */
