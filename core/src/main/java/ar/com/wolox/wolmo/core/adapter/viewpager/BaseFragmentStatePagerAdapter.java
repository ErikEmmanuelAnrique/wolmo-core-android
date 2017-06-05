/*
 * Copyright (c) Wolox S.A
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ar.com.wolox.wolmo.core.adapter.viewpager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Basic {@link FragmentStatePagerAdapter} to manage fragments with title.
 */
public class BaseFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> mPages;
    private ArrayList<String> mTitles;

    /**
     * Constructor. Requires an isntance of {@link FragmentManager}.
     *
     * @param fm An isntance of {@link FragmentManager}
     */
    public BaseFragmentStatePagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        mPages = new ArrayList<>();
        mTitles = new ArrayList<>();
    }

    /**
     * Returns the {@link Fragment} in the provided position. Can be null if the {@link Fragment}
     * isn't in the {@link android.support.v4.view.ViewPager}
     *
     * @param position The position of the requested {@link Fragment}
     * @return The {@link Fragment} in the given position. Can be null.
     */
    @Override
    @NonNull
    public Fragment getItem(int position) {
        return mPages.get(position);
    }

    /**
     * Returns the amount of {@link Fragment}s in the {@link android.support.v4.view.ViewPager}
     *
     * @return amount of {@link Fragment}s
     */
    @Override
    public int getCount() {
        return mPages.size();
    }

    /**
     * Returns the title of the {@link Fragment} in a certain position
     *
     * @param position The position of the {@link Fragment} whose title is requested
     * @return The title of the {@link Fragment} in the given position. Can be null.
     */
    @Override
    @Nullable
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    /**
     * Adds a fragment to the adapter with no title. The title will be set to <b>null</b>.
     *
     * @param fragment Fragment to add
     */
    public void addItem(@NonNull Fragment fragment) {
        addItem(fragment, null);
    }

    /**
     * Adds a fragment to the adapter with the given title.
     *
     * @param fragment Fragment to add
     * @param title    Title for the fragment
     */
    public void addItem(@NonNull Fragment fragment, @Nullable String title) {
        mPages.add(fragment);
        mTitles.add(title);
        notifyDataSetChanged();
    }
}