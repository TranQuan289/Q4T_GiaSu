package com.example.android.Register;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.giasu.Fragment_profile;
import com.example.android.giasu.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePassFragment extends Fragment{
    ImageView img_back;
    Button change;
    EditText pass,pass1,pass_old;
    String id="1";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.change_pass_fragment,container,false);
        img_back = v.findViewById(R.id.img_back);
        change = v.findViewById(R.id.btn_change);
        pass = v.findViewById(R.id.edt_pass2);
        pass_old=v.findViewById(R.id.edt_curr_pass);
        pass1= v.findViewById(R.id.edt_pass);



        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new Fragment_profile());
            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pass.getText().toString().trim().equals(pass1.getText().toString().trim())) {

                    DataClient dataClient = APIUtils.getData();
                    Call<String> callback = dataClient.change_pass(id, pass.getText().toString().trim(),pass_old.getText().toString().trim());
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String string = response.body().toString().trim();
                            if (string != null)
                                Toast.makeText(getContext(), "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(getContext(), "Mật khẩu củ không đúng", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else
                    Toast.makeText(getContext(), "Mật khẩu mới không trùng nhau", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
    private void replaceFragment4(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main, fragment).addToBackStack(null).commit();
    }
}