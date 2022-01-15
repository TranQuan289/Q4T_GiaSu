package com.example.android.create;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.Register.Register_Teacher;
import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.giasu.Login;
import com.example.android.giasu.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateTeacherFragment extends Fragment {
    Spinner sprmonhoc,srplopgoc;
    String sobuoi,gio,money,hinhthuc,address,mon,lop;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_createteacher, container, false);

        sprmonhoc=(Spinner) v.findViewById(R.id.menu);
        srplopgoc=(Spinner) v.findViewById(R.id.menu1);

        ArrayList<String> monhocList=new ArrayList<>();
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


        Button btn_day1 = v.findViewById(R.id.btn_day1);
        Button btn_day2 = v.findViewById(R.id.btn_day2);
        Button btn_day3 = v.findViewById(R.id.btn_day3);
        Button btn_day4 = v.findViewById(R.id.btn_day4);
        Button btn_day5 = v.findViewById(R.id.btn_day5);
        Button btn_day6 = v.findViewById(R.id.btn_day6);
        Button btn_day7 = v.findViewById(R.id.btn_day7);

        btn_day2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_day2.setTextColor(Color.RED);
                sobuoi=btn_day2.getText().toString();
                btn_day1.setTextColor(Color.BLACK);
                btn_day3.setTextColor(Color.BLACK);
                btn_day4.setTextColor(Color.BLACK);
                btn_day5.setTextColor(Color.BLACK);
                btn_day6.setTextColor(Color.BLACK);
                btn_day7.setTextColor(Color.BLACK);
            }
        });
        btn_day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_day3.setTextColor(Color.RED);
                sobuoi=btn_day3.getText().toString();
                btn_day2.setTextColor(Color.BLACK);
                btn_day1.setTextColor(Color.BLACK);
                btn_day4.setTextColor(Color.BLACK);
                btn_day5.setTextColor(Color.BLACK);
                btn_day6.setTextColor(Color.BLACK);
                btn_day7.setTextColor(Color.BLACK);
            }
        });
        btn_day4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_day4.setTextColor(Color.RED);
                sobuoi=btn_day4.getText().toString();
                btn_day2.setTextColor(Color.BLACK);
                btn_day3.setTextColor(Color.BLACK);
                btn_day1.setTextColor(Color.BLACK);
                btn_day5.setTextColor(Color.BLACK);
                btn_day6.setTextColor(Color.BLACK);
                btn_day7.setTextColor(Color.BLACK);
            }
        });
        btn_day5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_day5.setTextColor(Color.RED);
                sobuoi=btn_day5.getText().toString();
                btn_day2.setTextColor(Color.BLACK);
                btn_day3.setTextColor(Color.BLACK);
                btn_day4.setTextColor(Color.BLACK);
                btn_day1.setTextColor(Color.BLACK);
                btn_day6.setTextColor(Color.BLACK);
                btn_day7.setTextColor(Color.BLACK);
            }
        });
        btn_day6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_day6.setTextColor(Color.RED);
                sobuoi=btn_day6.getText().toString();
                btn_day2.setTextColor(Color.BLACK);
                btn_day3.setTextColor(Color.BLACK);
                btn_day4.setTextColor(Color.BLACK);
                btn_day5.setTextColor(Color.BLACK);
                btn_day1.setTextColor(Color.BLACK);
                btn_day7.setTextColor(Color.BLACK);
            }
        });
        btn_day7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_day7.setTextColor(Color.RED);
                sobuoi=btn_day7.getText().toString();
                btn_day2.setTextColor(Color.BLACK);
                btn_day3.setTextColor(Color.BLACK);
                btn_day4.setTextColor(Color.BLACK);
                btn_day5.setTextColor(Color.BLACK);
                btn_day6.setTextColor(Color.BLACK);
                btn_day1.setTextColor(Color.BLACK);
            }
        });
        btn_day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_day1.setTextColor(Color.RED);
                sobuoi=btn_day1.getText().toString();
                btn_day2.setTextColor(Color.BLACK);
                btn_day3.setTextColor(Color.BLACK);
                btn_day4.setTextColor(Color.BLACK);
                btn_day5.setTextColor(Color.BLACK);
                btn_day6.setTextColor(Color.BLACK);
                btn_day7.setTextColor(Color.BLACK);
            }
        });

        Button btn_hour1 = v.findViewById(R.id.button13);
        Button btn_hour2 = v.findViewById(R.id.button);
        Button btn_hour3 = v.findViewById(R.id.button3);
        Button btn_hour4 = v.findViewById(R.id.button4);
        Button btn_hour5 = v.findViewById(R.id.button5);

        btn_hour1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_hour1.setTextColor(Color.RED);
                gio=btn_hour1.getText().toString();
                btn_hour2.setTextColor(Color.BLACK);
                btn_hour3.setTextColor(Color.BLACK);
                btn_hour4.setTextColor(Color.BLACK);
                btn_hour5.setTextColor(Color.BLACK);
                Toast.makeText(getActivity(), ""+gio, Toast.LENGTH_SHORT).show();
            }
        });
        btn_hour2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_hour2.setTextColor(Color.RED);
                gio=btn_hour2.getText().toString();
                btn_hour1.setTextColor(Color.BLACK);
                btn_hour3.setTextColor(Color.BLACK);
                btn_hour4.setTextColor(Color.BLACK);
                btn_hour5.setTextColor(Color.BLACK);
                Toast.makeText(getActivity(), ""+gio, Toast.LENGTH_SHORT).show();
            }
        });
        btn_hour3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_hour3.setTextColor(Color.RED);
                gio=btn_hour3.getText().toString();
                btn_hour2.setTextColor(Color.BLACK);
                btn_hour1.setTextColor(Color.BLACK);
                btn_hour4.setTextColor(Color.BLACK);
                btn_hour5.setTextColor(Color.BLACK);
                Toast.makeText(getActivity(), ""+gio, Toast.LENGTH_SHORT).show();
            }
        });
        btn_hour4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_hour4.setTextColor(Color.RED);
                gio=btn_hour4.getText().toString();
                btn_hour2.setTextColor(Color.BLACK);
                btn_hour3.setTextColor(Color.BLACK);
                btn_hour1.setTextColor(Color.BLACK);
                btn_hour5.setTextColor(Color.BLACK);
                Toast.makeText(getActivity(), ""+gio, Toast.LENGTH_SHORT).show();
            }
        });
        btn_hour5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_hour5.setTextColor(Color.RED);
                gio=btn_hour5.getText().toString();;
                btn_hour2.setTextColor(Color.BLACK);
                btn_hour3.setTextColor(Color.BLACK);
                btn_hour4.setTextColor(Color.BLACK);
                btn_hour1.setTextColor(Color.BLACK);
                Toast.makeText(getActivity(), ""+gio, Toast.LENGTH_SHORT).show();
            }
        });

        Button btn_money1 = v.findViewById(R.id.button6);
        Button btn_money2 = v.findViewById(R.id.button15);
        Button btn_money3 = v.findViewById(R.id.button14);

        btn_money1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_money1.setTextColor(Color.RED);
                money=btn_money1.getText().toString();
                btn_money2.setTextColor(Color.BLACK);
                btn_money3.setTextColor(Color.BLACK);
            }
        });
        btn_money2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_money2.setTextColor(Color.RED);
                money=btn_money2.getText().toString();
                btn_money1.setTextColor(Color.BLACK);
                btn_money3.setTextColor(Color.BLACK);
            }
        });
        btn_money3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_money3.setTextColor(Color.RED);
                money=btn_money3.getText().toString();
                btn_money1.setTextColor(Color.BLACK);
                btn_money2.setTextColor(Color.BLACK);
            }
        });

        Button btn_hinhthuc1 = v.findViewById(R.id.button16);
        Button btn_hinhthuc2 = v.findViewById(R.id.btn_online);

        btn_hinhthuc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_hinhthuc1.setTextColor(Color.RED);
                hinhthuc=btn_hinhthuc1.getText().toString();
                btn_hinhthuc2.setTextColor(Color.BLACK);
            }
        });
        btn_hinhthuc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_hinhthuc2.setTextColor(Color.RED);
                hinhthuc=btn_hinhthuc2.getText().toString();
                btn_hinhthuc1.setTextColor(Color.BLACK);
            }
        });

        Button btn_ok = v.findViewById(R.id.btn_next);
        EditText edtaddress=(EditText) v.findViewById(R.id.edtaddress) ;
        Bundle bundle=getArguments();

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address=edtaddress.getText().toString().trim();
                if(address.length() <=0 || mon.equals("") || lop.equals("") || sobuoi.equals("") || gio.equals("") || money.equals("") || hinhthuc.equals("")){
                    Toast.makeText(getActivity(), "Bạn chưa chọn đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    String id=bundle.getString("id").toString().trim();
                    String perr=bundle.getString("perr").toString().trim();
                    DataClient Post= APIUtils.getData();
                    Call<String> callback=Post.post(id,sobuoi,hinhthuc,gio,money,lop,mon,address);
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String result=response.body();
                            if(result.equals("success")){
                                showDialog(Gravity.BOTTOM);
                                edtaddress.setText("");
                                btn_money1.setTextColor(Color.BLACK);
                                btn_money2.setTextColor(Color.BLACK);
                                btn_money3.setTextColor(Color.BLACK);
                                btn_day1.setTextColor(Color.BLACK);
                                btn_day2.setTextColor(Color.BLACK);
                                btn_day3.setTextColor(Color.BLACK);
                                btn_day4.setTextColor(Color.BLACK);
                                btn_day5.setTextColor(Color.BLACK);
                                btn_day6.setTextColor(Color.BLACK);
                                btn_day7.setTextColor(Color.BLACK);
                                btn_hinhthuc1.setTextColor(Color.BLACK);
                                btn_hinhthuc2.setTextColor(Color.BLACK);
                                btn_hour1.setTextColor(Color.BLACK);
                                btn_hour2.setTextColor(Color.BLACK);
                                btn_hour3.setTextColor(Color.BLACK);
                                btn_hour4.setTextColor(Color.BLACK);
                                btn_hour5.setTextColor(Color.BLACK);

                            } else {
                                Toast.makeText(getActivity(), "thất bại"+response.body(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(getActivity(), "Xảy ra lỗi "+t.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        return v;
    }

    private void showDialog(int gravity) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_post);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = gravity;
        window.setAttributes(layoutParams);
        if (Gravity.BOTTOM == gravity) {
            dialog.setCancelable(true);
        } else {
            dialog.setCancelable(false);
        }
        dialog.show();
    }
}
