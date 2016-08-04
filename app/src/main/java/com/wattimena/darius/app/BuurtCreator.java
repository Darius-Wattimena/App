package com.wattimena.darius.app;

import java.util.List;
import java.util.Objects;

/**
 * Created by DariusPC on 7-7-2016.
 */
public class BuurtCreator {
    public Buurt CreateNewBuurt(String wijk, String type, Integer file)
    {
        Buurt CurrentBuurt = new Buurt();
        return CurrentBuurt.SetWijk(wijk, type, file);
    }

    public Integer GetBuurtFile(String wijk, String type, List<Buurt> list)
    {
        Integer value = null;
        for (int i = 0; i < list.size(); i++) {
            if(Objects.equals(list.get(i).GetWijk(), wijk) && Objects.equals(list.get(i).GetType(), type)){
                value = list.get(i).GetFile();
            }
        }
        return value;
    }
}