package bcp.keycloak.authenticator.gateway;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
//import com.example.sns.SNSAws.AwsSNSClient;

import java.util.HashMap;
import java.util.Map;

public class AwsSmsService implements SmsService {
    public static final String AWS_ACCESS_KEY_ID = "aws.accessKeyId";
    public static final String AWS_SECRET_KEY = "aws.secretKey";
    static {
        System.setProperty(AWS_ACCESS_KEY_ID, "AKIA5RXNGPTY72ZAWKAU");
        System.setProperty(AWS_SECRET_KEY, "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");
    }
    //private final String senderId;

    /*AwsSmsService(Map<String, String> config) {
        senderId = config.get("senderId");
    }*/
    public static void main(String[] args) {
        //SpringApplication.run(SnsAwsApplication.class, args);
        AwsSmsService myClient = new AwsSmsService();
        myClient.send("Mebrok 3lik", "+212613488905");
    }
    @Override
    public void send(String phoneNumber, String message) {
        AmazonSNS snsClient = AmazonSNSClient.builder().withRegion(Regions.EU_WEST_3).build();
        Map<String, MessageAttributeValue> messageAttributes = new HashMap<>();
        messageAttributes.put("AWS.SNS.SMS.SenderID",
                new MessageAttributeValue().withStringValue("senderId").withDataType("String"));
        messageAttributes.put("AWS.SNS.SMS.SMSType",
                new MessageAttributeValue().withStringValue("Transactional").withDataType("String"));

        PublishResult result = snsClient.publish(new PublishRequest()
                .withMessage(message)
                .withPhoneNumber(phoneNumber)
                .withMessageAttributes(messageAttributes));
        System.out.println("Message sent seccessfully--" + result.getMessageId());
    }
}
