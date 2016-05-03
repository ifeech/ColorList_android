package ru.surf.eugenio_vasilev;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<float[]> hsvColorsList = new ArrayList<float[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // создание адаптера
        createHsvColorList(); // создание списка hsv цветов
        LvAdapter lvAdapter = new LvAdapter(this, hsvColorsList);

        // настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.lvMain);
        if (lvMain != null) lvMain.setAdapter(lvAdapter);

        lvMain.setOnItemClickListener(this);
    }

    private void createHsvColorList(){
        for(float i = 0; i < 360; i++){
            hsvColorsList.add(new float[]{i, 1, 1});
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent ColorDetailIntent = new Intent(this, ColorDetail.class);

        // передаём цвет
        ColorDetailIntent.putExtra("itemColor", hsvColorsList.get(position));
        startActivity(ColorDetailIntent);
    }
}
