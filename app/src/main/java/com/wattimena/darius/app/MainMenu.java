package com.wattimena.darius.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainMenu extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        Button barChart = (Button) findViewById(R.id.button);
        Button lineChart = (Button) findViewById(R.id.button2);

        ButtonFactory(barChart, NeighbourSelection.class);
        ButtonFactory(lineChart, LineChartData.class);
    }

    private void ButtonFactory(Button btn, final Class activity){
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), activity);
                view.getContext().startActivity(intent);
            }


        });
    }
}