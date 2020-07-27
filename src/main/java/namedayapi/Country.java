package namedayapi;

/**
 * Enum with supported Countries
 * @author Degubi
 */
public enum Country {
    
    BULGARIA("bg"),
    CROATIA("hr"),
    CZECHIA("cz"),
    DENMARK("dk"),
    ESTONIA("ee"),
    FINLAND("fi"),
    FRANCE("fr"),
    GERMANY("de"),
    GREECE("gr"),
    HUNGARY("hu"),
    ITALY("it"),
    LATVIA("lv"),
    LITHUANIA("lt"),
    POLAND("pl"),
    RUSSIAN_FEDERATION("ru"),
    SLOVAKIA("sk"),
    SPAIN("es"),
    SWEDEN("se"),
    USA("us");
    
    private static final Country[] VALUES = values();
    
    final String code;
    
    Country(String code) {
        this.code = code;
    }
    
    static Country fromCode(String code) {
        for(var country : VALUES) {
            if(country.code.equals(code)) {
                return country;
            }
        }
        
        throw new IllegalArgumentException("Unkown country code: '" + code + "'");
    }
}