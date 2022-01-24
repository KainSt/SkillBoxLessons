import java.io.File;
import java.util.Date;

public class FileXLSReader {
    public static void main(String[] args){
        File file = new File("C:\\Users\\KS\\Documents\\JAVA Lessons\\[Skillbox] Java-разработчик (2020)\\09.Работа с файлами и сетью\\9.9 Домашняя работа 9.3\\movementList");
        System.out.println(file.getName());

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
