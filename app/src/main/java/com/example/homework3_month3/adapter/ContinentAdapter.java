package com.example.homework3_month3.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.example.homework3_month3.databinding.ItemContinentBinding;

public class ContinentAdapter extends ListAdapter<String, ContinentAdapter.ContinentViewHolder> {

    private final OnClickListener onClickListener;

    public ContinentAdapter(OnClickListener onClickListener) {
        super(DIFF_CALLBACK);
        this.onClickListener = onClickListener;
    }

    private static final DiffUtil.ItemCallback<String> DIFF_CALLBACK = new DiffUtil.ItemCallback<String>() {
        @Override
        public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem) {
            return oldItem.equals(newItem);
        }
    };

    @NonNull
    @Override
    public ContinentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemContinentBinding binding = ItemContinentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ContinentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentViewHolder holder, int position) {
        String city = getItem(position);
        holder.bind(city);
    }

    public class ContinentViewHolder extends RecyclerView.ViewHolder {
        private final ItemContinentBinding binding;

        public ContinentViewHolder(ItemContinentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String city) {
            binding.tvContinent.setText(city);
            itemView.setOnClickListener(v -> onClickListener.onClick(city));
        }
    }

    public interface OnClickListener {
        void onClick(String city);
    }
}