function fn() {
  var config = {
    baseUrl: 'https://sandbox.api.mastercard.com'
  };

  // SSL configuration for mTLS
karate.configure('ssl', {
    keyStore: 'classpath:certs/mastercard.p12',
    keyStorePassword: karate.properties['keystore.password'] || 'Rapid-Testing-Karate-Secure',
    keyStoreType: 'pkcs12'
  });

  return config;
}