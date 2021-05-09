package com.example.android.t108590049_HW8_5_2;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

class Sport implements Parcelable {

    private String title;
    private String info;
    private String details;
    private final int imageResource;

    private Sport(@NonNull Parcel in) {
        title   = in.readString();
        info    = in.readString();
        details = in.readString();
        imageResource = in.readInt();
    }

    public Sport(String title, String info, String details, int imageResource) {
        this.title   = title;
        this.info    = info;
        this.details = details;
        this.imageResource = imageResource;
    }

    public static final Creator<Sport> CREATOR = new Creator<Sport>() {

        @NonNull
        @Override
        public Sport createFromParcel(Parcel in) {
            return new Sport(in);
        }

        @NonNull
        @Override
        public Sport[] newArray(int size) {
            return new Sport[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(info);
        dest.writeString(details);
        dest.writeInt(imageResource);
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public String getDetails() {
        return details;
    }

    public int getImageResource() {
        return imageResource;
    }
}
