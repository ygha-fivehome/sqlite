package com.ygha.mysql.exam;

public class SpaceEntity {

    private int mId;
    private String mSpace;
    private String mNickname;
    private String mUuid;

    public SpaceEntity(int mId, String mSpace, String mNickname, String mUuid) {
        this.mId = mId;
        this.mSpace = mSpace;
        this.mNickname = mNickname;
        this.mUuid = mUuid;
    }

    public int getId() {
        return mId;
    }

    public String getSpace() {
        return mSpace;
    }

    public String getNickname() {
        return mNickname;
    }

    public String getUuid() {
        return mUuid;
    }
}
