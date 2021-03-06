package com.example.android51.rv_et;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.android51.databinding.ItemBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Model> list = new ArrayList<Model>();
    Listener listener;

    public Adapter(Listener listener) {
        this.listener = listener;
    }

    public void adds(Model model) {
        list.add(model);
        notifyDataSetChanged();
    }

    public void update(Model model, int posituion) {
        list.remove(posituion);
        list.add(posituion, model);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(ItemBinding.inflate(LayoutInflater.from
                (parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ItemBinding binding;

        public ViewHolder(ItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
            itemView.getRoot().setOnClickListener(v ->
                    listener.onItemClick(list.get(getAdapterPosition()), getAdapterPosition()));
        }

        public void onBind(Model model) {
            binding.tvName.setText(model.getName());
            binding.tvPhone.setText(model.getPhone());

        }
    }

    public interface Listener {
        void onItemClick(Model model, int position);
    }
}
