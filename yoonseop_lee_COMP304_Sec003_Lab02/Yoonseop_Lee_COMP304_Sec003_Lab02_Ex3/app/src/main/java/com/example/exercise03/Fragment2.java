package com.example.exercise03;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment2 extends Fragment {

    View view;
    TextView text;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getActivity(),"@string/onCreateViewMessage",Toast.LENGTH_SHORT).show();
        LayoutInflater lf = getActivity().getLayoutInflater();
        view =  lf.inflate(R.layout.fragment_fragment2, container, false);
        text = (TextView) view.findViewById(R.id.textView);
        text.append("\nonCreate executed\n");
        return view;
    }

    public void onStart()
    {
        super.onStart();
        Toast.makeText(getActivity(),"onStart executed",Toast.LENGTH_SHORT).show();
        text.append("onStart executed\n");
    }
    public void onStop()
    {
        super.onStop();
        text.append("onStop executed\n");
    }
    public void onDestroy()
    {
        super.onDestroy();
        text.append("onDestroy executed\n");
    }
}
