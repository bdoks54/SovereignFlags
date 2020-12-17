package com.bdoks54.wikisovereignflagsapp;

import java.io.Serializable;

public class SovereignFlag implements Serializable {
    private String name;    //South Korea
    private String shortname;   //KR
    private String code;    //410
    private String flag;
    private String korname;
    //for android R
    private int rid;        //이미지별 고유 아이디

    public SovereignFlag(String name, String shortname, String code, String korname, int rid) {
        this.name = name;
        this.shortname = shortname;
        this.code = code;
        this.korname = korname;
        this.rid = rid;
    }


    public int getRid() {
        return rid;
    }
    public String getCode() {
        return code;
    }

    public String getFlag() {
        return flag;
    }

    public String getKorname() {
        return korname;
    }

    public String getName() {
        return name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setKorname(String korname) {
        this.korname = korname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    @Override
    public String toString() {
        return "SovereignFlag{" +
                "name='" + name + '\'' +
                ", shortname='" + shortname + '\'' +
                ", code='" + code + '\'' +
                ", flag='" + flag + '\'' +
                ", korname='" + korname + '\'' +
                ", rid=" + rid +
                '}';
    }
}
