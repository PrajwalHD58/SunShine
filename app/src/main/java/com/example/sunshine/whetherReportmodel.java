package com.example.sunshine;

public class whetherReportmodel {
//    "id":6438381849411584,
    private  String weather_state_name;
    private  String applicable_date;
    private float min_temp;
    private float max_temp;
    private float the_temp;



    public whetherReportmodel() {

    }

    @Override
    public String toString() {
        return "Date="+ applicable_date + "\n" +
                "Weather="+weather_state_name + "\n"+
                "Min temp=" + min_temp +"Celcius\n"+
                "Max temp=" + max_temp +"Celcius\n"+
                "Avg_temp=" + the_temp +"Celcius\n";
    }

    public String getWeather_state_name() {
        return weather_state_name;
    }

    public void setWeather_state_name(String weather_state_name) {
        this.weather_state_name = weather_state_name;
    }




    public String getApplicable_date() {
        return applicable_date;
    }

    public void setApplicable_date(String applicable_date) {
        this.applicable_date = applicable_date;
    }

    public float getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(float min_temp) {
        this.min_temp = min_temp;
    }

    public float getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(Float max_temp) {
        this.max_temp = max_temp;
    }

    public float getThe_temp() {
        return the_temp;
    }

    public void setThe_temp(float the_temp) {
        this.the_temp = the_temp;
    }


}
