package learn.android.calculator;

import android.os.Parcel;
import android.os.Parcelable;

public class UserInputDataHolder implements Parcelable {

    public UserInputDataHolder() {
    }

    private StringBuilder userInput = new StringBuilder();

    protected UserInputDataHolder(Parcel in) {
    }

    public static final Creator<UserInputDataHolder> CREATOR = new Creator<UserInputDataHolder>() {
        @Override
        public UserInputDataHolder createFromParcel(Parcel in) {
            return new UserInputDataHolder(in);
        }

        @Override
        public UserInputDataHolder[] newArray(int size) {
            return new UserInputDataHolder[size];
        }
    };

    public StringBuilder getUserInput() {
        return userInput;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
