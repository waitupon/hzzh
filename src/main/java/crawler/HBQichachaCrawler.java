package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HBQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=HB&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        HBQichachaCrawler chinaZCrawler = new HBQichachaCrawler();
        int city = 130100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/HB.txt");
        List<Integer>except = new ArrayList<>();

        for(int c = city;c<=131100; c+=100){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }


        fis.close();


    }
}
