package com.example.Web_Junit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "notes")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Note {

    public Note(){
    }

    public Note(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "tag")
    private String tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
