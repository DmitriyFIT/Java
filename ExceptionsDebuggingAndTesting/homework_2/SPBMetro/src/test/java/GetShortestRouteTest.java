import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class GetShortestRouteTest extends TestCase {

    List <Station> routeOnTheLine = new ArrayList<>();
    List <Station> routeWithOneConnection = new ArrayList<>();
    List <Station> routeWithTwoConnections = new ArrayList<>();
    StationIndex stationIndex = new StationIndex();
    RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

    @Override
    protected void setUp() throws Exception {
        Line line1 = new Line(1, "First");
        Line line2 = new Line(2, "Second");
        Line line3 = new Line(3, "Third");

        Station station11 = new Station("11", line1);
        Station station12 = new Station("12", line1);
        Station station13 = new Station("13", line1);
        Station station21 = new Station("21", line2);
        Station station22 = new Station("22", line2);
        Station station23 = new Station("23", line2);
        Station station31 = new Station("31", line3);
        Station station32 = new Station("32", line3);
        Station station33 = new Station("33", line3);

        line1.addStation(station11);
        line1.addStation(station12);
        line1.addStation(station13);
        line2.addStation(station21);
        line2.addStation(station22);
        line2.addStation(station23);
        line3.addStation(station31);
        line3.addStation(station32);
        line3.addStation(station33);

        stationIndex.addStation(station11);
        stationIndex.addStation(station12);
        stationIndex.addStation(station13);
        stationIndex.addStation(station21);
        stationIndex.addStation(station22);
        stationIndex.addStation(station23);
        stationIndex.addStation(station31);
        stationIndex.addStation(station32);
        stationIndex.addStation(station33);

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        List<Station> connection1to2 = new ArrayList<>();
        connection1to2.add(station12);
        connection1to2.add(station22);

        List<Station> connection2to3 = new ArrayList<>();
        connection2to3.add(station21);
        connection2to3.add(station31);

        stationIndex.addConnection(connection1to2);
        stationIndex.addConnection(connection2to3);

        routeOnTheLine.add(station11);
        routeOnTheLine.add(station12);
        routeOnTheLine.add(station13);

        routeWithOneConnection.add(station11);
        routeWithOneConnection.add(station12);
        routeWithOneConnection.add(station22);
        routeWithOneConnection.add(station23);

        routeWithTwoConnections.add(station11);
        routeWithTwoConnections.add(station12);
        routeWithTwoConnections.add(station22);
        routeWithTwoConnections.add(station21);
        routeWithTwoConnections.add(station31);
        routeWithTwoConnections.add(station32);
    }

    @Test
    public void testGetRouteOnTheLine() {
        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex.getStation("11"),
                stationIndex.getStation("13"));
        List<Station> expected = routeOnTheLine;
        assertEquals(expected,actual);
    }

    @Test
    public void testGetRouteWithOneConnection() {
        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex.getStation("11"),
                stationIndex.getStation("23"));
        List<Station> expected = routeWithOneConnection;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetRouteWithTwoConnection() {
        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex.getStation("11"),
                stationIndex.getStation("32"));
        List<Station> expected = routeWithTwoConnections;
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}