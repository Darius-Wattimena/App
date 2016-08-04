package com.wattimena.darius.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by DariusPC on 4-8-2016.
 */
public class DataListIterator {
    int current = -1;
    int amount = 0;
    String[] data;
    ArrayList list2 = new ArrayList();
    public int iterate(List<String[]> MonthList, String month){
        Iterator itr = MonthList.iterator() ;
        while (itr.hasNext() ){
            current += 1;
            data = MonthList.get(current);
            list2.add(data[0]);
            itr.next();
        }
        for (int i=0;i < list2.size();i++)
            if (list2.get(i).equals(month)){
                amount += 1;
            }
        return amount ;
    }
}

