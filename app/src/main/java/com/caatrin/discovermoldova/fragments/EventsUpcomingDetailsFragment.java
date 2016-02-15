package com.caatrin.discovermoldova.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.caatrin.discovermoldova.BaseFragment;
import com.caatrin.discovermoldova.Constants;
import com.caatrin.discovermoldova.R;
import com.caatrin.discovermoldova.data.firebase.Event;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class EventsUpcomingDetailsFragment extends BaseFragment {

    public static final String ARG_KEY = "key";

    private ImageView mImgEventPhoto;
    private TextView mTxtTitle;
    private TextView mTxtTimeStart;
    private TextView mTxtTimeEnd;
    private TextView mTxtLocationName;
    private TextView mTxtLocationAddress;
    private TextView mTxtTickets;
    private TextView mPhoneNumber;
    private TextView mTxtDescription;

    private String mKey;


    public EventsUpcomingDetailsFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(Bundle args) {
        EventsUpcomingDetailsFragment fragment = new EventsUpcomingDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mKey = getArguments().getString(ARG_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_upcoming_events_details, container, false);
        initiateViews(v);

        Firebase ref = new Firebase(Constants.FIREBASE_URL_EVENTS).child(mKey);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Event event = dataSnapshot.getValue(Event.class);
                if (event == null) {
                    getActivity().finish();
                }
                setupEventData(event);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        return v;
    }

    private void setupEventData(Event event) {
        Uri path = Uri.parse(event.getImageUrl());
        Glide.with(getContext()).load(path).into(mImgEventPhoto);
        mTxtTitle.setText(event.getName());
        mTxtTimeStart.setText(event.getTime().getStartTime());
        mTxtTimeEnd.setText(event.getTime().getEndTime());
        mTxtLocationName.setText(event.getLocation().getName());
        StringBuilder address = new StringBuilder()
                .append(event.getLocation().getAddress())
                .append(", ")
                .append(event.getLocation().getCity());
        String zipCode = event.getLocation().getZipCode();
        if(!zipCode.equalsIgnoreCase("N/A")) {
            address.append(", ").append(zipCode);
        }
        mTxtLocationAddress.setText(address.toString());
        mTxtTickets.setText(event.getTickets());
        mPhoneNumber.setText(String.valueOf(event.getPhoneNumber()));
        mTxtDescription.setText(event.getDescription());
    }

    private void initiateViews(View v) {
        mImgEventPhoto = (ImageView) v.findViewById(R.id.img_item);
        mTxtTitle = (TextView) v.findViewById(R.id.txt_title);
        mTxtTimeStart = (TextView) v.findViewById(R.id.txt_time_start);
        mTxtTimeEnd = (TextView) v.findViewById(R.id.txt_time_end);
        mTxtLocationName = (TextView) v.findViewById(R.id.txt_location_name);
        mTxtLocationAddress = (TextView) v.findViewById(R.id.txt_location_address);
        mTxtTickets = (TextView) v.findViewById(R.id.txt_tickets);
        mPhoneNumber = (TextView) v.findViewById(R.id.txt_phone_number);
        mTxtDescription = (TextView) v.findViewById(R.id.txt_description);
    }


}
