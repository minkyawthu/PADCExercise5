package com.example.mkt.padcexercise5.fragments;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mkt.padcexercise5.R;
import com.example.mkt.padcexercise5.adapters.AttractAdapter;
import com.example.mkt.padcexercise5.data.models.AttractModel;
import com.example.mkt.padcexercise5.data.vos.AttractVO;

/**
 * A placeholder fragment containing a simple view.
 */
public class MyanmarAttractionFragment extends Fragment {

    private AttractAdapter attractAdapter;
    private ControllerAttractItem onControllerAttractItem;

    public MyanmarAttractionFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onControllerAttractItem = (ControllerAttractItem) context;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attractAdapter = new AttractAdapter(AttractModel.getObjInstance().getAttractList(), onControllerAttractItem);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myanmar_attraction, container, false);
        RecyclerView mAttract = (RecyclerView) view.findViewById(R.id.rv_attract);
        mAttract.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mAttract.setAdapter(attractAdapter);

        return view;

    }

    public interface ControllerAttractItem {
        void onTapAttract(AttractVO attractVO);
    }
}
