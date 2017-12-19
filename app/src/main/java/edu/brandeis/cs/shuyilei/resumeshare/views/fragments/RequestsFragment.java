package edu.brandeis.cs.shuyilei.resumeshare.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.brandeis.cs.shuyilei.resumeshare.R;
import edu.brandeis.cs.shuyilei.resumeshare.adapters.ContactsAdapter;
import edu.brandeis.cs.shuyilei.resumeshare.adapters.RequestAdapter;
import edu.brandeis.cs.shuyilei.resumeshare.beans.Request;
import edu.brandeis.cs.shuyilei.resumeshare.beans.User;
import edu.brandeis.cs.shuyilei.resumeshare.controllers.UserController;

/**
 * Created by shuyilei on 11/18/16.
 */

public class RequestsFragment extends Fragment {

    private ListView mListView;
    private UserController mUserController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mFragment = inflater.inflate(R.layout.fragment_requests, container, false);
        mListView=(ListView)mFragment.findViewById(R.id.lv_requests);
        RequestAdapter mRequestAdapter=new RequestAdapter(getActivity());
        mListView.setAdapter(mRequestAdapter);
        mUserController=new UserController(getActivity());
        mUserController.showRequests(mRequestAdapter);

        return mFragment;
    }
}
