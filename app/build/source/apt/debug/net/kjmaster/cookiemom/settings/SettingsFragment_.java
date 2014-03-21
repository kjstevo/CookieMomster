//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package net.kjmaster.cookiemom.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import net.kjmaster.cookiemom.R.layout;
import net.kjmaster.cookiemom.global.ISettings_;

public final class SettingsFragment_
    extends SettingsFragment
{

    private View contentView_;

    private void init_(Bundle savedInstanceState) {
        iSettings = new ISettings_(getActivity());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    private void afterSetContentView_() {
        setting_cookie_list = ((Spinner) findViewById(net.kjmaster.cookiemom.R.id.setting_cookie_list));
        setting_save_cookie = ((Button) findViewById(net.kjmaster.cookiemom.R.id.setting_save_cookie));
        settings_auot_fill_cases_check = ((CheckBox) findViewById(net.kjmaster.cookiemom.R.id.settings_auot_fill_cases_check));
        setting_custom_cookie_check = ((CheckBox) findViewById(net.kjmaster.cookiemom.R.id.setting_custom_cookie_check));
        settings_edit_cookie = ((EditText) findViewById(net.kjmaster.cookiemom.R.id.settings_edit_cookie));
        {
            View view = findViewById(net.kjmaster.cookiemom.R.id.setting_save_cookie);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        SettingsFragment_.this.onSave();
                    }

                }
                );
            }
        }
        afterViews();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView_ = super.onCreateView(inflater, container, savedInstanceState);
        if (contentView_ == null) {
            contentView_ = inflater.inflate(layout.settings_layout, container, false);
        }
        return contentView_;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        afterSetContentView_();
    }

    public View findViewById(int id) {
        if (contentView_ == null) {
            return null;
        }
        return contentView_.findViewById(id);
    }

    public static SettingsFragment_.FragmentBuilder_ builder() {
        return new SettingsFragment_.FragmentBuilder_();
    }

    public static class FragmentBuilder_ {

        private Bundle args_;

        private FragmentBuilder_() {
            args_ = new Bundle();
        }

        public SettingsFragment build() {
            SettingsFragment_ fragment_ = new SettingsFragment_();
            fragment_.setArguments(args_);
            return fragment_;
        }

    }

}
