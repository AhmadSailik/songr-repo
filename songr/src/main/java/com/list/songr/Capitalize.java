package com.list.songr;

public class Capitalize {
    private String word;
    public String getWord() {
        return word.toUpperCase();
    }

    public void setWord(String word) {
        this.word = word;
    }


    public Capitalize(String word){
        this.word=word;
    }


}
