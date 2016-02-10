package com.caatrin.discovermoldova;

import android.content.Context;
import android.support.v4.app.Fragment;

import io.realm.Realm;

/**
 * Created by ecaterinagaleru on 1/22/16.
 */
public class BaseFragment extends Fragment {

    protected Realm mRealm;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mRealm = Realm.getInstance(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mRealm.close();
    }
}
