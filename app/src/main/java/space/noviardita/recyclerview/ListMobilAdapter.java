package space.noviardita.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

abstract class ListMobilAdapter extends RecyclerView.Adapter<ListMobilAdapter.ListViewHolder>{
    private ArrayList<DataMobil> listMobil;

    public ListMobilAdapter(ArrayList<DataMobil> list) {
        this.listMobil = list; }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_mobil, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final DataMobil dataMobil =listMobil.get(position);
        Glide.with(holder.itemView.getContext()).load(dataMobil.getFoto())
                .apply(new RequestOptions())
                .into(holder.fotoMobil);

        holder.namaMobil.setText(dataMobil.getNama());
        holder.tambahButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), "Menambahkan " + dataMobil.getNama() + " ke Keranjang", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return listMobil.size(); }


    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView fotoMobil;
        TextView namaMobil;
        Button tambahButton;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoMobil = itemView.findViewById(R.id.foto_mobil);
            namaMobil = itemView.findViewById(R.id.nama_mobil);
            tambahButton = itemView.findViewById(R.id.tambah); }

    }
}
