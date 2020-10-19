package com.example.clicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ClickerFragment extends Fragment {
    public double cash;
    public double[] statsCost;
    public double[] statsQuantity;
    public double[] statsPower;
    public int quant = 1;

    private Button clickBtn, upgrade1, upgrade2, upgrade3, upgrade4, upgrade5, upgrade6, buyAmnt1,
            buyAmnt2, buyAmnt3, buyAmnt4;
    private TextView balance;
    private final static String cashc = "cashc";
    private final static String psts = "pstats";
    private final static String qsts = "qstats";
    private final static String csts = "cstats";


    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstaceState){
        View rootView = inflater.inflate(R.layout.fragment_clicks, container, false);

        clickBtn = rootView.findViewById(R.id.btn_click);
        upgrade1 = rootView.findViewById(R.id.btn_up1);
        upgrade2 = rootView.findViewById(R.id.btn_up2);
        upgrade3 = rootView.findViewById(R.id.btn_up3);
        upgrade4 = rootView.findViewById(R.id.btn_up4);
        upgrade5 = rootView.findViewById(R.id.btn_up5);
        upgrade6 = rootView.findViewById(R.id.btn_up6);
        balance = rootView.findViewById(R.id.txt_bal);
        buyAmnt1 = rootView.findViewById(R.id.btn_amnt1);
        buyAmnt2 = rootView.findViewById(R.id.btn_amnt2);
        buyAmnt3 = rootView.findViewById(R.id.btn_amnt3);
        buyAmnt4 = rootView.findViewById(R.id.btn_amnt4);

        if(savedInstaceState != null){
            cash = savedInstaceState.getInt(cashc);

            statsCost = savedInstaceState.getDoubleArray(csts);
            statsQuantity = savedInstaceState.getDoubleArray(qsts);
            statsPower = savedInstaceState.getDoubleArray(psts);
            updateCash();
            setCostText(upgrade1, statsCost[0]);
            setCostText(upgrade2, statsCost[1]);
            setCostText(upgrade3, statsCost[2]);
            setCostText(upgrade4, statsCost[3]);
            setCostText(upgrade5, statsCost[4]);
            setCostText(upgrade6, statsCost[5]);
        }else{
            loadDefaults();
        }


        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cash += 1 +
                        statsPower[0]*statsQuantity[0] +
                        statsPower[1]*statsQuantity[1] +
                        statsPower[2]*statsQuantity[2] +
                        statsPower[3]*statsQuantity[3] +
                        statsPower[4]*statsQuantity[4] +
                        statsPower[5]*statsQuantity[5];
                updateCash();
            }
        });

        upgrade1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cash -= statsCost[0];
                statsCost[0] = getUpgradeCost(upgrade1);;
                updateCash();
                setUpgradeCost(statsCost[0], upgrade1);
                statsQuantity[0]++;
            }
        });

        upgrade2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cash -= statsCost[1];
                statsCost[1] = getUpgradeCost(upgrade2);
                updateCash();
                setUpgradeCost(statsCost[1], upgrade2);
                statsQuantity[1]++;
            }
        });

        upgrade3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cash -= statsCost[2];
                statsCost[2] = getUpgradeCost(upgrade3);
                updateCash();
                setUpgradeCost(statsCost[2], upgrade3);
                statsQuantity[2]++;
            }
        });

        upgrade4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cash -= statsCost[3];
                statsCost[3] = getUpgradeCost(upgrade4);
                updateCash();
                setUpgradeCost(statsCost[3], upgrade4);
                statsQuantity[3]++;
            }
        });

        upgrade5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cash -= statsCost[4];
                statsCost[4] = getUpgradeCost(upgrade5);
                updateCash();
                setUpgradeCost(statsCost[4], upgrade5);
                statsQuantity[4]++;
            }
        });

        upgrade6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cash -= statsCost[5];
                statsCost[5] = getUpgradeCost(upgrade6);;
                updateCash();
                setUpgradeCost(statsCost[5], upgrade6);
                statsQuantity[5]++;
            }
        });


        buyAmnt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quant = 1;
            }
        });

        buyAmnt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quant = 5;
            }
        });

        buyAmnt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quant = 20;
            }
        });

        buyAmnt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quant = -1;
            }
        });
        return rootView;
    }


    public void updateCash(){
        String strDouble = String.format("%.2f", cash);
        balance.setText("$" + strDouble);
        upgradesUnlock();
        upgradesEnable();
    }



    //checks to see if upgrades can be bought
    public void upgradesEnable(){

        if(cash < statsCost[0]) {
            upgrade1.setEnabled(false);
        }

        if(cash < statsCost[1]) {
            upgrade2.setEnabled(false);
        }

        if(cash < statsCost[2]) {
            upgrade3.setEnabled(false);
        }

        if(cash < statsCost[3]) {
            upgrade4.setEnabled(false);
        }

        if(cash < statsCost[4]) {
            upgrade5.setEnabled(false);
        }

        if(cash < statsCost[5]) {
            upgrade6.setEnabled(false);
        }
    }


    //checks for upgrades when the game loads, button is clicked, and money ticks up
    //additionally enables upgrades to be bought
    public void upgradesUnlock(){

            if(cash >= statsCost[0]) {
                upgrade1.setVisibility(View.VISIBLE);
                upgrade1.setEnabled(true);
            }

            if(cash >= statsCost[1]) {
                upgrade2.setVisibility(View.VISIBLE);
                upgrade2.setEnabled(true);
            }

            if(cash >= statsCost[2]) {
                upgrade3.setVisibility(View.VISIBLE);
                upgrade3.setEnabled(true);
            }

            if(cash >= statsCost[3]) {
                upgrade4.setVisibility(View.VISIBLE);
                upgrade4.setEnabled(true);
            }

            if(cash >= statsCost[4]) {
                upgrade5.setVisibility(View.VISIBLE);
                upgrade5.setEnabled(true);
            }

            if(cash >= statsCost[5]) {
                upgrade6.setVisibility(View.VISIBLE);
                upgrade6.setEnabled(true);
            }
    }


    //
    public void moneyTick(){
        updateCash();

    }


    //sets the upgrade cost text when loading the game
    public void setCostText(Button upgradeNum, double currentCost){
        String temp = upgradeNum.getText().toString();
        temp = temp.substring(0, temp.lastIndexOf("$") +1) + String.format("%.2f", currentCost);
        upgradeNum.setText(temp);
    }


    //returns the cost of the next upgrade after buying
    public double getUpgradeCost(Button upgradeNum){
        String temp = upgradeNum.getText().toString();
        String currentCost = temp.substring(temp.lastIndexOf("$") + 1);
        double tempCost = Double.parseDouble(currentCost);
        return tempCost + tempCost*.01;
    }


    //sets the text after buying an upgrade
    public void setUpgradeCost(double cost, Button upgradeNum){
        String temp = upgradeNum.getText().toString();
        temp = temp.substring(0, temp.lastIndexOf("$") +1) + String.format("%.2f", cost);
        upgradeNum.setText(temp);
    }


    //sets default values if none exist
    public void loadDefaults(){
        //cost, quantity, base power (multiply base power by quantity for current power)
        statsCost = new double[]{20, 100, 500, 3000, 9000, 40000};
        statsQuantity = new double[]{0, 0, 0, 0, 0, 0};
        statsPower = new double[]{5, 40, 100, 500, 1000, 5000};
        cash = 0;

        String temp = "grain of sand \n$" + String.format("%.2f", statsCost[0]);
        upgrade1.setText(temp);
        temp = "Scarab \n$" + String.format("%.2f", statsCost[1]);
        upgrade2.setText(temp);
        temp = "Mummy Foot \n$" + String.format("%.2f", statsCost[2]);
        upgrade3.setText(temp);
        temp = "Ancient Brick \n$" + String.format("%.2f", statsCost[3]);
        upgrade4.setText(temp);
        temp = "Important Scepter \n$" + String.format("%.2f", statsCost[4]);
        upgrade5.setText(temp);
        temp = "Ra Autograph \n$" + String.format("%.2f", statsCost[5]);
        upgrade6.setText(temp);
    }





    //saved values
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        //string, data
        savedInstanceState.putDouble(cashc, cash);
        savedInstanceState.putDoubleArray(csts, statsCost);
        savedInstanceState.putDoubleArray(psts, statsPower);
        savedInstanceState.putDoubleArray(qsts, statsQuantity);
    }

}
