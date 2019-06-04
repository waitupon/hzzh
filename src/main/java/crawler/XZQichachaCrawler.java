package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XZQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=XZ&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        XZQichachaCrawler chinaZCrawler = new XZQichachaCrawler();
        int city = 540100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/XZ.txt");
        List<Integer>except = new ArrayList<>();
        for(int c = city;c<=540600; c+=100){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }

        for(int i=1; i<=totalPage;i++){
            chinaZCrawler.launch(i,542500,fis);
        }
        fis.close();


    }
}
