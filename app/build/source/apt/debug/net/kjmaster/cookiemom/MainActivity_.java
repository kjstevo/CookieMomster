//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package net.kjmaster.cookiemom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.googlecode.androidannotations.api.SdkVersionHelper;
import net.kjmaster.cookiemom.R.id;
import net.kjmaster.cookiemom.R.layout;
import net.kjmaster.cookiemom.global.ISettings_;

public final class MainActivity_
    extends MainActivity
{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(layout.main_activity);
    }

    private void init_(Bundle savedInstanceState) {
        iSettings = new ISettings_(this);
        main = ((Main) this.getApplication());
    }

    private void afterSetContentView_() {
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

    public static MainActivity_.IntentBuilder_ intent(Context context) {
        return new MainActivity_.IntentBuilder_(context);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean handled = super.onOptionsItemSelected(item);
        if (handled) {
            return true;
        }
        int itemId_ = item.getItemId();
        if ((itemId_ == id.menu_personal)||(itemId_ == id.menu_cookie_mom)) {
            onProfileSwitch(item);
            return true;
        }
        if (itemId_ == id.menu_eat_cookies) {
            onEatCookies();
            return true;
        }
        if (itemId_ == id.menu_about) {
            onAbout();
            return true;
        }
        if (itemId_ == id.menu_settings) {
            onSettings();
            return true;
        }
        return false;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        MainActivity_.super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case  444 :
                MainActivity_.this.placeCupboardOrder(resultCode, data);
                break;
            case  2232 :
                MainActivity_.this.onEatSelectScoutResult(resultCode, data);
                break;
            case  9876 :
                MainActivity_.this.onBoothOrder(resultCode, data);
                break;
            case  111 :
                MainActivity_.this.onScoutAssign(resultCode, data);
                break;
            case  1111 :
                MainActivity_.this.onRemoveScout(resultCode, data);
                break;
            case  4343 :
                MainActivity_.this.scoutResult(resultCode);
                break;
            case  9090 :
                MainActivity_.this.afterSettings(resultCode, data);
                break;
            case  888 :
                MainActivity_.this.onBoothResult(resultCode, data);
                break;
        }
    }

    public static class IntentBuilder_ {

        private Context context_;
        private final Intent intent_;

        public IntentBuilder_(Context context) {
            context_ = context;
            intent_ = new Intent(context, MainActivity_.class);
        }

        public Intent get() {
            return intent_;
        }

        public MainActivity_.IntentBuilder_ flags(int flags) {
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
