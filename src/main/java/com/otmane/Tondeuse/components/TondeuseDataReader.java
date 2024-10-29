package com.otmane.Tondeuse.components;

import com.otmane.Tondeuse.entities.Position;
import com.otmane.Tondeuse.entities.Tondeuse;
import com.otmane.Tondeuse.enums.Commande;
import com.otmane.Tondeuse.enums.Direction;
import org.springframework.batch.core.scope.context.StepSynchronizationManager;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Optional;

import static com.otmane.Tondeuse.utils.FileUtils.*;

@Component
public class TondeuseDataReader implements ItemReader<Tondeuse> {

    private int idCounter = 1;
    private final BufferedReader reader;

    public TondeuseDataReader(@Value("${file.path.input}") String filePath) throws IOException {
        this.reader = new BufferedReader(new FileReader(filePath));
        reader.readLine();
    }

    @Override
    public Tondeuse read() throws Exception {
        String firstLineData = Optional.ofNullable(StepSynchronizationManager.getContext())
                .map(stepContext -> stepContext.getStepExecution().getJobExecution()
                        .getExecutionContext()
                        .getString("firstLineData"))
                .orElseThrow();
        Position positionCoin = getPosition(firstLineData);

        String line1 = reader.readLine();
        if (line1 == null) return null;

        Tondeuse tondeuse = new Tondeuse();

        Position position = getPosition(line1);
        Direction direction = getDirection(line1);

        tondeuse.setPosition(position);
        tondeuse.setDirection(direction);
        tondeuse.setCoinSuperieur(positionCoin);

        String line2 = reader.readLine();
        ArrayDeque<Commande> commandes = getCommandes(line2);
        tondeuse.setCommandes(commandes);
        tondeuse.setId(idCounter++);
        return tondeuse;
    }

    public void closeReader() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }
}
