package ru.surf.eugenio_vasilev;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ColorName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_name);

        Intent intent = getIntent();
        float[] itemColor = intent.getFloatArrayExtra("itemColor");

        String nameColor = getNameColor(itemColor[0]);

        // вывод названия цвета
        TextView tvNameColor = (TextView) findViewById(R.id.tvNameColor);
        if (tvNameColor != null) tvNameColor.setText(nameColor);
    }

    public String getNameColor(float hue) {
        String nameColor;

        if(hue < 20) nameColor = "Красный";
        else if(hue < 50) nameColor = "Оранжевый";
        else if(hue < 70) nameColor = "Желтый";
        else if(hue < 140) nameColor = "Зелёный";
        else if(hue < 210) nameColor = "Голубой";
        else if(hue < 270) nameColor = "Синий";
        else if(hue < 300) nameColor = "Фиолетовый";
        else if(hue < 350) nameColor = "Розовый";
        else if(hue < 359) nameColor = "Красный";
        else nameColor = "Цвет неопределён";

        return nameColor;
    }
}
