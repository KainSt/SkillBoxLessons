import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileXLSReader {
    public static void main(String[] args) {
        File file = new File("Data\\movementList.csv");
        System.out.println(file.getPath());
        StringBuilder bilder = new StringBuilder();
        List<String> accountList = null;
        List<AccountOperation> bankList = new ArrayList<>();
        try {
            accountList = Files.readAllLines(Paths.get(file.getPath()));
            accountList.forEach(line -> bilder.append(line + "\n"));

            for (String operation: accountList) {
                String[] fragments = operation.split(",");


                for (int i = 0; i< fragments.length; i++){
                    if (IsColumnPart(fragments[i])){
                        fragments[i-1]+=("."+fragments[i]);
                        fragments[i-1]=fragments[i-1].substring(1,fragments[i-1].length()-1);

                    }
                }

               /* if(fragments.length != 8) {
                    for (String s: fragments) {
                        System.out.println(IsColumnPart(s) + "  " + s);
                    }

                    continue;
                }*/
                bankList.add(new AccountOperation(fragments[0],
                                  fragments[1],
                                  fragments[2],
                                  fragments[3],
                                  fragments[4],
                                  fragments[5],
                                  fragments[6],
                                  fragments[7]));

            }
            bankList.remove(0);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        System.out.println("Парсинг окончен");
        double sumPlus =0;
        double sumMinus =0;
        for (AccountOperation aO: bankList) {
            sumPlus+=Double.parseDouble(aO.changeAccountPlus);
            sumMinus+=Double.parseDouble(aO.changeAccountMinus);

        }
        System.out.println("Сумма расходов: " +sumMinus);
        System.out.println("Сумма доходов: " +sumPlus);

    }

    private static boolean IsColumnPart(String text) {
        String trimText = text.trim();
        //Если в тексте одна ковычка и текст на нее заканчивается значит это часть предыдущей колонки
        return trimText.indexOf("\"") == trimText.lastIndexOf("\"") && trimText.endsWith("\"");
    }

    public static class AccountOperation{

        String typeAccount; //Тип счёта
        String idAccount; // Номер счета
        String currencyAccount; // Валюта
        String dateOperation; //Дата операции
        String hashOperation; //Референс проводки
        String descriptionOperation; //Описание операции
        String changeAccountPlus; //Приход
        String changeAccountMinus; //Расход

        public AccountOperation(String typeAccount, String idAccount, String currencyAccount, String dateOperation,
                                String hashOperation, String descriptionOperation, String changeAccountPlus, String changeAccountMinus) {
            this.typeAccount = typeAccount;
            this.idAccount = idAccount;
            this.currencyAccount = currencyAccount;
            this.dateOperation = dateOperation;
            this.descriptionOperation = descriptionOperation;
            this.hashOperation = hashOperation;
            this.changeAccountPlus = changeAccountPlus;
            this.changeAccountMinus = changeAccountMinus;
        }


    }

}
