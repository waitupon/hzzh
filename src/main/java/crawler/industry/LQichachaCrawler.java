package crawler.industry;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LQichachaCrawler extends AbstractIndustryCrawler
{

    @Override
    public String getUrl() {
        return "https://www.qichacha.com/gongsi_industry.shtml?industryCode=L&subIndustryCode=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        LQichachaCrawler chinaZCrawler = new LQichachaCrawler();
        int industry = 71;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/industry/L.txt");
        List<Integer>except = new ArrayList<>();
        for(int c = industry;c<=72; c++){
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
