package kr.sadalmelik.gifgallery.service;

import kr.sadalmelik.gifgallery.domain.GifWrapper;
import kr.sadalmelik.gifgallery.repository.GifWrapperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class GifWrapperService {

    @Autowired
    GifWrapperRepository repository;

    @PostConstruct
    public void init() {
        List<GifWrapper> gifs;

        gifs = new ArrayList<>();

        for (int idx = 0; idx < 100; idx++) {
            int height = (idx % 7 + 1) * 50;

            gifs.add(
                    new GifWrapper(
                            "title" + idx,
                            "description" + idx,
                            "http://dummyimage.com/200x" + height,
                            height,200
                    )
            );
        }

        repository.save(gifs);
    }
}
