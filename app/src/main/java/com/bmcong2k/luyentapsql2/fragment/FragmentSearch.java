package com.bmcong2k.luyentapsql2.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

;
import com.bmcong2k.luyentapsql2.Book1;
import com.bmcong2k.luyentapsql2.R;
import com.bmcong2k.luyentapsql2.adapter.RecycleViewAdapter;
import com.bmcong2k.luyentapsql2.dal.SQliteHelper;


import java.util.Calendar;
import java.util.List;

public class FragmentSearch extends Fragment implements View.OnClickListener{



    private RecyclerView recyclerView;
    private TextView tvTong;
    private Button btnSearch;
    private SearchView searchView;
    private Spinner spTacGia;
    private RecycleViewAdapter adapter;
    private SQliteHelper db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search,container,  false);
    }

    @Override
    public void onClick(View v) {


//        if(v == btnSearch){
//            String from = eFrom.getText().toString();
//            String to = eTo.getText().toString();
//            if(!from.isEmpty() && !to.isEmpty()){
//                List<Book1> list = db.searchByTenSach();
//                adapter.setList(list);
//            }
//        }

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);

        adapter = new RecycleViewAdapter();
        db = new SQliteHelper(getContext());
        List<Book1> list = db.getAll();
        adapter.setList(list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),
                RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        // Serview
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                List<Book1> list1 = db.searchByTenSach(newText);
                adapter.setList(list1);
                return true;
            }
        });


        btnSearch.setOnClickListener(this);
        spTacGia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cate = spTacGia.getItemAtPosition(position).toString();
                List<Book1> list;
                if(cate == "All"){
                    list = db.getAll();
                }else {
                    list = db.searchByTacGia(cate);

                }
                adapter.setList(list);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initView(View view) {

        recyclerView = view.findViewById(R.id.recycleView);
        tvTong = view.findViewById(R.id.tvTong);
        btnSearch = view.findViewById(R.id.btnSearch);
        searchView = view.findViewById(R.id.search);

        spTacGia = view.findViewById(R.id.spTacGia);


        String[] arr = getResources().getStringArray(R.array.tacgia);
        String[] arr1 = new String[arr.length+1];
        arr1[0] = "All";
        for (int i=0; i<arr.length; i++){
            arr1[i+1] = arr[i];
        }
        spTacGia.setAdapter(new ArrayAdapter<String>(getContext(), R.layout.item_spriner,
                arr1));



    }



}
