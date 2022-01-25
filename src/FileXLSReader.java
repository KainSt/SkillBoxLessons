import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

public class FileXLSReader {
    public static void main(String[] args){
        File file = new File("C:\\Users\\KS\\IdeaProjects\\SkillBoxLessons\\Data\\movementList.csv");
        System.out.println(file.getPath());
        StringBuilder bilder = new StringBuilder();
        try{
            List<String> accountList = Files.readAllLines(Paths.get(file.getPath()));
            accountList.forEach(line -> bilder.append(line+"\n"));
        }
        catch (IOException ex){
            System.out.println(ex.toString());
        }
        System.out.println();
    }


    public class AccountOperation{
        String typeAccount;
        long idAccount;
        String currencyAccount;
        Date  dateOperation;
        String hashOperation;
        double changeAccount;

        public String getTypeAccount() {
            return typeAccount;
        }

        public long getIdAccount() {
            return idAccount;
        }

        public String getCurrencyAccount() {
            return currencyAccount;
        }

        public Date getDateOperation() {
            return dateOperation;
        }

        public String getHashOperation() {
            return hashOperation;
        }

        public double getChangeAccount() {
            return changeAccount;
        }

        public void setTypeAccount(String typeAccount) {
            this.typeAccount = typeAccount;
        }

        public void setIdAccount(long idAccount) {
            this.idAccount = idAccount;
        }

        public void setCurrencyAccount(String currencyAccount) {
            this.currencyAccount = currencyAccount;
        }

        public void setDateOperation(Date dateOperation) {
            this.dateOperation = dateOperation;
        }

        public void setHashOperation(String hashOperation) {
            this.hashOperation = hashOperation;
        }

        public void setChangeAccount(double changeAccount) {
            this.changeAccount = changeAccount;
        }
    }

}
