package com.example.demov2;

public class InjuryModel {

    int _id;
    String body_part;
    String sb_part;
    String injury;
    int image;
    String content;
    //byte[] Image;


    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getBody_part() {
        return body_part;
    }

    public void setBody_part(String body_part) {
        this.body_part = body_part;
    }

    public String getSb_part() {
        return sb_part;
    }

    public void setSb_part(String sb_part) {
        this.sb_part = sb_part;
    }

    public String getInjury() {
        return injury;
    }

    public void setInjury(String injury) {
        this.injury = injury;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
/*
    public byte[] getImage() {
        return Image;
    }*/

   // public void setImage(byte[] image) {
    //    Image = image;
  //  }

    public InjuryModel(String body_part, String sb_part, String injury, String content,  int image) {
        this.body_part = body_part;
        this.sb_part = sb_part;
        this.injury = injury;
        this.content = content;
        this.image = image;
    }

    public InjuryModel() {
    }

    public InjuryModel(int _id, String body_part, String sb_part, String injury, String content, int image) {
        this._id = _id;
        this.body_part = body_part;
        this.sb_part = sb_part;
        this.injury = injury;
        this.content = content;
        this.image = image;
    }

    public InjuryModel(int _id, String body_part, String sb_part, String injury, String content) {
        this._id = _id;
        this.body_part = body_part;
        this.sb_part = sb_part;
        this.injury = injury;
        this.content = content;
    }


}
