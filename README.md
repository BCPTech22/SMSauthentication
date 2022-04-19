# SMS authentication

* To install the SMS Authenticator one has to:

1) Build and package the project: $ mvn clean package

2) Add the jar to the Keycloak deployment

3) Add login-sms.ftl templates to the Keycloak themes folder : \themes\base\login

4) Add the additional template messages to the Keycloak base template : \messages\messages_en.properties

# Configuration :

Configuration of the REALM to use the SMS Authentication:

1) create a new REALM (or select a previously created REALM).

2) Under Authentication > Flows:

  - Copy the 'Browser' flow to 'SMS Browser' flow
  - Click on 'Actions > Add execution' on the 'Browser with SMS Forms' line and add the 'SMS Authentication'
  - Set 'SMS Authentication' to 'REQUIRED' or 'ALTERNATIVE'
  - To configure the SMS Authenticator, click 'Actions > Config' and fill in the relevant attributes
3) Under Authentication > Bindings:

  - Select 'SMS Browser' as the 'Browser Flow' for the REALM.
