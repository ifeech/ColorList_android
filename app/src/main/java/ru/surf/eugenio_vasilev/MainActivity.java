package ru.surf.eugenio_vasilev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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
        lvMain.setAdapter(lvAdapter);
    }

    private void createHsvColorList(){
        for(float i = 0; i < 360; i++){
            hsvColorsList.add(new float[]{i, 1, 1});
        }
    }

}
