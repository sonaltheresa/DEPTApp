package com.example.deptapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText e1,e2,e3;
CDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        db=new CDB(this);
    }
    public void onsave(View v){
        String dn,dl;
        dn=e2.getText().toString();
        dl=e3.getText().toString();
        db.addDept(dn,dl);
        e2.setText("");
        e3.setText("");
    }

    public void onfind(View v){
      String a[];
      try{
          String dno =e1.getText().toString();
          a = db.getOneDepartment(Integer.parseInt(dno));
          if(a[0]!=""){
              e2.setText(a[0]);
              e3.setText(a[1]);
          }
          else
          {
              Toast.makeText(this, "not found", Toast.LENGTH_SHORT).show();
          }
      }catch (Exception e){
          System.out.println(e);
      }
    }
    public  void ondelete(View v){
        String dno =e1.getText().toString();
        db.deleteDept(Integer.parseInt(dno));
        e2.setText("");
        e3.setText("");
    }
    public void onupdate(View v){
        String dno =e1.getText().toString();
        String dn,dl;
        dn=e2.getText().toString();
        dl=e3.getText().toString();
        db.update(Integer.parseInt(dno),dn,dl);
        e2.setText("");
        e3.setText("");
    }
}