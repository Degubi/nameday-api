package namedayapi;

/**
 * Enum with suppored TimeZone constants
 * @author Degubi
 */
public enum TimeZone {

    AMERICA_DENCER("America/Denver"),
    AMERICA_COSTA_RICA("America/Costa_Rica"),
    AMERICA_LOS_ANGELES("America/Los_Angeles"),
    AMERICA_ST_VINCENT("America/St_Vincent"),
    AMERICA_TORONTO("America/Toronto"),
    EUROPE_AMSTERDAM("Europe/Amsterdam"),
    EUROPE_MONACO("Europe/Monaco"),
    EUROPE_PRAGUE("Europe/Prague"),
    EUROPE_ISLE_OF_MAN("Europe/Isle_of_Man"),
    AFRICA_CAIRO("Africa/Cairo"),
    AFRICA_JOHANNESBURG("Africa/Johannesburg"),
    AFRICA_NAIROBI("Africa/Nairobi"),
    ASIA_YAKUTSK("Asia/Yakutsk"),
    ASIA_HONG_KONG("Asia/Hong_Kong"),
    ASIA_TAIPEI("Asia/Taipei"),
    PACIFIC_MIDWAY("Pacific/Midway"),
    PACIFIC_HONOLULU("Pacific/Honolulu"),
    US_SAMOA("US/Samoa"),
    ZULU("Zulu"),
    US_HAWAII("US/Hawaii"),
    ISRAEL("Israel"),
    ETC_GMT_2("Etc/GMT-2"),
    ETC_GMT_6("Etc/GMT-6");

    final String value;

    TimeZone(String value) {
        this.value = value;
    }
}