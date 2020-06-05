import demo.configuration.HibernateConfig;
import demo.dao.InstrumentDao;
import demo.dao.ManagerDao;
import demo.dao.SingerDao;
import demo.entities.Album;
import demo.entities.Manager;
import demo.entities.Singer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.sound.midi.Instrument;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class App {

    public static void main(String... args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(HibernateConfig.class);
        SingerDao singerDao = ctx.getBean(SingerDao.class);
        InstrumentDao instrumentDao = ctx.getBean(InstrumentDao.class);
        ManagerDao managerDao = ctx.getBean(ManagerDao.class);
        Singer singer1 = singerDao.findById(3l);

        System.out.println("Count of instruments: " + instrumentDao.countInstrument());

        listSingersWithAlbum(singerDao.findAllWithAlbum());


//        Singer singer = new Singer();
//        singer.setFirstName("BB");
//        singer.setLastName("King");
//        singer.setBirthDate(new Date((new GregorianCalendar(1940, 8, 16)).getTime().getTime()));
//
//        Album album = new Album();
//        album.setTitle("My Kind of Blues");
//        album.setReleaseDate(new java.sql.Date((new GregorianCalendar(1961, 7, 18)).getTime().getTime()));
//        singer.addAlbum(album);
//
//        Manager manager = new Manager();
//        manager.setFirstName("Jon");
//        manager.setLastName("Neue");
//        managerDao.save(manager);
//        singer.setManager(manager);
//
//        singerDao.save(singer);

        //TODO сделать поиск по id и удаление

        ctx.close();
    }

    private static void listSingersWithAlbum(List<Singer> singers) {
        singers.forEach(s -> {
            if (s.getAlbums() != null) {
                s.getAlbums().forEach(a -> System.out.println("\t" + a.toString()));
            }
            if (s.getInstruments() != null) {
                s.getInstruments().forEach(i -> System.out.println("\tInstrument: " + i.getInstrumentId()));
            }
        });
    }
}
