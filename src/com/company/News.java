package com.company;

import java.util.Date;

public class News {
    int ID;
    private String headline;
    private String textline;
    private Date publicationDate;

    public News() {
    }
    public News(int ID, String headline, String textline, Date publicationDate) {
        this.ID = ID;
        this.headline = headline;
        this.textline = textline;
        this.publicationDate = publicationDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getTextline() {
        return textline;
    }

    public void setTextline(String textline) {
        this.textline = textline;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}
