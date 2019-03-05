package mg.studio.weatherappdesign;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    static String img_weather_condition = "";
    static String second_day = "";
    static String third_day = "";
    static String forth_day = "";
    static String fifth_day = "";
    static String temp2="";
    static String temp3="";
    static String temp4="";
    static String temp5="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String getWeatherMain(JSONArray jsonArray, int positon) {
        try {
            JSONObject someday = jsonArray.getJSONObject(positon);
            String weatherDescribe = someday.optString("weather").toString();

            JSONArray tmp = new JSONArray(weatherDescribe);
            JSONObject weatherDescribeMain = tmp.getJSONObject(0);
            String result = weatherDescribeMain.optString("main");
            return result;
        } catch (JSONException e) {
            //return e.toString();
            Log.i("异常:", e.toString());
        }
        return null;
    }

    public void forcastTheWeather(String str,int i){
        ImageView img_weather_conditionview=(ImageView)this.findViewById(R.id.img_weather_condition);
        ImageView secondview=(ImageView)this.findViewById(R.id.second_day);
        ImageView thirdview=(ImageView)this.findViewById(R.id.third_day);
        ImageView forthview=(ImageView)this.findViewById(R.id.forth_day);
        ImageView fifthview=(ImageView)this.findViewById(R.id.fifth_day);
        if(i==2){
            switch (str){
                case"Clear":
                    img_weather_conditionview.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.sunny_small));
                    break;
                case"Clouds":
                    img_weather_conditionview.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.windy_small));
                    break;
                case"Rain":
                    img_weather_conditionview.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.rainy_small));
                    break;
                default:

            }
        }
        if(i==10){
            switch (str){
                case"Clear":
                    secondview.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.sunny_small));
                    break;
                case"Clouds":
                    secondview.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.windy_small));
                    break;
                case"Rain":
                    secondview.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.rainy_small));
                    break;
                default:

            }
        }
        if(i==18){
            switch (str){
                case"Clear":
                    thirdview.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.sunny_small));
                    break;
                case"Clouds":
                    thirdview.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.windy_small));
                    break;
                case"Rain":
                    thirdview.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.rainy_small));
                    break;
                default:

            }
        }
        if(i==26){
            switch (str){
                case"Clear":
                    forthview.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.sunny_small));
                    break;
                case"Clouds":
                    forthview.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.windy_small));
                    break;
                case"Rain":
                    forthview.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.rainy_small));
                    break;
                default:

            }
        }
        if(i==34){
            switch (str){
                case"Clear":
                    fifthview.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.sunny_small));
                    break;
                case"Clouds":
                    fifthview.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.windy_small));
                    break;
                case"Rain":
                    fifthview.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.rainy_small));
                    break;
                default:

            }
        }
    }

    public String getWeathertemp(JSONArray jsonArray, int positon) {
        try {
            JSONObject currentday=jsonArray.getJSONObject(positon);
            String main=currentday.optString("main").toString();
            JSONObject temp=new JSONObject(main);

            String result=temp.optString("temp");
            Double data=Double.parseDouble(result);
            data=data-273.15;
            int appear=data.intValue();
            result=String.valueOf(appear);

            return (result);

        } catch (JSONException e) {
            //return e.toString();
            Log.i("异常:", e.toString());
        }
        return null;
    }

    public  void showtemp(String temp,int a){
        if(a==10){
            TextView temp2=(TextView)this.findViewById(R.id.temp2);
            Log.i("temp2:",temp);
            temp2.setText(temp+"°C");
        }
        if(a==18){
            TextView temp3=(TextView)this.findViewById(R.id.temp3);
            temp3.setText(temp+"°C");
        }
        if(a==26){
            TextView temp4=(TextView)this.findViewById(R.id.temp4);
            temp4.setText(temp+"°C");
        }
        if(a==34){
            TextView temp5=(TextView)this.findViewById(R.id.temp5);
            temp5.setText(temp+"°C");
        }


    }

    public void btnClick(View view) {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null && info.isAvailable())
        {
            new DownloadUpdate().execute();
            Toast.makeText(getApplicationContext(),"Network connected",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"No network connection", Toast.LENGTH_LONG).show();
        }

        //new DownloadUpdate().execute();

        //get the system time
        SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("MM/dd/yyyy");
        Date curDate=new Date(System.currentTimeMillis());
        String str=formatter.format(curDate);
        Log.d("curdate time:",str);
        TextView text_curtime=(TextView)this.findViewById(R.id.tv_date);
        text_curtime.setText(str);


        //setCityName("Chongqing");

        SimpleDateFormat format=new SimpleDateFormat("EEEE");
        Date curdate=new Date(System.currentTimeMillis());
        String curstr=format.format(curDate);
        TextView today=(TextView)this.findViewById(R.id.today);
        today.setText(curstr);
        int numberInWeek=getNumberInWeek(curstr);
        setSpecificTime(numberInWeek);

    }

    public int getNumberInWeek(String str){
        int number=0;
        switch (str){
            case "Sunday":
                number=7;
                break;
            case"Saturday":
                number=6;
                break;
            case"Friday":
                number=5;
                break;
            case"Thursday":
                number=4;
                break;
            case"Wednesday":
                number=3;
                break;
            case"Tuesday":
                number=2;
                break;
            case"Monday":
                number=1;
                break;
            default:
                break;
        }
        return number;
    }

    public String getStringInWeek(int t){
        String whatday=null;
        switch (t){
            case 0:
                whatday="SUN";
                break;
            case 1:
                whatday="MON";
                break;
            case 2:
                whatday="TUE";
                break;
            case 3:
                whatday="WED";
                break;
            case 4:
                whatday="THU";
                break;
            case 5:
                whatday="FRI";
                break;
            case 6:
                whatday="SAT";
                break;
            default:
                break;
        }
        return whatday;
    }
    public void setSpecificTime(int i){
        int time2=i+1;
        time2=time2%7;
        String time2string=getStringInWeek(time2);
        Log.i("time2：",time2string);
        TextView time2time=(TextView)this.findViewById(R.id.time2);
        time2time.setText(time2string);

        int time3=i+2;
        time3=time3%7;
        String time3string=getStringInWeek(time3);
        Log.i("time3：",time3string);
        TextView time3time=(TextView)this.findViewById(R.id.time3);
        time3time.setText(time3string);

        int time4=i+3;
        time4=time4%7;
        String time4string=getStringInWeek(time4);
        Log.i("time4：",time4string);
        TextView time4time=(TextView)this.findViewById(R.id.time4);
        time4time.setText(time4string);

        int time5=i+4;
        time5=time5%7;
        String time5string=getStringInWeek(time5);
        TextView time5time=(TextView)this.findViewById(R.id.time5);
        time5time.setText(time5string);
    }

    public void setCityName(String cityName){
        TextView cityname=(TextView)this.findViewById(R.id.tv_location);
        cityname.setText(cityName);
}

    private class DownloadUpdate extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... strings) {
            String stringUrl = "http://api.openweathermap.org/data/2.5/forecast?q=Chongqing,cn&mode=json&APPID=aa3d744dc145ef9d350be4a80b16ecab";
            HttpURLConnection urlConnection = null;
            BufferedReader reader;

            try {
                URL url = new URL(stringUrl);

                // Create the request to get the information from the server, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Mainly needed for debugging
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                //The temperature
                //return buffer.toString();
                try{
                    JSONObject root=new JSONObject(buffer.toString());
                    String  list=root.optString("list").toString();

                    JSONArray arraylist=new JSONArray(list);
                    JSONObject currentday=arraylist.getJSONObject(0);
                    String main=currentday.optString("main").toString();
                    JSONObject temp=new JSONObject(main);

                    String result=temp.optString("temp");
                    Double data=Double.parseDouble(result);
                    data=data-273.15;
                    int appear=data.intValue();
                    result=String.valueOf(appear);

                   // String city=root.optString("city").toString();
                    //JSONObject ncity = new JSONObject(city);
                    //String nowcity=ncity.optString("ncity");

                    img_weather_condition=getWeatherMain(arraylist,2);
                    second_day=getWeatherMain(arraylist,10);
                    third_day=getWeatherMain(arraylist,18);
                    forth_day=getWeatherMain(arraylist,26);
                    fifth_day=getWeatherMain(arraylist,34);

                    temp2=getWeathertemp(arraylist,10);
                    temp3=getWeathertemp(arraylist,18);
                    temp4=getWeathertemp(arraylist,26);
                    temp5=getWeathertemp(arraylist,34);


                    return  result;

                }catch (JSONException e){
                    Log.i("异常:",e.toString());
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String temperature) {
            //Update the temperature displayed
            ((TextView) findViewById(R.id.temperature_of_the_day)).setText(temperature);

            setCityName("Chongqing");
            forcastTheWeather(img_weather_condition,2);
            forcastTheWeather(second_day,10);
            forcastTheWeather(third_day,18);
            forcastTheWeather(forth_day,26);
            forcastTheWeather(fifth_day,34);

            showtemp(temp2,10);
            showtemp(temp3,18);
            showtemp(temp4,26);
            showtemp(temp5,34);
        }
    }
}
