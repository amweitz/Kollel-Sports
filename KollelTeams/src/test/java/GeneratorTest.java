import org.junit.jupiter.api.Test;
import org.kollel.Basketball;
import org.kollel.Generator;
import org.kollel.Hockey;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {
    @Test
    void testTeams(){
        Generator a = new Generator();
        a.setNumberSlots(4);
        a.setBasketballPerSlot(4);
        a.setHockeyPerSlot(4);

        ArrayList<String> w = new ArrayList<>(List.of("Aryeh Eizikovitz", "Avi Lowinger", "Elie Spirgel", "Elisha Gamms", "Jonathan Posner", "Justin Schloss", "Moshe Farkas", "Moshe Hoffman", "Rafi Lubetsky", "Yamin Semer", "Yehuda Lubetski"));
        a.addTeam('h',"Jonathan Posner", w);

        ArrayList<String> x = new ArrayList<>(List.of("David Karoudo", "David Link", "Dov Klapper", "Eitan Kahn", "Elazer Schwartz", "Jake Lutz", "Natan Burg", "Rav Hirschel", "Yisroel Duchman", "Yoel Gellman", "Yosef Warum"));
        a.addTeam('h',"Yosef Warum", x);

        ArrayList<String> ab = new ArrayList<>(List.of("Akiva Mittel", "Ari Cohn", "Avraham Cohen", "Doni Posner", "Ezra Landa", "Isaac Kantowitz", "Joshua Ratzker", "Moshe Strulowitz", "Rami Kessock", "Yitzchak Galler"));
        a.addTeam('h',"Rami Kessock", ab);

        ArrayList<String> ac = new ArrayList<>(List.of("Ari Herman", "Aryeh Levi", "Bz Scheinman", "Chaim Simon", "Eli Eisenberg", "Nathaniel Aviv-Gabay", "Yisroel Shaffren", "Yosef Karpel", "Yosef Shell", "Zac Pockriss"));
        a.addTeam('h',"Aryeh Levi", ac);

        ArrayList<String> ad = new ArrayList<>(List.of("Eli Zern", "Ari Burger", "Aryeh Rabinovitch", "Chaim Steinberg", "Doniel Austien (Player)", "Dovid Lichstein", "Noam Becker", "Shlomo Gellman", "Tzadok Cohen"));
        a.addTeam('h',"Tzadok Cohen", ad);

        ArrayList<String> ae = new ArrayList<>(List.of("Akiva Sytner", "Ariel Mayer", "Isaac Forgash", "Michael Karoudo", "Moshe Brazil", "Rabbi Poleyoff", "Shmuel Fine", "Yeshaya Friedman", "Yoshi Rosenbluth"));
        a.addTeam('h',"Moshe Brazil", ae);

        ArrayList<String> af = new ArrayList<>(List.of("Aiden Rauzman", "Akiva Reich", "Dov Klar", "Dovid Hirsch", "Eli Sudwerts", "Jacob Rotenberg", "Joseph Ambinder", "Kivi Margolese", "Yaakov Meisels"));;
        a.addTeam('h',"Jacob Rotenberg", af);

        ArrayList<String> ag = new ArrayList<>(List.of("Ami Roth", "Avi Burns", "Daniel Cinamon", "Adir Sacknovitz", "Jonathan Book", "Judah Schanzer", "Seth Grossman", "Shia Forgash", "Sydney Rosenblum"));
        a.addTeam('h',"Shia Forgash", ag);

        ArrayList<String> ah = new ArrayList<>(List.of("Akiva Magder", "Aryeh Levi", "Azaria Tiger", "Ethan Mauskopf", "Ezra Kopstick", "Leib Katz", "Moshe Tzvi Shapiro", "Rueben Kamintezky", "Yair Zell"));
        a.addTeam('h',"Aryeh Levi", ah);

        ArrayList<String> ai = new ArrayList<>(List.of("Akiva Mosak", "Asher Fogel", "Doniel Austien", "Ezra Seplowitz", "Gabriel Kurlander", "Gavriel Pinsky", "Jonathan Rosenberg", "Noam Sheffy", "Shai Kruter", "Yoel Kopstick"));
        a.addTeam('h',"Doniel Austien", ai);




        ArrayList<String> y = new ArrayList<>(List.of("avraham glatter", "Eliyahu Kramer", "Levi weinograd", "Netanel Herschmann", "rav israeli", "Yisrael Siegel", "Yoel Loloi", "Yosef Chaim Halev"));
        a.addTeam('b',"rav israeli", y);

        ArrayList<String> z = new ArrayList<>(List.of("Abie Jacoby", "Aryeh Krimsky", "Avi Klerer", "Ayden Lubin", "Dov Hirsch", "Dovi Marcus", "Jacob Guberman", "Shai Friedman"));
        a.addTeam('b',"Dovi Marcus", z);

        ArrayList<String> q = new ArrayList<>(List.of("Chaim Dovidowitz", "Ezra Shmuel", "Ezra Weiss", "ISR Zechariah Lebowitz", "Noah Green", "Raphi Mark", "Sam Siklick", "Zvi Kahn"));
        a.addTeam('b',"Sam Siklick", q);

        ArrayList<String> r = new ArrayList<>(List.of("Binyamin Neimark", "Eli Kroll", "Eyal Kinderlehrer", "Ilan Wachstock", "Jojo Mizrahi", "Tani Steiger", "Yaakov Neikrug", "Yisroel Einhorn"));
        a.addTeam('b',"Yisroel Einhorn", r);

        ArrayList<String> s = new ArrayList<>(List.of("Benyamin Szlafrok", "Binny Perl", "R' Binyomin Kaminetsky", "Eli Ludmir", "Kalman Singer", "Rami Gertler", "Schreier", "Shlomo Golubtchik"));
        a.addTeam('b',"R' Binyomin Kaminetsky", s);

        ArrayList<String> t = new ArrayList<>(List.of("Akiva Fox", "Avi Tepler", "Binyomin Savetsky", "Gabriel Kramer", "Henry Mann", "Rav Turetsky", "Shlomo Ambinder", "Yehuda Loenbraun"));
        a.addTeam('b',"Henry Mann", t);

        ArrayList<String> u = new ArrayList<>(List.of("Avi Rosman", "Chaim Turetsky", "Eitan Warburg", "Jacob Levine", "Jonathan Glazer", "Moshe Uretsky", "Solomon Shyrokov", "Yechiel Wolf"));
        a.addTeam('b',"Eitan Warburg", u);

        ArrayList<String> v = new ArrayList<>(List.of("Akiva Fried", "Danny Weinberger", "Dovid Saks", "Ezra Hochbaum", "Moshe Levy", "USA Zecharia Lebowitz", "Yaakov Wasserman", "Zvi Kahn"));
        a.addTeam('b',"Danny Weinberger", v);

        ArrayList<String> aa = new ArrayList<>(List.of("Abie Barnett", "Avi Munitz", "Joshua Treuhaft", "Nadav Aron", "Rafi Goldkin", "Chaim Goldman", "Tani Konig", "Yisroel Shaffren"));
        a.addTeam('b',"Tani Konig", aa);

        ArrayList<String> aj = new ArrayList<>(List.of("Aryeh Hirt", "Avraham Steinberg", "Charlie Shapiro", "Daniel Kroopnick", "Jonah Lamet", "Joseph Greenberg", "Mikkel Hertzberg", "Netanel Kieffer"));
        a.addTeam('b',"Aryeh Hirt", aj);

        ArrayList<String> ak = new ArrayList<>(List.of("Dovid Mandel", "Gedalia Pollack", "Jonathan Posner", "Chananya Rosen", "Noah Troy", "Rami Shaw", "Yamin Semer", "Chaim Simon"));
        a.addTeam('b',"Dovid Mandel", ak);

        ArrayList<String> al = new ArrayList<>(List.of("Eliezer Schwartz", "Eytan Leibowitz", "Jake Lutz", "Moshe Farkas", "Moshe Hoffman", "Sam Mandel", "Yosef Tischler", "Eitan Pfeifer"));
        a.addTeam('b',"Eitan Pfeifer", al);

        a.printSchedual(10);
        Map<ArrayList<Basketball>, ArrayList<Hockey>> tester = a.getMap();
        checker(tester);
    }
    @Test
    void test(){
        Generator a = new Generator();
        a.setNumberSlots(2);
        a.setBasketballPerSlot(2);
        a.setHockeyPerSlot(2);

        ArrayList<String> b = new ArrayList<>(List.of("a"));
        a.addTeam('h',"a", b);

        ArrayList<String> c = new ArrayList<>(List.of("b"));
        a.addTeam('h',"b", c);

        ArrayList<String> d = new ArrayList<>(List.of("b"));
        a.addTeam('b',"b", d);

        ArrayList<String> e = new ArrayList<>(List.of("a"));
        a.addTeam('b',"a", e);

        a.printSchedual(3);
    }

    public void checker (Map<ArrayList<Basketball>, ArrayList<Hockey>> tester){
        for(ArrayList<Basketball> balll : tester.keySet()){
            ArrayList<Hockey> hocc = tester.get(balll);
            int num = 0;
            ArrayList<String> comb = new ArrayList<>();
            for(Hockey ja : hocc){
                List<String> jnj = ja.getTeam();
                num += jnj.size();
                comb.addAll(jnj);
            }
            for(Basketball ja : balll){
                List<String> jnj = ja.getTeam();
                num += jnj.size();
                comb.addAll(jnj);
            }
            assertEquals(comb.size(), num);
        }
    }
}