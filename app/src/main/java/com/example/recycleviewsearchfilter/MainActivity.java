package com.example.recycleviewsearchfilter;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    private RecyclerView rv;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sv= (SearchView) findViewById(R.id.mSearch);
        rv= (RecyclerView) findViewById(R.id.myRecycler);
        //SET ITS PROPERTIES
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        //ADAPTER
        adapter=new MyAdapter(this,getPlayers());
        rv.setAdapter(adapter);

    }


    //ADD PLAYERS TO ARRAYLIST
    private ArrayList<Model> getPlayers() {
        ArrayList<Model> players=new ArrayList<>();
        Model p=new Model();
        p.setName("Home");
        p.setImg(R.drawable.home);
        players.add(p);

        p=new Model();
        p.setName("Contacts");
        p.setImg(R.drawable.contact);
        players.add(p);

        p=new Model();
        p.setName("Images");
        p.setImg(R.drawable.image);
        players.add(p);

        p=new Model();
        p.setName("Videos");
        p.setImg(R.drawable.videos);
        players.add(p);

        p=new Model();
        p.setName("Mails");
        p.setImg(R.drawable.mail);
        players.add(p);

        return players;

    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu) {
        getMenuInflater().inflate( R.menu.menu, menu);
        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE
                adapter.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement

        return true;
    }

}