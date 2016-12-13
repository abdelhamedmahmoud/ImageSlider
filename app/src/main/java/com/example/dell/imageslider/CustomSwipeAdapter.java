package com.example.dell.imageslider;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Dell on 12/13/2016.
 */

public class CustomSwipeAdapter extends PagerAdapter {
    int [] image_rsources={R.drawable.about,R.drawable.about720,R.drawable.exformultiple};
    Context ctx;
    LayoutInflater layoutInflater;
    public CustomSwipeAdapter (Context ctx){
        this.ctx=ctx;

    }

    @Override
    public int getCount() {
        return image_rsources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(RelativeLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view=layoutInflater.inflate(R.layout.item,container,false);
        ImageView imageView=(ImageView)item_view.findViewById(R.id.image_view);
        TextView textView=(TextView)item_view.findViewById(R.id.image_count);
        imageView.setImageResource(image_rsources[position]);
        textView.setText("image : "+position);
        container.addView(item_view);



        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((RelativeLayout)object);
    }
}
