package com.example.studentportal;

/*import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;*/

public class Portal {

    private String myPortalTitle;
    private String myPortalUrl;

    public Portal(String mPortalName, String mPortalUrl) {

        this.myPortalTitle = mPortalName;
        this.myPortalUrl = mPortalUrl;
    }

    @Override
    public String toString() {
        return myPortalTitle;
    }

    public String getMyPortalTitle() {
        return myPortalTitle;
    }

    public String getMyPortalUrl() {
        return myPortalUrl;
    }

    public void setMyPortalTitle(String myPortalTitle) {
        this.myPortalTitle = myPortalTitle;
    }

    public void setMyPortalUrl(String myPortalUrl) {
        this.myPortalUrl = myPortalUrl;
    }

    //I thought to use Parcelable and Parcel, but rejected this idea.

   /* public Portal(String stringExtra, String myPortalTitle) {
        this.myPortalTitle = myPortalTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.myPortalTitle);
    }

    protected Portal(Parcel in) {
        this.myPortalTitle = in.readString();
    }

    public static final Parcelable.Creator<Portal> CREATOR = new Parcelable.Creator<Portal>() {
        @Override
        public Portal createFromParcel(Parcel source) {
            return new Portal(source);
        }

        @Override
        public Portal[] newArray(int size) {
            return new Portal[size];
        }
    };*/
}
