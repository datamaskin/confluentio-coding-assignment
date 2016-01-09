## Confluent Coding Assignment

*Following the coding assignment doco the **Written Assignment** follows.*

###Ruminations

   Understandably the real solution was some combination of serialization/character set encoding/decoding.  
   Unfortunately I was not able to come up with such a scheme in the allotted time frame.  
   The upside I did get a refresher on Java Serialization (not used here) and the opportunity to dig into  
   byte arrays and the Byte class much more than I ever would have without this challenge.  
   Notwithstanding, I do have a viable solution per the instructions albeit not the preferred solution.  

####Per the Instructions

1. I am supplying code without excessive commenting or commented out code
2. Possibly a hint to the correct solution but again the returned byte array from the method: `removeZeros()` simply  
   removes all zeros notwithstanding and returns the modified `byte` array.
3. All code is POJO type code with the exception of: `import junit.framework.TestCase`
4. Included are 2 `TestCase` classes: `EncoderTest` and `ByteArrayUtilTest`

#####Notes
* The Confluent Coding Assignment project was created and executed entirely within the Intellij IDE.
* The program was executed within the *Configurations* **Run** menu.
* Additionally, I used the Intellij terminal to issue the following sequence of command lines to invoke 2 separate  
  processes:
    * `$ java -cp out/production/confluentio/:. name.davidwbrown.ProcessZero remove`
    * with the result:  
    ` :i`  
    `203a691008`  
    * `$ java -cp out/production/confluentio/:. name.davidwbrown.ProcessZero revert`
    * with the result:  
    `203a69100008`  
    * Please note the Java commandline arg: `-cp` will need to be adjusted locally.
* The program project has been pushed to [github](https://github.com/pimpedoutgeek?tab=repositories "David Brown's github")

## Confluent Written Assignment

* Assumptions:
    * The integrated JMS and flat file (assume .csv) have been forged into JSON callable via REST. If not then the  
      [JPhantIO](https://github.com/pimpedoutgeek/JPhant_Java_Based_Phant_Library) library should be able to accommodate
      the target data formats.
    * The data can be tabulated.
    * Assume a calculation of the number of stock price requests to display based on the 80 percentile cutoff.
* Though Apache Kafka appears to be a very powerful and full-featured pub-sub service a conclusion I came to after  
  installing and starting:
    * `Zookeeper`
    * `Kafka-server`
    * `Schema-registry`  
  adding to the `schema-registry` and executing various `curl` commands I decided to use a framework I have patched  
  together from a previous github fork for a similar coding assignment namely: the [JPhantIO](https://github.com/pimpedoutgeek/JPhant_Java_Based_Phant_Library) library forked and  
  developed on github.
* Here are some of the reasons why I chose to use a Java based phant.io framework:
    * JPhantIO can be configured to the data input and output.
    * Easily use a client side Javascript function callback to chart the data using Google Charts as does phant.io
    * Add Data using Get or Post Methods (Configurable.)
    * Get Data in efficient Format: String[][] aaExample = { {"Field1", "Field2"}, {"Value1", "Value2"}... }
    * (Or Get Data in Raw Formats - Csv, Json, Jsonp.)
    * Clear all Data
    * Get Status in efficient Format (a Stats class encapsulating Cap, PageCount, Remaining, and Used.)  
      (Or Get Status in Raw Formats - Csv, Json, Jsonp.)
    * Get Rate Limits (Limit, Remaining, Reset - only valid after addData().)
    * Convert to/from supported Data Structures (String[][] and ArrayList<ArrayList<String>>.)
    * Smart CSV Extraction (handles embedded Quotes, Commas, Carriage Returns, and Line Feeds.)
    * Automatic Retries on HTTPConnection Errors (up to 5 retries.)
    * Can optionally use a ProxyHost and Port (if you're behind a company Firewall/Proxy Server.)
    
  Much more detail of the [JPhantIO](https://github.com/pimpedoutgeek/JPhant_Java_Based_Phant_Library) library is available in the github Readme.md  
  
  The moving stock price algorithm say simple moving average can be easily changed to exponential moving average by  
  supplying the correct class file of getters/setters and a REST controller with appropriate methods to supply the  
  target algorithm such as in my project implementing JPhantIO: [spring-boot-currency-fair-test](https://github.com/pimpedoutgeek/spring-boot-currencyfair-test) in the 2 class files:  
  `MarketTrader` and `MarketTraderController`.