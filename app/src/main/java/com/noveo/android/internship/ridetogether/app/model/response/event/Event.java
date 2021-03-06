package com.noveo.android.internship.ridetogether.app.model.response.event;

import com.google.gson.annotations.SerializedName;
import org.parceler.Parcel;

import java.util.Date;
import java.util.List;

@Parcel
public class Event implements EventBased {
    @SerializedName("route_id")
    int routeId;
    @SerializedName("creator_id")
    int creatorId;
    @SerializedName("image_path")
    String imagePath;
    @SerializedName("date")
    Date date;
    @SerializedName("description")
    String description;
    @SerializedName("participants")
    List<User> participants;
    @SerializedName("subscribers")
    List<User> subscribers;
    @SerializedName("title")
    String title;
    @SerializedName("id")
    int id;
    @SerializedName("added_at")
    Date addedAt;

    public Event() {
    }

    public Event(int id, int routeId, Date date, List<User> participants,
                 List<User> subscribers, String description, String title, String imagePath, Date addedAt) {
        this.id = id;
        this.routeId = routeId;
        this.date = date;
        this.participants = participants;
        this.subscribers = subscribers;
        this.description = description;
        this.title = title;
        this.imagePath = imagePath;
        this.addedAt = addedAt;
    }

    public int getId() {
        return id;
    }

    public int getRouteId() {
        return routeId;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public List<User> getSubscribers() {
        return subscribers;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    @Override
    public EventViewType getViewType() {
        return EventViewType.EVENT;
    }
}
