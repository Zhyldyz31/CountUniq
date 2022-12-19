import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
//Name:Zhyldyz Zhumabekova 
//Neptun code:G9PZT9

public class SchoolTest {
    File file4 = new File("schedule4.txt");
    File file5 = new File("schedule5.txt");
    File file6 = new File("schedule6.txt");
    File file7 = new File("schedule7.txt");

    @BeforeEach
    void beforeEach() {
        new Schedule(file4).subjects[0] = 4;
        new Schedule(file5).subjects[1] = 5;
        new Schedule(file6).subjects[2] = 6;
        new Schedule(file7).subjects[3] = 7;
    }

    @Test
    void classesPerDay() {
        Schedule f4 = new Schedule(file4);
        Schedule f5 = new Schedule(file5);
        Schedule f6 = new Schedule(file6);
        Schedule f7 = new Schedule(file7);
        assertEquals(4, f4.getClassesPerDay());
        assertEquals(5, f5.getClassesPerDay());
        assertEquals(6, f6.getClassesPerDay());
        assertEquals(7, f7.getClassesPerDay());
        assertNotEquals(8, f7.getClassesPerDay());

    }

    @Test
    void scheduledClassType() {
        Schedule f4 = new Schedule(file4);
        Schedule f5 = new Schedule(file5);
        Schedule f6 = new Schedule(file6);
        Schedule f7 = new Schedule(file7);
        assertEquals(Subject.SCIENCE, f6.get(5, 7));
        assertEquals(Subject.HUMANITY, f5.get(3, 2));
        assertEquals(Subject.HUMANITY, f7.get(4, 3));
        assertEquals(Subject.SCIENCE, f4.get(1, 5));

    }

    @Test
    void suitable() {
        Schedule f4 = new Schedule(file4);
        Schedule f5 = new Schedule(file5);
        Schedule f6 = new Schedule(file6);
        Schedule f7 = new Schedule(file7);
        assertTrue(f5.isSuitableForYear(12));
        assertTrue(f4.isSuitableForYear(5));
        assertTrue(f6.isSuitableForYear(7));
        assertTrue(f7.isSuitableForYear(8));
    }

    @Test
    void notSuitable() {
        Schedule f5 = new Schedule(file5);
        Schedule f6 = new Schedule(file6);
        Schedule f7 = new Schedule(file7);
        assertFalse(f6.isSuitableForYear(5));
        assertFalse(f7.isSuitableForYear(6));
        assertFalse(f5.isSuitableForYear(4));

    }

    @Test(expected = IllegalArgumentException.class)
    void invalidName() {
        File abc = new File("abcdefg.txt");
    }

    @Test(expected = IllegalStateException.class)
    void shortContent() {
        File scheduleShort = new File("scheduleShort.txt");

    }

}