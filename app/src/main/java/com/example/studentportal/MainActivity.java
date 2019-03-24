package com.example.studentportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {

    private List<Portal> myPortals;
    private PortalAdapter myPortalAdapter;
    private RecyclerView myRecyclerView;
    private GestureDetector mGestureDetector;
    public final static String EXTRATEXT_NAME = "extratextName";
    public final static String EXTRATEXT_URL = "extratextUrl";
    public final static int REQUESTCODE = 1234;
    public final static int GRIDCOLUMNS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //After making functional toolbar, let's make the RecyclerView array list:

        myRecyclerView = findViewById(R.id.recyclerView);
        myPortals = new ArrayList<>();
        //Adding edited parameter of RecyclerView array list:
        myRecyclerView.setLayoutManager(new GridLayoutManager(this, GRIDCOLUMNS));
        //Add fab(floating action button) to change activity:
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AdditionActivity.class);
                startActivityForResult(intent, REQUESTCODE);
            }
        });
        myRecyclerView.addOnItemTouchListener(this);
        mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        myPortals.add(new Portal("Student Intranet", "https://student.xamk.fi"));
        myPortals.add(new Portal("Moodle", "https://moodle.xamk.fi"));
        updateUI();
    }

    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View child = rv.findChildViewUnder(e.getX(), e.getY());
        int mAdapterPosition = rv.getChildAdapterPosition(child);
        if(child != null && mGestureDetector.onTouchEvent(e)) {
            Intent intent = new Intent(MainActivity.this, WebviewActivity.class);
            intent.putExtra(EXTRATEXT_URL, myPortals.get(mAdapterPosition).getMyPortalUrl());
            startActivity(intent);
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean allowIntercept) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void updateUI() {
        if (myPortalAdapter == null) {
            myPortalAdapter = new PortalAdapter(myPortals);
            myRecyclerView.setAdapter(myPortalAdapter);
        } else {
            myPortalAdapter.notifyDataSetChanged();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if(requestCode == REQUESTCODE){
            if(resultCode == RESULT_OK) {
                myPortals.add(new Portal(data.getStringExtra(MainActivity.EXTRATEXT_NAME), data.getStringExtra(MainActivity.EXTRATEXT_URL)));
                updateUI();
            }
        }
    }
}

/*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGeoObjects = new ArrayList<>();

        for (int i = 0; i < GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES.length; i++) {
            mGeoObjects.add(new GeoObject(GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES[i], GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i], GeoObject.PRE_DEFINED_GEO_OBJECT_ANSWER[i]));
        }

        final RecyclerView mGeoRecyclerView = findViewById(R.id.recyclerView);
        mGeoRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mGeoRecyclerView.setHasFixedSize(true);
        final GeoObjectAdapter mAdapter = new GeoObjectAdapter(this, mGeoObjects);
        mGeoRecyclerView.setAdapter(mAdapter);
        mGeoRecyclerView.addOnItemTouchListener(this);

        mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });*/
