public class BuilderMailText {

    public String buildMessageContent() {

        WeatherAPIRequest weatherAPIRequest = new WeatherAPIRequest();
        WeatherData data = weatherAPIRequest.setWeatherDataFromWeatherAPI();

        WeatherAlert weatherAlert = new WeatherAlert();

        StringBuilder messageContent = new StringBuilder();
        messageContent.append("Warunki pogodowe :\n")
                .append("Temperature in Celsius: ").append(data.getTemperatureInCelsius()).append("\n")
                .append("Max Temperature in Celsius: ").append(data.getMaxTemperatureInCelsius()).append("\n")
                .append("Min Temperature in Celsius: ").append(data.getMinTemperatureInCelsius()).append("\n")
                .append("Conditions: ").append(data.getConditions()).append("\n")
                .append("Wind Speed: ").append(data.getWindSpeed()).append("\n")
                .append("Precipitation: ").append(data.getPrecipitation()).append("\n")
                .append("Humidity: ").append(data.getHumidity()).append("\n\n");

        for (String alert : weatherAlert.evaluateWeatherConditions()) {
            messageContent.append(alert).append("\n");
        }
        return messageContent.toString();
    }
}

