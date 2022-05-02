package com.gsb.adapter;



import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gsb.modele.Echantillon;
import com.example.adapter.R;
import java.util.ArrayList;

public class EchantillonAdapter extends BaseAdapter {

    protected ArrayList<Echantillon> echantillons;
    protected LayoutInflater inflater;
    protected Context context ;

    public EchantillonAdapter(ArrayList<Echantillon> echantillons, Context context) {
        this.echantillons = echantillons;
        this.context = context ;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() { return echantillons.size();}

    @Override
    public Echantillon getItem(int position) { return echantillons.get(position);}

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public long getItemID (int position ) {
        return position ;}

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.echantillon, parent, false);
        Echantillon echantillon = getItem(position);

        TextView tv_echantillon_id  = convertView.findViewById(R.id.tv_echantillon_id);
        TextView tv_echantillon_libelle = convertView.findViewById (R.id.tv_echantillon_libelle);
        TextView tv_echantillon_quantite = convertView.findViewById (R.id.tv_echantillon_quantité);

        tv_echantillon_id.setText(echantillon.getCode());
        tv_echantillon_libelle.setText(echantillon.getLibelle());
        tv_echantillon_quantite.setText(echantillon.getQuantiteStock());

        return convertView;
    }

}
