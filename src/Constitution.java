import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Jan on 01.12.2016.
 */
public class Constitution {
        private List<Article> articles = new LinkedList<>();
        private List<Chapter> chapters = new LinkedList<>();

        public Constitution(String constitutionPath) {
            //Loads all chapters
            try (BufferedReader br = new BufferedReader(new FileReader(constitutionPath))) {
                String line = br.readLine();
                while (line != null) {
                    //Check if is Article
                    if (Pattern.matches("^Rozdział\\s[IVXLCDM]++$", line)) {
                        Chapter chapter = new Chapter(line);
                        line = br.readLine();
                        while (line != null && !Pattern.matches("^Art\\.\\s[0-9]{1,3}\\.$", line) && !Pattern.matches("^Rozdział\\s[IVXLCDM]++$", line)) {
                            chapter.addLine(line);
                            line = br.readLine();
                        }
                        chapters.add(chapter);
                    } else {
                        line = br.readLine();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Loads all articles
            try (BufferedReader br = new BufferedReader(new FileReader(constitutionPath))) {
                String line = br.readLine();
                int chapter = -1;
                while (line != null) {
                    if (Pattern.matches("^Rozdział\\s[IVXLCDM]++$", line)) {
                        chapter++;
                    }
                    //Check if is Article and add it to corresponding chapter and to article list
                    if (Pattern.matches("^Art\\.\\s[0-9]{1,3}\\.$", line)) {
                        Article article = new Article(line);
                        line = br.readLine();
                        while (line != null && !Pattern.matches("^Art\\.\\s[0-9]{1,3}\\.$", line) && !Pattern.matches("^©Kancelaria\\sSejmu$", line) && !Pattern.matches("^Rozdział\\s[IVXLCDM]++$", line)) {
                            article.addLine(line);
                            line = br.readLine();
                        }
                        article.removeHyphens();
                        articles.add(article);
                        chapters.get(chapter).addArticle(article);
                    } else {
                        line = br.readLine();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void readArticle (int article) throws Exception{
            if(article>articles.size()){
                throw new Exception("No such article");
            }
            articles.get(article-1).read();
        }

        public void readArticles(int startArticle, int endArticle) throws Exception{
            if(endArticle>articles.size() || startArticle < 0){
                throw new Exception("No such article range");
            }
            if(endArticle > startArticle){
                throw new Exception("Start article and be smaller than end article");
            }
            for(int i = startArticle-1; i <= endArticle-1;i++){
                articles.get(i).read();
            }
        }

        public void readChapter (int chapter) throws Exception{
            if(chapter>chapters.size()){
                throw new Exception("No such chapter");
            }
            chapters.get(chapter-1).read();
        }


    }

