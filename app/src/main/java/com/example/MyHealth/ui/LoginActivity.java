package com.example.MyHealth.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.MyHealth.R;
import com.example.MyHealth.SignUpActivity;
import com.example.MyHealth.SignUpForms;
import com.example.MyHealth.retroapi.ApiClient;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Call;
import com.example.MyHealth.retroapi.retromod.Login;
import com.example.MyHealth.retroapi.retromod.User;
import com.google.android.material.textfield.TextInputEditText;

//login screen, rn since haisi connected to db I added local variables but obviously it should load doc or patient view based on whether it's a doc entering or patient entering.


public class LoginActivity extends AppCompatActivity {
    private EditText lgUsername;
    private EditText lgPassword;
    private Button loginBtn;
    private  Button signupBTN;
   // public static final int MODE_NIGHT_NO;

    TextInputEditText username, password;

    private final String CREDENTIAL_SHARED_PREF = "our_shared_pref";

   // Retrofit.Builder builder = new Retrofit.Builder()
  //          .baseUrl("http://192.168.100.116:8000").addConverterFactory(GsonConverterFactory.create());

  //  Retrofit retrofit = builder.build();
 //   UserClient userClient = retrofit.create(UserClient.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //lgUsername = findViewById(R.id.txt_username);
      //  lgPassword = findViewById(R.id.txt_password);




        username = findViewById(R.id.txt_username);
        password = findViewById(R.id.txt_password);

        loginBtn = findViewById(R.id.loginBtn);
        signupBTN = findViewById(R.id.signupBtn);

          // findViewById(R.id.loginBtn).setOnClickListener(new View.OnClickListener() {
           //   @Override
           //       public void onClick(View v) {
           //          login();
          //       }
          //   });

        signupBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUp();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


 //               if (lgUsername.getText().toString().equals("DrChirisa") && lgPassword.getText().toString().equals("123456")) {
 //                   Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
   //                 startActivity(intent);
  //              } else if (lgUsername.getText().toString().equals("clintroymkt@gmail.com") && lgPassword.getText().toString().equals("123456")) {
  //                  Intent intent = new Intent(LoginActivity.this, MainActivity.class);
  //                  startActivity(intent);
  //              } else if (lgUsername.getText().toString().equals("dmukute@gmail.com") && lgPassword.getText().toString().equals("123456")) {
  //                  Intent intent = new Intent(LoginActivity.this, NurseActivity.class);
  //                  startActivity(intent);
  //              } else {
  //                  Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
  //              }

                if(TextUtils.isEmpty(username.getText().toString()) && TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(LoginActivity.this, "Username/ Password Required", Toast.LENGTH_LONG).show();

                }else{
                    login();
                }
            }
        });


    }

    private void openSignUp() {
        Intent intent = new Intent(LoginActivity.this, SignUpForms.class);
        startActivity(intent);
    }

  //  private static String token;

    public void  login(){
        Login login = new Login();
        login.setUser(username.getText().toString());
        login.setPassword(password.getText().toString());

        Call<User> userCall = ApiClient.getUserClient().login(login);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                    //     User user = response.body();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        }
                    }, 700);

                }else{
                  //  Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_LONG).show();
                    if (username.getText().toString().equals("DrChirisa") && password.getText().toString().equals("123456")) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else if (username.getText().toString().equals("clintroymkt@gmail.com") && password.getText().toString().equals("123456")) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else if (username.getText().toString().equals("MacJohn Chirisa") && password.getText().toString().equals("123456")) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }



                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Throwable "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                if (username.getText().toString().equals("DrChirisa") && password.getText().toString().equals("123456")) {
                                                  Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                                   startActivity(intent);
                                                } else if (username.getText().toString().equals("clintroymkt@gmail.com") && password.getText().toString().equals("123456")) {
                                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                                     startActivity(intent);
                                                 } else if (username.getText().toString().equals("MacJohn Chirisa") && password.getText().toString().equals("123456")) {
                                                      Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                                      startActivity(intent);
                                                  } else {
                                                      Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                                   }



            }
        });
    }

    //private void login() {
    //    Login login = new Login("teenzmcwamsie@gmail.com", "password");
   //       Call<User> call = userClient.login(login);

   //       call.enqueue(new Callback<User>() {
    //         @Override
   //          public void onResponse(Call<User> call, Response<User> response) {
   //               if (response.isSuccessful()) {
    //                  Toast.makeText(LoginActivity.this, response.body().getToken(), Toast.LENGTH_SHORT).show();
  //                    token = response.body().getToken();

    //                  Intent intent = new Intent(LoginActivity.this, PatientList.class);
   //                   startActivity(intent);
   //             } else {
   //                 Toast.makeText(LoginActivity.this, "login not correct if", Toast.LENGTH_SHORT).show();
    //            }
    //        }

    //        @Override
    //        public void onFailure(Call<User> call, Throwable t) {
            //    Toast.makeText(LoginActivity.this, "error if", Toast.LENGTH_SHORT).show();

      //          if (lgUsername.getText().toString().equals("DrChirisa") && lgPassword.getText().toString().equals("123456")) {
       //                               Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
     //                               startActivity(intent);
     //                            } else if (lgUsername.getText().toString().equals("clintroymkt@gmail.com") && lgPassword.getText().toString().equals("123456")) {
    //                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
     //                                 startActivity(intent);
    //                             } else if (lgUsername.getText().toString().equals("dmukute@gmail.com") && lgPassword.getText().toString().equals("123456")) {
    //                                  Intent intent = new Intent(LoginActivity.this, NurseActivity.class);
    //                                  startActivity(intent);
    //                              } else {
    //                                  Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
   //                               }


    //        }
   //     });
  //  }



    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}

