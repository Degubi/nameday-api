module nameday.api {
    requires transitive java.net.http;
    requires transitive jakarta.json;
    requires transitive jakarta.json.bind;
    
    exports namedayapi;
}