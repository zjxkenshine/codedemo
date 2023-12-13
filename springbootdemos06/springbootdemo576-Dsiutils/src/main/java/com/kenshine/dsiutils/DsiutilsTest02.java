package com.kenshine.dsiutils;

import it.unimi.dsi.big.util.*;
import it.unimi.dsi.bits.TransformationStrategies;
import it.unimi.dsi.fastutil.Hash;
import it.unimi.dsi.fastutil.longs.LongBigArrayBigList;
import it.unimi.dsi.fastutil.objects.Object2LongOpenCustomHashMap;
import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectBigLists;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import it.unimi.dsi.lang.MutableString;
import it.unimi.dsi.util.FrontCodedStringList;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author by kenshine
 * @Classname DsiutilsTest02
 * @Description big util包
 * @Date 2023-12-13 15:35
 * @modified By：
 * @version: 1.0$
 */
public class DsiutilsTest02 {

    /**
     * FrontCodedStringBigList 前端压缩StringList
     */
    @Test
    public void test01(){
        final List<String> c = Arrays.asList(WORDS);
        final MutableString s = new MutableString();

        final FrontCodedStringBigList fcl = new FrontCodedStringBigList(c.iterator(), 1, true);
        // long类型的size
        System.out.println(fcl.size64());
        // 读取到MutableString
        fcl.get(12,s);
        System.out.println(s.toString());
        // 读取
        System.out.println(fcl.get(12));
    }

    /**
     * ImmutableBinaryTrie 不可变二叉搜索树
     */
    @Test
    public void test02(){
        // 转为二进制 选择转换策略 元素必须要从小到大排列
        ImmutableBinaryTrie<String> immutableBinaryTrie = new ImmutableBinaryTrie<>(Arrays.asList("1", "2", "3"), TransformationStrategies.utf16());
        System.out.println(immutableBinaryTrie.size());
        System.out.println(immutableBinaryTrie.toString());
    }

    /**
     *  ImmutableExternalPrefixMap 外部存储的前缀Map
     */
    @Test
    public void test03() throws IOException {
        // 元素必须是前缀排序的
        final ImmutableExternalPrefixMap d = new ImmutableExternalPrefixMap(new ObjectLinkedOpenHashSet<CharSequence>(new String[] { "aab", "aac", "aad","abd"}), 2);
        System.out.println(d.getInterval(""));
        System.out.println(d.getInterval("aa"));
        System.out.println(d.getInterval("aa"));

        final ImmutableExternalPrefixMap e = new ImmutableExternalPrefixMap(new ObjectLinkedOpenHashSet<CharSequence>(WORDS), 2);
        System.out.println(e.size64());
        // d开头的索引位置
        System.out.println(e.getInterval("d"));
    }

    /**
     * LiterallySignedStringMap 使用原始字符串列表签名的函数的字符串Map
     * FrontCodedStringList：前缀压缩List
     * Object2LongOpenCustomHashMap 对象转到Long的映射Map
     */
    @Test
    public void test04(){
        // 0-100
        final String[] s = new String[100];
        for(int i = s.length; i-- != 0;) {
            s[i] = Integer.toString(i);
        }
        Collections.shuffle(Arrays.asList(s));
        final FrontCodedStringList fcl = new FrontCodedStringList(Arrays.asList(s), 8, true);
        final Object2LongOpenCustomHashMap<CharSequence> mph = new Object2LongOpenCustomHashMap<>(new CharSequenceStrategy());
        mph.defaultReturnValue(-1);
        for(int i = 0; i < s.length; i++) {
            // String-long映射
            mph.put(new MutableString(s[i]),  i);
        }
        LiterallySignedStringMap map = new LiterallySignedStringMap(mph, ObjectBigLists.asBigList(fcl));
        System.out.println(map.size64());
        System.out.println(map.getLong("91"));
        System.out.println(map.getLong("11"));
    }

    /**
     * MappedFrontCodedStringBigList  FrontCodedStringBigList的内存映射版本
     */
    @Test
    public void test05() throws IOException, ConfigurationException {
        final String basename = File.createTempFile(this.getClass().getName(), ".basename").toString();
        final List<String> c = new ArrayList<>(Arrays.asList(WORDS));
        c.add(StringUtils.repeat("a", 1000));
        c.add(StringUtils.repeat("a", 500) + StringUtils.repeat("b", 500));
        c.add(StringUtils.repeat("a", 1000) + StringUtils.repeat("b", 1000));
        c.add(StringUtils.repeat("a", 100) + StringUtils.repeat("b", 1000));
        final MutableString s = new MutableString();
        Collections.sort(c);

        final FrontCodedStringBigList fcl = new FrontCodedStringBigList(c.iterator(), 8, true);
        MappedFrontCodedStringBigList.build(basename, 4, c.stream().map(x -> x.getBytes(StandardCharsets.UTF_8)).iterator());
        final MappedFrontCodedStringBigList mfcl = MappedFrontCodedStringBigList.load(basename);

        System.out.println(mfcl.get(35));
        System.out.println(fcl.get(35));
    }


    private final static class CharSequenceStrategy implements Hash.Strategy<CharSequence>, Serializable {
        private static final long serialVersionUID = 1L;

        @Override
        public boolean equals(final CharSequence a, final CharSequence b) {
            if (a == null) {
                return b == null;
            }
            if (b == null) {
                return false;
            }
            return a.toString().equals(b.toString());
        }

        @Override
        public int hashCode(final CharSequence o) {
            return o.toString().hashCode();
        }
    }


    public static final String[] WORDS = { "0", "00", "01", "02", "0200", "03", "09", "1", "10", "100", "11", "12", "13", "14", "15", "15mb", "18", "19", "1999", "2", "20", "2000", "2003", "2004",
            "2430", "27", "28", "3", "30", "33", "3d", "4", "5", "50", "6", "61", "7", "7027", "8", "9", "96", "a", "abiti", "accanto", "accesso", "accordo", "ad", "addio", "adsl", "aerei", "aereo",
            "affari", "affitto", "aforismi", "ai", "aiuto", "al", "alan", "alcune", "alcuni", "all", "alla", "alta", "altra", "altre", "altri", "altro", "ambo", "american", "amici", "amico", "amore",
            "ampia", "anche", "anima", "anni", "anno", "annunci", "annuncio", "anticoncezionali", "api", "appelli", "appuntamento", "aquario", "argomento", "arianna", "arrivi", "arte", "aspettano",
            "assicurazioni", "aste", "auto", "autore", "autoworld", "avermi", "avrai", "avuto", "avventura", "avvocati", "avvocato", "aziendale", "aziende", "azione", "azioni", "b", "b2b", "baci",
            "banche", "barra", "barzelletta", "barzellette", "basket", "basta", "battute", "battutine", "bella", "belle", "bello", "bellucci", "ben", "benessere", "benvenuti", "biasimo", "bilancia",
            "bisogno", "bisturi", "blu", "bob", "borsa", "borse", "borsellino", "brevi", "buffe", "buona", "business", "c", "cabaret", "calcio", "calcola", "calendari", "calorie", "camera",
            "campeggio", "canale", "canali", "canone", "canzone", "capacità", "capisce", "capodanno", "carabinieri", "carta", "cartoline", "cartoni", "casa", "casaclick", "case", "categorie",
            "cattiverie", "ce", "cellulare", "center", "centesimi", "cerca", "cercatrova", "cerchi", "champions", "chat", "che", "chi", "chiedi", "chilo", "chiuso", "cinema", "citta", "città",
            "ciunga", "classe", "classifica", "classifiche", "clicca", "cliccati", "clienti", "collegati", "collegato", "colleghi", "com", "come", "comico", "commedia", "community", "compra",
            "computer", "computers", "con", "conosci", "console", "consulenze", "consulti", "contattaci", "contenuti", "continua", "copyright", "corpo", "correzioni", "cortometrag", "cosa", "cose",
            "crea", "credito", "cronache", "cucina", "cui", "cultura", "cupido", "cv", "d", "da", "dai", "dal", "dalla", "date", "decisamente", "dei", "del", "dell", "della", "delle", "dello",
            "desideri", "di", "dieta", "dietro", "difficoltà", "digiland", "digitale", "directory", "diritti", "disclaimer", "discorso", "discussioni", "disposizione", "diteci", "diversi",
            "divertente", "divertenti", "divertimento", "divorzio", "documentario", "dom", "domanda", "domini", "donne", "dopo", "download", "drammatico", "dreamcast", "dubbi", "due", "durare", "e",
            "easysms", "ebay", "ecocultura", "ecommerce", "economia", "edicola", "editoria", "editoriale", "editoriali", "elenco", "elisa", "erotico", "esclusivi", "etaslab", "eterni", "eterno",
            "euro", "evoluzione", "excite", "express", "extra", "fa", "facile", "fai", "fantascienza", "fare", "fasi", "fatto", "febbraio", "ferro", "feste", "festival", "figli", "figlia", "figlio",
            "filastrocche", "files", "film", "finalmente", "finanza", "finora", "fiorellini", "fissa", "fitness", "flat", "folli", "fondi", "fortuna", "forum", "foto", "fotografia", "freddure",
            "free", "fumetti", "fun", "galleria", "gallerie", "gallery", "gamecube", "games", "garanzie", "gemella", "gemelli", "generale", "genere", "generi", "gente", "gi", "giallo", "gio",
            "gioca", "giochi", "gioco", "giornalistiche", "giorno", "giurisdizioni", "giusta", "gli", "google", "gossip", "gratis", "gratuitamente", "gratuiti", "grottesco", "guadagna", "guadagni",
            "guardare", "guest", "guida", "ha", "hai", "ho", "home", "hope", "horror", "hosting", "hotel", "humor", "i", "idee", "il", "immagini", "improbabile", "in", "incinta", "incontri",
            "indice", "indirizzi", "infernali", "informazioni", "iniziativa", "inseriti", "interagisci", "internet", "interromperti", "intrattenimento", "invia", "inwind", "iol", "irriverenti",
            "iscrivermi", "iscriviti", "it", "italia", "italiani", "italiaonline", "jumpy", "l", "la", "lastminute", "laurea", "lavagna", "lavatrice", "lavoro", "le", "legge", "leggendo", "leggerlo",
            "leggi", "libero", "libri", "life", "line", "live", "lo", "località", "loghi", "loro", "lotto", "lui", "lun", "lunedì", "lycos", "macchine", "mai", "mail", "mailbox", "mappe", "mar",
            "marito", "mars", "matrimonio", "matte", "matti", "maturando", "medicoonline", "meglio", "memoria", "menù", "mer", "mercatino", "mercedes", "messo", "meteo", "mette", "mib", "mibtel",
            "miglior", "migliori", "milano", "mio", "misteri", "miti", "mms", "moda", "mode", "modem", "modo", "moglie", "molto", "mondo", "mostralfonso", "motori", "moviola", "mp3", "multiservizi",
            "musica", "musical", "mutui", "mutuo", "n64", "napoli", "nascosti", "nascosto", "nasdaq", "natura", "naviga", "nazionale", "ne", "negativo", "nel", "nella", "nelle", "neve", "news",
            "newsgroup", "newsletter", "nikkei", "non", "notebook", "notizie", "novita", "nuova", "nuovi", "o", "offerte", "offre", "ogni", "on", "online", "ora", "ordine", "ore", "oroscopo", "orsa",
            "oscar", "ottima", "ottimizza", "ovviamente", "p", "padre", "page", "palco", "panoramica", "parecchi", "parenti", "parla", "partite", "partner", "pass", "passioni", "pazze", "pc", "pena",
            "per", "perdere", "personal", "personalizzati", "persone", "piace", "pianeta", "piangono", "pianificare", "piatti", "picchio", "pillole", "pippo", "pippoland", "piu", "più",
            "playstation", "poesie", "polemica", "policy", "poliziesco", "pop", "porno", "porta", "positivo", "possibile", "posta", "poveri", "povertà", "praticità", "preferenza", "preferiti",
            "premi", "premio", "premium", "prese", "presentaci", "prestiti", "prestito", "previsioni", "prezzi", "primo", "privacy", "problema", "prodotti", "professionale", "progetto", "promozioni",
            "proposte", "prostituta", "prova", "ps2", "pubblicheremo", "pubblicita", "punti", "puoi", "qualche", "qualcosa", "quelle", "quello", "questa", "queste", "questi", "questo", "qui",
            "raccolte", "raccontato", "radio", "rapido", "rassegna", "realizzazione", "recensioni", "recensiti", "relazione", "religione", "reserved", "responsabile", "ricchezza", "ricchi",
            "ricerca", "ricerche", "ricette", "ricevi", "richiedi", "ridono", "rights", "rime", "risate", "riservati", "riso", "risolti", "risparmi", "rno", "roma", "rosso", "rotta", "rubriche", "s",
            "sab", "sacco", "sali", "salute", "san", "saretefamosi", "sarà", "scambia", "scarica", "scaricare", "scegli", "scelta", "scelti", "scienza", "scienze", "sconosciuto", "scontati",
            "sconti", "scopri", "scoprilo", "scrivi", "scrivici", "se", "secondo", "segnala", "segreti", "sei", "sembrano", "sempre", "seno", "sentimentale", "sera", "serpenti", "serve", "servizi",
            "sessi", "settimana", "sfido", "sfortuna", "sfortunata", "shirt", "shop", "shopping", "si", "sia", "siamo", "signora", "silicone", "simpatiche", "siti", "sito", "smeraldo", "sms",
            "snake", "software", "sognato", "soli", "solo", "soluzione", "soluzioni", "son", "sondaggio", "sono", "sotto", "special", "speciale", "speciali", "spediscila", "spettacolari", "spicy",
            "sport", "srl", "sta", "stampa", "stanno", "stanza", "stasera", "stella", "stellare", "stelle", "storia", "storico", "storie", "stranafoto", "strane", "strani", "studia", "stupidario",
            "stupisci", "su", "sua", "subito", "successo", "sugli", "sul", "sulla", "suo", "suonerie", "suoni", "super", "supertop", "sviluppatori", "t", "tante", "tantum", "tarocco", "tassi", "te",
            "tecnologia", "teknosurf", "telefonia", "telefonino", "televisione", "tempo", "territorio", "testa", "thriller", "ti", "tipiche", "toccano", "top", "tra", "traduzioni", "tranquillo",
            "trasloca", "trasloco", "tre", "tribù", "troppo", "trova", "trovi", "trucchi", "tu", "tua", "tue", "tuo", "tuoi", "tutta", "tutte", "tutti", "tutto", "tuttocasa", "tv", "uccelli", "uffa",
            "ultim", "ultimi", "umoristico", "un", "una", "unico", "uomini", "uomo", "user", "utili", "vacanze", "vale", "valentino", "varie", "vasectomia", "veloce", "velocemente", "ven", "vendita",
            "vero", "vetrine", "via", "viaggi", "viaggiare", "viaggio", "video", "videogiochi", "vignette", "vinci", "virgilio", "virtuali", "visita", "vista", "vivere", "voglio", "voi", "volta",
            "vostre", "voto", "vuoi", "vuole", "wap", "web", "webmaster", "western", "www", "xbox", "yahoo", "zone" };
}
