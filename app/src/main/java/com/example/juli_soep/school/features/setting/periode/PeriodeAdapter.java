package com.example.juli_soep.school.features.setting.periode;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.juli_soep.school.R;
import com.example.juli_soep.school.features.setting.jabatan.JabatanAdapter;
import com.example.juli_soep.school.features.setting.periode.model.Periode;

import java.util.List;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;
import static android.widget.Toast.LENGTH_LONG;

public class PeriodeAdapter extends RecyclerView.Adapter<PeriodeAdapter.ViewHolder> {
    interface OnItemSelected{
        void onSelect(Periode model);
    }

    private List<Periode>periodes;
    private OnItemSelected listener ;

    PeriodeAdapter(List<Periode> periodes, PeriodeAdapter.OnItemSelected listener) {
        this.periodes = periodes;
        this.listener = listener;
    }

    @Override
    public PeriodeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_periode, parent, false);
        PeriodeAdapter.ViewHolder viewHolder = new PeriodeAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final PeriodeAdapter.ViewHolder holder, final int position) {
        final Periode periode = periodes.get(position);
        holder.mKdPeriode.setText(periode.getKdPeriode());
        holder.mNamaPeriode.setText(periode.getNamaPeriode());
        holder.mTglMulai.setText(periode.getTglMulai());
        holder.mTglSelesai.setText(periode.getTglSelesai());
        holder.itemView.setOnClickListener(view -> listener.onSelect(periode));
    }

    @Override
    public int getItemCount() {
        return periodes.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {
         TextView mNamaPeriode, mKdPeriode,mKeterangan,mTglMulai,mTglSelesai;
         ViewHolder(View view) {
            super(view);
             mNamaPeriode = view.findViewById(R.id.nama_user);
             mKdPeriode = view.findViewById(R.id.id_user);
             mTglMulai = view.findViewById(R.id.tanggal_mulai);
             mTglSelesai = view.findViewById(R.id.tanggal_selesai);
        }
    }
}
