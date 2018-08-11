package com.example.juli_soep.school.features.setting.jabatan;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.juli_soep.school.R;
import com.example.juli_soep.school.features.setting.jabatan.model.Jabatan;

import java.util.List;

public class JabatanAdapter extends RecyclerView.Adapter<JabatanAdapter.ViewHolder> {
    interface OnItemSelected {
        void onSelect(Jabatan model);
    }

    private List<Jabatan> jabatans;
    private OnItemSelected listener;


    JabatanAdapter(List<Jabatan> jabatans, OnItemSelected listener) {
        this.jabatans = jabatans;
        this.listener = listener;
    }


    @Override
    public JabatanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jabatan, parent, false);

        JabatanAdapter.ViewHolder viewHolder = new JabatanAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final JabatanAdapter.ViewHolder holder, final int position) {
        final Jabatan jabatan = jabatans.get(position);

        holder.mKdJurusan.setText(jabatan.getKdJabatan());
        holder.mNamaJurusan.setText(jabatan.getNamaJabatan());
        holder.mGolongan.setText(jabatan.getGolongan());
        holder.mGaji.setText(jabatan.getGaji());
        holder.mTunjangan.setText(jabatan.getTunjangan());
        //holder.mKeterangan.setText(jabatan.getKeterangan());
        holder.itemView.setOnClickListener(view -> listener.onSelect(jabatan));
    }


    @Override
    public int getItemCount() {
        return jabatans.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView mNamaJurusan, mKdJurusan,mKeterangan,mGolongan,mGaji,mTunjangan;


        ViewHolder(View view) {
            super(view);
            mKdJurusan = view.findViewById(R.id.id_jabatan);
            mNamaJurusan = view.findViewById(R.id.nama_jabatan);
            mGolongan = view.findViewById(R.id.golongan);
            mGaji = view.findViewById(R.id.gaji);
            mTunjangan = view.findViewById(R.id.tunjangan);
            //mKeterangan = view.findViewById(R.id.keterangan);
        }
    }
}