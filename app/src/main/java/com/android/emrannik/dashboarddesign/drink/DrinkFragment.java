package com.android.emrannik.dashboarddesign.drink;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.emrannik.dashboarddesign.R;


import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrinkFragment extends Fragment {

    RecyclerView rvDrink;
    AdapterDrink mAdapter;
    String drinks[]={"drink1","drink2"};
    String price[]={"5000","10000"};
    int img[]={R.drawable.drink,R.drawable.drink};
    public DrinkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_drink, container, false);
        rvDrink = v.findViewById(R.id.rvDrink);
        rvDrink.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvDrink.setLayoutManager(layoutManager);

        ArrayList<DataDrink> dataDrinks = getData();

        mAdapter = new AdapterDrink(dataDrinks,getActivity());
        rvDrink.setAdapter(mAdapter);

        return v;
    }

    private ArrayList<DataDrink> getData() {
        ArrayList<DataDrink> dataDrinks = new ArrayList<>();
        for (int i = 0; i<drinks.length;i++){
            DataDrink drink = new DataDrink();
            drink.setdrinkName(drinks[i]);
            drink.setPrice(price[i]);
            drink.setImg(img[i]);
            dataDrinks.add(drink);
        }
        return dataDrinks;
    }

}
