package example.com.sdkintegrationapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class FBProfile extends AppCompatActivity {
    String first_name,last_name,email,gender,profileURL,fb_id;
   ImageView  profilePictureView;
   TextView firstNametv,lastNametv,gendertv,emailtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fbprofile);

        profilePictureView=findViewById(R.id.fb_profile_pic);

        firstNametv=findViewById(R.id.first_name);
        lastNametv=findViewById(R.id.last_name);
        gendertv=findViewById(R.id.gender);
        emailtv=findViewById(R.id.email);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        first_name= prefs.getString("fb_first_name","" );
        last_name= prefs.getString("fb_last_name", "");
        email=prefs.getString("fb_email", "");
        gender=prefs.getString("fb_gender", "");
        profileURL= prefs.getString("fb_profileURL","");
        fb_id=prefs.getString("fb_id","");
        Log.d("FBDATA", "Shared Name : "+first_name+"\nLast Name : "+last_name+"\nEmail : "+email+"\nGender : "+gender+"\nProfile Pic : "+profileURL+"\nFB_ID : "+fb_id);

        firstNametv.setText(first_name);
        lastNametv.setText(last_name);
        gendertv.setText(gender);
        emailtv.setText(email);
        try {
            String imageURL;
            imageURL = "http://graph.facebook.com/"+fb_id+"/picture?width=250&height=250";
            Log.d("imageUrl",imageURL);


            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher_round);

            Glide.with(getApplicationContext())
                    .load(imageURL)
                    .apply(options)
                    .into(profilePictureView);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
