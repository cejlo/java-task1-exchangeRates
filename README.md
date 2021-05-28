# :balance_scale: Java Task / Exchange Rates

Task for recruitment process. Delivered in two versions:
- Console application
- JavaFX application


### :desktop_computer:	 Console application

To use with console go to **\output\ConverterConsole** folder and run:
```bash
java -jar ConverterConsole.jar [currency] [amount]
```
```bash
java -jar ConverterConsole.jar PLN 2.50 
    // result: 11.24
```

### :repeat: JavaFX application

To run application go to **\output\ConverterJavaFXApp** folder and:

- double-click on ConverterJavaFXApp.exe

![Screen GUI](/screens/ExchangeRateConverter2.jpg)


### :heavy_check_mark: Test

To run tests open project in Eclipse and run **AllTests** with JUnit configuration and linked JUnit 5 library.
![Screen JUnit](/screens/jUnit.jpg)


### :bookmark_tabs: About task

The task is to create simple exchange rates calculator in Java.

- The source for exchange rates is a file that is compatible with http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml
- The file has to be read from the current project folder
- There should be written file parser with exchange rates and a class with converter / calculator
- Libraries for parsing XML can be used
- the calculator should accept the amount in EUR and the target currency, and return the amount in the target currency
