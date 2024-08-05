package co.ateunti.test.nds.service;

import co.ateunti.test.nds.alt.repository.AltRepository;
import co.ateunti.test.nds.domain.Sample;
import co.ateunti.test.nds.main.repository.SampleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SampleService {
    private final SampleRepository sampleRepository;
    private final AltRepository altRepository;

    public SampleService(SampleRepository sampleRepository, AltRepository altRepository) {
        this.sampleRepository = sampleRepository;
        this.altRepository = altRepository;
    }

    public Optional<Sample> findByDocNumber(String docNumber) {
        var result = altRepository.findByDocNumber(docNumber)
                .map(data -> new Sample(null, data.getDoc(), data.getName()));
        if (result.isEmpty()) {
            result = sampleRepository.findByDoc(docNumber);
        }
        return result;
    }
}
