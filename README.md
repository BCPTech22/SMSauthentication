# SMSauthentication

* To install the SMS Authenticator one has to:

1) Build and package the project:

$ mvn clean package

2) Add the jar to the Keycloak deployment

Add login-sms.ftl templates to the Keycloak themes folder : \themes\base\login

3) Add the additional template messages to the Keycloak base template : \messages\messages_en.properties
