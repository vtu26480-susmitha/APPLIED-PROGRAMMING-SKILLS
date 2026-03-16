import java.util.*;

class UndergroundSystem {

    class CheckInData {
        String station;
        int time;

        CheckInData(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class TravelData {
        int totalTime = 0;
        int count = 0;
    }

    Map<Integer, CheckInData> checkInMap;
    Map<String, TravelData> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInData data = checkInMap.get(id);
        checkInMap.remove(id);

        String route = data.station + "-" + stationName;
        int travelTime = t - data.time;

        TravelData td = travelMap.getOrDefault(route, new TravelData());
        td.totalTime += travelTime;
        td.count += 1;

        travelMap.put(route, td);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "-" + endStation;
        TravelData td = travelMap.get(route);
        return (double) td.totalTime / td.count;
    }
}