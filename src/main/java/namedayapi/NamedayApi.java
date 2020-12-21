package namedayapi;

import jakarta.json.*;
import jakarta.json.bind.*;
import java.net.*;
import java.net.http.*;
import java.net.http.HttpResponse.*;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;

/**
 * Small wrapper library for https://api.abalin.net
 * @author Degubi
 */
public final class NamedayApi {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Jsonb JSONB = JsonbBuilder.create();
    private static final String API_URL = "https://api.abalin.net";
    private static final Pattern NAME_SEPARATOR_PATTERN = Pattern.compile(" |, ");

    /**
     * Function for fetching namedays for a CommonDate.
     * @return List of names grouped by country
     */
    public static CompletableFuture<Map<Country, List<String>>> getNamedays(Temporal date) {
        return sendRequest(API_URL + date.endPoint).thenApply(NamedayApi::groupByCountry);
    }

    /**
     * Function for fetching namedays filtered by the specified country.
     * @param country Country
     * @return List of names
     */
    public static CompletableFuture<List<String>> getNamedays(Temporal date, Country country) {
        return sendRequest(API_URL + date.endPoint + "?country=" + country.code).thenApply(k -> splitNames(k, country));
    }

    /**
     * Function for fetching namedays filtered by the specified timeZone.
     * @param timeZone TimeZone
     * @return List of names grouped by country
     */
    public static CompletableFuture<Map<Country, List<String>>> getNamedays(Temporal date, TimeZone timeZone) {
        return sendRequest(API_URL + date.endPoint + "?timezone=" + timeZone.value).thenApply(NamedayApi::groupByCountry);
    }

    /**
     * Function for fetching namedays filtered by the specified country.
     * @param country Country
     * @return List of names
     * If the endpoint gets removed delete this function, else remove deprecation.
     */
    public static CompletableFuture<List<String>> getNamedays(Temporal date, Country country, TimeZone timeZone) {
        return sendRequest(API_URL + date.endPoint + "?country=" + country.code + "&timezone=" + timeZone.value).thenApply(k -> splitNames(k, country));
    }

    /**
     * Function for fetching namedays for specific dates filtered by the specified country.
     * This function doesn't use a Date object, because the Api doesn't support all variations of requests.
     * @param month Month
     * @param day Day
     * @param country Country
     * @return List of names for the given date & country
     */
    public static CompletableFuture<List<String>> getNamedays(Month month, int day, Country country) {
        return sendRequest(API_URL + "/namedays?country=" + country.code + "&month=" + month.getValue() + "&day=" + day).thenApply(k -> splitNames(k, country));
    }

    /**
     * Function for searching names inside the specified country.
     * @param searchedName Searched Name
     * @param country Country
     * @return List of days for the given name & country, grouped by month
     */
    public static CompletableFuture<Map<Month, List<Integer>>> searchForName(String searchedName, Country country) {
        return sendRequest(API_URL + "/getdate?name=" + searchedName + "&country=" + country.code).thenApply(NamedayApi::groupByDate);
    }



    private static List<String> splitNames(JsonObject obj, Country country) {
        return Arrays.asList(NAME_SEPARATOR_PATTERN.split(obj.getJsonObject("data")
                                                             .getJsonObject("namedays")
                                                             .getString(country.code)));
    }

    @SuppressWarnings("boxing")
    private static Map<Month, List<Integer>> groupByDate(JsonObject obj) {
        return obj.getJsonArray("results").stream()
                  .map(JsonValue::asJsonObject)
                  .collect(Collectors.groupingBy(k -> Month.of(k.getInt("month")), Collectors.mapping(k -> k.getInt("day"), Collectors.toList())));
    }

    private static Map<Country, List<String>> groupByCountry(JsonObject obj) {
        var response = obj.getJsonObject("namedays").getJsonObject("data");

        return response.keySet().stream()
                       .collect(Collectors.toMap(Country::fromCode, l -> Arrays.asList(NAME_SEPARATOR_PATTERN.split(response.getString(l)))));
    }

    private static CompletableFuture<JsonObject> sendRequest(String url) {
        return CLIENT.sendAsync(HttpRequest.newBuilder(URI.create(url)).build(),
                           info -> BodySubscribers.mapping(BodySubscribers.ofByteArray(), data -> JSONB.fromJson(new String(data), JsonObject.class)))
                     .thenApply(HttpResponse::body);
    }

    private NamedayApi() {}
}