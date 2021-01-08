package com.java;
public class combine {
    int tamil;
    int english;
    int maths;
    int science;
    int social;
    public combine(int p_tamil, int p_english, int p_maths, int p_science, int p_social) {
        tamil = p_tamil;
        english = p_english;
        maths = p_maths;
        science = p_science;
        social = p_social;
    }
    public int readTamil(){
        return tamil;
    }
    public int readEnglish(){
        return english;
    }
    public int readMaths(){
        return maths;
    }
    public int readScience(){
        return science;
    }
    public int readSocial(){
        return social;
    }
}

