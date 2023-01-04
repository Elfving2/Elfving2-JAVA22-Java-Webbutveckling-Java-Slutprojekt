package Model;
public class WeatherBean {
    private String cityStr;

    private String countryStr;

    private String cloudsStr;

    private String temperatureStr;

    private String lastUpdateStr;

    private String[] saveCookies;

    private String deniedCookies;

    public String getDeniedCookies() {
        return deniedCookies;
    }

    public void setDeniedCookies(String deniedCookies) {
        this.deniedCookies = deniedCookies;
    }

    public String[] getSaveCookies() {
        return saveCookies;
    }

    public void setSaveCookies(String[] saveCookies) {
        this.saveCookies = saveCookies;
    }

    public WeatherBean(String cityStr, String countryStr) {
        this.cityStr = cityStr;
        this.countryStr = countryStr;
    }
    public String getCityStr() {
        return cityStr;
    }
    public String getCountryStr() {
        return countryStr;
    }

    public String getCloudsStr() {
        return cloudsStr;
    }

    public void setCloudsStr(String cloudsStr) {
        this.cloudsStr = cloudsStr;
    }

    public String getTemperatureStr() {
        return temperatureStr;
    }

    public void setTemperatureStr(String temperatureStr) {
        this.temperatureStr = temperatureStr;
    }

    public String getLastUpdateStr() {
        String date = lastUpdateStr.substring(0,10);
        return date;
    }

    public void setLastUpdateStr(String lastUpdateStr) {
        this.lastUpdateStr = lastUpdateStr;
    }
}
