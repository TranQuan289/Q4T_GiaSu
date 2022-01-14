package com.example.android.Find;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.giasu.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindCity extends Fragment {
    Button btn;
    Spinner sprmonhoc,srplopgoc;
    String mon,lop;
    EditText edtfind;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_find,container,false);
        btn = v.findViewById(R.id.button);

        edtfind=(EditText) v.findViewById(R.id.editText3);
        RadioButton radioButton1 = (RadioButton) v.findViewById(R.id.rb1);
        RadioButton radioButton2 = (RadioButton) v.findViewById(R.id.rb2);

        sprmonhoc=(Spinner) v.findViewById(R.id.editText6);
        srplopgoc=(Spinner) v.findViewById(R.id.editText4);

        ArrayList<String> monhocList=new ArrayList<>();
        monhocList.add("");
        monhocList.add("Toán");
        monhocList.add("Lý");
        monhocList.add("Hóa");
        monhocList.add("Văn");
        monhocList.add("Sử");
        monhocList.add("Địa");
        ArrayAdapter monhocAdapter=new ArrayAdapter(getActivity(),R.layout.support_simple_spinner_dropdown_item,monhocList);
        monhocAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprmonhoc.setAdapter(monhocAdapter);

        ArrayList<String> lophocList=new ArrayList<>();
        lophocList.add("");
        lophocList.add("1");
        lophocList.add("2");
        lophocList.add("3");
        lophocList.add("4");
        lophocList.add("5");
        lophocList.add("6");
        lophocList.add("7");
        lophocList.add("8");
        lophocList.add("9");
        lophocList.add("10");
        lophocList.add("11");
        lophocList.add("12");
        ArrayAdapter lophocAdapter=new ArrayAdapter(getActivity(),R.layout.support_simple_spinner_dropdown_item,lophocList);
        lophocAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        srplopgoc.setAdapter(lophocAdapter);

        srplopgoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lop=lophocList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sprmonhoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mon=monhocList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edtfind.getText().toString().trim();
                if(name.equals("") && mon.equals("") && lop.equals("")){
                    Toast.makeText(getActivity(), "Bạn ít nhất phải điền hoặc chọn 1 thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    DataClient dataClient= APIUtils.getData();
                    Call<List<user>> callback=dataClient.find(name,mon,lop);
                    callback.enqueue(new Callback<List<user>>() {
                        @Override
                        public void onResponse(Call<List<user>> call, Response<List<user>> response) {
                            ArrayList<user> userList= (ArrayList<user>) response.body();
                            if(userList.size()>0) {
                                Bundle bundle =new Bundle();
                                bundle.putSerializable("data",userList);
                                Fragment_finduser fragment_finduser=new Fragment_finduser();
                                fragment_finduser.setArguments(bundle);
                                replaceFragment4(fragment_finduser);
                            } else {
                                Toast.makeText(getActivity(), "Thông tin tìm kiếm không có", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<user>> call, Throwable t) {
                            Toast.makeText(getActivity(), "Thông tin tìm kiếm không có", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });
        return v;
    }
    private void replaceFragment4(Fragment fragment){
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        transaction.replace(R.id.main,fragment).addToBackStack(null).commit();
    }
}
