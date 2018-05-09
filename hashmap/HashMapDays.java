
import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author user
 */
public class HashMapDays {

    public static void main(String[] args) {
        String[] days = {"�P����", "�P���@", "�P���G", "�P���T", "�P���|", "�P����", "�P����"};
        HashMap<Integer, String> hm = new HashMap<>();
        for (int i = 1; i <= days.length; i++) {
            hm.put(i, days[i - 1]);
        }

        Calendar c = Calendar.getInstance();
        System.out.println(hm.get(c.get(Calendar.DAY_OF_WEEK)));  // use .HOUR, .MINUTE, .SECOND to obtain time parts
    }

}
