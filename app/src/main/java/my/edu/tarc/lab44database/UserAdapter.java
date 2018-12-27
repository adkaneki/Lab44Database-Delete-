package my.edu.tarc.lab44database;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewFirstName, textViewLastName, textViewPhone;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewFirstName = itemView.findViewById(R.id.textViewFirstName);
            textViewLastName = itemView.findViewById(R.id.textViewLastName);
            textViewPhone = itemView.findViewById(R.id.textViewPhone);
        }
    }

    private final LayoutInflater layoutInflater;
    private List<User> userList; //Cached copy of users

    public UserAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.user_record, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int position) {
        if(userList != null){
            User user = userList.get(position);
            userViewHolder.textViewFirstName.setText(user.getFirstName());
            userViewHolder.textViewLastName.setText(user.getLastName());
            userViewHolder.textViewPhone.setText(user.getPhone());
        }else{
            userViewHolder.textViewFirstName.setText("No record.");
        }

    }

    @Override
    public int getItemCount() {
        if(userList != null)
            return userList.size();
        else
            return 0;
    }

    public void setUsers(List<User> users){
        userList = users;
        notifyDataSetChanged();
    }

    public User getUserAtPosition (int position) {
        return userList.get(position);
    }
}
