package com.example.airtnt.ui.translate;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import com.example.airtnt.History;
import com.example.airtnt.R;
import android.util.Log;

public class TranslateFragment extends Fragment implements View.OnClickListener {

    private TranslateViewModel translateViewModel;
    private static final String TAG = "Translate Fragment";
    private TextView topText;
    private History hist;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        translateViewModel =
                ViewModelProviders.of(this).get(TranslateViewModel.class);
        View root = inflater.inflate(R.layout.fragment_translate, container, false);
        topText = root.findViewById(R.id.text_gallery);
        translateViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                topText.setText(s);
            }
        });

        Context mContext = getActivity().getApplicationContext();
        hist = new History(mContext);
//        topText.setText(hist == null ? "Null" : "not null");

        Button btnFromLang = root.findViewById(R.id.btnFromLang);
        Button btnToLang = root.findViewById(R.id.btnToLang);
        btnFromLang.setOnClickListener(this);
        btnToLang.setOnClickListener(this);


        Log.d(TAG, "onCreatView() in Translate Fragment is called.");
        return root;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFromLang:
                //
                hist.insertDialog("From Lang BLABLABLA");
                topText.setText(hist.getDialog().peek());
                break;
            case R.id.btnToLang:
                //
                hist.insertDialog("To Lang BLABLABLA");
                topText.setText(hist.getDialog().peek());
                break;

        }
    }
}