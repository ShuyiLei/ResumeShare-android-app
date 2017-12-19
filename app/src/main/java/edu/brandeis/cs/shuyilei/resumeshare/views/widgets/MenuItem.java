package edu.brandeis.cs.shuyilei.resumeshare.views.widgets;

import android.graphics.drawable.Drawable;

/**
 * Created by shuyilei on 11/6/16.
 */

public class MenuItem {
    public Drawable getDrawable() {
        return drawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }



    public MenuItem(Drawable drawable, String title) {
        this.drawable = drawable;
        this.title = title;
    }

    private String title;
    private Drawable drawable;
}
