package school;

import school.subject.SubjectType;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
//Name:Zhyldyz Zhumabekova 
//Neptun code:G9PZT9

class Schedule {
    private Schedule(File file) {
        /// File fl=new File ("filetxt.txt");
        String filename = file.getName();
        if (filename.contains("schedule")) {
            int numbLines = 0;
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                sc.nextLine();
                numbLines++;
            }
            if (numbLines < 6) {
                throw new IllegalStateException("There not enough days with classes");
            }
        } else {
            throw new IllegalArgumentException("Filename does not contain 'schedule' sequence");
        }

    }

    File file = new File("file.txt");
    int numbLines = 0;
    Scanner sc = new Scanner(file);

    public int getClassesPerDay() {
        String line = Files.readAllLines(Paths.get(file)).get(0);
        int ClassesPerDay = Integer.valueOf(line);
        return ClassesPerDay;

    }

    public Subject get(int dayN, int classN) {
        String line = Files.readAllLines(Paths.get(file)).get(dayN);
        String[] arrOfStr = line.split(" ", 3);
        String sbj = arrOfStr[classN];
        Subject returnSubject = Subject.valueOf(sbj);
        return returnSubject;
    }

    Subject[] subjects;

    public Boolean isSuitableForYear(int grade) {
        for (int i = 0; i < subjects.length; i++) {
            int startingYear = subjects[i].getstartingYear();
            return grade >= startingYear;
        }
    }
}
