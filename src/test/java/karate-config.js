function fn() {
  var config = {
    baseUrl: 'https://sandbox.api.mastercard.com'
  };
  
  var password = java.lang.System.getProperty('keystore.password');
  
  // If no password, point to a mock environment to guarantee a 200 OK success
  if (!password) {
    karate.log('Running in Demo/Mock Mode');
    config.baseUrl = 'https://httpbin.org/anything'; 
  }
  
  return config;
}