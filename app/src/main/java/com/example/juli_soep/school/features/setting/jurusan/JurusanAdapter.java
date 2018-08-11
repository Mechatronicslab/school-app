package com.example.juli_soep.school.features.setting.jurusan;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.juli_soep.school.R;
import com.example.juli_soep.school.features.setting.jurusan.model.Jurusan;

import java.util.List;

public class JurusanAdapter extends RecyclerView.Adapter<JurusanAdapter.ViewHolder> {
    interface OnItemSelected {
        void onSelect(Jurusan model);
    }

    private List<Jurusan> jurusans;
    private OnItemSelected listener;


    JurusanAdapter(List<Jurusan> jurusans, OnItemSelected listener) {
        this.jurusans = jurusans;
        this.listener = listener;
    }


    @Override
    public JurusanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jurusan, parent, false);

        JurusanAdapter.ViewHolder viewHolder = new JurusanAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final JurusanAdapter.ViewHolder holder, final int position) {
        final Jurusan jurusan = jurusans.get(position);


        holder.mNamaJurusan.setText(jurusan.getNama_jurusan());
        holder.mKdJurusan.setText(jurusan.getKd_jurusan());
        holder.mKeterangan.setText(jurusan.getKeterangan());
        holder.itemView.setOnClickListener(view -> listener.onSelect(jurusan));
    }


    @Override
    public int getItemCount() {
        return jurusans.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView mNamaJurusan, mKdJurusan,mKeterangan;


        ViewHolder(View view) {
            super(view);
            mNamaJurusan = view.findViewById(R.id.nama_jurusan);
            mKdJurusan = view.findViewById(R.id.id_jurusan);
            mKeterangan = view.findViewById(R.id.keterangan);
        }
    }
}