package country;

public enum Country {
    RUSSIA("Россия", true),
    USA("CША", true),
    FRANCE("Франция", false),
    GERMANY("Германия", false),
    CHINA("Китай", true),
    SOMALIA("Сомали", false);

    private final String ruName;
    private final boolean isOpen;

    Country(final String ruName, final boolean isOpen) {
        this.ruName = ruName;
        this.isOpen = isOpen;
    }

    public boolean getIsOpen() {
        return (this.isOpen);
    }

    @Override
    public String toString() {
        return (Country.super.toString() + " (" + this.ruName + ")");
    }

    public static Country getByRuName(final String ruName) throws NoSuchCountryException {
        Country[] arr = Country.values();
        for (Country country : arr) {
            if (ruName.equals(country.ruName)) {
                return country;
            }
        }
        throw new NoSuchCountryException(ruName);
    }
}
