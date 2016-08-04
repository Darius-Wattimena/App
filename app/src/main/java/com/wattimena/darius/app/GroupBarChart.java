package com.wattimena.darius.app;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GroupBarChart extends AppCompatActivity {

    private GoogleApiClient client;

    public static String currentWijk;
    public static int file;
    public InputStream InputStream1;
    public InputStream InputStream2;
    public BuurtCreator buurtCreator = new BuurtCreator();
    public List<Buurt> buurtList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_chart);

        BuurtCreator buurtCreator = new BuurtCreator();
        buurtList.add(buurtCreator.CreateNewBuurt("charlois", "diefstal", R.raw.charlois_diefstal));
        buurtList.add(buurtCreator.CreateNewBuurt("charlois", "normal", R.raw.charlois));
        buurtList.add(buurtCreator.CreateNewBuurt("centrum", "diefstal", R.raw.centrum_diefstal));
        buurtList.add(buurtCreator.CreateNewBuurt("centrum", "normal", R.raw.centrum));
        buurtList.add(buurtCreator.CreateNewBuurt("delfshaven", "diefstal", R.raw.delfshaven_diefstal));
        buurtList.add(buurtCreator.CreateNewBuurt("delfshaven", "normal", R.raw.delfshaven));
        buurtList.add(buurtCreator.CreateNewBuurt("feijenoord", "diefstal", R.raw.feijenoord_diefstal));
        buurtList.add(buurtCreator.CreateNewBuurt("feijenoord", "normal", R.raw.feijenoord));
        buurtList.add(buurtCreator.CreateNewBuurt("hillegersberg", "diefstal", R.raw.hillegerberg_diefstal));
        buurtList.add(buurtCreator.CreateNewBuurt("hillegersberg", "normal", R.raw.hillegersberg));
        buurtList.add(buurtCreator.CreateNewBuurt("hoogvliet", "diefstal", R.raw.hoogvliet_diefstal));
        buurtList.add(buurtCreator.CreateNewBuurt("hoogvliet", "normal", R.raw.hoogvliet));
        buurtList.add(buurtCreator.CreateNewBuurt("kralingen", "diefstal", R.raw.kralingen_diefstal));
        buurtList.add(buurtCreator.CreateNewBuurt("kralingen", "normal", R.raw.kralingen));
        buurtList.add(buurtCreator.CreateNewBuurt("omoord", "diefstal", R.raw.omoord_diefstal));
        buurtList.add(buurtCreator.CreateNewBuurt("omoord", "normal", R.raw.omoord));
        buurtList.add(buurtCreator.CreateNewBuurt("pernis", "diefstal", R.raw.pernis_diefstal));
        buurtList.add(buurtCreator.CreateNewBuurt("pernis", "normal", R.raw.pernis));
        buurtList.add(buurtCreator.CreateNewBuurt("west", "diefstal", R.raw.west_diefstal));
        buurtList.add(buurtCreator.CreateNewBuurt("west", "normal", R.raw.west));
        buurtList.add(buurtCreator.CreateNewBuurt("overschie", "diefstal", R.raw.overschie_diefstal));
        buurtList.add(buurtCreator.CreateNewBuurt("overschie", "normal", R.raw.overschie));
        buurtList.add(buurtCreator.CreateNewBuurt("ijsselmonde", "diefstal", R.raw.ijsselmonde_diefstal));
        buurtList.add(buurtCreator.CreateNewBuurt("ijsselmonde", "normal", R.raw.ijsselmonde));


        GetFile(currentWijk, "diefstal");
        GetFile(currentWijk, "normal");

        DataLoader csvFile = new DataLoader(InputStream1);
        DataLoader csvFile2 = new DataLoader(InputStream2);

        List<String[]> MonthListBike = csvFile.read();
        List<String[]> MonthListContainers = csvFile2.read();

        List<Integer> numbers = new ArrayList<>();
        List<Integer> numbers2 = new ArrayList<>();
        List<String> names = new ArrayList<>();

        for (int i = 1; i < 13; i++) {
            String number = i + "";
            numbers.add(new DataListIterator().iterate(MonthListBike, number));
            numbers2.add(new DataListIterator().iterate(MonthListContainers, number));
        }

        names.add("Jan");
        names.add("Feb");
        names.add("Mar");
        names.add("Apr");
        names.add("Mei");
        names.add("Jun");
        names.add("Jul");
        names.add("Aug");
        names.add("Sep");
        names.add("Oct");
        names.add("Nov");
        names.add("Dec");

        MakeChart(numbers, numbers2, names);

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void GetFile(String wijk, String type)
    {
        switch (type){
            case "diefstal":{
                int data = buurtCreator.GetBuurtFile(wijk, type, buurtList);
                InputStream1 = getResources().openRawResource(data);
            }
            case "normal":{
                int data2 = buurtCreator.GetBuurtFile(wijk, type, buurtList);
                InputStream2 = getResources().openRawResource(data2);
            }
        }
    }

    public Void CreateMonth(String month) {
        xVals.add(month);
        return null;
    }

    public Void CreateMonth2(int value, int number) {
        yVals1.add(new BarEntry(value, number));
        return null;
    }

    public Void CreateMonth3(int value, int number) {
        yVals2.add(new BarEntry(value, number));
        return null;
    }

    public ArrayList<String> xVals = new ArrayList<>();
    public ArrayList<BarEntry> yVals1 = new ArrayList<>();
    public ArrayList<BarEntry> yVals2 = new ArrayList<>();

    public Void MakeChart(List<Integer> list1, List<Integer> list2, List<String> names) {

        Context context = getApplicationContext();

        BarDataSet set1, set2;
        for (int i = 0; i < names.size(); i++) {
            CreateMonth(names.get(i));
        }
        for (int i = 0; i < list1.size(); i++) {
            CreateMonth2(list1.get(i), i);
            CreateMonth3(list2.get(i), i);
        }

        set1 = new BarDataSet(yVals1, "Amount of stolen bicycles");
        set1.setColor(Color.rgb(230, 0, 0));
        set2 = new BarDataSet(yVals2, "Amount of installed bike containers");
        set2.setColor(Color.rgb(164, 228, 251));

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        dataSets.add(set2);

        BarData data = new BarData(xVals, dataSets);

        data.setGroupSpace(80f);

        BarChart chart = new BarChart(context);
        setContentView(chart);
        chart.animateY(3000);

        chart.setData(data);
        chart.setDescription("");

        return null;
    }
}