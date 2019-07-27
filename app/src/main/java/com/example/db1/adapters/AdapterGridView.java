package com.example.db1.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.db1.R;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdapterGridView extends BaseAdapter {
    private Context context;
    ArrayList<String> name;
    ArrayList<String> phone;
    ArrayList<String>urlPhoto;

    public AdapterGridView(Context context, ArrayList<String> name, ArrayList<String> phone, ArrayList<String>urlPhoto) {
        this.context = context;
        this.name = name;
        this.phone = phone;
        this.urlPhoto = urlPhoto;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemGrid;

        if (convertView == null) {

            itemGrid = new View(context);
            itemGrid = inflater.inflate(R.layout.item_grid, null);
            TextView tv_name= (TextView) itemGrid.findViewById(R.id.item_grid_tv_name);
            TextView tv_number = (TextView) itemGrid.findViewById(R.id.item_grid_tv_numero);
            ImageView imageView = (ImageView) itemGrid.findViewById(R.id.item_grid_imgphoto);
            tv_name.setText(name.get(position));
            tv_number.setText(phone.get(position));
            // set image based on selected text
            imageView.setImageResource(R.drawable.img_1);


        } else {
            itemGrid = (View) convertView;
        }
        return itemGrid;
    }
    @Override
    public int getCount() {
        return name.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    public Bitmap cargarImagen(String url, String name)
    {
        File sd = Environment.getExternalStorageDirectory();
        File image = new File(sd+url, name);
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(),bmOptions);
        bitmap = Bitmap.createScaledBitmap(bitmap,200,200,true);
     //   imageView.setImageBitmap(bitmap);
        return  bitmap;
    }
}
