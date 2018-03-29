package com.example.mehdi.onboarding;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Mehdi on 18/12/2017.
 */

public class SliderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    private int[] sliderImages = {R.drawable.eat_icon, R.drawable.sleep_icon, R.drawable.code_icon};
    private String[] sliderHeader = {"EAT", "SLEEP", "CODE"};
    private String[] sliderDescription = {"Simply create different folders for each language. If english is your default language, just put the english strings into res/values/strings.xml. Then create a new folder values-ru and put the russian strings with identical names into res/values-ru/strings.xml. ",
            "Simply create different folders for each language. If english is your default language, just put the english strings into res/values/strings.xml. Then create a new folder values-ru and put the russian strings with identical names into res/values-ru/strings.xml. ",
            "Simply create different folders for each language. If english is your default language, just put the english strings into res/values/strings.xml. Then create a new folder values-ru and put the russian strings with identical names into res/values-ru/strings.xml. "};

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return sliderImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView imageViewSlider = view.findViewById(R.id.imageView_slider);
        TextView textViewHeader = view.findViewById(R.id.textView_slider_header);
        TextView textViewDescription = view.findViewById(R.id.textView_slider_description);

        imageViewSlider.setImageResource(sliderImages[position]);
        textViewHeader.setText(sliderHeader[position]);
        textViewDescription.setText(sliderDescription[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}

















