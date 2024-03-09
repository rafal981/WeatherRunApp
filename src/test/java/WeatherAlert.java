import java.util.ArrayList;

public class WeatherAlert  {

    public  ArrayList<String> evaluateWeatherConditions() {

        WeatherAPIRequest weatherAPIRequest = new WeatherAPIRequest();


        WeatherData data =  weatherAPIRequest.setWeatherDataFromWeatherAPI();

        ArrayList<String> alertArray = new ArrayList<>();

        if (data.getTemperatureInCelsius() <= 3) {
            alertArray.add("Temperatura jest bardzo niska. Złe warunki biegowe");
        }
        if (data.getTemperatureInCelsius() > 30) {
            alertArray.add("Temperatura jest bardzo wysoka. Złe warunki biegowe");
        }
        if (data.getWindSpeed() > 40.0) {
            alertArray.add("Uważaj, dzisiaj jest silny wiatr");
        }
        if (data.getHumidity() < 50.0) {
            alertArray.add("Uważaj, bardzo suche powietrze");
        }
        if (data.getHumidity() > 110) {
            alertArray.add("Uważaj, bardzo duża wilgotność powietrza");
        }
        if (data.getPrecipitation() > 1) {
            alertArray.add("Uważaj silne opady");
        }
        if (alertArray.size()==0){
            alertArray.add("Brak alertów pogodowych");
        }
        return alertArray;
    }
}
