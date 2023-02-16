package com.example.thejepits.ui.payment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.thejepits.databinding.FragmentPaymentBinding;

public class PaymentFragment extends Fragment {

private FragmentPaymentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        PaymentViewModel dashboardViewModel =
                new ViewModelProvider(this).get(PaymentViewModel.class);

    binding = FragmentPaymentBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}