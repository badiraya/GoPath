package com.example.gopath;

import androidx.fragment.app.Fragment;

public class Tab {
    private Category category;
    private Fragment fragment;

    public Tab(Category category, Fragment fragment) {
        this.category = category;
        this.fragment = fragment;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}