package com.example.timetable;

public class Model {
    private String sno;
    private String one;
    private String two;
    private String three;

    private String four;
    private String five;
    private String six;

    public Model(String sno,String one, String two, String three, String four, String five, String six) {
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
        this.six = six;
        this.sno=sno;
    }
public String getSno()
{
    return sno;
}
    public String getone() {
        return one;
    }

    public String gettwo() {
        return two;
    }

    public String getthree() {
        return three;
    }

    public String getfour() {
        return four;
    }
    public String getfive() {
        return five;
    }

    public String getsix() {
        return six;
    }
}
