package ru.surf.eugenio_vasilev;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ColorDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_detail_activity);

        Intent mainIntent = getIntent();
        float[] hsvColor = mainIntent.getFloatArrayExtra("extra_hsv_color");

        // фон страницы
        RelativeLayout detailColorPage = (RelativeLayout) findViewById(R.id.detailColorPage);
        if (detailColorPage != null) detailColorPage.setBackgroundColor(Color.HSVToColor(hsvColor));

        // вывод rgb цвета
        String textRgbColor = hsvToRgb(hsvColor[0], hsvColor[1], hsvColor[2]);
        TextView rgbLabel = (TextView) findViewById(R.id.color_detail_rgb_label);
        if (rgbLabel != null) rgbLabel.setText(textRgbColor);
    }

    public final String hsvToRgb(float hue, float saturation, float value) {
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
            default: throw new RuntimeException("Ошибка конвертации HSV в RGB. HSV: " + hue + ", " + saturation + ", " + value);
        }
    }

    public final String rgbToString(float r, float g, float b) {
        String rs = Integer.toString((int)(r * 255));
        String gs = Integer.toString((int)(g * 255));
        String bs = Integer.toString((int)(b * 255));

        return "R: " + rs + ", G: " + gs + ", B: " + bs;
    }
}
