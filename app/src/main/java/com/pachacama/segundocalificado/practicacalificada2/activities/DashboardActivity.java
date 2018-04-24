package com.pachacama.segundocalificado.practicacalificada2.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.pachacama.segundocalificado.practicacalificada2.R;
import com.pachacama.segundocalificado.practicacalificada2.adapters.ProductAdapter;
import com.pachacama.segundocalificado.practicacalificada2.models.Product;
import com.pachacama.segundocalificado.practicacalificada2.models.User;
import com.pachacama.segundocalificado.practicacalificada2.repository.ProductRepository;
import com.pachacama.segundocalificado.practicacalificada2.repository.UserRepository;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private static final String TAG = DashboardActivity.class.getSimpleName();

    // SharedPreferences
    private SharedPreferences sharedPreferences;
    private TextView usernameText;

    // RecyclerView
    private RecyclerView productsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Toast.makeText(DashboardActivity.this, "Go home section...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_notification:
                        Toast.makeText(DashboardActivity.this, "Go camera section...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.design_menu_item_text:
                        Toast.makeText(DashboardActivity.this, "Go share section...", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });


        usernameText = findViewById(R.id.fullname_text);

        // init SharedPreferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // get username from SharedPreferences
        String username = sharedPreferences.getString("username", null);
        Log.d(TAG, "username: " + username);

        User user = UserRepository.getUser(username);
        usernameText.setText(user.getFullname());

        // Configure ReciclerView
        productsList = findViewById(R.id.product_list);
        productsList.setLayoutManager(new LinearLayoutManager(this));
        // Set Data Adapter to ReciclerView
        List<Product> products= ProductRepository.list();
        productsList.setAdapter(new ProductAdapter(products));


    }

    public void callLogout(View view){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean success = editor.putBoolean("islogged", false).commit();
        startActivity(new Intent(this, MainActivity.class));
    }

    public void callRegisterForm(View view) {
        startActivity(new Intent(this, RegisterProductActivity.class));
    }
}
