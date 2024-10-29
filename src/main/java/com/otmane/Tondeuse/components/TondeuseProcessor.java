package com.otmane.Tondeuse.components;

import com.otmane.Tondeuse.entities.Tondeuse;
import com.otmane.Tondeuse.exception.TondeuseConfigurationException;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class TondeuseProcessor implements ItemProcessor<Tondeuse, String> {
    @Override
    public String process(Tondeuse item) {
        if (item.isInitialConfValid()){
            item.start();
            return item.getPosition().getX() + " " + item.getPosition().getY() + " " + item.getDirection().name();
        }
        throw new TondeuseConfigurationException();

    }
}