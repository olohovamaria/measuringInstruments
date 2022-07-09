package service;

import model.Instrument;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class InstrumentServiceImpl implements InstrumentService {
    // Хранилище инструментов
    private static final Map<Integer, Instrument> INSTRUMENT_REPOSITORY_MAP = new HashMap<>();

    // Переменная для генерации ID ИНСТРУМЕНТА
    private static final AtomicInteger INSTRUMENT_ID_HOLDER = new AtomicInteger();
    @Override
    public void create(Instrument instrument) {
        final int instrumentId = INSTRUMENT_ID_HOLDER.incrementAndGet();
        instrument.setId(instrumentId);
        INSTRUMENT_REPOSITORY_MAP.put(instrumentId, instrument);

    }

    @Override
    public List<Instrument> readAll() {

        return new ArrayList<>(INSTRUMENT_REPOSITORY_MAP.values());
    }

    @Override
    public Instrument read(int id) {

        return INSTRUMENT_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Instrument instrument, int id) {
        if (INSTRUMENT_REPOSITORY_MAP.containsKey(id)) {
            instrument.setId(id);
            INSTRUMENT_REPOSITORY_MAP.put(id, instrument);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return INSTRUMENT_REPOSITORY_MAP.remove(id) != null;
    }
}
