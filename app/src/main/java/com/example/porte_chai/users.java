package com.example.porte_chai;
public class users {
    public String sage;
    public String scity;
    public String skilo;
    public String slink;
    public String sname;
    public String sphone;
    public String sstreet;
    public String svideoIntro;

    public users() {
    }

    public String getSname() {
        return this.sname;
    }

    public String getSphone() {
        return this.sphone;
    }

    public String getSage() {
        return this.sage;
    }

    public String getSkilo() {
        return this.skilo;
    }

    public String getSstreet() {
        return this.sstreet;
    }

    public String getScity() {
        return this.scity;
    }

    public String getSlink() {
        return this.slink;
    }
    public String getVideoIntro() {
        return this.svideoIntro;
    }

    public users(String sname, String sphone, String sage, String skilo, String sstreet, String scity, String slink,String svideoIntro) {
        this.sname = sname;
        this.sphone = sphone;
        this.sage = sage;
        this.skilo = skilo;
        this.sstreet = sstreet;
        this.scity = scity;
        this.slink = slink;
        this.svideoIntro = svideoIntro;
    }
}