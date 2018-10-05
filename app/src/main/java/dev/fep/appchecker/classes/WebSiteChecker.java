package dev.fep.appchecker.classes;

import android.os.AsyncTask;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;

import dev.fep.appchecker.adapters.AppAdapter;
import dev.fep.appchecker.objects.App;

/**
 * Created by Ferran on 23/09/2018.
 */

public class WebSiteChecker extends AsyncTask<String, Void, Boolean> {

    App apptocheck;
    AppAdapter appAdapter;

    public WebSiteChecker(App apptocheck, AppAdapter appAdapter) {

        this.apptocheck = apptocheck;
        this.appAdapter = appAdapter;
    }

    @Override
        protected void onPreExecute() {
        }

        @Override
        protected Boolean doInBackground(String... params) {

            try {
                HttpURLConnection.setFollowRedirects(false);
                HttpURLConnection con =  (HttpURLConnection) new URL(params[0]).openConnection();
                con.setRequestMethod("HEAD");
                System.out.println(con.getResponseCode());
                return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

    @Override
    protected void onPostExecute(Boolean result) {
        boolean bResponse = result;
        if (bResponse==true)
        {
            Log.e("god","bona");
            apptocheck.setPublished(1);


        }
        else
        {
            Log.e("god","mala");
            apptocheck.setPublished(0);
        }

        appAdapter.notifyDataSetChanged();
    }
}
