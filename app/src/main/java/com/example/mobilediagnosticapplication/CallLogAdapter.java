package com.example.mobilediagnosticapplication;

import android.provider.CallLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class CallLogAdapter extends RecyclerView.Adapter<CallLogAdapter.ViewHolder> {
   /* private List<CallLogItem> callLogItems;

    public CallLogAdapter(List<CallLogItem> callLogItems) {
        this.callLogItems = callLogItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.call_log_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CallLogItem item = callLogItems.get(position);

        holder.nameTextView.setText(item.getName());
        holder.numberTextView.setText(item.getNumber());
        holder.typeImageView.setImageResource(getCallTypeIcon(item.getType()));
        holder.durationTextView.setText(getFormattedDuration(item.getDuration()));
        holder.dateTextView.setText(getFormattedDate(item.getDate()));
    }

    @Override
    public int getItemCount() {
        return callLogItems.size();
    }

    private int getCallTypeIcon(int type) {
        switch (type) {
            case CallLog.Calls.INCOMING_TYPE:
                return R.drawable.ic_call_received;
            case CallLog.Calls.OUTGOING_TYPE:
                return R.drawable.ic_call_made;
            case CallLog.Calls.MISSED_TYPE:
                return R.drawable.ic_call_missed;
            default:
                return R.drawable.ic_call;
        }
    }

    */



    private List<CallLogItem> callLogItems;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameTextView;
        private final ImageView typeImageView;
        private final  TextView numberTextView;

        private final TextView dateTextView;
        private final TextView durationTextView;
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            nameTextView = (TextView) view.findViewById(R.id.textView);
            typeImageView=(ImageView) view.findViewById(R.id.imageView);
            numberTextView=(TextView) view.findViewById(R.id.textView2);
            dateTextView=(TextView) view.findViewById(R.id.textView3);
            durationTextView=(TextView) view.findViewById(R.id.textView4);
        }

        public TextView getTextView() {
            return nameTextView;
        }

    }


    public CallLogAdapter(List<CallLogItem> callLogItems) {
        this.callLogItems = callLogItems;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.call_log_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        CallLogItem item = callLogItems.get(position);

        holder.nameTextView.setText(item.getName());
        holder.numberTextView.setText(item.getNumber());
        holder.typeImageView.setImageResource(getCallTypeIcon(item.getType()));
        holder.durationTextView.setText(getFormattedDuration(item.getDuration()));
        holder.dateTextView.setText(getFormattedDate(item.getDate()));
    }
    private int getCallTypeIcon(int type) {
        switch (type) {
            case CallLog.Calls.INCOMING_TYPE:
                return R.drawable.ic_baseline_call_received_24;
            case CallLog.Calls.OUTGOING_TYPE:
                return R.drawable.ic_baseline_call_made_24;
            case CallLog.Calls.MISSED_TYPE:
                return R.drawable.ic_baseline_call_missed_24;
            default:
                return R.drawable.ic_baseline_call_24;
        }
    }
    private String getFormattedDuration(long duration) {
        return String.format("%02d:%02d:%02d", TimeUnit.SECONDS.toHours(duration),
                TimeUnit.SECONDS.toMinutes(duration) % TimeUnit.HOURS.toMinutes(1),
                duration % TimeUnit.MINUTES.toSeconds(1));
    }
    private String getFormattedDate(long timestamp) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return callLogItems.size();
    }
}


