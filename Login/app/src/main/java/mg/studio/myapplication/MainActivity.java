package mg.studio.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvName;
    private SessionManager session;
    private  TextView user_name;
    private Button btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_name = this.findViewById(R.id.user_name);
        btnLogout = findViewById(R.id.btnLogout);

        Intent getintent=getIntent();
        String userName=getintent.getStringExtra("userName");
        user_name.setText(""+userName);


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this, Login.class);
                startActivity(intent);

            }
        });

    }
}
        /**
         * Only logged in users should access this activity
         */
   /*     session = new SessionManager(this);
        if (!session.isLoggedIn()) {
            logout();
        }
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.user_name);




        *//**
         * If the user just registered an account from Register.class,
         * the parcelable should be retrieved
         *//*
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            // Retrieve the parcelable
            Feedback feedback = bundle.getParcelable("feedback");
            // Get the from the object
            String userName = feedback.getName();
            tvName.setText(userName);
        }


    }*/

    /**
     * Logging out the user:
     * - Will set isLoggedIn flag to false in SharedPreferences
     * - Clears the user data from SqLite users table
     */

 /*   public void btnLogout(View view) {
        logout();
    }*/

/*
    public void logout() {
        // Updating the session
        session.setLogin(false);
        // Redirect the user to the login activity
        startActivity(new Intent(this, Login.class));
        finish();
    }
}*/
