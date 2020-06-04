package com.example.deliveryapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.deliveryapplication.MainActivity;
import com.example.deliveryapplication.R;
import com.example.deliveryapplication.model.Address;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsFragment extends Fragment {

    private MainActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
    }

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng erevan = new LatLng(40.1872, 44.5152);
            googleMap.addMarker(new MarkerOptions().position(erevan).title("Marker in Erevan"));
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(erevan, 11.5f));

            addMarkers(googleMap);
        }
    };

    private void addMarkers(GoogleMap googleMap) {
        List<Address> addressList = activity.getDataPresenter().getMockAddressMockData();
        addressList.forEach(address -> {
            int customMarker = 0;
            switch (address.getPlaceCategory()) {
                case "hotel":
                    customMarker = R.drawable.ic_hotel;
                    break;
                case "office":
                    customMarker = R.drawable.ic_office;
                    break;
                case "medical services":
                    customMarker = R.drawable.ic_medical_center;
                    break;
                case "apartment":
                    customMarker = R.drawable.ic_apartment;
                    break;
            }
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            googleMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(address.getAddress()).icon(BitmapDescriptorFactory.fromResource(customMarker)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.5f));
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}