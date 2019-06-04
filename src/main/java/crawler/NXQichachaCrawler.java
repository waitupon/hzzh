package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NXQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=NX&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        NXQichachaCrawler chinaZCrawler = new NXQichachaCrawler();
        int city = 640100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/NX.txt");
        List<Integer>except = new ArrayList<>();
        for(int c = city;c<=640500; c+=100){
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
