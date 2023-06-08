
import java.util.Map;
import java.util.Set;

public class Animal {
    private String title;
    private boolean isAvailable;
    private boolean isSold;
    private Map<String, String> photoMap;

    @Override
    public String toString() {
        String mainString = "", photoMapString = "photoMap: \n";
        mainString += "Title: " + title + "\n";
        if (isAvailable){
            mainString += "is Available: true \nis Sold: false \n";
        }
        else {
            mainString += "is Available: false \nis Sold: true \n";
        }
        for(String key: photoMap.keySet()){
            photoMapString += "{" + key + "=" + photoMap.get(key) + "}" + "\n";
        }
        mainString += photoMapString;
        return mainString;
    }
}
