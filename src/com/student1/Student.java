package com.student1;

public class Student {
    private String name;
    private int sub1;
    private int sub2;
    private int sub3;

    public Student(String name, int sub1, int sub2, int sub3) {
        this.name = name;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
    }

    public String getName() { return name; }
    public int getSub1() { return sub1; }
    public int getSub2() { return sub2; }
    public int getSub3() { return sub3; }
}
