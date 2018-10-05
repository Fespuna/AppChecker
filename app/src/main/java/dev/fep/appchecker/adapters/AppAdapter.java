package dev.fep.appchecker.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dev.fep.appchecker.R;
import dev.fep.appchecker.objects.App;

/**
 * Created by Ferran on 23/09/2018.
 */

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.MyViewHolder> {

    private Activity mContext;
    private ArrayList<App> AppList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView app_name, app_package,vm;
        public ImageView app_status;
        public LinearLayout app_item;

        public MyViewHolder(View view) {
            super(view);

            app_name = (TextView) view.findViewById(R.id.app_name);
            app_package = (TextView) view.findViewById(R.id.app_package);
            vm = (TextView) view.findViewById(R.id.vm);
            app_status = (ImageView) view.findViewById(R.id.app_status);
            app_item = (LinearLayout) view.findViewById(R.id.app_item);
        }
    }

    public AppAdapter(Activity mContext, ArrayList<App> AppList) {
        this.mContext = mContext;
        this.AppList = new ArrayList<>();
        this.AppList = AppList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.app_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final App app = AppList.get(position);

        holder.app_name.setText(app.getApp_name());
        holder.app_package.setText(app.getApp_package());
        holder.vm.setText(app.getVm());

        if(app.getPublished()==1){
            //greentick
            Log.e("god","bonaxxx");
            holder.app_status.setImageResource(R.drawable.tick);
        }else if(app.getPublished()==0){
            //redcross
            Log.e("god","malaxxx");
            holder.app_status.setImageResource(R.drawable.cross);
        }else{
        //    holder.app_status.setVisibility(View.INVISIBLE);
        }

        holder.app_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, holder.app_name.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return AppList.size();
    }

    public Activity getmContext() {
        return mContext;
    }

    public void setmContext(Activity mContext) {
        this.mContext = mContext;
    }

    public List<App> getAppList() {
        return AppList;
    }

    public void setAppList(ArrayList<App> AppList) {
        this.AppList = AppList;
        notifyDataSetChanged();
    }
}
