package com.example.user.fragmentsandbottommenu;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class TwoFragment extends Fragment {

     public static TwoFragment newInstance() {
         return new TwoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.two_fragment,container,false);
         if (networkState(container.getContext())==true){
             Toast.makeText(container.getContext(), "INTERNET EST", Toast.LENGTH_SHORT).show();
         } else {
             Toast.makeText(container.getContext(), "INTERNETA NET", Toast.LENGTH_SHORT).show();
         }
        return view;
    }
    public boolean networkState(Context context){
         try {
             ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
             NetworkInfo info = cm.getActiveNetworkInfo();
             if (info != null && info.isConnectedOrConnecting()) {
                 return true;
             } else
             return false;
         } catch (Exception e){
             e.printStackTrace();
         }
         return false;
    }
}
