package com.example.porte_chai;
public class prodata {
    private String jcity;
    private String jdes;
    private String jkey;
    private String jnumber;
    private String jsalary;
    private String jtime;
    private String jtitle;

    public prodata() {
    }

    public String getJnumber() {
        return this.jnumber;
    }

    public String getJkey() {
        return this.jkey;
    }

    public String getJtitle() {
        return this.jtitle;
    }

    public String getJcity() {
        return this.jcity;
    }

    public String getJtime() {
        return this.jtime;
    }

    public String getJsalary() {
        return this.jsalary;
    }

    public String getJdes() {
        return this.jdes;
    }

    public prodata(String jnumber, String jkey, String jtitle, String jcity, String jtime, String jsalary, String jdes) {
        this.jnumber = jnumber;
        this.jkey = jkey;
        this.jtitle = jtitle;
        this.jcity = jcity;
        this.jtime = jtime;
        this.jsalary = jsalary;
        this.jdes = jdes;
    }
}