package bcp.keycloak.authenticator.gateway;


import org.jboss.logging.Logger;

import java.util.Map;
public class SmsServiceFactory {

    private static final Logger LOG = Logger.getLogger(SmsServiceFactory.class);

    public static SmsService get(Map<String, String> config) {
		if (Boolean.parseBoolean(config.getOrDefault("simulation", "false"))) {
			return (phoneNumber, message) ->
				LOG.warn(String.format("***** SIMULATION MODE ***** Would send SMS to %s with text: %s", phoneNumber, message));
		} else {
        AwsSmsService myClient = new AwsSmsService();
        myClient.send("+212613488905","New Message");
        return (myClient) ;}


    }

}
