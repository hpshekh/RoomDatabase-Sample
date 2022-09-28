package com.hpshekh.roomdatabase_sample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hpshekh.roomdatabase_sample.R;
import com.hpshekh.roomdatabase_sample.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRVAdapter extends RecyclerView.Adapter<ContactRVAdapter.ContactViewHolder> {

    private ArrayList<Contact> contactList = new ArrayList<>();
    private Context context;

    public ContactRVAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.nameText.setText(contact.getName());
        holder.mobileText.setText(contact.getMobile());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView nameText, mobileText;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.nameText);
            mobileText = itemView.findViewById(R.id.mobileText);
        }
    }

    public void UpdateList(List<Contact> contactList) {
        this.contactList.clear();
        this.contactList.addAll(contactList);
        notifyDataSetChanged();
    }
}
