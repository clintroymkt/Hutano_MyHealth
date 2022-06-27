package com.example.MyHealth;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyXAxisValueFormatter extends ValueFormatter implements IAxisValueFormatter {


    private String[] mValues;

    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    public void DateAxisValueFormatter(String[] values) {
        this.mValues = values; }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return sdf.format(new Date((long) value));
    }
}
   /* public String getXValue(String dateInMillisecons, int index, ViewPortHandler viewPortHandler) {
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("MMM DD");
            //return sdf.format(new Date(Long.parseLong(dateInMillisecons)));

            String s = sdf.format(dateInMillisecons);

            return s;

        } catch (Exception e) {

            return dateInMillisecons;
        }
    } */
//}