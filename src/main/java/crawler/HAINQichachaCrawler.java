package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HAINQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=HAIN&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        HAINQichachaCrawler chinaZCrawler = new HAINQichachaCrawler();
        int city = 460100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/HAIN.txt");
        List<Integer>except = new ArrayList<>();
        except.add(522400);
        except.add(522500);
        for(int c = city;c<=460400; c+=100){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }


            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,469000,fis);
            }

        fis.close();


    }
}
