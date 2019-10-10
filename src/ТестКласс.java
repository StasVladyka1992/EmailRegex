import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.UNICODE_CASE;

/**
 * @project untitled1
 * author Stas Vladyka on 10.10.2019.
 */
public class ТестКласс {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(
                //Общая логика:
                //1) Общий сценарий - поиск хотя бы одной буквы
                //          1.не сработает с доменами без точек
                //          2.не сработает с доменами с одной буквой
//
                //2) Сценарий для только единственного первого домена
                //3) Сценарий для доменов с одной буквой
                //4) Сценарий для 3 букв-цифр


                //1 группа - ищет буквы и цифры по жадному сценарию, доходит до конца и идет в обратку, пытаясь найти хотя бы одну букву, сценарий - жадный
                //2 группа - ищет все буквы и цифры по сверхжадному сценарию, захватывая все символы сразу. После этого пытается найти символ буквы (сделан)
//
//                "((^[\\p{Alpha}0-9]+[\\p{Alpha}]+)\\.)+|((^[\\p{Alpha}0-9]+\\.[\\p{Alpha}]+)\\.)" +
                        "((((^[\\p{Alpha}0-9]+[\\p{Alpha}]+)\\.)+|((^[\\p{Alpha}0-9]+\\.[\\p{Alpha}]+)\\.)+|((^[\\p{Alpha}]+)\\.))([\\p{Alpha}0-9]+)$)|" +   //сценарий 1
                        "(^[\\p{Alpha}0-9]+[\\p{Alpha}]+$)|" + //2 сценарий
                        "(^[\\p{Alpha}]+$)" //сценарий 3

//        "((^[\\p{Alpha}0-9]+[\\p{Alpha}]+)\\.)+|((^[\\p{Alpha}0-9]+\\.[\\p{Alpha}]+)\\.)+"
//                        +
//                        "^([\\p{Alpha}0-9]*?[\\p{Alpha}]+?[\\p{Alpha}0-9]++\\.)+([\\p{Alpha}0-9]++)$"
                , Pattern.UNICODE_CHARACTER_CLASS);

        String[] ar = {

                "sfafas.afafg12ad",
                "ыф214ф12фаю.сщь",
                "fasfrwq2121.asfasf.2121",
                "fasfrwq2121.asfasf.21afa.asfa112",
                "fasfasfq",
                "asfas12ada",
                "gmail.ru",
                "1g1.ru",
                "1g.ru",
                "f.ru",
                "g.ru",
                "g.r",
                "s",

                //не валид
                "\'.ru",
                //не валид
                "@g.r",
                //не валид
                "g1@.r",
                //не валид
                "122313",
                //не валид
                "@fа.ru",
                //не валид
                "@f.r",
                //не валид
                "1212314.afasfa",
                //не валид
                "sasfaf.",
                //не валид
                "1.ru",
                //не валид
                "g.r@",


        };


        for (String s : ar) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                System.out.println("Group: " + matcher.group() + " Domain: " + s);
            }
        }


    }
}
