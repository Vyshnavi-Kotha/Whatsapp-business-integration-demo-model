package com.example;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WhatsAppService {
    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.whatsapp.from}")
    private String fromNumber;

    public void sendRegistrationMessage(String toNumber, String firstName) {
        Twilio.init(accountSid, authToken);
        Message.creator(
                new PhoneNumber("whatsapp:" + toNumber),
                new PhoneNumber(fromNumber),
                "Hello " + firstName + ", your registration is successfully done!"
        ).create();
    }
}
