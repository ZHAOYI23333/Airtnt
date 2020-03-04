package com.example.airtnt.ui.translate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.airtnt.R;
import android.util.Log;
public class TranslateFragment extends Fragment {

    private TranslateViewModel translateViewModel;
    private static final String TAG = "Translate Fragment";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        translateViewModel =
                ViewModelProviders.of(this).get(TranslateViewModel.class);
        View root = inflater.inflate(R.layout.fragment_translate, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        translateViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        Log.d(TAG, "onCreatView() in Translate Fragment is called.");
        return root;
    }
}