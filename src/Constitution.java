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
            loadChapters(constitutionPath);
            loadArticles(constitutionPath);
        }



        public String readArticle (int[] article) throws Exception{
            if(article[0]>articles.size()){
                throw new Exception("No such article");
            }
            return articles.get(article[0]-1).read();
        }



        public String readArticles(int[] range) throws Exception{
            String articlesString ="";
            if(range[1]>articles.size() || range[0] < 0){
                throw new Exception("No such article range");
            }
            if(range[1] < range[0]){
                throw new Exception("Start article and be smaller than end article");
            }
            articlesString+=articles.get(range[0]-1).read();
            for(int i = range[0]; i <= range[1]-1;i++){
                articlesString+=("\n"+articles.get(i).read());
            }
            return articlesString;
        }

        public String readChapter (int[] chapter) throws Exception{
            if(chapter[0]>chapters.size()){
                throw new Exception("No such chapter");
            }
            return chapters.get(chapter[0]-1).read();
        }

        private boolean isArticle(String line){
            return Pattern.matches("^Art\\.\\s[0-9]{1,3}.$", line);
        }

        private boolean isSubChapter(String line){
            return Pattern.matches("^\\p{javaUpperCase}\\p{javaUpperCase}.+$", line);
        }

        private boolean isChapter (String line){
            return Pattern.matches("^Rozdział\\s[IVXLCDM]++$", line);
        }

        private boolean isKancelaria (String line){
            return Pattern.matches("^©Kancelaria\\sSejmu$", line);
        }

        private void createChapter(String chapterNumber, String firstSubChapter){
            Chapter chapter = new Chapter(chapterNumber);
            chapter.addContent(new SubChapter(firstSubChapter));
            chapters.add(chapter);
        }

        private void updateChapter(Article article, String subChapter, int chapter){
            article.removeHyphens();
            articles.add(article);
            chapters.get(chapter).addContent(article);
            if(!subChapter.equals("")) {
                chapters.get(chapter).addContent(new SubChapter(subChapter));
            }
        }

        private void loadChapters(String constitutionPath){
            //Loads all chapters
            try (BufferedReader br = new BufferedReader(new FileReader(constitutionPath))) {
                String line = br.readLine();
                while (line != null) {
                    //Check if is Chapter
                    if (isChapter(line)) {
                        createChapter(line, line = br.readLine());
                    } else {
                        line = br.readLine();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        private void loadArticles(String constitutionPath){
            try (BufferedReader br = new BufferedReader(new FileReader(constitutionPath))) {
                String line = br.readLine();
                int chapter = -1;
                while (line != null) {
                    if (isChapter(line)) {
                        chapter++;
                    }

                    //Check if is Article and add it to corresponding chapter and to article list
                    if (isArticle(line)) {
                        String subChapter =""; //keeps subChapter text
                        Article article = new Article(line); // creates newArticle
                        line = br.readLine();

                        while (line != null && !isArticle(line) && !isChapter(line)) {
                            //Skips two lines if Kancelaria appears
                            if(isKancelaria(line)){
                                line = br.readLine();
                                line = br.readLine();
                            }

                            //Saves SubChapterText
                            else if (isSubChapter(line)) {
                                subChapter = line;
                                line = br.readLine();
                            }

                            //adds newline to Article
                            else {
                                article.addLine(line);
                                line = br.readLine();
                            }
                        }
                        updateChapter(article,subChapter,chapter);
                    } else {
                        line = br.readLine();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

