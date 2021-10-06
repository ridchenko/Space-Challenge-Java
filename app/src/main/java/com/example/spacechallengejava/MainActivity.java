package com.example.spacechallengejava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String phase1Path = "phase01.txt";
    public static final String phase2Path = "phase02.txt";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Simulation simulation = new Simulation(this);

        ArrayList<Item> phase1 = simulation.loadItems(phase1Path);
        ArrayList<Item> phase2 = simulation.loadItems(phase2Path);

        ArrayList<U1> u1Phase1 = simulation.loadU1(phase1);
        ArrayList<U1> u1Phase2 = simulation.loadU1(phase2);
        ArrayList<U2> u2Phase1 = simulation.loadU2(phase1);
        ArrayList<U2> u2Phase2 = simulation.loadU2(phase2);

        int U1_budget = simulation.runSimulation(u1Phase1) +
                simulation.runSimulation(u1Phase2);
        int U2_budget = simulation.runSimulation(u2Phase1) +
                simulation.runSimulation(u2Phase2);

        TextView result = findViewById(R.id.txtResult);
        result.setText("U1 budget = " + U1_budget + "millions"
                + "\nU2 budget = " + U2_budget + "millions");
    }
}