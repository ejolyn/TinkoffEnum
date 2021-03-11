import country.Country;
import country.NoSuchCountryException;

import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
        System.out.println("Для выхода из программы введите 'exit'");
        System.out.println("Ввод английских и русских названий осуществляется в следующем формате:");
        Country[] country = Country.values();
        for (Country value : country) {
            System.out.println(value.toString());
        }
        while (true) {
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();
            str = str.trim();
            if (str.equals("exit")) {
                break;
            }
            if (!checkEnglishName(str)) {
                try {
                    Country res = Country.getByRuName(str);
                    if (res.getIsOpen()) {
                        System.out.println("Страна [" + res.toString() + "] открыта для посещения");
                    } else {
                        System.out.println("Страна [" + res.toString() + "] закрыта для посещения");
                    }
                } catch (NoSuchCountryException noSuchCountryException) {
                    System.out.println("Попробуйте еще раз:");
                }
            }
        }
    }

    public static boolean checkEnglishName(final String str) {
        try {
            Country res = Country.valueOf(str);
            if (res.getIsOpen()) {
                System.out.println("Страна [" + res.toString() + "] открыта для посещения");
            } else {
                System.out.println("Страна [" + res.toString() + "] закрыта для посещения");
            }
            return (true);
        } catch (IllegalArgumentException e) {
            System.out.println("Название страны на английском не найдено, ищется на русском...");
        } catch (NullPointerException e) {
            System.out.println("Это что, null?");
        }
        return (false);
    }
}

