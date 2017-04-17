package com.example.reiko.businesscard.ListView;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reiko.businesscard.R;

import java.util.List;

public class ElementAdapter extends ArrayAdapter<ElementListView> {

    public ElementAdapter( Context context, List<ElementListView> elements) {
        super(context, 0, elements);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.element_listview,parent, false);
        }

        ElementListViewHolder viewHolder = (ElementListViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ElementListViewHolder();
            viewHolder.pseudo = (TextView) convertView.findViewById(R.id.pseudo);
            viewHolder.text = (TextView) convertView.findViewById(R.id.text);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(viewHolder);
        }

        ElementListView elementListview = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.pseudo.setText(elementListview.getPseudo());
        viewHolder.text.setText(elementListview.getText());
        viewHolder.avatar.setImageDrawable(new ColorDrawable(elementListview.getColor()));

        return convertView;
    }

    private class ElementListViewHolder{
        public TextView pseudo;
        public TextView text;
        public ImageView avatar;
    }

}
