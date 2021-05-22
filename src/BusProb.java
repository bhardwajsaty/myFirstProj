import java.util.ArrayList;
import java.util.*;
import java.util.List;

class Passanger {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    float fare;

    public Passanger(int id, float fare) {
        this.id = id;
        this.fare = fare;
    }
}

public class BusProb {
    public static void main(String[] args) {
        int capacity;
        int stops;
        List<String> listOfInputs = new ArrayList<>();
        capacity = 18;
        stops = 8;
        listOfInputs.add("+12412 +5465 +5241 +52425 +21032 +21315");
        listOfInputs.add("+5645 +56412 +41524 -12412 -21032 -21315");
        listOfInputs.add("+56456 +46423 +12412 -5645 -52425 -5241 -5465");
        listOfInputs.add("+1543 +1873 +28466 -12412 -56456 -41524");
        listOfInputs.add("+35456 +36874 +4654 +12412 -1543");
        listOfInputs.add("+4879 +4131 +532 +562 -28466 -12412");
        listOfInputs.add("+65446 +10412 +12412 +68723 -532");
        listOfInputs.add("+7545 +8651 -4131 -562");
        String query = "5, 28466";
        String actual = output(capacity, stops, listOfInputs, query);
        //assertEquals(503829939, actual.hashCode());
        System.out.println(actual.hashCode());
    }

    static ArrayList<Passanger> passengerList = new ArrayList<>();
    static ArrayList<Passanger> currentList = new ArrayList<>();
    static ArrayList<Passanger> totalFareList = new ArrayList<>();

    // static ArrayList<Passanger> endTripList= new ArrayList<>();
    public static String output(int capacity, int stops, List<String> listOfInputStrings, String query) {
        String outstring = "";
        int n = capacity;

        int passengersIN = 0;
        int passengersOUT = 0;
        float fare = 0;
        double twentyFivePercentPass = Math.ceil((0.25 * n));
        double fiftyPercentPass = Math.ceil((0.5 * n));
        boolean foundPassenger = false;

        float fare1 = (float) (n + (n * 0.6));
        float fare2 = (float) (n + (n * 0.3));
        float fare3 = (float) n;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        //Loop until no of stops
        for (int i = 0; i < stops; i++) {
            String line = listOfInputStrings.get(i);
            //Split using comma
            String[] passengers = line.split(" ");
            for (int k = 0; k < passengers.length; k++) {
                //Trim passId
                String passId = passengers[k].replace("+", "").replace("-", "");
                int id = Integer.parseInt(passId);
                if (passengers[k].startsWith("+")) {

                    for (Passanger pass : passengerList) {
                        if (id == pass.getId())
                            foundPassenger = true;
                    }

                    if (!foundPassenger) {
                        passengerList.add(new Passanger(id, 0));
                        currentList.add(new Passanger(id, 0));
                        //totalFareList.add(new Passanger(id,0));
                        passengersIN++;
                    }
                } else {
                    Iterator<Passanger> iter
                            = passengerList.iterator();
                    while (iter.hasNext()) {
                        Passanger pass = iter.next();
                        if (id == pass.getId()) {
                            iter.remove();
                            passengersOUT++;
                        }
                    }

                }
            }
            //System.out.println(currentList.size()+" new passengers added at "+(i+1)+"th stop.");
            // System.out.println(passengersIN-passengersOUT+" total passengers present at "+(i+1)+"th stop.");
            //Set fare
            for (int j = 0; j < currentList.size(); j++) {
                if (passengerList.size() <= twentyFivePercentPass)
                    fare = fare1;//(float)(n+(n*0.6));
                else if (passengerList.size() > twentyFivePercentPass && passengerList.size() <= fiftyPercentPass)
                    fare = fare2;//(float)(n+(n*0.3));
                else if (passengerList.size() > fiftyPercentPass)
                    fare = fare3;//(float)n;

                currentList.get(j).setFare(fare);
            }

            totalFareList.addAll(currentList);

            for (Passanger pass : currentList) {
                // System.out.println(pass.getFare());
                if (Float.compare(pass.getFare(), fare1) == 0)
                    count1++;
                if (Float.compare(pass.getFare(), fare2) == 0)
                    count2++;
                if (Float.compare(pass.getFare(), fare3) == 0)
                    count3++;
            }

            currentList.clear();

        }
        if (query.equalsIgnoreCase("1")) {
            outstring += passengersIN + " passengers got on the bus and " + passengersOUT + " passengers got out of the bus";
            // System.out.println(outstring);
        }
        if (query.equalsIgnoreCase("2")) {

            outstring += count1 + " passengers traveled with a fare of " + fare1 + ", " + count2 + " passengers traveled with a fare of " +
                    fare2 + " and " + count3 + " passengers traveled with a fare of " + fare3;
            // System.out.println(outstring);
        }

        if (query.startsWith("3")) {
            String[] arr = query.split(",");
            String passId = arr[1].substring(1);
            int id = Integer.parseInt(passId);
            float totalfare = 0;
            for (Passanger pass : totalFareList) {
                if (pass.getId() == id) {
                    totalfare += pass.getFare();
                }
            }
            outstring += "Passenger " + id + " spent a total fare of " + totalfare;
            // System.out.println(outstring);
        }

        if (query.startsWith("4")) {
            String[] arr = query.split(",");
            String passId = arr[1].substring(1);
            int id = Integer.parseInt(passId);
            int count = 0;
            for (Passanger pass : totalFareList) {
                if (pass.getId() == id) {
                    count++;
                }
            }
            outstring += "Passenger " + id + " has got on the bus for " + count + " times";
            //  System.out.println(outstring);
        }

        if (query.startsWith("5")) {
            String[] arr = query.split(",");
            String passId = arr[1].substring(1);
            int id = Integer.parseInt(passId);
            int count = 0;
            for (Passanger pass : passengerList) {
                if (pass.getId() == id) {
                    count++;
                }
            }
            if (count == 0)
                outstring += "Passenger " + id + " was not inside the bus at the end of the trip";
            else outstring += "Passenger " + id + " was inside the bus at the end of the trip";
            //System.out.println(outstring);
        }

        return outstring;
    }
}