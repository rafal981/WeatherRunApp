public class AssessmentOfConditions {

     public static String evaluateWeatherConditions(){

         SeleniumWeatherForRunTest seleniumWeatherForRunTest = new SeleniumWeatherForRunTest();

         int weatherConditionsMet = 0;
         //StringBuilder additionalMessage = new StringBuilder();

        if (seleniumWeatherForRunTest.temp > -5 && seleniumWeatherForRunTest.temp < 25){
            weatherConditionsMet++;
            System.out.println("Temperatura jest odpowiednia do biegania");
        }
         if (seleniumWeatherForRunTest.temp <= 10.0){
            System.out.println("Załóż strój zimowy");
        }else if (seleniumWeatherForRunTest.temp > 20.0){
            System.out.println("Załóż strój letni");
        }

        if (seleniumWeatherForRunTest.wind > 40.0){
            weatherConditionsMet++;
            System.out.println("Uważaj, dzisiaj jest silny wiatr");
        }

        if (seleniumWeatherForRunTest.raining >20.0){
            weatherConditionsMet++;
            System.out.println("Uważaj, silne opady. Śliska nawierzchnia");
        }

        if (seleniumWeatherForRunTest.humi > 40.0 && seleniumWeatherForRunTest.humi < 60.0){
            weatherConditionsMet++;
            System.out.println("Dobra wilgotność powietrza");
        }

         if (weatherConditionsMet == 4) {
             return "Bardzo dobre warunki do biegania. " ;
         } else if (weatherConditionsMet >= 2) {
             return "Dobre warunki do biegania. " ;
         } else {
             return "Słabe warunki do biegania.";
         }
    }
}

