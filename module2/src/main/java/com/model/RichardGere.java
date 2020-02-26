package com.model;

public class RichardGere {

    private  long id;
    private  String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public RichardGere(long id, String content) {
        this.id = id;
        this.content = content;
    }


}
