# Official International Name days API library
[![Github issues](https://img.shields.io/github/issues/Degubi/nameday-api?label=Issues&style=plastic&logo=github)](https://github.com/Degubi/nameday-api/issues)
[![Linecount](https://img.shields.io/tokei/lines/github/degubi/nameday-api?label=Total%20Lines&logo=Github&style=plastic)](https://github.com/Degubi/nameday-api/tree/master/src/main/java)
[![Dependencies](https://img.shields.io/badge/Dependencies-1-green?style=plastic&logo=Java)](https://github.com/Degubi/nameday-api/blob/master/package.json)

## Name day API library for [nameday.abalin.net](https://nameday.abalin.net)

This library makes it easy to send requests towards [nameday.abalin.net](https://nameday.abalin.net) API.  
For examples check the 'Usage' section.

## Installation

**Maven dependency:** (via Github Packages)

```xml
<repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/Degubi/nameday-api</url>
</repository>

<dependency>
    <groupId>degubi</groupId>
    <artifactId>nameday-api</artifactId>
    <version>1.3.0</version>
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
