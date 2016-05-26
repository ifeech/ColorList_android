package ru.surf.eugenio_vasilev;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vevge on 03.05.2016.
 * Кастомизация списка
 */
public class ColorAdapter extends ArrayAdapter<float[]> {

    static class ViewHolder {
        TextView itemColorLabel;
    }

    public ColorAdapter(Context context, List<float[]> objects) {
        super(context, R.layout.color_list_item, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.color_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.itemColorLabel = (TextView) convertView.findViewById(R.id.item_color_label);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.itemColorLabel.setBackgroundColor(Color.HSVToColor(getItem(position)));

        return convertView;
    }
}
