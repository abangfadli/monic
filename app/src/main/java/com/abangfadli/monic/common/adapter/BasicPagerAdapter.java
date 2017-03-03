package com.abangfadli.monic.common.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ahmadfadli on 2/13/16.
 * http://stackoverflow.com/questions/13664155/dynamically-add-and-remove-view-to-viewpager
 */
public class BasicPagerAdapter extends PagerAdapter {

    private ArrayList<ViewTitle> mViews;

    public BasicPagerAdapter() {
        mViews = new ArrayList<>();
    }

    //-----------------------------------------------------------------------------
    // Used by ViewPager.  Called when ViewPager needs a page to display; it is our job
    // to add the page to the container, which is normally the ViewPager itself.  Since
    // all our pages are persistent, we simply retrieve it from our "views" ArrayList.
    @Override
    public Object instantiateItem (ViewGroup container, int position) {
        View v = mViews.get (position).getView();
        container.addView (v);
        return v;
    }

    //-----------------------------------------------------------------------------
    // Used by ViewPager.  Called when ViewPager no longer needs a page to display; it
    // is our job to remove the page from the container, which is normally the
    // ViewPager itself.  Since all our pages are persistent, we do nothing to the
    // contents of our "views" ArrayList.
    @Override
    public void destroyItem (ViewGroup container, int position, Object object) {
        container.removeView (mViews.get (position).getView());
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mViews.get(position).getTitle();
    }

    @Override
    public int getCount() {
        return mViews.size();
    }

    //-----------------------------------------------------------------------------
    // Add "view" to right end of "views".
    // Returns the position of the new view.
    // The app should call this to add pages; not used by ViewPager.
    public int addView (ViewTitle v)
    {
        return addView (v, mViews.size());
    }

    //-----------------------------------------------------------------------------
    // Add "view" at "position" to "views".
    // Returns position of new view.
    // The app should call this to add pages; not used by ViewPager.
    public int addView (ViewTitle v, int position)
    {
        mViews.add (position, v);
        return position;
    }

    //-----------------------------------------------------------------------------
    // Removes "view" from "views".
    // Retuns position of removed view.
    // The app should call this to remove pages; not used by ViewPager.
    public int removeView (ViewPager pager, ViewTitle v)
    {
        return removeView (pager, mViews.indexOf (v));
    }

    //-----------------------------------------------------------------------------
    // Removes the "view" at "position" from "views".
    // Retuns position of removed view.
    // The app should call this to remove pages; not used by ViewPager.
    public int removeView (ViewPager pager, int position)
    {
        // ViewPager doesn't have a delete method; the closest is to set the adapter
        // again.  When doing so, it deletes all its views.  Then we can delete the view
        // from from the adapter and finally set the adapter to the pager again.  Note
        // that we set the adapter to null before removing the view from "views" - that's
        // because while ViewPager deletes all its views, it will call destroyItem which
        // will in turn cause a null pointer ref.
        pager.setAdapter (null);
        mViews.remove (position);
        pager.setAdapter (this);

        return position;
    }

    public void removeAllView(ViewPager pager){
        pager.setAdapter(null);
        mViews.clear();
        pager.setAdapter(this);
    }
    //-----------------------------------------------------------------------------
    // Returns the "view" at "position".
    // The app should call this to retrieve a view; not used by ViewPager.
    public View getView (int position)
    {
        return mViews.get (position).getView();
    }

    //-----------------------------------------------------------------------------
    // Used by ViewPager.
    @Override
    public boolean isViewFromObject (View view, Object object)
    {
        return view == object;
    }
}
