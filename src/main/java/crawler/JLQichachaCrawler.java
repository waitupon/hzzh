package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JLQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=JL&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        JLQichachaCrawler chinaZCrawler = new JLQichachaCrawler();
        int city = 220100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/JL.txt");
        List<Integer>except = new ArrayList<>();
        for(int c = city;c<=220800; c+=100){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }
        for(int i=1; i<=totalPage;i++){
            chinaZCrawler.launch(i,222400,fis);
        }


        fis.close();


    }
}
