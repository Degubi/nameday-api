# Official International Name days API library

## Name day API library for [api.abalin.net](https://api.abalin.net)

This library makes it easy to send requests towards [api.abalin.net](https://api.abalin.net) API.  
For examples check the 'Usage' section.

## Installation

**Maven dependency:** (via Github Packages)

```xml
<dependency>
  <groupId>degubi</groupId>
  <artifactId>nameday-api</artifactId>
  <version>1.0</version>
</dependency>
```

**Jar file:**
<br><br>
Jar file downloads are available under 'Packages'

## List of supported Countries & TimeZones

For supported countries there's an enum called 'Country'.  
For supported timezones there's an enum called 'TimeZone'.  
For temporals (Today, Tomorrow, Yesterday) there's an enum called 'Temporal'.  
For custom dates there's an overload that takes a month and a day.

## Usage

Most of the functions are overloaded for Temporal/Country/TimeZone. They all return CompletableFutures.  
The data is grouped depending on the type of the request.

```java
// List of names grouped by Country for today
NamedayApi.getNamedays(Temporal.TODAY);

// List of names for tomorrow in the USA
NamedayApi.getNamedays(Temporal.TOMORROW, Country.USA);

// List of names grouped by Country for yesterday with Europe/Prague time zone specification 
NamedayApi.getNamedays(Temporal.YESTERDAY, TimeZone.EUROPE_PRAGUE);

// List of names for today in Hungary with Europe/Amsterdam time zone specification
NamedayApi.getNamedays(Temporal.TODAY, Country.HUNGARY, TimeZone.EUROPE_AMSTERDAM)

// List of names on the 1st of April in Denmark
NamedayApi.getNamedays(Month.APRIL, 1, Country.DENMARK);

// List of days grouped by Month for the name 'John' in Spain
NamedayApi.searchForName("John", Country.SPAIN);
```

## Contributing

Feedback, bug reports and enhancements are always welcome.