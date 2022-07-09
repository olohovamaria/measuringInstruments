package controller;

import model.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.InstrumentService;

import java.util.List;

@RestController
public class InstrumentController {
    private final InstrumentService instrumentService;

    @Autowired
    public InstrumentController(InstrumentService instrumentService) {

        this.instrumentService = instrumentService;
        }
    @PostMapping(value = "/instruments")
    public ResponseEntity<?> create(@RequestBody Instrument instrument) {
        instrumentService.create(instrument);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/instruments")
    public ResponseEntity<List<Instrument>> read() {
        final List<Instrument> instruments = instrumentService.readAll();

        return instruments != null &&  !instruments.isEmpty()
                ? new ResponseEntity<>(instruments, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/instruments/{id}")
    public ResponseEntity<Instrument> read(@PathVariable(name = "id") int id) {
        final Instrument instrument = instrumentService.read(id);

        return instrument != null
                ? new ResponseEntity<>(instrument, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/instruments/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Instrument instrument) {
        final boolean updated = instrumentService.update(instrument, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/instruments/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = instrumentService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}



