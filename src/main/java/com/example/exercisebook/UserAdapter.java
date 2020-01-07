package com.example.exercisebook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    private List<User> users = new ArrayList<>();
    private OnItemButtonClickListener listener;
    private OnDeleteItemButtonClickListener deleteListener;
    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);
        return new UserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        User currentUser = users.get(position);
        holder.userName.setText(currentUser.getFullName());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    public User getUserAt(int position){
        return users.get(position);
    }

    class UserHolder extends RecyclerView.ViewHolder {
        private TextView userName;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            //View relativeLayoutView = ((ViewGroup)itemView).getChildAt(0);
            Button editButton = itemView.findViewById(R.id.editUserButton);
            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemButtonClick(users.get(position));
                    }
                }
            });

            Button deleteButton = itemView.findViewById(R.id.deleteUserButton);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION){
                        deleteListener.onDeleteItemButtonClick(users.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemButtonClickListener {
        void onItemButtonClick(User user);
    }

    public void setOnButtonItemClickListener(OnItemButtonClickListener listener) {
        this.listener = listener;
    }

    public interface OnDeleteItemButtonClickListener {
        void onDeleteItemButtonClick(User user);
    }

    public void setOnDeleteButtonItemClickListener(OnDeleteItemButtonClickListener listener) {
        this.deleteListener = listener;
    }

}