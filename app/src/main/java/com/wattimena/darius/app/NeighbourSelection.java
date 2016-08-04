package com.wattimena.darius.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NeighbourSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.neighbour_selection);

        Button centrum = (Button) findViewById(R.id.button9);
        Button delfshaven = (Button) findViewById(R.id.button10);
        Button feijenoord = (Button) findViewById(R.id.button11);
        Button charlois = (Button) findViewById(R.id.button12);
        Button hillegersberg = (Button) findViewById(R.id.button13);
        Button kralingen = (Button) findViewById(R.id.button15);
        Button overschie = (Button) findViewById(R.id.button16);
        Button ijsselmonde = (Button) findViewById(R.id.button17);
        Button hoogvliet = (Button) findViewById(R.id.button18);
        Button omoord = (Button) findViewById(R.id.button19);
        Button pernis = (Button) findViewById(R.id.button20);
        Button west = (Button) findViewById(R.id.button21);

        BuurtCreator buurtCreator = new BuurtCreator();
        buurtCreator.CreateNewBuurt("centrum", "diefstal", R.raw.centrum_diefstal);
        buurtCreator.CreateNewBuurt("centrum", "normal", R.raw.centrum);

        ButtonFactory("centrum", centrum);
        ButtonFactory("delfshaven", delfshaven);
        ButtonFactory("feijenoord", feijenoord);
        ButtonFactory("charlois", charlois);
        ButtonFactory("hillegersberg", hillegersberg);
        ButtonFactory("kralingen", kralingen);
        ButtonFactory("overschie", overschie);
        ButtonFactory("ijsselmonde", ijsselmonde);
        ButtonFactory("hoogvliet", hoogvliet);
        ButtonFactory("omoord", omoord);
        ButtonFactory("pernis", pernis);
        ButtonFactory("west", west);

    }

    private void ButtonFactory(final String Wijk, Button btn){
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), GroupBarChart.class);
                GroupBarChart.currentWijk = Wijk;
                view.getContext().startActivity(intent);
            }


        });
    }

}
