package com.example.rkdls.apiproject1.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rkdls.apiproject1.R;

public class ItemView extends LinearLayout {
    TextView myText1;
    TextView myText2;
    TextView myText3;

    public ItemView(Context context, ItemDataBox aItem) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.list_layout, this, true);

        myText1 = (TextView) findViewById(R.id.txt_component);
        myText1.setText(aItem.getData(0));

        myText2 = (TextView) findViewById(R.id.txt_productName);
        myText2.setText(aItem.getData(1));

        myText3 = (TextView) findViewById(R.id.txt_price);
        myText3.setText(aItem.getData(2));
    }

    public void setText(int index, String data){
        if(index == 0)
            myText1.setText(data);
        else if (index == 1)
            myText2.setText(data);
        else if (index == 2)
            myText3.setText(data);
        else
            throw new IllegalArgumentException();
    }
}
