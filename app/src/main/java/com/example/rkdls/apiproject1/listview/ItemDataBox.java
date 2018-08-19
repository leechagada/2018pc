package com.example.rkdls.apiproject1.listview;

public class ItemDataBox {
    String[] myData;

    public ItemDataBox(String text1, String text2, String text3) {
        myData = new String[3];
        myData[0] = text1;
        myData[1] = text2;
        myData[2] = text3;
    }

    public String[] getData(){
        return myData;
    }

    public String getData(int index){
        if (myData == null || index >= myData.length)
            return null;

        return myData[index];
    }
}
