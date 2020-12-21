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
Downloads are available under 'Releases'

## List of supported Countries & TimeZones

For supported countries there's an enum called 'Country'.  
For supported timezones there's an enum called 'TimeZone'.  
For temporals (Today, Tomorrow, Yesterday) there's an enum called 'Temporal'.  
For custom dates there's an overload that takes a month and a day.

## Usage

Most of the functions are overloaded for Temporal/Country/TimeZone. They all return CompletableFutures.  
The data is grouped depending on the type of the request.

```java
// List of names for today grouped by Country
NamedayApi.getNamedays(Temporal.TODAY);

// List of names for tomorrow in the USA
NamedayApi.getNamedays(Temporal.TOMORROW, Country.USA);

// List of names in the Europe/Prague zone grouped by Country
NamedayApi.getNamedays(Temporal.YESTERDAY, TimeZone.EUROPE_PRAGUE);

// List of names on the 1st of Aprin in Denmark
NamedayApi.getNamedays(Month.APRIL, 1, Country.DENMARK);

// List of days grouped by Month
NamedayApi.searchForName("John", Country.SPAIN);
```

## Contributing

Feedback, bug reports and enhancements are always welcome.