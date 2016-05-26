package ru.surf.eugenio_vasilev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private static final String EXTRA_HSV_COLOR = "extra_hsv_color";

    private ArrayList<float[]> hsvColorsList = new ArrayList<float[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // создание адаптера
        createHsvColorList(); // создание списка hsv цветов
        ColorAdapter colorAdapter = new ColorAdapter(this, hsvColorsList);

        // настраиваем список
        ListView colorsListView = (ListView) findViewById(R.id.main_colors_list_view);
        if (colorsListView != null) colorsListView.setAdapter(colorAdapter);

        if (colorsListView != null) {
            colorsListView.setOnItemClickListener(this);
            colorsListView.setOnItemLongClickListener(this);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent colorDetailIntent = new Intent(this, ColorDetailActivity.class);

        // передаём цвет
        colorDetailIntent.putExtra(EXTRA_HSV_COLOR, hsvColorsList.get(position));
        startActivity(colorDetailIntent);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Intent colorNameIntent = new Intent(this, ColorNameActivity.class);

        // передаём цвета
        colorNameIntent.putExtra(EXTRA_HSV_COLOR, hsvColorsList.get(position));
        startActivity(colorNameIntent);

        return true;
    }

    private void createHsvColorList(){
        for(float i = 0; i < 360; i++){
            hsvColorsList.add(new float[]{i, 1, 1});
        }
    }
}
