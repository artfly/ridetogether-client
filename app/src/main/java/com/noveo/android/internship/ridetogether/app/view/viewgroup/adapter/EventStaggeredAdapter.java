package com.noveo.android.internship.ridetogether.app.view.viewgroup.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.noveo.android.internship.ridetogether.app.R;
import com.noveo.android.internship.ridetogether.app.model.response.event.Event;
import com.noveo.android.internship.ridetogether.app.model.rest.RideTogetherClient;
import com.noveo.android.internship.ridetogether.app.utils.EventUtil;
import com.noveo.android.internship.ridetogether.app.view.viewgroup.holder.EventStaggeredViewHolder;

import java.util.List;

public class EventStaggeredAdapter extends RecyclerView.Adapter<EventStaggeredViewHolder> {
    private List<Event> events;
    private Context context;

    public EventStaggeredAdapter(List<Event> events, Context context) {
        this.events = events;
        this.context = context;
    }

    @Override
    public EventStaggeredViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View eventView = inflater.inflate(R.layout.list_item_event_staggered, parent, false);

        return new EventStaggeredViewHolder(eventView);
    }

    @Override
    public void onBindViewHolder(final EventStaggeredViewHolder holder, int position) {
        Event event = events.get(position);
        holder.eventTitleView.setText(event.getTitle());
        holder.eventDateView.setText(EventUtil.dateToTimedString(event.getDate(), context));
        holder.progressBar.setVisibility(View.VISIBLE);
        Log.d("GlidePath", RideTogetherClient.getImageUrl(event.getImagePath()));
        Glide.with(context)
                .load(RideTogetherClient.getImageUrl(event.getImagePath()))
                .asBitmap()
                .listener(new RequestListener<String, Bitmap>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                        float ratio = (float) bitmap.getHeight() / (float) bitmap.getWidth();
                        holder.eventImageView.setHeightRatio(ratio);
                        holder.eventImageView.setImageBitmap(bitmap);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
