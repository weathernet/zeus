import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2018/11/1 0001
 */
public class Test {


    public static void main(String[] args) {
       String a = "account, article, atlas, banner, bill, chat, code, comment, correlation, discussion, eqitem, eqresult, eqtest, feedback, handbook, help, highlight, panels, policy, report, special, user, vip";
       List<String>  TableName= new ArrayList<>();
        String[] split = a.split(",");
        for (int i = 0; i < split.length; i++) {
            String sss='"'+split[i]+'"';
            TableName.add(sss);
        }
        System.out.println(TableName.toString());
    }
}
