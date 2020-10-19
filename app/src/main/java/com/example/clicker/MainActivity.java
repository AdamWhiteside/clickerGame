package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public int location = 1;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contain_main);
switch(location){
    case 0:
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain,
                new HomeFragment()).commit();
        break;
    case 1:
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain,
                new ClickerFragment()).commit();
        break;
}

    }

}
