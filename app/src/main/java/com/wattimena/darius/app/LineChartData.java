package com.wattimena.darius.app;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class LineChartData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line_chart);
        InputStream inputStream = getResources().openRawResource(R.raw.fietsdiefstal_rotterdam_linechart);
        DataLoader dataLoader = new DataLoader(inputStream);
        List<String[]> MonthList = dataLoader.read();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            String number = i + "";
            numbers.add(new DataListIterator().iterate(MonthList, number));
        }

        List<String> names = new ArrayList<String>();

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

        MakeChart(numbers, names);
    }

    public Void MakeChart(List<Integer> list1, List<String> names) {

        Context context = getApplicationContext();
        ArrayList<Entry> entries = new ArrayList<>();

        for (int i = 0; i < list1.size(); i++) {
            entries.add(new Entry(list1.get(i), i));
        }

        LineDataSet dataset = new LineDataSet(entries, "Data");

        LineChart nChart = new LineChart(context);
        setContentView(nChart);

        LineData data = new LineData(names, dataset);
        nChart.setData(data);

        nChart.setDescription("");

        Legend l = nChart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        return null;
    }
}
