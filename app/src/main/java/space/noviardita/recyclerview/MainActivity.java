package space.noviardita.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvData;
    private ArrayList<DataMobil> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvData = findViewById(R.id.id_laptop);
        rvData.setHasFixedSize(true);

        list.addAll(DataMobil2.getListData());
        showRecyclerList();

    }

    private void showRecyclerList() {
        rvData.setLayoutManager(new LinearLayoutManager(this));
        ListMobilAdapter listLaptopAdapter = new ListMobilAdapter(list) {
        };
        rvData.setAdapter(listLaptopAdapter);
    }
}
