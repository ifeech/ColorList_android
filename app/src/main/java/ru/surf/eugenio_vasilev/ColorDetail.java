package ru.surf.eugenio_vasilev;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ColorDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_detail);

        TextView tvColor = (TextView) findViewById(R.id.tvColor);

        Intent intent = getIntent();
        float[] itemColor = intent.getFloatArrayExtra("itemColor");

        // фон страницы
        RelativeLayout detailColorPage = (RelativeLayout) findViewById(R.id.detailColorPage);
        detailColorPage.setBackgroundColor(Color.HSVToColor(itemColor));

        // вывод rgb цвета
        String rgbColor = hsvToRgb(itemColor[0], itemColor[1], itemColor[2]);
        tvColor.setText(rgbColor);
    }

    public String hsvToRgb(float hue, float saturation, float value) {

        int h = (int)(hue/60) % 6;
        float Vmin = (1 - saturation)*value;
        float a = (value - Vmin)*((hue % 60)/60);
        float Vinc = Vmin+a;
        float Vdec = value-a;

        switch (h) {
            case 0: return rgbToString(value, Vinc, Vmin);
            case 1: return rgbToString(Vdec, value, Vmin);
            case 2: return rgbToString(Vmin, value, Vinc);
            case 3: return rgbToString(Vmin, Vdec, value);
            case 4: return rgbToString(Vinc, Vmin, value);
            case 5: return rgbToString(value, Vmin, Vdec);
            default: throw new RuntimeException("Something went wrong when converting from HSV to RGB. Input was " + hue + ", " + saturation + ", " + value);
        }
    }

    public String rgbToString(float r, float g, float b) {
        String rs = Integer.toString((int)(r * 255));
        String gs = Integer.toString((int)(g * 255));
        String bs = Integer.toString((int)(b * 255));
        return "R: " + rs + ", G: " + gs + ", B: " + bs;
    }
}
