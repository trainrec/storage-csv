package no.trainrec.storage;

import no.trainrec.core.data.StorageInterface;
import no.trainrec.core.domain.ExerciseEntry;

import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.IOException;

public class CSV implements StorageInterface {
    private BufferedReader reader;

    public CSV() {}

    public CSV(BufferedReader inputReader) {
        reader = inputReader;
    }

    public List<ExerciseEntry> load() {
        List<ExerciseEntry> entries = new ArrayList<ExerciseEntry>();
        String row = "";
        try {
            while ((row = reader.readLine()) != null) {
                String[] data = row.split(",");
                entries.add(new ExerciseEntry(data[0], data[1]));
            }
        } catch (IOException ex) {}
        return entries;
    }
    public void save(List<ExerciseEntry> entries) {}

}
