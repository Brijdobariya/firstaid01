package com.example.demov2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomAdapter extends ArrayAdapter<InjuryModel> {

    Context c;
    DatabaseHandler db;
    ArrayList<InjuryModel> InjuryModelArrayList;



    public CustomAdapter(@NonNull Context context, ArrayList<InjuryModel> contactModelArrayList) {
        super(context, 0, contactModelArrayList);
        this.c = context;
        this.InjuryModelArrayList = contactModelArrayList;
        db = new DatabaseHandler(context);
        Log.v("DS>>>",""+InjuryModelArrayList.size());
    }

    @Override
    public int getCount() {
        return InjuryModelArrayList.size();
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).
                    inflate(R.layout.list_item, parent, false);
        }
        InjuryModel injuryModel = getItem(position);
        TextView empName = listitemView.findViewById(R.id.txtName);
        TextView empNumber = listitemView.findViewById(R.id.txtNumber);
        TextView empEmail = listitemView.findViewById(R.id.txtEmail);
        TextView empAddress = listitemView.findViewById(R.id.txtAddress);
        CircleImageView propic = listitemView.findViewById(R.id.profile_image);
        // Button btnEdit = listitemView.findViewById(R.id.btnEdit);
        // Button btnDelete = listitemView.findViewById(R.id.btnDelete);
        empName.setText("Body Part: "+injuryModel.getBody_part());
        empNumber.setText(injuryModel.getSb_part());
        empEmail.setText(injuryModel.getInjury());
        //empAddress.setText(injuryModel.getAddress());
        //Log.v("DS","111"+ Arrays.toString(contactModel.getImage()));
        if (injuryModel.getImage()==0) {
        }else{
            propic.setImageResource(injuryModel.getImage());

        }


        return listitemView;
    }
}
