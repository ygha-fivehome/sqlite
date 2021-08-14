package com.ygha.mysql.exam;

public class DeviceInfo {

    int id;
    String space;
    String nickname;
    String uuid;

    public DeviceInfo(int id, String space, String nickname, String uuid) {
        this.id = id;
        this.space = space;
        this.nickname = nickname;
        this.uuid = uuid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
