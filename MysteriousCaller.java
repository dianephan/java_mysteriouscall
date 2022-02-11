import java.net.URI;
import java.net.URISyntaxException;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

public class MysteriousCaller {
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static void main(String[] args) throws URISyntaxException {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        String from = "+<YOUR_TWILIO_NUMBER>";
        String to = "+<YOUR_PHONE_NUMBER>"; 

        Call call = Call.creator(
            new PhoneNumber(to), 
            new PhoneNumber(from),
            URI.create("https://<YOUR_URL_HERE>-4190.twil.io/virtualselfcall.mp3"))
          .create();

        System.out.println(call.getSid());
    }
}
