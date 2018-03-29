package com.example.mehdi.onboarding;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private Button buttonBack, buttonNext;
    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] textViewDots;

    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBack = findViewById(R.id.button_back);
        buttonNext = findViewById(R.id.button_next);
        viewPager = findViewById(R.id.viewPager_mainActivity);
        linearLayout = findViewById(R.id.linearLayout_dots);

        sliderAdapter = new SliderAdapter(this);

        viewPager.setAdapter(sliderAdapter);

        buttonNext.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
        viewPager.addOnPageChangeListener(this);

        addDotsIndicator(0);
    }

    private void addDotsIndicator(int position) {
        textViewDots = new TextView[3];
        linearLayout.removeAllViews();

        for (int i = 0; i < textViewDots.length; i++) {
            textViewDots[i] = new TextView(this);
            textViewDots[i].setText(Html.fromHtml("&#8226"));
            textViewDots[i].setTextSize(35);
            textViewDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            linearLayout.addView(textViewDots[i]);
        }

        if (textViewDots.length > 0) {
            textViewDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_next : {
                viewPager.setCurrentItem(currentPage + 1);
                break;
            }

            case R.id.button_back : {
                viewPager.setCurrentItem(currentPage - 1);
            }
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        addDotsIndicator(position);
        currentPage = position;

        if (position == 0) {
            buttonNext.setEnabled(true);
            buttonBack.setEnabled(false);
            buttonBack.setVisibility(View.INVISIBLE);

        } else if (position == textViewDots.length - 1) {
            buttonNext.setEnabled(true);
            buttonNext.setText("FINISH");
            buttonNext.setVisibility(View.VISIBLE);

            buttonBack.setEnabled(true);
            buttonBack.setVisibility(View.VISIBLE);

        } else {
            buttonNext.setEnabled(true);
            buttonNext.setText("NEXT");
            buttonNext.setVisibility(View.VISIBLE);

            buttonBack.setEnabled(true);
            buttonBack.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
