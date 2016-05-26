package ru.surf.eugenio_vasilev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ColorNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_name_activity);

        Intent mainIntent = getIntent();
        float[] hsvColor = mainIntent.getFloatArrayExtra("extra_hsv_color");
        String nameColor = getNameColor(hsvColor[0]);

        // вывод названия цвета
        TextView colorNameLabel = (TextView) findViewById(R.id.color_name_label);
        if (colorNameLabel != null) colorNameLabel.setText(nameColor);
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
