package es.iessaladillo.pedrojoya.navigationtest.ui.secondary;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.iessaladillo.pedrojoya.navigationtest.R;

public class SecondaryFragment extends Fragment {

    private SecondaryFragmentViewModel mViewModel;

    public static SecondaryFragment newInstance() {
        return new SecondaryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_secondary, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SecondaryFragmentViewModel.class);
        // TODO: Use the ViewModel
    }

}
