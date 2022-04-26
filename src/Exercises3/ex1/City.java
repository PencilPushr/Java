package Exercises3.ex1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class City extends Population{

    private double latitude, longitude; //specify location

    public City(double inputSize, double latitude, double longitude) {
        super(inputSize);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        //Math.round(getSize()*100)/100D + " million located ..."
        //above code is a placeholder if the code below is slow
        return roundToTwoDP(getSize()) + " million located at "
                                        + roundToTwoDP(this.latitude) + " lat, "
                                        + roundToTwoDP(this.longitude) + " lon";
    }

    //rounds to the closest two decimal places
    public double roundToTwoDP(double value){
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, //rounding to 2 decimal places
                RoundingMode.HALF_UP); //apparently java default is to round down if the last number is even
        return bd.doubleValue();
    }
}
