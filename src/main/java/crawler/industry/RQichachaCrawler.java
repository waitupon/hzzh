package crawler.industry;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RQichachaCrawler extends AbstractIndustryCrawler
{

    @Override
    public String getUrl() {
        return "https://www.qichacha.com/gongsi_industry.shtml?industryCode=R&subIndustryCode=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        RQichachaCrawler chinaZCrawler = new RQichachaCrawler();
        int industry = 86;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/industry/R.txt");
        List<Integer>except = new ArrayList<>();
        for(int c = industry;c<=90; c++){
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
