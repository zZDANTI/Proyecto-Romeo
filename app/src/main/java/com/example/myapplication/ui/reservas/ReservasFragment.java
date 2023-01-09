package com.example.myapplication.ui.reservas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentNotificationsBinding;
import com.example.myapplication.databinding.FragmentReservasBinding;

public class ReservasFragment extends Fragment {

    private FragmentReservasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ReservasViewModel reservasViewModel =
                new ViewModelProvider(this).get(ReservasViewModel.class);

        binding = FragmentReservasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textReservas;
        reservasViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}