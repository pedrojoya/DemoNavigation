package es.iessaladillo.pedrojoya.navigationtest.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import es.iessaladillo.pedrojoya.navigationtest.R;

public class MainFragment extends Fragment {

    private NavController navController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Get navController from NavHostFragment.
        navController = NavHostFragment.findNavController(this);
        setupViews(requireView());
    }

    private void setupViews(View view) {
        EditText txtMessage = ViewCompat.requireViewById(view, R.id.txtMessage);
        Button btnShowSecondary = ViewCompat.requireViewById(view, R.id.btnShowSecondary);
        btnShowSecondary.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putString(getString(R.string.argMessage), txtMessage.getText().toString());
            navController.navigate(R.id.showSecondaryAction, args);
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }

}
