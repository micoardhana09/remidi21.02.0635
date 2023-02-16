package com.example.thejepits.ui.home;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thejepits.HomeActivity;
import com.example.thejepits.LoginActivity;
import com.example.thejepits.ProfileActivity;
import com.example.thejepits.R;
import com.example.thejepits.databinding.FragmentHomeBinding;
import com.example.thejepits.room.ItemModel;
import com.example.thejepits.room.MyItem;
import com.example.thejepits.util.AdapterRecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    ImageButton btnProfil, btnLogout, btnAccount, btnHistory, btnPayment;
    RecyclerView recyclerView;
    AdapterRecyclerView recyclerViewAdapter;
    ArrayList<ItemModel> data;
    TextView tvEmailHome;
    private LinearLayoutManager recyclerViewLayoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

    binding = FragmentHomeBinding.inflate(inflater, container, false);

    View root = binding.getRoot();


    btnProfil = root.findViewById(R.id.btnProfil);
    btnLogout = root.findViewById(R.id.btnLogout);
    btnAccount = root.findViewById(R.id.btnAccount2);
    btnHistory = root.findViewById(R.id.btnHistory);
    btnPayment = root.findViewById(R.id.btnPayment);
//    recyclerView = root.findViewById(R.id.recyclerView);
    tvEmailHome = root.findViewById(R.id.tvEmail);

//    String emailhome = getActivity().getIntent().getStringExtra("email");
//    tvEmailHome.setText("Welcome, "+ emailhome +"!");

//        recyclerViewLayoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(recyclerViewLayoutManager);
//        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
//
//        data = new ArrayList<>();
//        for (int i = 0; i < MyItem.Judul.length; i++) {
//            data.add(new ItemModel(
//                    MyItem.Judul[i],
//                    MyItem.Pengarang[i],
//                    MyItem.Tahun[i],
//                    MyItem.cover[i],
//                    MyItem.Isi[i]
//            ));
//        }
//        recyclerViewAdapter = new AdapterRecyclerView(getContext(),data);
//        recyclerView.setAdapter(recyclerViewAdapter);

    btnProfil.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent profil = new Intent(getActivity(), ProfileActivity.class);
            startActivity(profil);
        }
    });
    btnLogout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent logout = new Intent(getActivity(), LoginActivity.class);
            startActivity(logout);
        }
    });
        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent payment = new Intent(getActivity(), HomeActivity.class);
                startActivity(payment);
            }
        });
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent history = new Intent(getActivity(), HomeActivity.class);
                startActivity(history);
            }
        });
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(getActivity(), ProfileActivity.class);
                startActivity(profile);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}