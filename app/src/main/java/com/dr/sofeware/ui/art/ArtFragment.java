package com.dr.sofeware.ui.art;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dr.sofeware.databinding.FragmentArtBinding;

public class ArtFragment extends Fragment {

    private FragmentArtBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ArtViewModel notificationsViewModel =
                new ViewModelProvider(this).get(ArtViewModel.class);

        binding = FragmentArtBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textArt;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}