package com.example.yoonseoplee_comp304_003_test02.Views;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import com.example.yoonseoplee_comp304_003_test02.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ViewMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button button;
    PopupMenu popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        button = (Button)findViewById(R.id.button);
    }

    public void showPopup() {
        if (popup == null) {
            popup = new PopupMenu(ViewMap.this, button);
            popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());
        }
        popup.setOnMenuItemClickListener(new
                                                 PopupMenu.OnMenuItemClickListener() {
                                                     @Override
                                                     public boolean onMenuItemClick(MenuItem item) {
         if (item.getItemId() == R.id.action_normal) {
             mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
             button.setText("Normal");
         }
         else if (item.getItemId() == R.id.action_satellite) {
             mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
             button.setText("Satellite");
         }
         else if (item.getItemId() == R.id.action_hybrid) {
             mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
             button.setText("Hybrid");
         }
         else if (item.getItemId() == R.id.action_terrain) {
             mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
             button.setText("Terrain");
         }
          return true;
             }
                     });
        popup.show();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng centennialCollege = new LatLng(43.7854, -79.2264);
        mMap.addMarker(new MarkerOptions().position(centennialCollege).title("Centennial College"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(centennialCollege));

        LatLng latLng = new LatLng(43.7854, -79.2264);

        float zoomLevel = 16.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });
    }


}
