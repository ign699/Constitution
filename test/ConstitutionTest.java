import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jan on 10.12.2016.
 */
public class ConstitutionTest {

    private Constitution constitution = null;
    @Test
    public void readArticle() throws Exception {
        constitution = new Constitution("C:\\Users\\Jan\\IdeaProjects\\Constitution\\src\\konstytucja.txt");
        assertEquals("Art. 15.\n" +
                "1. Ustrój terytorialny Rzeczypospolitej Polskiej zapewnia decentralizację władzy\n" +
                "publicznej.\n" +
                "2. Zasadniczy podział terytorialny państwa uwzględniający więzi społeczne,\n" +
                "gospodarcze lub kulturowe i zapewniający jednostkom terytorialnym zdolność\n" +
                "wykonywania zadań publicznych określa ustawa.", constitution.readArticle(new int[]{15}));
    }

    @Test
    public void readArticles() throws Exception {
        assertEquals("Art. 15.\n" +
                "1. Ustrój terytorialny Rzeczypospolitej Polskiej zapewnia decentralizację władzy\n" +
                "publicznej.\n" +
                "2. Zasadniczy podział terytorialny państwa uwzględniający więzi społeczne,\n" +
                "gospodarcze lub kulturowe i zapewniający jednostkom terytorialnym zdolność\n" +
                "wykonywania zadań publicznych określa ustawa.\n" +
                "Art. 16.\n" +
                "1. Ogół mieszkańców jednostek zasadniczego podziału terytorialnego stanowi z\n" +
                "mocy prawa wspólnotę samorządową.\n" +
                "2. Samorząd terytorialny uczestniczy w sprawowaniu władzy publicznej.\n" +
                "Przysługującą mu w ramach ustaw istotną część zadań publicznych samorząd wykonuje\n" +
                "w imieniu własnym i na własną odpowiedzialność.", constitution.readArticles(new int[] {15,16}));
    }

    @Test
    public void readChapter() throws Exception {
        assertEquals("Rozdział I\n" +
                "RZECZPOSPOLITA\n" +
                "Art. 1.\n" +
                "Rzeczpospolita Polska jest dobrem wspólnym wszystkich obywateli.\n" +
                "Art. 2.\n" +
                "Rzeczpospolita Polska jest demokratycznym państwem prawnym,\n" +
                "urzeczywistniającym zasady sprawiedliwości społecznej.\n" +
                "Art. 3.\n" +
                "Rzeczpospolita Polska jest państwem jednolitym.\n" +
                "Art. 4.\n" +
                "1. Władza zwierzchnia w Rzeczypospolitej Polskiej należy do Narodu.\n" +
                "2. Naród sprawuje władzę przez swoich przedstawicieli lub bezpośrednio.\n" +
                "Art. 5.\n" +
                "Rzeczpospolita Polska strzeże niepodległości i nienaruszalności swojego terytorium,\n" +
                "zapewnia wolności i prawa człowieka i obywatela oraz bezpieczeństwo obywateli,\n" +
                "strzeże dziedzictwa narodowego oraz zapewnia ochronę środowiska, kierując się\n" +
                "zasadą zrównoważonego rozwoju.\n" +
                "Art. 6.\n" +
                "1. Rzeczpospolita Polska stwarza warunki upowszechniania i równego dostępu do\n" +
                "dóbr kultury, będącej źródłem tożsamości narodu polskiego, jego trwania i\n" +
                "rozwoju.\n" +
                "2. Rzeczpospolita Polska udziela pomocy Polakom zamieszkałym za granicą w\n" +
                "zachowaniu ich związków z narodowym dziedzictwem kulturalnym.\n" +
                "Art. 7.\n" +
                "Organy władzy publicznej działają na podstawie i w granicach prawa.\n" +
                "Art. 8.\n" +
                "1. Konstytucja jest najwyższym prawem Rzeczypospolitej Polskiej.\n" +
                "2. Przepisy Konstytucji stosuje się bezpośrednio, chyba że Konstytucja stanowi\n" +
                "inaczej.\n" +
                "Art. 9.\n" +
                "Rzeczpospolita Polska przestrzega wiążącego ją prawa międzynarodowego.\n" +
                "Art. 10.\n" +
                "1. Ustrój Rzeczypospolitej Polskiej opiera się na podziale i równowadze\n" +
                "władzy ustawodawczej, władzy wykonawczej i władzy sądowniczej.\n" +
                "2. Władzę ustawodawczą sprawują Sejm i Senat, władzę wykonawczą Prezydent\n" +
                "Rzeczypospolitej Polskiej i Rada Ministrów, a władzę sądowniczą\n" +
                "sądy i trybunały.\n" +
                "Art. 11.\n" +
                "1. Rzeczpospolita Polska zapewnia wolność tworzenia i działania partii\n" +
                "politycznych. Partie polityczne zrzeszają na zasadach dobrowolności i równości\n" +
                "obywateli polskich w celu wpływania metodami demokratycznymi na kształtowanie\n" +
                "polityki państwa.\n" +
                "2. Finansowanie partii politycznych jest jawne.\n" +
                "Art. 12.\n" +
                "Rzeczpospolita Polska zapewnia wolność tworzenia i działania związków\n" +
                "zawodowych, organizacji społeczno-zawodowych rolników, stowarzyszeń, ruchów\n" +
                "obywatelskich, innych dobrowolnych zrzeszeń oraz fundacji.\n" +
                "Art. 13.\n" +
                "Zakazane jest istnienie partii politycznych i innych organizacji odwołujących się w\n" +
                "swoich programach do totalitarnych metod i praktyk działania nazizmu, faszyzmu i\n" +
                "komunizmu, a także tych, których program lub działalność zakłada lub dopuszcza\n" +
                "nienawiść rasową i narodowościową, stosowanie przemocy w celu zdobycia władzy\n" +
                "lub wpływu na politykę państwa albo przewiduje utajnienie struktur lub\n" +
                "członkostwa.\n" +
                "Art. 14.\n" +
                "Rzeczpospolita Polska zapewnia wolność prasy i innych środków społecznego\n" +
                "przekazu.\n" +
                "Art. 15.\n" +
                "1. Ustrój terytorialny Rzeczypospolitej Polskiej zapewnia decentralizację władzy\n" +
                "publicznej.\n" +
                "2. Zasadniczy podział terytorialny państwa uwzględniający więzi społeczne,\n" +
                "gospodarcze lub kulturowe i zapewniający jednostkom terytorialnym zdolność\n" +
                "wykonywania zadań publicznych określa ustawa.\n" +
                "Art. 16.\n" +
                "1. Ogół mieszkańców jednostek zasadniczego podziału terytorialnego stanowi z\n" +
                "mocy prawa wspólnotę samorządową.\n" +
                "2. Samorząd terytorialny uczestniczy w sprawowaniu władzy publicznej.\n" +
                "Przysługującą mu w ramach ustaw istotną część zadań publicznych samorząd wykonuje\n" +
                "w imieniu własnym i na własną odpowiedzialność.\n" +
                "Art. 17.\n" +
                "1. W drodze ustawy można tworzyć samorządy zawodowe, reprezentujące osoby\n" +
                "wykonujące zawody zaufania publicznego i sprawujące pieczę nad należytym\n" +
                "wykonywaniem tych zawodów w granicach interesu publicznego i dla jego\n" +
                "ochrony.\n" +
                "2. W drodze ustawy można tworzyć również inne rodzaje samorządu. Samorządy te\n" +
                "nie mogą naruszać wolności wykonywania zawodu ani ograniczać wolności\n" +
                "podejmowania działalności gospodarczej.\n" +
                "Art. 18.\n" +
                "Małżeństwo jako związek kobiety i mężczyzny, rodzina, macierzyństwo i\n" +
                "rodzicielstwo znajdują się pod ochroną i opieką Rzeczypospolitej Polskiej.\n" +
                "Art. 19.\n" +
                "Rzeczpospolita Polska specjalną opieką otacza weteranów walk o niepodległość,\n" +
                "zwłaszcza inwalidów wojennych.\n" +
                "Art. 20.\n" +
                "Społeczna gospodarka rynkowa oparta na wolności działalności gospodarczej,\n" +
                "własności prywatnej oraz solidarności, dialogu i współpracy partnerów społecznych\n" +
                "stanowi podstawę ustroju gospodarczego Rzeczypospolitej Polskiej.\n" +
                "Art. 21.\n" +
                "1. Rzeczpospolita Polska chroni własność i prawo dziedziczenia.\n" +
                "2. Wywłaszczenie jest dopuszczalne jedynie wówczas, gdy jest dokonywane na\n" +
                "cele publiczne i za słusznym odszkodowaniem.\n" +
                "Art. 22.\n" +
                "Ograniczenie wolności działalności gospodarczej jest dopuszczalne tylko w drodze\n" +
                "ustawy i tylko ze względu na ważny interes publiczny.\n" +
                "Art. 23.\n" +
                "Podstawą ustroju rolnego państwa jest gospodarstwo rodzinne. Zasada ta nie narusza\n" +
                "postanowień art. 21 i art. 22.\n" +
                "Art. 24.\n" +
                "Praca znajduje się pod ochroną Rzeczypospolitej Polskiej. Państwo sprawuje nadzór\n" +
                "nad warunkami wykonywania pracy.\n" +
                "Art. 25.\n" +
                "1. Kościoły i inne związki wyznaniowe są równouprawnione.\n" +
                "2. Władze publiczne w Rzeczypospolitej Polskiej zachowują bezstronność w\n" +
                "sprawach przekonań religijnych, światopoglądowych i filozoficznych, zapewniając\n" +
                "swobodę ich wyrażania w życiu publicznym.\n" +
                "3. Stosunki między państwem a kościołami i innymi związkami wyznaniowymi są\n" +
                "kształtowane na zasadach poszanowania ich autonomii oraz wzajemnej\n" +
                "niezależności każdego w swoim zakresie, jak również współdziałania dla dobra\n" +
                "człowieka i dobra wspólnego.\n" +
                "4. Stosunki między Rzecząpospolitą Polską a Kościołem Katolickim określają\n" +
                "umowa międzynarodowa zawarta ze Stolicą Apostolską i ustawy.\n" +
                "5. Stosunki między Rzecząpospolitą Polską a innymi kościołami oraz związkami\n" +
                "wyznaniowymi określają ustawy uchwalone na podstawie umów zawartych\n" +
                "przez Radę Ministrów z ich właściwymi przedstawicielami.\n" +
                "Art. 26.\n" +
                "1. Siły Zbrojne Rzeczypospolitej Polskiej służą ochronie niepodległości państwa i\n" +
                "niepodzielności jego terytorium oraz zapewnieniu bezpieczeństwa i\n" +
                "nienaruszalności jego granic.\n" +
                "2. Siły Zbrojne zachowują neutralność w sprawach politycznych oraz podlegają\n" +
                "cywilnej i demokratycznej kontroli.\n" +
                "Art. 27.\n" +
                "W Rzeczypospolitej Polskiej językiem urzędowym jest język polski. Przepis ten nie\n" +
                "narusza praw mniejszości narodowych wynikających z ratyfikowanych umów\n" +
                "międzynarodowych.\n" +
                "Art. 28.\n" +
                "1. Godłem Rzeczypospolitej Polskiej jest wizerunek orła białego w koronie w\n" +
                "czerwonym polu.\n" +
                "2. Barwami Rzeczypospolitej Polskiej są kolory biały i czerwony.\n" +
                "3. Hymnem Rzeczypospolitej Polskiej jest Mazurek Dąbrowskiego.\n" +
                "4. Godło, barwy i hymn Rzeczypospolitej Polskiej podlegają ochronie prawnej.\n" +
                "5. Szczegóły dotyczące godła, barw i hymnu określa ustawa.\n" +
                "Art. 29.\n" +
                "Stolicą Rzeczypospolitej Polskiej jest Warszawa.", constitution.readChapter(new int[]{1}));
    }

}