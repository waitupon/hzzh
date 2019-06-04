package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YNQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=YN&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        YNQichachaCrawler chinaZCrawler = new YNQichachaCrawler();
        int city = 530100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/YN.txt");
        List<Integer>except = new ArrayList<>();
        except.add(530200);
        except.add(532400);
        except.add(532700);
        except.add(533000);
        except.add(533200);
        for(int c = city;c<=530900; c+=100){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }

        city = 532300;

        for(int c = city;c<=533400; c+=100){
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
