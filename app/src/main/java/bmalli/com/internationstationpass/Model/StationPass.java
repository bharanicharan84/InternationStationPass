package bmalli.com.internationstationpass.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bmalli on 11/29/17.
 */

public class StationPass implements Parcelable {

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getRiseTime() {
        return riseTime;
    }

    public void setRiseTime(long riseTime) {
        this.riseTime = riseTime;
    }

    public long duration;
    public long riseTime;

    public StationPass(long duration, long riseTime){
        this.duration = duration;
        this.riseTime = riseTime;
    }

    protected StationPass(Parcel in) {
        long[] data = new long[2];
        in.readLongArray(data);

        this.duration = data[0];
        this.riseTime = data[1];
    }

    public static final Creator<StationPass> CREATOR = new Creator<StationPass>() {
        @Override
        public StationPass createFromParcel(Parcel in) {
            return new StationPass(in);
        }

        @Override
        public StationPass[] newArray(int size) {
            return new StationPass[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeLongArray(new long[]{this.duration,this.riseTime});
    }
}
