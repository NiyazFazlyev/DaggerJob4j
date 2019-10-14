package ru.job4j.daggerjob4j;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    EditText newString;

    @Inject
    Store store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getStore().injectTo(this);
        setContentView(R.layout.activity_main);
        newString = findViewById(R.id.newString);
        this.recycler = findViewById(R.id.recycler_view);
        this.recycler.setLayoutManager(new LinearLayoutManager(this));
        if (store == null) {
            System.out.println("Store null!!!!!!!!!");
        }
        this.recycler.setAdapter(new StringAdapter(store.getAll()));

    }

    public void addBtn(View view) {
        String value = newString.getText().toString();
        store.add(value);
//        strings.add(value);
        recycler.getAdapter().notifyDataSetChanged();
    }

    public class StringHolder extends RecyclerView.ViewHolder {
        private View view;

        public StringHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public class StringAdapter extends RecyclerView.Adapter<StringHolder> {

        private final List<String> strings;

        public StringAdapter(List<String> strings) {
            this.strings = strings;
        }

        @NonNull
        @Override
        public StringHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
            View view = inflater.inflate(R.layout.text_info, parent, false);
            return new StringHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull StringHolder holder, int i) {
            String string = this.strings.get(i);
            TextView text = holder.view.findViewById(R.id.text);

            if ((i % 2) == 0) {
                holder.view.setBackgroundColor(Color.parseColor("#d8d8d8"));
            }
            text.setText(string);
        }

        @Override
        public int getItemCount() {
            return this.strings.size();
        }
    }


}
