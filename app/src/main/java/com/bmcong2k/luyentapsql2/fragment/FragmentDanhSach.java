 package com.bmcong2k.luyentapsql2.fragment;


 import android.content.Intent;
 import android.os.Bundle;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;

 import androidx.annotation.NonNull;
 import androidx.annotation.Nullable;
 import androidx.fragment.app.Fragment;
 import androidx.recyclerview.widget.LinearLayoutManager;
 import androidx.recyclerview.widget.RecyclerView;

 import com.bmcong2k.luyentapsql2.Book1;
 import com.bmcong2k.luyentapsql2.R;
 import com.bmcong2k.luyentapsql2.UpdateDeleteActivity;
 import com.bmcong2k.luyentapsql2.adapter.RecycleViewAdapter;
 import com.bmcong2k.luyentapsql2.dal.SQliteHelper;

 import java.util.List;

 public class FragmentDanhSach extends Fragment  implements RecycleViewAdapter.ItemListener  {



     private RecycleViewAdapter adapter;
     private RecyclerView recyclerView;
     private SQliteHelper db;

     @Nullable
     @Override
     public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         return inflater.inflate(R.layout.fragment_danhsach,container,  false);
     }

     @Override
     public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);
         recyclerView = view.findViewById(R.id.recycleView);
         adapter = new RecycleViewAdapter();

         db = new SQliteHelper(getContext());
         // tao db gia
//         Book1 b = new Book1(3, "Coder", "Thay Que", "asdasdsadsad", "GD", 3);
//         Book1 b2 = new Book1(1, "Coder12", "Thay Que", "asdasdsadsad", "GD", 3);

         List<Book1> list = db.getAll();

//         list.add(b);
//         list.add(b2);
         adapter.setList(list);
         LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
         recyclerView.setLayoutManager(manager);
         recyclerView.setAdapter(adapter);

         adapter.setItemListener(this);
     }

     @Override
     public void onItemClick(View view, int position) {
         Book1 book = adapter.getItem(position);
         Intent intent = new Intent(getActivity(), UpdateDeleteActivity.class);
         intent.putExtra("book", book);
         startActivity(intent);
     }

     // lam tuoi lai database
     @Override
     public void onResume() {
         super.onResume();
         List<Book1> list = db.getAll();
         adapter.setList(list);
     }


 }
