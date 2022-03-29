import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Flight> flightList = findPlanesLeavingInTheNextTwoHours(Airport.getInstance());
        for (Flight flight : flightList) {
            System.out.println(flight);
        }
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        LocalDateTime now = LocalDateTime.now();

        return airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream()
                        .filter(flight -> flight.getType()
                        .equals(Flight.Type.DEPARTURE)))
                .filter(flight -> localDateTime(flight.getDate()).getHour() <= (now.plusHours(2)).getHour())
                .filter(flight -> localDateTime(flight.getDate()).getHour() > (now.minusHours(2)).getHour())
                .collect(Collectors.toList());
    }

    public static LocalDateTime localDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}