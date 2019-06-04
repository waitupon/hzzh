package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CQQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=CQ&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        CQQichachaCrawler chinaZCrawler = new CQQichachaCrawler();
        int city = 500101;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/CQ.txt");
        List<Integer>except = new ArrayList<>();
        except.add(500232);
        except.add(500234);
        except.add(500239);
        for(int c = city;c<=500120; c++){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }


        city = 500151;

        for(int c = city;c<=500156; c++){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }

        city = 500229;

        for(int c = city;c<=500243; c++){
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
