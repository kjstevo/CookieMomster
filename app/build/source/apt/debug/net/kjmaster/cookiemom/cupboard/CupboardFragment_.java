//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package net.kjmaster.cookiemom.cupboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import it.gmariotti.cardslib.library.view.CardListView;
import net.kjmaster.cookiemom.Main;
import net.kjmaster.cookiemom.R.layout;

public final class CupboardFragment_
    extends CupboardFragment
{

    private View contentView_;

    private void init_(Bundle savedInstanceState) {
        main = ((Main) getActivity().getApplication());
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    private void afterSetContentView_() {
        cardView = ((CardListView) findViewById(net.kjmaster.cookiemom.R.id.carddemo_list_base1));
        afterViews();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView_ = super.onCreateView(inflater, container, savedInstanceState);
        if (contentView_ == null) {
            contentView_ = inflater.inflate(layout.main_fragment, container, false);
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

    public static CupboardFragment_.FragmentBuilder_ builder() {
        return new CupboardFragment_.FragmentBuilder_();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(net.kjmaster.cookiemom.R.menu.cupboard_frag, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean handled = super.onOptionsItemSelected(item);
        if (handled) {
            return true;
        }
        int itemId_ = item.getItemId();
        if (itemId_ == net.kjmaster.cookiemom.R.id.menu_place_cupboard_order) {
            placeOrder();
            return true;
        }
        if (itemId_ == net.kjmaster.cookiemom.R.id.menu_edit_data) {
            editData();
            return true;
        }
        if (itemId_ == net.kjmaster.cookiemom.R.id.menu_pickup_cupboard_order) {
            pickupOrder();
            return true;
        }
        return false;
    }

    public static class FragmentBuilder_ {

        private Bundle args_;

        private FragmentBuilder_() {
            args_ = new Bundle();
        }

        public CupboardFragment build() {
            CupboardFragment_ fragment_ = new CupboardFragment_();
            fragment_.setArguments(args_);
            return fragment_;
        }

    }

}
