//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package net.kjmaster.cookiemom.scout.add;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.googlecode.androidannotations.api.SdkVersionHelper;
import net.kjmaster.cookiemom.R.layout;
import net.kjmaster.cookiemom.global.ISettings_;

public final class AddScoutActivity_
    extends AddScoutActivity
{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(layout.scout_add_scout_layout);
    }

    private void init_(Bundle savedInstanceState) {
        iSettings = new ISettings_(this);
    }

    private void afterSetContentView_() {
        addScoutDialogFragment = ((AddScoutDialogFragment) findSupportFragmentByTag("add_scout"));
        afterViews();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        afterSetContentView_();
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        afterSetContentView_();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        afterSetContentView_();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (((SdkVersionHelper.getSdkInt()< 5)&&(keyCode == KeyEvent.KEYCODE_BACK))&&(event.getRepeatCount() == 0)) {
            onBackPressed();
        }
        return super.onKeyDown(keyCode, event);
    }

    public static AddScoutActivity_.IntentBuilder_ intent(Context context) {
        return new AddScoutActivity_.IntentBuilder_(context);
    }

    private Fragment findSupportFragmentByTag(String tag) {
        if (!(this instanceof FragmentActivity)) {
            return null;
        }
        FragmentActivity activity_ = ((FragmentActivity) this);
        return activity_.getSupportFragmentManager().findFragmentByTag(tag);
    }

    public static class IntentBuilder_ {

        private Context context_;
        private final Intent intent_;

        public IntentBuilder_(Context context) {
            context_ = context;
            intent_ = new Intent(context, AddScoutActivity_.class);
        }

        public Intent get() {
            return intent_;
        }

        public AddScoutActivity_.IntentBuilder_ flags(int flags) {
            intent_.setFlags(flags);
            return this;
        }

        public void start() {
            context_.startActivity(intent_);
        }

        public void startForResult(int requestCode) {
            if (context_ instanceof Activity) {
                ((Activity) context_).startActivityForResult(intent_, requestCode);
            } else {
                context_.startActivity(intent_);
            }
        }

    }

}