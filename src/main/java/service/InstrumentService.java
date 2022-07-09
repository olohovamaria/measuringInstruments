package service;
import model.Instrument;

import java.util.List;

public interface InstrumentService {

    void create(Instrument instrument);


    List<Instrument> readAll();

    Instrument read(int id);


    boolean update(Instrument instrument, int id);


    boolean delete(int id);
}