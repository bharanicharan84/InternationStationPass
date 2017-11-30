package bmalli.com.internationstationpass.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import bmalli.com.internationstationpass.Model.StationPass;
import bmalli.com.internationstationpass.R;

/**
 * Created by bmalli on 11/30/17.
 */

public class PassAdapter extends RecyclerView.Adapter<PassAdapter.ViewHolder> {

    private Context mContext;
    private List<StationPass> passList;

    public PassAdapter(List<StationPass> passesList) {
        this.passList = passesList;

    }

    @Override
    public PassAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.articles_list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        mContext = parent.getContext();
        return vh;
    }

    @Override
    public void onBindViewHolder(PassAdapter.ViewHolder holder, int position) {
        final StationPass pass = passList.get(position);
        holder.passDuration.setText(Long.toString(pass.getDuration()));
        Date d = new Date(pass.getRiseTime() * 1000);
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        holder.passTime.setText(df.format(d));
    }

    @Override
    public int getItemCount() {
        return this.passList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView passDuration;
        public TextView passTime;

        public ViewHolder(View itemView) {
            super(itemView);
            passDuration = (TextView) itemView.findViewById(R.id.passDuration);
            passTime = (TextView) itemView.findViewById(R.id.passTime);
        }
    }
}
