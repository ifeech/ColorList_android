package ru.surf.eugenio_vasilev;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vevge on 03.05.2016.
 * Кастомизация списка
 */
public class LvAdapter extends BaseAdapter {

    private LayoutInflater lInflater;
    private ArrayList<float[]> list;

    LvAdapter(Context context, ArrayList<float[]> data) {
        list = data;
        lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        ((TextView) view.findViewById(R.id.tvItem)).setBackgroundColor(Color.HSVToColor(list.get(position)));

        return view;
    }
}
