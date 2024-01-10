package com.example.mytodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Screen_a extends AppCompatActivity {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private TextView textView;
    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        textView=findViewById(R.id.countitems);
        listView=findViewById(R.id.listView);
        button=findViewById(R.id.addtask);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                additem(v);
                countitems();
                //textView.setText("("+String.valueOf(items.size())+")");


            }
        });



        items=new ArrayList<>();
        itemsAdapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
        listView.setAdapter(itemsAdapter);
        setUpListViewListener();


    }

    private void countitems() {
        if(items.size()==0){
            textView.setText("");
        } else{
            textView.setText("("+String.valueOf(items.size())+")");
        }
    }


    private void setUpListViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Context context=getApplicationContext();
                Toast.makeText(context,"Item Removed",Toast.LENGTH_LONG).show();
                items.remove(position);
                countitems();
                //textView.setText("("+String.valueOf(items.size())+")");
                itemsAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

   private void additem(View view) {
        EditText ipt=findViewById(R.id.editTextText);
        String itemText=ipt.getText().toString();
        if(!(itemText.equals(""))){
            itemsAdapter.add(itemText);
            ipt.setText("");
        }else{
            Toast.makeText(getApplicationContext(),"Please enter text...",Toast.LENGTH_LONG).show();
        }

    }
}