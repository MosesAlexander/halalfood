package com.example.halalfood;

import androidx.fragment.app.FragmentActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener,
        GoogleMap.OnInfoWindowLongClickListener {

    private GoogleMap mMap;

    private static final String TAG = "HALALTAG";
    private static final int SPLASH_TIME_OUT = 3000;

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public boolean onMarkerClick(final Marker marker)
    {
        marker.showInfoWindow();
        if(marker.getTitle().equals("Török Döner Kebab")){
            Log.e(TAG, "Török Döner Kebab!");


        } else if (marker.getTitle().equals("Baalbek Lebanese Restaurant")){
            Log.e(TAG, "Baalbek Lebanese Restaurant!");
        } else if (marker.getTitle().equals("Mughal Shahi")) {
            Log.e(TAG, "Mughal Shahi!");
        } else if (marker.getTitle().equals("Antalya Kebab")) {
            Log.e(TAG, "Antalya Kebab!");
        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        //display the logo during 2 seconds,
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                MapsActivity.this.setContentView(R.layout.activity_maps);
                // Obtain the SupportMapFragment and get notified when the map is ready to be used.
                SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.map);
                mapFragment.getMapAsync(MapsActivity.this);

            }
        }, SPLASH_TIME_OUT);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Marker m1,m2,m3,m4;
        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnInfoWindowLongClickListener(this);
        googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            // Use default InfoWindow frame
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            // Defines the contents of the InfoWindow
            @Override
            public View getInfoContents(Marker arg0) {

                View v = null;
                // Getting view from the layout file infowindowlayout.xml
                if (arg0.getTitle().equals("Török Döner Kebab")) {
                    v = getLayoutInflater().inflate(R.layout.torokinfowindowlayout, null);

                    LatLng latLng = arg0.getPosition();

                    ImageView im = (ImageView) v.findViewById(R.id.torok);
                    TextView tv1 = (TextView) v.findViewById(R.id.textView1);
                    String title = arg0.getTitle();
                    String informations = arg0.getSnippet();

                    tv1.setText(title);
                } else if (arg0.getTitle().equals("Baalbek Lebanese Restaurant")) {
                    v = getLayoutInflater().inflate(R.layout.baalbekinfowindowlayout, null);

                    LatLng latLng = arg0.getPosition();

                    ImageView im = (ImageView) v.findViewById(R.id.baalbek);
                    TextView tv1 = (TextView) v.findViewById(R.id.textView1baalbek);
                    String title = arg0.getTitle();
                    String informations = arg0.getSnippet();

                    tv1.setText(title);

                } else if (arg0.getTitle().equals("Mughal Shahi")) {
                    v = getLayoutInflater().inflate(R.layout.mughalinfowindowlayout, null);

                    LatLng latLng = arg0.getPosition();

                    ImageView im = (ImageView) v.findViewById(R.id.mughal);
                    TextView tv1 = (TextView) v.findViewById(R.id.textView1mughal);
                    String title = arg0.getTitle();
                    String informations = arg0.getSnippet();

                    tv1.setText(title);

                } else if (arg0.getTitle().equals("Antalya Kebab")) {
                    v = getLayoutInflater().inflate(R.layout.antalyainfowindowlayout, null);

                    LatLng latLng = arg0.getPosition();

                    ImageView im = (ImageView) v.findViewById(R.id.antalya);
                    TextView tv1 = (TextView) v.findViewById(R.id.textView1antalya);
                    String title = arg0.getTitle();
                    String informations = arg0.getSnippet();

                    tv1.setText(title);

                }

             //   if(onMarkerClick(arg0)==true && markerclicked==1){
               //     im.setImageResource(R.drawable.yourdrawable);
              //  }


                return v;

            }
        });

        LatLng marker1coord = new LatLng(47.47720483901818, 19.04772657111628);
        MarkerOptions marker1 = new MarkerOptions().position(marker1coord).title("Török Döner Kebab");
        m1 = googleMap.addMarker(marker1);
        m1.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));

        LatLng marker2coord = new LatLng(47.49017753181088, 19.052936095449965);
        MarkerOptions marker2 = new MarkerOptions().position(marker2coord).title("Baalbek Lebanese Restaurant");
        m2 = googleMap.addMarker(marker2);
        m2.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));

        LatLng marker3coord = new LatLng(47.507668870599844, 19.01584354793163);
        MarkerOptions marker3 = new MarkerOptions().position(marker3coord).title("Mughal Shahi");
        m3 = googleMap.addMarker(marker3);
        m3.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));

        LatLng marker4coord = new LatLng(47.512894336508054, 19.05380561002099);
        MarkerOptions marker4 = new MarkerOptions().position(marker4coord).title("Antalya Kebab");
        m4 = googleMap.addMarker(marker4);
        m4.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(marker1coord));
        googleMap.setMinZoomPreference(13);

    }

    @Override
    public void onInfoWindowLongClick(Marker marker) {
        if (marker.getTitle().equals("Török Döner Kebab")) {
            Intent intent = new Intent(this, FoodActivity.class);
            startActivity(intent);
            Log.e(TAG, "Török Döner Kebab");
        } else if (marker.getTitle().equals("Baalbek Lebanese Restaurant")) {
            Log.e(TAG, "Baalbek Lebanese Restaurant");
        } else if (marker.getTitle().equals("Mughal Shahi")) {
            Log.e(TAG, "Mughal Shahi");
        } else if (marker.getTitle().equals("Antalya Kebab")) {
            Log.e(TAG, "Antalya Kebab");
        }

    }
}