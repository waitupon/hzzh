package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JXQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=JX&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        JXQichachaCrawler chinaZCrawler = new JXQichachaCrawler();
        int city = 360100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/JX.txt");
        List<Integer>except = new ArrayList<>();
        for(int c = city;c<=361100; c+=100){
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
