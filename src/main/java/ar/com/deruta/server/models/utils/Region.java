package ar.com.deruta.server.models.utils;

public class Region {

    private Double minLat;
    private Double maxLat;
    private Double minLng;
    private Double maxLng;

    public Double getMinLat() {
        return minLat;
    }

    public void setMinLat(Double minLat) {
        this.minLat = minLat;
    }

    public Double getMaxLat() {
        return maxLat;
    }

    public void setMaxLat(Double maxLat) {
        this.maxLat = maxLat;
    }

    public Double getMinLng() {
        return minLng;
    }

    public void setMinLng(Double minLng) {
        this.minLng = minLng;
    }

    public Double getMaxLng() {
        return maxLng;
    }

    public void setMaxLng(Double maxLng) {
        this.maxLng = maxLng;
    }

    @Override
    public String toString() {
        return "Region{" +
                "minLat=" + minLat +
                ", maxLat=" + maxLat +
                ", minLng=" + minLng +
                ", maxLng=" + maxLng +
                '}';
    }
}
