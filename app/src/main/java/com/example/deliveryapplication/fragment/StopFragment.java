package com.example.deliveryapplication.fragment;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deliveryapplication.MainActivity;
import com.example.deliveryapplication.R;
import com.example.deliveryapplication.adapter.StopAdapter;
import com.example.deliveryapplication.listener.OnNavigateToMapListener;
import com.example.deliveryapplication.model.Delivery;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StopFragment extends Fragment implements OnNavigateToMapListener {

    @BindView(R.id.rec_list)
    RecyclerView recList;

    private MainActivity activity;

    public StopFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static StopFragment newInstance(String param1, String param2) {
        StopFragment fragment = new StopFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stop, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);


        activity = (MainActivity) getActivity();
        if (activity != null) {
            List<Delivery> mockDeliveryData = activity.getDataPresenter().getMockDeliveryData();
            recList.setLayoutManager(new LinearLayoutManager(activity));
            recList.setAdapter(new StopAdapter(activity, mockDeliveryData, this));
        }
    }

    @Override
    public void setOnNavigateToMap(Delivery delivery) {
        if (!statusCheck()) {
            navFromCurrentLocToDeliveryLoc(delivery);
        }
    }

    public boolean statusCheck() {
        final LocationManager manager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);

        if (manager != null && !manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            return true;
        }
        return false;
    }

    public void navFromCurrentLocToDeliveryLoc(Delivery delivery) {
        Uri navigation = Uri.parse("google.navigation:q=" + delivery.getAddress().getLatitude() + "," + delivery.getAddress().getLongitude() + "");
        Intent navigationIntent = new Intent(Intent.ACTION_VIEW, navigation);
        navigationIntent.setPackage("com.google.android.apps.maps");
        startActivity(navigationIntent);
    }
}