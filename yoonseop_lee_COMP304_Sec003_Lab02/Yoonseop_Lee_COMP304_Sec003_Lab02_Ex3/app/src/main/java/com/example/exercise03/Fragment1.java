package com.example.exercise03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Fragment1 extends Fragment {

    ListView listView;
    String[] activities = {"AI Activity(1)", "VR Activity(2)"};
    //public Fragment1() {
    //}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        listView = (ListView) view.findViewById(R.id.actList);
        Toast.makeText(getActivity(),"@string/onCreateViewMessage",Toast.LENGTH_SHORT).show();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, activities);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), AIActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), VRActivity.class);
                    startActivityForResult(myIntent, 1);
                }
            }
        });
        return view;
    }

    public void onStart()
    {
        super.onStart();
        Toast.makeText(getActivity(),"onStart executed",Toast.LENGTH_SHORT).show();
    }
}
