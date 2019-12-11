import core.Line;
import core.Station;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends Assert {

    List<Station> route;

    @Before
    public void setUpRouteCalculator() {
        route = new ArrayList<>();
        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");

        route.add(new Station("Пушкинская", line1));
        route.add(new Station("Московская", line1));
        route.add(new Station("Горьковская", line2));
        route.add(new Station("Пермская", line2));
        route.add(new Station("Екатерининская", line2));
    }

    @Test
    public void testCalculateDuration() {
        Double actual = RouteCalculator.calculateDuration(route);
        Double expected = 11.0;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetShortestRouteOneLine() {
        RouteCalculator routeCalculator = Main.getRouteCalculator();
        List<Station> actual = routeCalculator.getShortestRoute(Main.stationIndex.getStation("Лесная"), Main.stationIndex.getStation("Пушкинская"));
        List<Station> expected = new ArrayList<>();
        expected.add(Main.stationIndex.getStation("Лесная"));
        expected.add(Main.stationIndex.getStation("Выборгская"));
        expected.add(Main.stationIndex.getStation("Площадь Ленина"));
        expected.add(Main.stationIndex.getStation("Чернышевская"));
        expected.add(Main.stationIndex.getStation("Площадь Восстания"));
        expected.add(Main.stationIndex.getStation("Владимирская"));
        expected.add(Main.stationIndex.getStation("Пушкинская"));
        assertEquals(expected, actual);
    }

    @Test
    public void testGetShortestRouteOneConnection() {
        RouteCalculator routeCalculator = Main.getRouteCalculator();
        List<Station> actual = routeCalculator.getShortestRoute(Main.stationIndex.getStation("Василеостровская"), Main.stationIndex.getStation("Площадь Восстания"));
        List<Station> expected = new ArrayList<>();
        expected.add(Main.stationIndex.getStation("Василеостровская"));
        expected.add(Main.stationIndex.getStation("Гостиный двор"));
        expected.add(Main.stationIndex.getStation("Маяковская"));
        expected.add(Main.stationIndex.getStation("Площадь Восстания"));
        assertEquals(expected, actual);
    }

    @Test
    public void testGetShortestRouteTwoConnection() {
        RouteCalculator routeCalculator = Main.getRouteCalculator();
        List<Station> actual = routeCalculator.getShortestRoute(Main.stationIndex.getStation("Горьковская"), Main.stationIndex.getStation("Чернышевская"));
        List<Station> expected = new ArrayList<>();
        expected.add(Main.stationIndex.getStation("Горьковская"));
        expected.add(Main.stationIndex.getStation("Невский проспект"));
        expected.add(Main.stationIndex.getStation("Гостиный двор"));
        expected.add(Main.stationIndex.getStation("Маяковская"));
        expected.add(Main.stationIndex.getStation("Площадь Восстания"));
        expected.add(Main.stationIndex.getStation("Чернышевская"));
        assertEquals(expected, actual);
    }

}
