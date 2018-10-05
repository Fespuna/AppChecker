package dev.fep.appchecker.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import dev.fep.appchecker.R;
import dev.fep.appchecker.adapters.AppAdapter;
import dev.fep.appchecker.classes.WebSiteChecker;
import dev.fep.appchecker.objects.App;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AppAdapter adapter;
    private ArrayList<App> appList = new ArrayList<>();
    private GridLayoutManager mLayoutManager;
    String gplayURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new AppAdapter(this,appList);
        mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        Add_and_update_app_list();

    }

    private void Add_and_update_app_list(){

        // Here add your appname and app package. 3 is number by default.
        appList.add(new App("EXAMPLE APP","com.example.app",3, "VIRTUAL MACHINE NAME"));




        for(int i=0;i<appList.size();i++){

            gplayURL = "https://play.google.com/store/apps/details?id="+appList.get(i).getApp_package();
            WebSiteChecker task = new WebSiteChecker(appList.get(i),adapter);
            task.execute(gplayURL);
        }

        adapter.setAppList(appList);
        adapter.notifyDataSetChanged();
    }
}
