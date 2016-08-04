package com.wattimena.darius.app;

/**
 * Created by DariusPC on 7-7-2016.
 */
public class Buurt{
    private String Wijk;
    private String Type;
    private Integer File;

    public String GetWijk(){
        return this.Wijk;
    }
    public String GetType(){
        return this.Type;
    }
    public Integer GetFile(){
        return this.File;
    }

    public Buurt SetWijk(String newWijk, String newType, Integer newFile){
        this.Wijk = newWijk;
        this.Type = newType;
        this.File = newFile;
        return this;
    }
}