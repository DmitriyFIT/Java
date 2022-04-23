import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List <Station> route1;
    StationIndex stationIndex;
    RouteCalculator routeCalculator;

    @Override
    protected void setUp() throws Exception {
        route1 = new ArrayList<>();
        stationIndex = new StationIndex();

        Line line1 = new Line(1, "First");
        Line line2 = new Line(2, "Second");
        Line line3 = new Line(3, "Third");

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        Station s1l1 = new Station("st 1-1", line1);
        Station s2l1 = new Station("st 2-1", line1);
        Station s3l1 = new Station("st 3-1", line1);

        line1.addStation(s1l1);
        line1.addStation(s2l1);
        line1.addStation(s3l1);

        Station s1l2 = new Station("st 1-2", line2);
        Station s2l2 = new Station("st 2-2", line2);
        Station s3l2 = new Station("st 3-2", line2);

        line2.addStation(s1l2);
        line2.addStation(s2l2);
        line2.addStation(s3l2);

        Station s1l3 = new Station("st 1-3", line3);
        Station s2l3 = new Station("st 1-3", line3);
        Station s3l3 = new Station("st 1-3", line3);

        line3.addStation(s1l3);
        line3.addStation(s2l3);
        line3.addStation(s3l3);

        stationIndex.addStation(s1l1);
        stationIndex.addStation(s2l1);
        stationIndex.addStation(s3l1);
        stationIndex.addStation(s1l2);
        stationIndex.addStation(s2l2);
        stationIndex.addStation(s3l2);
        stationIndex.addStation(s1l3);
        stationIndex.addStation(s2l3);
        stationIndex.addStation(s3l3);

        List<Station> conection1to2 = new ArrayList<>();
        conection1to2.add(s2l1);
        conection1to2.add(s2l2);
        List<Station> connection2to3 = new ArrayList<>();
        connection2to3.add(s2l2);
        connection2to3.add(s3l3);

        route1.add(s1l1);
        route1.add(s2l1);
        route1.add(s3l1);
        route1.add(s2l2);
        route1.add(s1l2);
        route1.add(s3l3);
    }

    @Test
    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route1);
        double expected = 14.5;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetRouteOnTheLine() {
        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex.getStation("st 1-1"),
                stationIndex.getStation("st 1-3"));
        assertEquals(3, actual.size());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
