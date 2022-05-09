package com.bmcong2k.luyentapsql2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bmcong2k.luyentapsql2.Book1;
import com.bmcong2k.luyentapsql2.R;


import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.HomeViewHoler> {

    private List<Book1> list;
    private ItemListener itemListener;

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public RecycleViewAdapter() {
        list = new ArrayList<>();
    }

    public void setList(List<Book1> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public Book1 getItem(int po){
        return list.get(po);
    }

    @NonNull
    @Override
    public HomeViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new HomeViewHoler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHoler holder, int position) {

        Book1 item = getItem(position);
        holder.tenSach.setText(item.getTenSach());
        holder.tacGia.setText(item.getTacGia());
        holder.tomTat.setText(item.getTomTat());
        holder.nxb.setText(item.getNxb());
        holder.danhGia.setRating((int) item.getDanhGia());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHoler extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tenSach, tacGia, tomTat, nxb;
        private RatingBar danhGia;

        public HomeViewHoler(@NonNull View itemView) {
            super(itemView);
            tenSach= itemView.findViewById(R.id.tvTenSach);
            tacGia= itemView.findViewById(R.id.tvTacGia);
            tomTat= itemView.findViewById(R.id.tvTomTat);
            nxb= itemView.findViewById(R.id.tvNXB);
            danhGia= itemView.findViewById(R.id.ratingbar);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(itemListener != null){
                itemListener.onItemClick(v, getAdapterPosition());
            }
        }
    }

    // OVeright click item

    public interface ItemListener{
        void onItemClick(View view, int position);
    }

}
