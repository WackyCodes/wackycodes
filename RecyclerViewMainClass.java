// RecyclerViewMainClass
package com.example.shailendra.quickshop.retailerdata.fragmentclass;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.shailendra.quickshop.R;
import com.example.shailendra.quickshop.retailerdata.X_OfferRecyclerViewAdaptor;
import com.example.shailendra.quickshop.retailerdata.X_OfferRecyclerViewModel;

import java.util.ArrayList;
import java.util.List;

public class RetHomeFragment extends Fragment {

    public RetHomeFragment(){

    }

    //---------- offer recycler View in horizontal --------------
    private TextView offerTitle;
    private Button offerViewAllBtn;
    private RecyclerView offerRecyclerView;
    //---------- offer recycler View in horizontal --------------


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate( R.layout.fragment_ret_home,container,false );

        //---------- offer recycler View in horizontal --------------
        offerTitle = view.findViewById( R.id.offer_title );
        offerViewAllBtn = view.findViewById( R.id.offer_view_all_btn );
        offerRecyclerView = view.findViewById( R.id.offer_recycler_view );

        List<X_OfferRecyclerViewModel> x_offerRecyclerViewModelList = new ArrayList <>(  );
        x_offerRecyclerViewModelList.add( new X_OfferRecyclerViewModel( R.drawable.pic_b,"Rs. 45/-","Mobile" ) );
        x_offerRecyclerViewModelList.add( new X_OfferRecyclerViewModel( R.drawable.pic_b,"Rs. 45/-","Mobile" ) );
        x_offerRecyclerViewModelList.add( new X_OfferRecyclerViewModel( R.drawable.pic_b,"Rs. 45/-","Mobile" ) );
        x_offerRecyclerViewModelList.add( new X_OfferRecyclerViewModel( R.drawable.pic_b,"Rs. 45/-","Mobile" ) );

        X_OfferRecyclerViewAdaptor x_offerRecyclerViewAdaptor = new X_OfferRecyclerViewAdaptor( x_offerRecyclerViewModelList );

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getActivity() );
        linearLayoutManager.setOrientation( LinearLayoutManager.HORIZONTAL );
        offerRecyclerView.setLayoutManager( linearLayoutManager );
        offerRecyclerView.setAdapter( x_offerRecyclerViewAdaptor );

        x_offerRecyclerViewAdaptor.notifyDataSetChanged();

        //---------- offer recycler View in horizontal --------------



        return super.onCreateView( inflater, container, savedInstanceState );
    }
}
