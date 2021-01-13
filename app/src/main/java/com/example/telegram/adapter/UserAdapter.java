package com.example.telegram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.telegram.R;
import com.example.telegram.databinding.ItemViewBinding;
import com.example.telegram.model.User;
import com.example.telegram.viewModel.HomePageViewModel;

import java.util.UUID;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.Holder> {
    private HomePageViewModel mViewModel;
    private UserAdapterCallback mCallback;

    public UserAdapter(HomePageViewModel viewModel,UserAdapterCallback callback) {
        mViewModel = viewModel;
        mCallback=callback;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewBinding binding= DataBindingUtil.inflate(
                LayoutInflater.from(mViewModel.getApplication()),
                R.layout.item_view,
                parent,
                false);

        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        User user=mViewModel.getUserList().get(position);
            holder.binding(user);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallback.onItemSelectedListener(user.getId());
                }
            });
    }

    @Override
    public int getItemCount() {
        return mViewModel.getUserList().size();
    }

    class Holder extends RecyclerView.ViewHolder{
        private ItemViewBinding mItemViewBinding;

        public Holder(@NonNull ItemViewBinding binding) {
            super(binding.getRoot());
            mItemViewBinding=binding;
        }

        public void binding(User user){
                mItemViewBinding.setUser(user);
        }
    }

    public interface UserAdapterCallback{
        void onItemSelectedListener(UUID userId);
    }
}
