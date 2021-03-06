package com.noveo.android.internship.ridetogether.app.presentation.common;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import butterknife.ButterKnife;
import com.noveo.android.internship.ridetogether.app.view.bus.BusProvider;
import com.squareup.otto.Bus;

public abstract class BaseFragment extends Fragment {
    private Bus bus = BusProvider.getInstance();

    @Override
    public void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        bus.unregister(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void postEvent(Object event) {
        bus.post(event);
    }
}
